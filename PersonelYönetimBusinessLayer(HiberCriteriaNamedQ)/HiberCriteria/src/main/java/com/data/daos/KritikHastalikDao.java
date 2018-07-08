package com.data.daos;

import java.util.List;

import org.hibernate.Session;

import com.data.entities.KritikHastalik;
import com.data.utils.HibernateUtil;

public class KritikHastalikDao implements ICrud<KritikHastalik> {
	Session em = HibernateUtil.getSessionFactory().getCurrentSession();

	public KritikHastalikDao() {

	}

	@Override
	public Boolean create(KritikHastalik varlik) {
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
	public KritikHastalik read(Long id) {
		try {
			KritikHastalik kritikHastalik = em.find(KritikHastalik.class, id);
			return kritikHastalik;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (em.isOpen())
				em.close();
		}
		return null;
	}

	@Override
	public List<KritikHastalik> readAll() {
		try {
			List<KritikHastalik> kritikHastalik = em.createQuery("SELECT i FROM KritikHastalik k WHERE i.deleted=false")
					.getResultList();
			return kritikHastalik;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (em.isOpen())
				em.close();
		}
		return null;
	}

	@Override
	public Boolean update(KritikHastalik varlik) {
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
	public Boolean update(KritikHastalik varlik, Long id) {
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
		KritikHastalik kritikHastalik = read(id);
		try {
			em.getTransaction().begin();
			em.remove(kritikHastalik);
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
