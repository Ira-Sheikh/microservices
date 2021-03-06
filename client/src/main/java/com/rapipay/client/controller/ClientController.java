package com.rapipay.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.rapipay.client.entity.Client;
import com.rapipay.client.services.ClientServices;



@RestController
public class ClientController {
	
	@Autowired
	ClientServices service;

	@GetMapping("/client/{id}")
	public Client getClient(@PathVariable int id) {
		return service.getClient(id);
	}
	
	@GetMapping("/client/agent/{agentid}")
	public List<Client> getClientByAgentId(@PathVariable int agentid) {
		return service.getClientByAgentId(agentid);
	}
	
	
	
	@GetMapping("/client/all")
	public List<Client> getAllClient() {
		return service.getAllClient();
	}
	
	@PostMapping("/client/insert")
	public Client insertClient(@RequestBody Client client) {
		return service.insertClient(client);
	}
	
	@PutMapping("/client/update/{id}")
	public Object updateClient(@RequestBody Client client, @PathVariable int id) {
		return service.updateClient(client, id);
	}
	
	@DeleteMapping("/client/delete/{id}")
	public String deleteClient(@PathVariable int id) {
		return service.deleteClient(id);
	}
}
