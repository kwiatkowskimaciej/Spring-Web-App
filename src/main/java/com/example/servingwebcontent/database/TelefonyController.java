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
public class TelefonyController {

    @Autowired
    private TelefonyDAO dao;

    @RequestMapping(value={"/telefon"})
    public String showDbPage(Model model) {
        List<Telefon> listTelefon = dao.findAll();
        model.addAttribute("listTelefon", listTelefon);

        return "telefon/telefon";}

    @GetMapping("/new_telefon")
    public String showNewForm(Model model) {
        Telefon telefon = new Telefon();
        model.addAttribute("telefon",telefon);

        return "telefon/new_telefon";
    }

    @RequestMapping(value = "/save_telefon", method = RequestMethod.POST)
    public String save(@ModelAttribute("telefon") Telefon telefon) {
        try {
            dao.save(telefon);
        } catch (Exception exception) {
            return "redirect:/database_integrity_error";
        }
        return "redirect:/telefon";
    }

    @RequestMapping("/edit_telefon/{id}")
    public ModelAndView showEditForm(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("telefon/edit_telefon");
        Telefon telefon = dao.get(id);
        mav.addObject("telefon", telefon);

        return mav;
    }

    @RequestMapping(value = "/update_telefon", method = RequestMethod.POST)
    public String update(@ModelAttribute("telefon") Telefon telefon) {
        try {
            dao.update(telefon);
        } catch (Exception exception) {
            return "redirect:/database_integrity_error";
        }
        return "redirect:/telefon";
    }

    @RequestMapping("/delete_telefon/{id}")
    public String delete(@PathVariable(name = "id") int id) {
        dao.delete(id);

        return "redirect:/telefon";
    }
}
