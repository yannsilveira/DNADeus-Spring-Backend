package com.example.app.services;

import com.example.app.domain.User;
import com.example.app.domain.Ministry;
import com.example.app.repositories.UserRepository;
import com.example.app.repositories.MinistryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MinistryRepository ministryRepository;


    public List<User> findAll(Integer id) {
        Optional<Ministry> obj = ministryRepository.findById(id);
        System.out.println("");
        return obj.get().getMembros();
    }

    public User findById(Integer idMin, Integer idMem) {
        Optional<Ministry> objMin = ministryRepository.findById(idMin);
        //Optional<Membro> objMem = membroRepository.findById(idMem);

        User membro = null;

        for (User x : objMin.get().getMembros()) {
            if (x.getId().equals(idMem)) {
                membro = x;
            }
        }

        System.out.println("");
        return membro;
    }

    public User insert(Integer id, User objMem) {
        Optional<Ministry> obj = ministryRepository.findById(id);

        obj.get().getMembros().add(objMem);
        System.out.println("");
        return userRepository.save(objMem);
    }

    public void delete(Integer idMin, Integer idMem) {
        Optional<Ministry> objMin = ministryRepository.findById(idMin);

        if (objMin.isPresent()) {
            for (User x : objMin.get().getMembros()) {
                if (x.getId().equals(idMem)) {
                    //ministerioRepository.deleteById(x.getId());
                    objMin.get().getMembros().remove(x);
                    ministryRepository.save(objMin.get());
                    break;
                }
            }
        }

        System.out.println("");
    }

}
