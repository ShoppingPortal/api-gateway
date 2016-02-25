package com.cisco.microservices.gateway.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("INVENTORY-SERVICE")
public interface InventoryService {

  @RequestMapping(value = "/inventory", method = RequestMethod.GET)
  Object getAll();

  @RequestMapping(value = "/inventory/{id}", method = RequestMethod.GET)
  Object get(@PathVariable("id") Long id);

  @RequestMapping(value = "/inventory/create", method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  Object add(@RequestBody Object obj);

  @RequestMapping(value = "/inventory/update/{id}", method = RequestMethod.PUT,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  Object update(@PathVariable("id") Long id, @RequestBody Object obj);

  @RequestMapping(value = "/inventory/delete/{id}", method = RequestMethod.DELETE)
  Object delete(@PathVariable("id") Long id);
}
