package com.cisco.microservices.gateway.controller;

import com.cisco.microservices.gateway.service.InventoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

  @Autowired
  InventoryService inventoryService;

  @RequestMapping(method = RequestMethod.GET)
  Object getAll() {
    return inventoryService.getAll();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  Object get(@PathVariable("id") Long id) {
    return inventoryService.get(id);
  }

  @RequestMapping(value = "/create", method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  Object add(@RequestBody Object obj) {
    return inventoryService.add(obj);
  }

  @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  Object update(@PathVariable("id") Long id, @RequestBody Object obj) {
    return inventoryService.update(id, obj);
  }

  @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
  Object delete(@PathVariable("id") Long id) {
    return inventoryService.delete(id);
  }
}
