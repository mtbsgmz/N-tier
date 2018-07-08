package com.data.daos;

import java.util.List;

import org.hibernate.Session;

import com.data.entities.IsDeneyimi;
import com.data.utils.HibernateUtil;

public class IsDeneyimiDao implements ICrud<IsDeneyimi> {
	Session em = HibernateUtil.getSessionFactory().getCurrentSession();
	
 
	public IsDeneyimiDao() {
		 
	}

	@Override
	public Boolean create(IsDeneyimi varlik) {
		try {
			em.getTransaction().begin();
			em.persist(varlik);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(em.isOpen()) em.close();
		}
		return false;

	}

	@Override
	public IsDeneyimi read(Long id) {
		try {
			IsDeneyimi isDeneyimi = em.find(IsDeneyimi.class, id);
			return isDeneyimi;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(em.isOpen()) em.close();
		}
		return null;
	}

	@Override
	public List<IsDeneyimi> readAll() {
		try {
			List<IsDeneyimi> isDeneyimi = em.createQuery("SELECT i FROM IsDeneyimi k WHERE i.deleted=false")
					.getResultList();
			return isDeneyimi;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(em.isOpen()) em.close();
		}
		return null;
	}

	@Override
	public Boolean update(IsDeneyimi varlik) {
		try {
			em.getTransaction().begin();
			em.merge(varlik);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(em.isOpen()) em.close();
		}
		return false;
	}

	@Override
	public Boolean update(IsDeneyimi varlik, Long id) {
		try {
			em.getTransaction().begin();
			varlik.setID(id);
			em.merge(varlik);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(em.isOpen()) em.close();
		}
		return false;
	}

	@Override
	public Boolean delete(Long id) {
		IsDeneyimi isDeneyimi = read(id);
		try {
			em.getTransaction().begin();
			em.remove(isDeneyimi);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(em.isOpen()) em.close();
		}
		return false;
	}

}
