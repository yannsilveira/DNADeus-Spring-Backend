package com.example.app.resources;

import com.example.app.domain.Ministry;
import com.example.app.services.MinistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/")
@CrossOrigin(origins = "http://localhost:3000")
public class MinistryResource {

    @Autowired
    private MinistryService ministryService;


    @GetMapping(value = "/ministries")
    public ResponseEntity<List<Ministry>> findAll(){
        List<Ministry> ministryList = ministryService.findAll();
        return ResponseEntity.ok().body(ministryList);
    }

    @GetMapping(value = "/ministries/{id}")
    public ResponseEntity<Ministry> findById(@PathVariable Integer id){
        Ministry obj = ministryService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping(value = "/ministries")
    public ResponseEntity<Ministry> insert(@RequestBody Ministry obj){
        obj = ministryService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).body(obj);
    }

    @PostMapping(value = "/sessions", consumes = "application/json")
    public ResponseEntity<Ministry> session(@RequestBody Ministry obj){
        Ministry newObj = ministryService.session(obj);
        System.out.println("");
        return ResponseEntity.ok().body(newObj);
    }

    @DeleteMapping(value = "/ministries/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        ministryService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/ministries/{id}")
    public ResponseEntity<Ministry> update(@PathVariable Integer id, @RequestBody Ministry obj){
        obj = ministryService.update(id, obj);
        return ResponseEntity.noContent().build();
    }
}
