package com.rapipay.client.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rapipay.client.dao.ClientDao;
import com.rapipay.client.entity.Client;
@Service
public class ClientServicesImpl implements ClientServices{

	@Autowired
	ClientDao clientDao;
	
	
	
	
	@Override
	public Client getClient(int id) {
		return clientDao.findById(id).get();
	}

	@Override
	public Client insertClient(Client client) {
		return clientDao.saveAndFlush(client);
	}

	@Override
	public Object updateClient(Client client, int id) {
		if(clientDao.existsById(id)) {
			Client oldClient = clientDao.findById(id).get();
			
			oldClient.setClientName(client.getClientName() != null ? client.getClientName() : oldClient.getClientName());
			oldClient.setClientState(client.getClientState() != null ? client.getClientState() : oldClient.getClientState());
			oldClient.setClientPassword(client.getClientPassword() != null ? client.getClientPassword() : oldClient.getClientPassword());
			oldClient.setPhoneNumber(client.getPhoneNumber() != 0 ? client.getPhoneNumber() : oldClient.getPhoneNumber());
			oldClient.setWalletBalance(client.getWalletBalance() != 0 ? client.getWalletBalance() : oldClient.getWalletBalance());
			oldClient.setAgentId(client.getAgentId()!=0?client.getAgentId():oldClient.getAgentId());
		    return clientDao.saveAndFlush(oldClient);
		}
		return "Client Not Found";
	}
@Override
public List<Client> getClientByAgentId(int id)
{
	
	List list=clientDao.findAll();
	
	return  (List<Client>) list.stream().filter(client-> ((Client) client).getAgentId()==(id)).collect(Collectors.toList());
	
}
	@Override
	public String deleteClient(int id) {
		clientDao.deleteById(id);
		return "Client Deleted";
	}

	@Override
	public List<Client> getAllClient() {
	return clientDao.findAll();
	}
}
