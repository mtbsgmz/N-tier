package com.eticaret.hepsiorada.dao;

import java.util.List;

import org.hibernate.FlushMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eticaret.hepsiorada.modal.ADRES;

@Repository
public class AdresDAO implements BaseDAO<ADRES> {

	@Autowired
	private SessionFactory session;

	@Override
	public void create(ADRES varlik) {
		session.getCurrentSession().save(varlik);
	}

	@Override
	public ADRES read(Long id) {
		return session.getCurrentSession().get(ADRES.class, id);
	}

	@Override
	public void update(ADRES varlik) {
		session.getCurrentSession().update(varlik);
	}

	@Override
	public void delete(Long id) {

		ADRES varlik = read(id);
		session.getCurrentSession().setFlushMode(FlushMode.AUTO);
		session.getCurrentSession().delete(varlik);
	}

	@Override
	public List<ADRES> readAll() {
		return session.getCurrentSession().createQuery("from ADRES").getResultList();
	}

	@Override
	public void delete(ADRES varlik) {
		session.getCurrentSession().delete(varlik);
	}

}
