package com.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.entities.Kisi;

public class KisiDao implements ICrud<Kisi> {
	EntityManagerFactory emf = null;
	EntityManager em = null;

	public KisiDao() {
		emf = Persistence.createEntityManagerFactory("KayitGUI-SwingJavaJPADataLayer");
		em = emf.createEntityManager();
	}

	@Override
	public Boolean create(Kisi varlik) {
		try {
			em.getTransaction().begin();
			em.persist(varlik);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public Kisi read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Kisi> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean update(Kisi varlik) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean update(Kisi varlik, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
