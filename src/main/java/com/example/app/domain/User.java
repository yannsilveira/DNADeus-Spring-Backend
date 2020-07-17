package com.example.app.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name = "tb_membro")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private Integer age;
    private String whatsapp;

    //@JsonIgnore
    @JsonIgnore
    @ManyToMany(mappedBy = "membros")
    private List<Ministry> ministries = new ArrayList<>();

    public User(){

    }

    public User(Integer id, String name, String email, Integer age, String whatsapp) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.whatsapp = whatsapp;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer idade) {
        this.age = idade;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whats) {
        this.whatsapp = whats;
    }

    //@JsonIgnore
    public List<Ministry> getMinistries() {
        return ministries;
    }

    public void setMinistries(List<Ministry> ministries) {
        this.ministries = ministries;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User membro = (User) o;

        return id != null ? id.equals(membro.id) : membro.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
