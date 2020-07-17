package com.example.app.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_ministerio")
public class Ministry implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "ministry")
    private List<Event> events = new ArrayList<>();


    //@JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "tb_ministerio_membro",
            joinColumns = @JoinColumn(name = "ministerio_id"),
            inverseJoinColumns = @JoinColumn(name = "membros_id")
    )
    private List<User> membros = new ArrayList<>();


    public Ministry() {

    }

    public Ministry(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }


    public List<User> getMembros() {
        return membros;
    }

    public void setMembros(List<User> membros) {
        this.membros = membros;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ministry that = (Ministry) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
