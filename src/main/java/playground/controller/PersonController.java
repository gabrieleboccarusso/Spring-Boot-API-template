package playground.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import playground.entity.Person;
import playground.repository.PersonRepository;

@RestController
@RequestMapping("person")
public class PersonController {
 private final PersonRepository personRepository;
 
 public PersonController(PersonRepository personRepository) {
  this.personRepository = personRepository;
  
  this.personRepository.saveAll(List.of(
     new Person("1", "John", "Doe"),
     new Person("2", "Mark", "Smith"),
     new Person("3", "Arnold", "Goodman")
    ));
 }
 
 @GetMapping
 Iterable<Person> allPeople() {
  return this.personRepository.findAll();
 }
 
 @GetMapping("/{id}")
 Optional<Person> getPersonById(@PathVariable String id) {
  return this.personRepository.findById(id);
 }
 
 /*
  * possible JSON in the body:
  * {
  *  "id": "5",
  *  "firstName": "Lucy",
  *  "lastName": "Block"
  * }
  * */
 @PostMapping
 Person postPerson(@RequestBody Person person) {
  return this.personRepository.save(person);
 }
 
 @PutMapping("/{id}")
 ResponseEntity<Person> putPerson(@PathVariable String id, @RequestBody Person person) {
  HttpStatus status = this.personRepository.existsById(id)
    ? HttpStatus.OK
    : HttpStatus.CREATED;
  
  return new ResponseEntity<Person>(this.personRepository.save(person), status);
 }
 
 @DeleteMapping("/{id}")
 void deletePerson(@PathVariable String id) {
  this.personRepository.deleteById(id);
 }
}
