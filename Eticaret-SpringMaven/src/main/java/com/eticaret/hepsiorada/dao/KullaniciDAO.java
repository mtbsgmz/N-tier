package com.eticaret.hepsiorada.dao;

import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eticaret.hepsiorada.modal.KULLANICI;

@Repository
public class KullaniciDAO implements BaseDAO<KULLANICI> {

	@Autowired
	private SessionFactory session;

	@Override
	public void create(KULLANICI varlik) {
		session.getCurrentSession().save(varlik);

	}

	@Override
	public KULLANICI read(Long id) {
		// TODO Auto-generated method stub
		return session.getCurrentSession().get(KULLANICI.class, id);
	}

	@Override
	public void update(KULLANICI varlik) {
		session.getCurrentSession().update(varlik);

	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		KULLANICI varlik = read(id);
		session.getCurrentSession().setFlushMode(FlushMode.AUTO);
		session.getCurrentSession().delete(varlik);
	}

	@Override
	public List<KULLANICI> readAll() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from KULLANICI").getResultList();
	}

	@Override
	public void delete(KULLANICI varlik) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(varlik);

	}
}
