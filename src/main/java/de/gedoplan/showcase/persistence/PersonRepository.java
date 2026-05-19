package de.gedoplan.showcase.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.gedoplan.showcase.domain.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer>{

  public List<Person> findByFamilyName(String familyName);
}
