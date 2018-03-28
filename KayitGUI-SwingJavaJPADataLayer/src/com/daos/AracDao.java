package com.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.entities.Arac;

public class AracDao implements ICrud<Arac> {
	
	EntityManagerFactory emf = null;
	EntityManager em = null;

	public AracDao() {
		emf = Persistence.createEntityManagerFactory("KayitGUI-SwingJavaJPADataLayer");
		em = emf.createEntityManager();
	}

	@Override
	public Boolean create(Arac varlik) {
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
	public Arac read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Arac> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean update(Arac varlik) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean update(Arac varlik, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
