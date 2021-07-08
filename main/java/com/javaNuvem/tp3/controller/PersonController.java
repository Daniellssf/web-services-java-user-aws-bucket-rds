package com.javaNuvem.tp3.controller;

import com.javaNuvem.tp3.client.AmazonClient;
import com.javaNuvem.tp3.client.ViaCEPClient;
import com.javaNuvem.tp3.model.Adress;
import com.javaNuvem.tp3.model.Person;
import com.javaNuvem.tp3.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class PersonController {

    @Autowired
    PersonService personService;
    @Autowired
    ViaCEPClient viaCEPClient;
    @Autowired
    AmazonClient amazonClient;



    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(method = {RequestMethod.GET}, value = "/person/{email}")
    public Person findUserByEmail(@PathVariable String email) {
        return (Person) personService.findUserByEmail(email);
    }

    @PostMapping("/registerPerson")
    public Person register(@RequestPart(value = "name") String name,
                            @RequestPart(value = "email") String email,
                            @RequestPart(value = "tel") String tel,
                            @RequestPart(value = "cep") String cep,
                            @RequestPart(value = "mfile") MultipartFile mfile) throws IOException {

        Adress adress = viaCEPClient.buscaEnderecoPor(cep);
        String urlFile = amazonClient.uploadFile(mfile);
        File file = amazonClient.convertMultiPartToFile(mfile);
        amazonClient.uploadFileTos3bucket(urlFile, file);
        return personService.registerPerson(name, email, tel, cep, urlFile, adress);
    }

    @RequestMapping(method = {RequestMethod.PUT}, value = "/modifyPerson/{id}")
    public void update(@PathVariable Long id, @RequestBody Person person) {

        personService.updatePerson(id, person);
    }

    @RequestMapping(value = "/editPerson", method = RequestMethod.PUT)
    public void editarUsuario(@RequestParam("name") String name,
                              @RequestParam("email") String email,
                              @RequestParam("tel") String tel,
                              @RequestParam("cep") String cep) {

        personService.editPerson(name, email, tel, cep);
    }

    @RequestMapping(value = "/editEmail", method = RequestMethod.PUT)
    public void editarEmail(@RequestParam("email") String email,
                            @RequestParam("newemail") String newemail) {

        personService.editEmail(email, newemail);
    }
}
