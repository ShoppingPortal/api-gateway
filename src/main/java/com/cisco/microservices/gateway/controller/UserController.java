package com.cisco.microservices.gateway.controller;

import com.cisco.microservices.gateway.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  UserService userService;

  @RequestMapping(value = "/list", method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public Object getAllUsers(@RequestParam(value = "type", required = false) Object userType) {
    return userService.getAll(userType);
  }

  @RequestMapping(value = "/addUser", method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  Object add(@RequestBody Object obj) {
    return userService.add(obj);
  }

  @RequestMapping(value = "/delete/{username}", method = RequestMethod.DELETE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  Object delete(@PathVariable("username") String username) {
    return userService.delete(username);
  }
}
