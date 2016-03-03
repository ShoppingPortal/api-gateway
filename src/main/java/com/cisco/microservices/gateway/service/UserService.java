package com.cisco.microservices.gateway.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("USERS-SERVICE")
public interface UserService {

  @RequestMapping(value = "/user/list", method = RequestMethod.GET,
      produces = MediaType.APPLICATION_JSON_VALUE)
  Object getAll(@RequestParam(value = "type", required = false) Object params);

  @RequestMapping(value = "/user/addUser", method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  Object add(@RequestBody Object obj);

  @RequestMapping(value = "/delete/{username}", method = RequestMethod.DELETE)
  Object delete(@PathVariable("username") String username);
}
