package de.gedoplan.showcase.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Person {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String familyName;
  private String givenName;

  private LocalDate birthDay;

  public Person(String familyName, String givenName, LocalDate birthDay) {
    this.familyName = familyName;
    this.givenName = givenName;
    this.birthDay = birthDay;
  }

}