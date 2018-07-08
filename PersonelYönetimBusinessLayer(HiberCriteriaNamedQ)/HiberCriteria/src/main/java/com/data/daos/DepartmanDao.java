package com.data.daos;

import java.util.List;

import org.hibernate.Session;

import com.data.entities.Departman;
import com.data.utils.HibernateUtil;

public class DepartmanDao implements ICrud<Departman> {
	Session em = HibernateUtil.getSessionFactory().getCurrentSession();

	public DepartmanDao() {

	}

	@Override
	public Boolean create(Departman varlik) {
		try {
			em.getTransaction().begin();
			em.persist(varlik);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (em.isOpen())
				em.close();
		}
		return false;

	}

	@Override
	public Departman read(Long id) {
		try {
			Departman departman = em.find(Departman.class, id);
			return departman;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (em.isOpen())
				em.close();
		}
		return null;
	}

	@Override
	public List<Departman> readAll() {
		try {
			List<Departman> departman = em.createQuery("SELECT i FROM Departman k WHERE i.deleted=false")
					.getResultList();
			return departman;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (em.isOpen())
				em.close();
		}
		return null;
	}

	@Override
	public Boolean update(Departman varlik) {
		try {
			em.getTransaction().begin();
			em.merge(varlik);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (em.isOpen())
				em.close();
		}
		return false;
	}

	@Override
	public Boolean update(Departman varlik, Long id) {
		try {
			em.getTransaction().begin();
			varlik.setID(id);
			em.merge(varlik);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (em.isOpen())
				em.close();
		}
		return false;
	}

	@Override
	public Boolean delete(Long id) {
		Departman departman = read(id);
		try {
			em.getTransaction().begin();
			em.remove(departman);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (em.isOpen())
				em.close();
		}
		return false;
	}

}
