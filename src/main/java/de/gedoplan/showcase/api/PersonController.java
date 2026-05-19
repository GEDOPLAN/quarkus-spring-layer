package de.gedoplan.showcase.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.gedoplan.showcase.domain.Person;
import de.gedoplan.showcase.persistence.PersonRepository;
import de.gedoplan.showcase.service.PersonService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {

  final PersonRepository personRepository;
  final PersonService personService;

  @GetMapping
  public Iterable<Person> get() {
    return this.personRepository.findAll();
  }

  @GetMapping("{familyName}")
  public Iterable<Person> getByFamilyName(@PathVariable(name = "familyName") String familyName) {
    return this.personRepository.findByFamilyName(familyName);
  }

  @GetMapping(path = "avg-age")
  public double getAverageAge() {
    return this.personService.getAverageAge();
  }

}
