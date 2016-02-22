package com.cisco.microservices.gateway.controller;

import com.cisco.microservices.gateway.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  UserService userService;

  @RequestMapping(value = "/list", method = RequestMethod.GET, 
      produces = MediaType.APPLICATION_JSON_VALUE)
  public Object getAllUsers() {
    return userService.getAll();
  }

  @RequestMapping(value = "/addUser", method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  Object add(@RequestBody Object obj) {
    return userService.add(obj);
  }
}
