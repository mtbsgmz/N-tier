package com.eticaret.hepsiorada.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eticaret.hepsiorada.modal.SIPARISLER; 
@Repository
public class SiparislerDAO implements BaseDAO<SIPARISLER> {
@Autowired
	private SessionFactory session;

	@Override
	public void create(SIPARISLER varlik) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SIPARISLER read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(SIPARISLER varlik) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SIPARISLER> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(SIPARISLER varlik) {
		// TODO Auto-generated method stub
		
	}
	 
	 
}
