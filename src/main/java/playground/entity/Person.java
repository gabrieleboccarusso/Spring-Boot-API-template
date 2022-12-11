package playground.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

// annotate the following class has an entity (a.k.a. table)
@Entity
public class Person {
 // define this variable has an id
 @Id
 private String id;
 // set properties of the columns
 @Column(name = "first_name", length = 128)
 private String firstName;
 @Column(name = "last_name", length = 128)
 private String lastName;
 
 // define the various constructors
 public Person() {
  this.setId(UUID.randomUUID().toString());
 }
 
 public Person(String id) {
  this.setId(id);
 }
 
 public Person(String id, String firstName) {
  this(id);
  this.setFirstName(firstName);
 }
 
 public Person(String id, String firstName, String lastName) {
  this (id, firstName);
  this.setLastName(lastName);
 } 
 // end of constructors

 // also define the setters and the getters
 public String getId() {
  return id;
 }

 public void setId(String id) {
  this.id = id;
 }

 public String getFirstName() {
  return firstName;
 }

 public void setFirstName(String firstName) {
  this.firstName = firstName;
 }

 public String getLastName() {
  return lastName;
 }

 public void setLastName(String lastName) {
  this.lastName = lastName;
 }
}