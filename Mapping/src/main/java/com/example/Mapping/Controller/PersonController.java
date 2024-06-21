package com.example.Mapping.Controller;

import com.example.Mapping.Model.Person;
import com.example.Mapping.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Person")
public class PersonController {

    @Autowired
    private PersonService personService;
    @GetMapping
    public List<Person> getAllPersons() {
        return personService.findAll();
    }

//    @GetMapping("/{id}")
//    public Optional<Person> getPersonById(@PathVariable Long id) {
//        return personService.findById(id);
//    }

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personService.save(person);
    }
    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {
        personService.deleteById(id);
    }

}
