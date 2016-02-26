package com.cisco.microservices.gateway.controller;

import com.cisco.microservices.gateway.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

  @Autowired
  ProductService productService;

  @RequestMapping(value = "/list", method = RequestMethod.GET)
  Object getAll() {
    return productService.getAll();
  }

  @RequestMapping(value = "/addProduct", method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  Object add(@RequestBody Object obj) {
    return productService.add(obj);
  }

  @RequestMapping(value = "/updateProduct", method = RequestMethod.PUT,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  Object update(@RequestBody Object obj) {
    return productService.update(obj);
  }

  @RequestMapping(value = "/delete/{productName}", method = RequestMethod.DELETE)
  Object delete(@PathVariable("productName") String productName) {
    return productService.delete(productName);
  }

}
