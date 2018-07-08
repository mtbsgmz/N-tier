package com.data.daos;

import java.util.List;

import javax.persistence.LockModeType;
import javax.persistence.NoResultException;

import org.hibernate.Session;

import com.data.entities.Kisi;
import com.data.utils.HibernateUtil;

public class KisiDao implements ICrud<Kisi> {

	Session em = HibernateUtil.getSessionFactory().getCurrentSession();
	
	public KisiDao() {
		 
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
		}finally {
			if(em.isOpen()) em.close();
		}
		return false;

	}

	@Override
	public Kisi read(Long id) {
		try {
			em.getTransaction().begin();
			Kisi kisi = em.find(Kisi.class, id);
			em.getTransaction().commit();
			return kisi;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(em.isOpen()) em.close();
		}
		return null;
	}
	
	public Kisi readByPar(Long id) {
		try {
			em.getTransaction().begin();
			Kisi kisi = em.createQuery("SELECT k FROM Kisi k WHERE k.ID =:kisiid",Kisi.class)
					.setParameter("kisiid", id)
					.getSingleResult();
			em.getTransaction().commit();
			return kisi;
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(em.isOpen()) em.close();
		}
		return null;
	}
	
	public Kisi readByParN(Long id) {
		try {
			em.getTransaction().begin();
			Kisi kisi = em.createNamedQuery("Kisi.findById",Kisi.class)
					.setParameter("kisipar", id)
					.getSingleResult();
			em.getTransaction().commit();
			return kisi;
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(em.isOpen()) em.close();
		}
		return null;
	}
	
	
	@Override
	public List<Kisi> readAll() {
		try {
			em.getTransaction().begin();
			List<Kisi> kisiler 
			= em.createQuery("SELECT k FROM Kisi k WHERE k.deleted=false").getResultList();
			em.getTransaction().commit();
			return kisiler;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(em.isOpen()) em.close();
		}
		return null;
	}
	public List<Kisi> readAllN() {
		try {
			em.getTransaction().begin();
			List<Kisi> kisiler 
			= em.createNamedQuery("Kisi.findAll").getResultList();
			em.getTransaction().commit();
			
			return kisiler;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(em.isOpen()) em.close();
		}
		return null;
	}
	@Override
	public Boolean update(Kisi varlik) {
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
	public Boolean update(Kisi varlik, Long id) {
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
		Kisi kisi = read(id);
		try {
			em.getTransaction().begin();
			em.remove(kisi);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(em.isOpen()) em.close();
		}
		return false;
	}

	public Boolean delete(Kisi kisi) {		
		try {
			em.getTransaction().begin();
			
			if(!em.contains(kisi)){
				kisi = (Kisi) em.merge(kisi);
			}			
			em.remove(kisi);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(em.isOpen()) em.close();
		}
		return false;
	}
	
	public Boolean deleteN(Long id) {		
		try {
			em.getTransaction().begin();
			em.createNamedQuery("Kisi.deleteById", Kisi.class)
			.setParameter("kisiid", id).executeUpdate();
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(em.isOpen()) em.close();
		}
		return false;
	}
	
	
	public Boolean deleteSoft(Kisi varlik){
		try {
			em.getTransaction().begin();
			varlik.setSilindi(true);
			em.lock(varlik, LockModeType.OPTIMISTIC);
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
}
