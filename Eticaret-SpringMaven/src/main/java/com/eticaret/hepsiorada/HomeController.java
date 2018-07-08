package com.eticaret.hepsiorada;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eticaret.hepsiorada.modal.KULLANICI;
import com.eticaret.hepsiorada.service.AdresService;
import com.eticaret.hepsiorada.service.BaseService;
import com.eticaret.hepsiorada.service.KullaniciService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	@Qualifier("kullaniciService")
	BaseService<KULLANICI> kullaniciService;

	@Autowired
	AdresService adresService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		try {

			KULLANICI kul = kullaniciService.read(1L);
			if(kul==null) kul = new KULLANICI();
			model.addAttribute("kullanici", kul);
			System.out.println("Kullanıcı:" + kul);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {

			List<KULLANICI> kullanicilar = kullaniciService.readAll();
			model.addAttribute("kullanicilar", kullanicilar);

		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("serverTime", formattedDate);

		return "kullanicilar";
	}

	@RequestMapping(value = "/kullaniciEkle", method = RequestMethod.POST)
	public String dummy(@ModelAttribute("kullanici") KULLANICI kullanici, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {

			model.addAttribute("hatakodu", "Veriler Uygun Değil");
			return "kullanicilar";
		}
		System.out.println("Kullanıcı:" + kullanici);
		kullaniciService.create(kullanici);
		
		try {

			List<KULLANICI> kullanicilar = kullaniciService.readAll();
			model.addAttribute("kullanicilar", kullanicilar);

		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
		return "kullanicilar";
	}

}
