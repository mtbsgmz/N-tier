package tr.com.deneme.dao;

import java.util.List;

import org.hibernate.Session;

import tr.com.deneme.entities.Person;
import tr.com.deneme.interfaces.ICRUD;
import tr.com.deneme.tools.HibernateUtil;

public class PersonDAO implements ICRUD<Person> {

	public boolean create(Person varlik) {
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();

			session.getTransaction().begin();
			if (!session.contains(varlik)) {
				// session.merge(varlik);
			}
			session.saveOrUpdate(varlik);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}
		return false;
	}

	public Person read(Long id) {
		try {
			Person kisi = HibernateUtil.getSessionFactory().openSession().get(Person.class, id);
			return kisi;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean update(Person varlik, Long id) {
		return false;
	}

	public boolean update(Person varlik) {
		return false;
	}

	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Person> readAll() {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.getTransaction().begin();
			return session.createQuery("from Person").getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session.isOpen())
				session.close();
		}

		return null;
	}

}