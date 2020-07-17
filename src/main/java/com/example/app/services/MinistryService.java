package com.example.app.services;

import com.example.app.domain.Ministry;
import com.example.app.repositories.MinistryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MinistryService {

    @Autowired
    private MinistryRepository ministryRepository;


    public List<Ministry> findAll() {
       return ministryRepository.findAll();
    }

    public Ministry findById(Integer id) {
        Optional<Ministry> ministerio = ministryRepository.findById(id);
        return ministerio.get();
    }


    public Ministry insert(Ministry obj) {
        return ministryRepository.save(obj);
    }

    public void delete(Integer id) {
        ministryRepository.deleteById(id);
    }

    public Ministry update(Integer id, Ministry newObj) {
        Ministry obj = ministryRepository.getOne(id);
        updateData(obj, newObj);
        return ministryRepository.save(obj);
    }

    public void updateData(Ministry obj, Ministry newObj){
        obj.setName(newObj.getName());
    }


    public Ministry session(Ministry obj) {
        Optional<Ministry> newObj = ministryRepository.findById(obj.getId());


        System.out.println("");
        return newObj.get();
    }
}
