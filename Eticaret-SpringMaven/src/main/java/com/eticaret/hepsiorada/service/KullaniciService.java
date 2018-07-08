package com.eticaret.hepsiorada.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eticaret.hepsiorada.dao.KullaniciDAO;
import com.eticaret.hepsiorada.modal.KULLANICI;

@Service("kullaniciService")
@Transactional
public class KullaniciService implements BaseService<KULLANICI> {

	@Autowired
	KullaniciDAO kullaniciDAO;

	@Override
	public void create(KULLANICI varlik) {
		// TODO Auto-generated method stub
		kullaniciDAO.create(varlik);
	}

	@Override
	public KULLANICI read(Long id) {
		// TODO Auto-generated method stub
		return kullaniciDAO.read(id);
	}

	@Override
	public void update(KULLANICI varlik) {
		// TODO Auto-generated method stub
		kullaniciDAO.update(varlik);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		KULLANICI varlik = read(id);
		kullaniciDAO.delete(varlik);
	}

	@Override
	public List<KULLANICI> readAll() {
		// TODO Auto-generated method stub
		return kullaniciDAO.readAll();
	}

	@Override
	public void delete(KULLANICI varlik) {
		// TODO Auto-generated method stub
		kullaniciDAO.delete(varlik);
	}

}
