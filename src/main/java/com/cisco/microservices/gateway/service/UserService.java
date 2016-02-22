package com.cisco.microservices.gateway.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("USERS-SERVICE")
public interface UserService {

  @RequestMapping(value = "/user/list", method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  Object getAll();

  @RequestMapping(value = "/user/addUser", method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  Object add();
}
