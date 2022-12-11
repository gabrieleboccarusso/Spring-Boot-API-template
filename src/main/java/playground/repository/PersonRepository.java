package playground.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import playground.entity.Person;

// you create an interface and extends it with `CrudRepository`.
// the first object to be passed is the entity and the second is
// the type of the entity id.
public interface PersonRepository extends JpaRepository<Person, String> {
}
