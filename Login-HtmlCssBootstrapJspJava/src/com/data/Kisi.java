package com.data;

public class Kisi {
	
	public String kullaniciAdi;
	public String parola;
	public boolean hatirla;
	public Kisi() {
		kullaniciAdi = null;
		parola = null;
		hatirla = false;
	}
	public String getKullaniciAdi() {
		return kullaniciAdi;
	}
	public void setKullaniciAdi(String kullaniciAdi) {
		this.kullaniciAdi = kullaniciAdi;
	}
	public String getParola() {
		return parola;
	}
	public void setParola(String parola) {
		this.parola = parola;
	}
	public boolean isHatirla() {
		return hatirla;
	}
	public void setHatirla(boolean hatirla) {
		this.hatirla = hatirla;
	}
	
	

}
