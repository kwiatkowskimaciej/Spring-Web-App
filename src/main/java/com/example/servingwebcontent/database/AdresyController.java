package com.example.servingwebcontent.database;

import com.example.servingwebcontent.registration.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdresyController {

    @Autowired
    private AdresyDAO dao;

    @RequestMapping(value={"/adres"})
    public String showDbPage(Model model) {
        List<Adres> listAdres = dao.findAll();
        model.addAttribute("listAdres", listAdres);

        return "adres/adres";}

    @GetMapping("/new_adres")
    public String showNewForm(Model model) {
        Adres adres = new Adres();
        model.addAttribute("adres",adres);

        return "adres/new_adres";
    }

    @RequestMapping(value = "/save_adres", method = RequestMethod.POST)
    public String save(@ModelAttribute("adres") Adres adres) {
        dao.save(adres);

        return "redirect:/";
    }

    @RequestMapping("/edit_adres/{id}")
    public ModelAndView showEditForm(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("adres/edit_adres");
        Adres adres = dao.get(id);
        mav.addObject("adres", adres);

        return mav;
    }

    @RequestMapping(value = "/update_adres", method = RequestMethod.POST)
    public String update(@ModelAttribute("adres") Adres adres) {
        dao.update(adres);

        return "redirect:/";
    }

    @RequestMapping("/delete_adres/{id}")
    public String delete(@PathVariable(name = "id") int id) {
        dao.delete(id);

        return "redirect:/";
    }
}
