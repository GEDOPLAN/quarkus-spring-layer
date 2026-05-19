package de.gedoplan.showcase.service;

import java.time.LocalDate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jboss.logging.Logger;

import de.gedoplan.showcase.domain.Person;
import de.gedoplan.showcase.persistence.PersonRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.enterprise.event.Startup;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class InitPersonDemoDataService {
  @Inject
  PersonRepository personRepository;

  @Inject
  Logger log;

  /**
   * Create test/demo data.
   * Attn: Interceptors may not be called, if method is private!
   *
   * @param event Application scope initialization event
   */
  @Transactional
  void createDemoData(@Observes Startup event) {
    try {
      if (this.personRepository.count() == 0) {
        this.personRepository.save(new Person("Duck", "Dagobert", LocalDate.of(1905, 12, 5)));
        this.personRepository.save(new Person("Duck", "Donald", LocalDate.of(1931, 3, 13)));
        this.personRepository.save(new Person("Mouse", "Mickey", LocalDate.of(1928, 11, 28)));
        this.personRepository.save(new Person("Mouse", "Minnie", LocalDate.of(1928, 11, 28)));
      }
    } catch (Exception e) {
      log.warn("Cannot create demo data", e);
    }

  }

}
