package com.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.entities.ADRES;

public class AdresDao implements ICrud<ADRES> {
	EntityManagerFactory emf = null;
	EntityManager em = null;

	public AdresDao() {
		emf = Persistence.createEntityManagerFactory("KayitGUI-SwingJavaJPADataLayer");
		em = emf.createEntityManager();
	}

	@Override
	public Boolean create(ADRES varlik) {
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
	public ADRES read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ADRES> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean update(ADRES varlik) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean update(ADRES varlik, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
