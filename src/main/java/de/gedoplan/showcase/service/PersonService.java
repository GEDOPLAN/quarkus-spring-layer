package de.gedoplan.showcase.service;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.gedoplan.showcase.domain.Person;
import de.gedoplan.showcase.persistence.PersonRepository;

@Component
public class PersonService {

  @Autowired
  PersonRepository personRepository;

  public double getAverageAge() {
    double totalAge = 0;
    int count = 0;
    for (Person person : this.personRepository.findAll()) {
      ++count;
      totalAge += Period.between(person.getBirthDay(), LocalDate.now()).getYears();
    }
    return count != 0 ? (totalAge / count) : 0;
  }
}
