package com.ordrd.controller.rest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ordrd.model.Customer;
import com.ordrd.model.Location;
import com.ordrd.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService secondService;

	@RequestMapping(value = "/getCustomer", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer getCustomer(@RequestParam(value = "id", defaultValue = "1") String id) {
		Customer customer = secondService.findById(Integer.parseInt(id));
		return customer;
	}

	@RequestMapping(value = "/getAllCustomer", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> getAllCustomer(String name) {
		return secondService.findAll();
	}

	@RequestMapping(value = "/createCustomer", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer createCustomer(@RequestParam(value = "id", defaultValue = "1") String id,
			@RequestParam(value = "name", defaultValue = "Guest") String name) {
		Customer customer = new Customer();
		customer.setName(name);
		Location location = new Location();
		location.setId(33);
		customer.setLocation(location);
		secondService.insert(customer);
		return secondService.findById(Integer.parseInt(id));
	}

	@RequestMapping(value = "/updateCustomer", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer updateCustomer(@RequestParam(value = "id", defaultValue = "1") String id,
			@RequestParam(value = "name", defaultValue = "Guest") String name) {
		Customer customer = new Customer(Integer.parseInt(id));
		customer.setName(name);
		secondService.update(customer);
		return secondService.findById(Integer.parseInt(id));
	}

	@RequestMapping(value = "/deleteCustomer", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteCustomer(@RequestParam(value = "id", defaultValue = "1") String id) {
		Customer customer = new Customer(Integer.parseInt(id));
		// customer.setLocation(new Location());
		secondService.delete(customer);
	}

	@RequestMapping(value = "/getImageFile", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
	public ResponseEntity<InputStreamResource> getImageFile(
			@RequestParam(value = "id", defaultValue = "1") String id) {
		String file = getClass().getClassLoader().getResource("img/house_yellow.png").getFile();

		try {
			InputStreamResource isr = new InputStreamResource(new FileInputStream(file));
			return ResponseEntity.ok().body(isr);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}
}
