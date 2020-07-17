package com.example.app.services;

import com.example.app.domain.Event;
import com.example.app.domain.Ministry;
import com.example.app.repositories.EventRepository;
import com.example.app.repositories.MinistryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private MinistryRepository ministryRepository;

    public Event insert(Integer id, Event objEvent) throws ParseException {
        Optional<Ministry> obj = ministryRepository.findById(id);

        objEvent.setMinistry(obj.get());

        obj.get().getEvents().add(objEvent);

        System.out.println("");
        return eventRepository.save(objEvent);
    }

    public List<Event> findAll(Integer id) {
        Optional<Ministry> obj = ministryRepository.findById(id);
        System.out.println("");
        return obj.get().getEvents();
    }

    public void delete(Integer idMin, Integer idEve) {
        Optional<Ministry> objMin = ministryRepository.findById(idMin);

        if (objMin.isPresent()) {
            for (Event x : objMin.get().getEvents()) {
                if (x.getId().equals(idEve)) {
                    //ministerioRepository.deleteById(x.getId());
                    objMin.get().getEvents().remove(x);
                    ministryRepository.save(objMin.get());
                    break;
                }
            }
        }

        System.out.println("");
    }
}
