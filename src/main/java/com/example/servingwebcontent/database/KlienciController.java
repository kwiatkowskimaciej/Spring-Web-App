package com.example.servingwebcontent.database;

import com.example.servingwebcontent.registration.UserDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.util.List;

@Controller
public class KlienciController {

    @Autowired
    private KlienciDAO dao;

    @Autowired
    private AdresyDAO daoAdresy;

    @Autowired
    private TelefonyDAO daoTelefony;

    @Autowired
    private SalonyDAO salonyDAO;



    @RequestMapping(value={"/klient"})
    public String showDbPage(Model model) {
        String text = "Some text to display at view";
        model.addAttribute("someText", text);
        List<Klient> listKlient = dao.findAll();
        model.addAttribute("listKlient", listKlient);

        return "klient/klient";}

    @GetMapping("/new_klient")
    public String showNewForm(Model model) {
        Klient klient = new Klient();
        model.addAttribute("klient", klient);
        List<Adres> listAdres = daoAdresy.findAll();
        List<Telefon> listTelefon = daoTelefony.findAll();
        List<Salon> listSalon = salonyDAO.findAll();
        model.addAttribute("listAdres", listAdres);
        model.addAttribute("listTelefon", listTelefon);
        model.addAttribute("listSalon", listSalon);

        return "klient/new_klient";
    }

    @RequestMapping(value = "/save_klient", method = RequestMethod.POST)
    public String save(@ModelAttribute("klient") Klient klient) {
        try {
            dao.save(klient);
        } catch (Exception exception) {
            return "redirect:/database_integrity_error";
        }
        return "redirect:/klient";
    }

    @RequestMapping("/edit_klient/{id}")
    public ModelAndView showEditForm(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("klient/edit_klient");
        Klient klient = dao.get(id);
        Adres adres = daoAdresy.get(klient.getNr_adresu());
        Telefon telefon = daoTelefony.get(klient.getNr_zbioru_telefonow());
        mav.addObject("klient", klient);
        mav.addObject("adres", adres);
        mav.addObject("telefon", telefon);

        return mav;
    }

    @RequestMapping(value = "/update_klient", method = RequestMethod.POST)
    public String update(@ModelAttribute("klient") Klient klient, @ModelAttribute("adres") Adres adres, @ModelAttribute("telefon") Telefon telefon, HttpServletRequest request) {
        try {
            dao.update(klient);
            daoAdresy.update(adres);
            daoTelefony.update(telefon);
        } catch (Exception exception) {
            return "redirect:/database_integrity_error";
        }

        if (request.isUserInRole("Client")) {
            return "redirect:/main_client";
        } else {
            return "redirect:/index";
        }
    }

    @RequestMapping("/delete_klient/{id}")
    public String delete(@PathVariable(name = "id") int id) {
        dao.delete(id);

        return "redirect:/klient";
    }
}
