package com.example.demo.service.impliments;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.persistance.dao.RendezvousRepository;
import com.example.demo.persistance.entities.Rendezvous;
import com.example.demo.service.interfaces.IRendezvous;

@Service
public class RendezvousService implements IRendezvous{

	@Autowired
	RendezvousRepository rendezvousrepository;
	
	@Override
	public Rendezvous saveRendezvous(Rendezvous rendezvous) {
		// TODO Auto-generated method stub
		return rendezvousrepository.save(rendezvous);
	}

	@Override
	public Rendezvous updateRendezvous(Rendezvous rendezvous) {
		// TODO Auto-generated method stub
		return rendezvousrepository.saveAndFlush(rendezvous);
	}

	@Override
	public boolean deleteRendezvous(Long id) {
		// TODO Auto-generated method stub
		rendezvousrepository.deleteById(id);
		return true;
	}

	@Override
	public List<Rendezvous> getListRendezvous() {
		// TODO Auto-generated method stub
		return  rendezvousrepository.findAll();
	}

	@Override
	public Rendezvous getRendezvous(Long id) {
		// TODO Auto-generated method stub
		return  rendezvousrepository.findById(id).get();
	}

	public Rendezvous findRendezvousById(Long id) {
		// TODO Auto-generated method stub
		return  rendezvousrepository.findById(id).get();
	}

	@Override
	public int getQuantityOfRendezvous() {
		// TODO Auto-generated method stub
		return rendezvousrepository.getQuantityOfRendezvous();
	}

	@Override
	public Rendezvous getRendezvousByIdRendezvous(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rendezvous findRendezvousByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rendezvous findRendezvousByName(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
