package com.rapipay.agent.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rapipay.agent.entity.*;
import com.rapipay.agent.services.AgentServices;


@RestController

public class AgentController {

	@Autowired
	AgentServices service;
	
	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/agent/{id}")
	public Agent getAgent(@PathVariable int id) {
		Agent a=this.service.getAgent(id);
		ArrayList client=this.restTemplate.getForObject("http://localhost:8082/client/agent/"+a.getAgentId(),ArrayList.class);
		a.setClient(client);
		return service.getAgent(id);
	}
   
    
    
	@GetMapping("/agent/all")
	public List<Agent> getAllAgent() {
		int i=0;
		List<Agent> l=this.service.getAllAgent();
		ArrayList client=this.restTemplate.getForObject("http://localhost:8082/client/agent/"+l.get(i).getAgentId(),ArrayList.class);
		
		l.get(i).setClient(client);
		i++;
		return service.getAllAgent();
	}

	@PostMapping("/agent/insert")
	public Agent insertAgent(@RequestBody Agent agent) {
		return service.insertAgent(agent);
	}

	@PutMapping("/agent/update/{id}")
	public Object updateAgent(@RequestBody Agent agent, @PathVariable int id) {
		System.out.println("hello");
		return service.updateAgent(agent, id);
	}

	@DeleteMapping("/agent/delete/{id}")
	public String deleteAgent(@PathVariable int id) {
		return service.deleteAgent(id);
	}
}
