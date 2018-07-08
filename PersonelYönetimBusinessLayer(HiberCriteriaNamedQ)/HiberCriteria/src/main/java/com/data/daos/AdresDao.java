package com.data.daos;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;

import com.data.entities.Adres;
import com.data.utils.HibernateUtil;

public class AdresDao implements ICrud<Adres> {

	Session em = HibernateUtil.getSessionFactory().getCurrentSession();

	public AdresDao() {

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
		} finally {
			if (em.isOpen())
				em.close();
		}
		return false;
	}

	@Override
	public Adres read(Long id) {
		try {
			return em.find(Adres.class, id);
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (em.isOpen())
				em.close();
		}
		return null;
	}

	@Override
	public List<Adres> readAll() {
		try {
			return em.createNamedQuery("Adres.findAll", Adres.class).getResultList();
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (em.isOpen())
				em.close();
		}
		return null;
	}

	@Override
	public Boolean update(Adres varlik) {
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
		return null;
	}

	@Override
	public Boolean update(Adres varlik, Long id) {
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
		return null;
	}

	@Override
	public Boolean delete(Long id) {
		try {
			Adres adres = read(id);
			em.getTransaction().begin();
			em.remove(adres);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (em.isOpen())
				em.close();
		}
		return null;
	}

}
