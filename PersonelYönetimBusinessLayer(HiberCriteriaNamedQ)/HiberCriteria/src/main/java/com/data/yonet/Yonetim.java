package com.data.yonet;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.data.entities.Kisi;
import com.data.utils.HibernateUtil;

@SuppressWarnings("deprecation")
public class Yonetim {

	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	
	
	public void islem(){
		session.getTransaction().begin();
		
		//Type 1 Single Result
		Query<Kisi> q = session.createQuery("from Kisi k where k.id =:kid");
		q.setParameter("kid", 1L);
		
		//Type 2 Result List
		Query<Kisi> q2 = session.createQuery("from Kisi k");
		
		
		try {
		////Type 1 Single Result
		Kisi kisi = q.getSingleResult();	
		
		//Type 2 Result List
		List<Kisi> kisilistesi = q.getResultList();
		Kisi kisim = kisilistesi.isEmpty() ? null: kisilistesi.get(0);
		System.out.println("Kisi:"+kisim);
		
		//List<Kisi> liste = q2.getResultList();
		
		//liste.forEach(System.out::println);
		
		//System.out.println("Kisi:"+kisi);
		
		} catch (NoResultException e) {
		////Type 1 Single Result
			System.out.println("Kiþi Bulunamadý !");
		}
		
		
		if(session.isConnected()){
			System.out.println("Baðlý");
		}else{
			System.out.println("Kopuk");
		}
		session.getTransaction().commit();
		
	}
	
	
	public void islemCriteria(){
		session.getTransaction().begin();
		try {
			
			Criteria cri = session.createCriteria(Kisi.class);
			cri.setFirstResult(0);
			cri.setMaxResults(5);
			//Adý A ile baþlayan kullanýcýlarý getir.
			
			//OR ile baðlamak için
			/*cri.add(Restrictions.or(
					Restrictions.ilike("AD", "A%"),
					Restrictions.ilike("SOYAD", "B%")
					));
			*/
			
			
			//And ile baðlamak için
			//cri.add(Restrictions.ilike("AD", "A%"));
			//cri.add(Restrictions.ilike("SOYAD", "B%"));
			
			//ID si 24 den büyük olanlarý getir.		
			//cri.add(Restrictions.gt("ID", 24L));
			
			//ID si 24 ile 28 arasýnda olanlarý getir.		
			//cri.add(Restrictions.between("ID", 24L, 28L));
			
			//createdTime alaný bul olmayanlar
			//cri.add(Restrictions.isNotNull("createdTime"));
			
			//IN Komutunun kullanýmý
			/*List<Long> ids = new ArrayList();
			ids.add(26L);
			ids.add(27L);
			ids.add(28L);		*/	
			//cri.add(Restrictions.in("ID", ids));
			
			//Ýstenilen parametreye göre sýralama yaptýrýr.
			//cri.addOrder(Order.asc("ID"));
			//cri.addOrder(Order.desc("AD"));
			
			//Criteria da çift sýralama özelliði
			//cri.add(Restrictions.ilike("AD","A%"));
			//cri.addOrder(Property.forName("AD").asc());
			//cri.addOrder(Property.forName("SOYAD").desc());
			
			//Obje ile where koþulu oluþturma
			/*Kisi kisi = new Kisi();
			kisi.setAD("Ahmet");			
			cri.add(Example.create(kisi));
			cri.setFetchMode("adres", FetchMode.EAGER);
			cri.setFetchMode("departmanlar", FetchMode.EAGER);
		 
			
			List<Kisi> liste = cri.list();
			
			liste.forEach(data->{
				System.out.println("Kiþi Adr:"+data.getAdres().get(0).getACIK_ADRES());
			});
			*/
			cri.setProjection(Projections.rowCount());
			//cri.add(Restrictions.isNotNull("createdTime"));
			
			Long adet = (Long) cri.uniqueResult();
			System.out.println("Adet:"+adet);
			//liste.forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		session.getTransaction().commit();
	}
	
	public static void main(String[] args) {
		 //new Yonetim().islem();
		 new Yonetim().islemCriteria();	
	
	}

}
