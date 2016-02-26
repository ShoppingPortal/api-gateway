package com.cisco.microservices.gateway.controller;

import com.cisco.microservices.gateway.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrderController {

  @Autowired
  OrderService orderService;

  @RequestMapping(value = "/orders", method = RequestMethod.GET)
  Object getAll() {
    return orderService.getAll();
  }

  @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
  Object get(@PathVariable("id") Long id) {
    return orderService.get(id);
  }

  @RequestMapping(value = "/order/insert", method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  Object add(@RequestBody Object obj) {
    return orderService.add(obj);
  }

  @RequestMapping(value = "/order/update/{id}", method = RequestMethod.PUT,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  Object update(@PathVariable("id") Long id, @RequestBody Object obj) {
    return orderService.update(id, obj);
  }

  @RequestMapping(value = "/order/delete/{id}", method = RequestMethod.DELETE)
  Object delete(@PathVariable("id") Long id) {
    return orderService.delete(id);
  }
}
