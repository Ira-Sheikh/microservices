package com.rapipay.agent.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rapipay.agent.entity.Agent;

public interface AgentServices {

	public Agent getAgent(int id);
	
	public List<Agent> getAllAgent();

	public Agent insertAgent(Agent agent);

	public Object updateAgent(Agent agent, int id);
	public String deleteAgent(int id);
	
}
