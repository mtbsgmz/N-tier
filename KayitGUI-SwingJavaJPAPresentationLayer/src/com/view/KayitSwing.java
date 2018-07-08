package com.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.entities.ADRES;
import com.entities.Arac;
import com.entities.CINSIYET;
import com.entities.Kisi;


public class KayitSwing {

	private JFrame frame;
	private JTextField txtAd;
	private JTextField txtArac1;
	private JTextField txtArac2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KayitSwing window = new KayitSwing();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public KayitSwing() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 530, 277);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAd = new JLabel("Ad: ");
		lblAd.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAd.setBounds(10, 29, 46, 14);
		frame.getContentPane().add(lblAd);
		
		JLabel lblCinsiyet = new JLabel("Cinsiyet: ");
		lblCinsiyet.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCinsiyet.setBounds(10, 54, 70, 14);
		frame.getContentPane().add(lblCinsiyet);
		
		JLabel lblAdres = new JLabel("Adres: ");
		lblAdres.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAdres.setBounds(189, 29, 70, 14);
		frame.getContentPane().add(lblAdres);
		
		JLabel lblAraclar = new JLabel("ARACLAR");
		lblAraclar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAraclar.setBounds(10, 79, 96, 14);
		frame.getContentPane().add(lblAraclar);
		
		JLabel lblArac = new JLabel("Arac 1: ");
		lblArac.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblArac.setBounds(10, 99, 70, 14);
		frame.getContentPane().add(lblArac);
		
		JLabel lblArac_1 = new JLabel("Arac 2: ");
		lblArac_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblArac_1.setBounds(10, 124, 70, 14);
		frame.getContentPane().add(lblArac_1);
		
		txtAd = new JTextField();
		txtAd.setBounds(75, 28, 86, 20);
		frame.getContentPane().add(txtAd);
		txtAd.setColumns(10);
		
		txtArac1 = new JTextField();
		txtArac1.setBounds(75, 98, 86, 20);
		frame.getContentPane().add(txtArac1);
		txtArac1.setColumns(10);
		
		txtArac2 = new JTextField();
		txtArac2.setBounds(75, 123, 86, 20);
		frame.getContentPane().add(txtArac2);
		txtArac2.setColumns(10);
		
		TextArea txtAdres = new TextArea();
		txtAdres.setBounds(199, 54, 293, 89);
		frame.getContentPane().add(txtAdres);
		
		JComboBox cmbCinsiyet = new JComboBox();
		cmbCinsiyet.setModel(new DefaultComboBoxModel(CINSIYET.values()));
		cmbCinsiyet.setBounds(75, 53, 86, 20);
		frame.getContentPane().add(cmbCinsiyet);
		
		JButton btnKaydet = new JButton("KAYDET");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
		try {
			 ADRES adresim = new ADRES();
			 adresim.setACIK_ADRES(txtAdres.getText().trim());
			 
			 Arac arac1 = new Arac();//1arac nesnesi urettim
				//araclar.setID(ID); Sequence ten geldigi icin ID set edilmez
				arac1.setPLAKA(txtArac1.getText().trim());//araci set ettim
				
				 Arac arac2 = new Arac();//ikinci arac nesnesi urettim
				 arac2.setPLAKA(txtArac2.getText().trim());//ikinci araci set ettim
				 
				 List<Arac> araclarim = new ArrayList<>();// bir liste set ettim
				 	araclarim.add(arac1);//araclari icine set ettim
				 	araclarim.add(arac2);
			
			Kisi kisi = new Kisi();
			kisi.setAD(txtAd.getText().trim());
			kisi.setAdres(adresim);
			kisi.setAraclar(araclarim);
			kisi.setCREATED_TIME(Calendar.getInstance());
			kisi.setCinsiyet(CINSIYET.valueOf(cmbCinsiyet.getItemAt(cmbCinsiyet.getSelectedIndex()) + ""));
			new com.daos.KisiDao().create(kisi);
			JOptionPane.showMessageDialog(null, "Bilgiler basariyla kayit edilmistir!");
			
		} catch (Exception e2) {
			e2.printStackTrace();
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Bilgiler Kayit Edilemedi!!!");
		}
				
				
			}
		});
		btnKaydet.setBounds(403, 174, 89, 23);
		frame.getContentPane().add(btnKaydet);
		
		JButton btnYen = new JButton("YENI");
		btnYen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtAd.setText("");
				txtAdres.setText(" ");
				txtArac1.setText("");
				txtArac2.setText("");			
				cmbCinsiyet.setSelectedIndex(0);
				
			}
		});
		btnYen.setBounds(291, 174, 89, 23);
		frame.getContentPane().add(btnYen);
	}
}
