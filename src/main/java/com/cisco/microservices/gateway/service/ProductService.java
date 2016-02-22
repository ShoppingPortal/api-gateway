package com.cisco.microservices.gateway.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("PRODUCTS-SERVICE")
public interface ProductService {

  @RequestMapping(value = "/product/list", method = RequestMethod.GET)
  Object getAll();

  @RequestMapping(value = "/product/addProduct", method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  Object add(Object obj);

  @RequestMapping(value = "/product/updateProduct", method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  Object update(Object obj);

  @RequestMapping(value = "/product/delete/{productId}", method = RequestMethod.GET)
  Object delete(@PathVariable("productId") Long productId);

}
