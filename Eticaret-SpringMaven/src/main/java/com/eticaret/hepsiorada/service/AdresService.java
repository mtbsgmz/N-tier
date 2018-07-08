package com.eticaret.hepsiorada.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eticaret.hepsiorada.dao.AdresDAO;
import com.eticaret.hepsiorada.modal.ADRES;

@Service
@Transactional
public class AdresService {

	@Autowired
	private AdresDAO adresDao;

	public void create(ADRES varlik) {
		adresDao.create(varlik);
	}

	public ADRES read(Long id) {
		// TODO Auto-generated method stub
		return adresDao.read(id);
	}

	public void update(ADRES varlik) {
		// TODO Auto-generated method stub
		adresDao.update(varlik);
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		ADRES varlik = read(id);
		adresDao.delete(varlik);
	}

	public List<ADRES> readAll() {
		// TODO Auto-generated method stub
		return adresDao.readAll();
	}

	public void delete(ADRES varlik) {
		// TODO Auto-generated method stub
		adresDao.delete(varlik);
	}

}
