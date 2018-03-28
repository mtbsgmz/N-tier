package com.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.entities.Adres;

public class AdresDao implements ICrud<Adres> {
	EntityManagerFactory emf = null;
	EntityManager em = null;

	public AdresDao() {
		emf = Persistence.createEntityManagerFactory("KayitGUI-SwingJavaJPADataLayer");
		em = emf.createEntityManager();
	}

	@Override
	public Boolean create(Adres varlik) {
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
	public Adres read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Adres> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean update(Adres varlik) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean update(Adres varlik, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
