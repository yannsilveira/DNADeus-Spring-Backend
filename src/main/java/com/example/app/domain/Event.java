package com.example.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_event")
public class Event implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private String zipcode;
    private String street;
    private Integer number;
    private String neighborhood;
    private String date;
    private String schedule;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "ministerio_id")
    private Ministry ministry;

    public Event() {

    }

    public Event(Integer id, String name, String description, String zipcode, String street, Integer number,
                 String neighborhood, String date, String schedule, Ministry ministry) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.zipcode = zipcode;
        this.street = street;
        this.number = number;
        this.neighborhood = neighborhood;
        this.date = date;
        this.schedule = schedule;
        this.ministry = ministry;
    }
    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nome) {
        this.name = nome;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipCode) {
        this.zipcode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer numero) {
        this.number = numero;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String bairro) {
        this.neighborhood = bairro;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String data) {
        this.date = data;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String horario) {
        this.schedule = horario;
    }

    public Ministry getMinistry() {
        return ministry;
    }

    public void setMinistry(Ministry ministry) {
        this.ministry = ministry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event eventos = (Event) o;

        return id != null ? id.equals(eventos.id) : eventos.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
