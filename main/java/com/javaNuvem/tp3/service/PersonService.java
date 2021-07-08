package com.javaNuvem.tp3.service;

import com.javaNuvem.tp3.client.ViaCEPClient;
import com.javaNuvem.tp3.model.Adress;
import com.javaNuvem.tp3.model.Person;
import com.javaNuvem.tp3.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonService {

    @Autowired
    private ViaCEPClient viaCEPClient;

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person registerPerson(String name, String email, String tel,
                                 String cep,String urlFile, Adress adress) {

        return this.personRepository.save(new Person(name, email, tel, cep, urlFile, adress));
    }

    public void updatePerson(Long id, Person person) {
        person.setId(id);
        personRepository.save(person);
    }

    public void editPerson(String name, String email, String tel, String cep) {
        Person person = personRepository.findByEmail(email);
        person.setName(name);
        person.setTel(tel);
        person.setCep(cep);
        Adress adress = viaCEPClient.buscaEnderecoPor(cep);
        person.setAdress(adress);
        personRepository.save(person);
    }

    public void editEmail(String email, String newemail) {
        Person person = personRepository.findByEmail(email);
        person.setEmail(newemail);
        personRepository.save(person);
    }

    public Person findUserByEmail(String email){
        Person person = this.personRepository.findByEmail(email);
        return person;
    }
}
