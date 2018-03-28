package com.yonet;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.entities.Adres;
import com.entities.Arac;
import com.entities.CINSIYET;
import com.entities.Kisi;

public class Yonet {
	
	private void islem() {
		
		Arac arac1 = new Arac();//1arac nesnesi urettim
		//araclar.setID(ID); Sequence ten geldigi icin ID set edilmez
		arac1.setPLAKA("06FD9396");//araci set ettim
		
		 Arac arac2 = new Arac();//ikinci arac nesnesi urettim
		 arac2.setPLAKA("06DG2590");//ikinci araci set ettim
		 
		 List<Arac> araclarim = new ArrayList<>();// bir liste set ettim
		 	araclarim.add(arac1);//araclari icine set ettim
		 	araclarim.add(arac2);
		 	
		
		 Adres adresim = new Adres();
		 adresim.setACIK_ADRES("yenimahall Ankara// baya acik oldu");
		 
		 Kisi kisi = new Kisi();
		 kisi.setAD("Mehmet");
		 kisi.setCinsiyet(CINSIYET.ERKEK);
		 kisi.setAdres(adresim);//OneToOne oldugu icin direk nesneyi set edebilirim
		 kisi.setAraclar(araclarim);//OneToMany oldugu icin list set etmem gerek.
		 kisi.setCREATED_TIME(Calendar.getInstance());
		 new com.daos.KisiDao().create(kisi);
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Yonet().islem();
		
	}

}
