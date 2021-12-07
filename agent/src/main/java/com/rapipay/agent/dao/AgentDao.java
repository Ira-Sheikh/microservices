package com.rapipay.agent.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rapipay.agent.entity.Agent;



@Repository
public interface AgentDao extends JpaRepository<Agent,Integer>{ 
	
	
}





