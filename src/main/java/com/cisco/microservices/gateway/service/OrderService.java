package com.cisco.microservices.gateway.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("ORDER-SERVICE")
public interface OrderService {

  @RequestMapping(value = "/api/orders", method = RequestMethod.GET)
  Object getAll();

  @RequestMapping(value = "/api/order/{id}", method = RequestMethod.GET)
  Object get(@PathVariable("id") Long id);

  @RequestMapping(value = "/api/order/insert", method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  Object add(@RequestBody Object obj);

  @RequestMapping(value = "/api/order/update/{id}", method = RequestMethod.PUT,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  Object update(@PathVariable("id") Long id, @RequestBody Object obj);

  @RequestMapping(value = "/api/order/delete/{id}", method = RequestMethod.DELETE)
  Object delete(@PathVariable("id") Long id);
}
