package de.gedoplan.showcase.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.gedoplan.showcase.service.GreeterBean;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

  @Autowired
  GreeterBean greeterBean;

  @GetMapping
  public String hello() {
    return greeterBean.greet("world");
  }
}
