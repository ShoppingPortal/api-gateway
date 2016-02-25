package com.cisco.microservices.gateway.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("PRODUCTS-SERVICE")
public interface ProductService {

  @RequestMapping(value = "/product/list", method = RequestMethod.GET)
  Object getAll();

  @RequestMapping(value = "/product/addProduct", method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  Object add(@RequestBody Object obj);

  @RequestMapping(value = "/product/updateProduct", method = RequestMethod.PUT,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  Object update(@RequestBody Object obj);

  @RequestMapping(value = "/product/delete/{productName}", method = RequestMethod.DELETE)
  Object delete(@PathVariable("productName") String productName);
}
