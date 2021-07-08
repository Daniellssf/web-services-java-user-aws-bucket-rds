package com.javaNuvem.tp3.model;

import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Person {

    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String tel;
    private String cep;
    private String mfile;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, optional = false)
    private Adress adress;

    public Person(String name, String email, String tel, String cep, String mfile, Adress adress) {
        this.name = name;
        this.email = email;
        this.tel = tel;
        this.cep = cep;
        this.mfile = mfile;
        this.adress = adress;
    }

    public Person() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public String getMfile() {
        return mfile;
    }

    public void setMfile(String urlFile) {
        this.mfile = urlFile;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", cep='" + cep + '\'' +
                ", adress=" + adress +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(getId(), person.getId()) && Objects.equals(getName(), person.getName()) && Objects.equals(getEmail(), person.getEmail()) && Objects.equals(getTel(), person.getTel()) && Objects.equals(getCep(), person.getCep()) && Objects.equals(getMfile(), person.getMfile()) && Objects.equals(getAdress(), person.getAdress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getEmail(), getTel(), getCep(), getMfile(), getAdress());
    }
}
