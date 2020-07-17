package com.example.app.resources;

import com.example.app.domain.Event;
import com.example.app.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value = "/ministries")
@CrossOrigin(origins = "http://localhost:3000")
public class EventResource {

    @Autowired
    private EventService eventService;

    @PostMapping(path = "/{id}/events")
    public ResponseEntity<Void> insert(@PathVariable Integer id, @RequestBody Event obj) throws ParseException {
        eventService.insert(id, obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        System.out.println("");
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "/{id}/events")
    public ResponseEntity<List<Event>> findAll(@PathVariable Integer id){
        List<Event> eventList = eventService.findAll(id);
        return ResponseEntity.ok().body(eventList);
    }


    @DeleteMapping(value = "/{idMin}/events/{idEve}")
    public ResponseEntity<Void> delete(@PathVariable Integer idMin, @PathVariable Integer idEve){
        eventService.delete(idMin, idEve);
        return ResponseEntity.noContent().build();
    }

}
