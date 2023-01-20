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
public class KlienciController {

    @Autowired
    private KlienciDAO dao;

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

        return "klient/new_klient";
    }

    @RequestMapping(value = "/save_klient", method = RequestMethod.POST)
    public String save(@ModelAttribute("klient") Klient klient) {
        dao.save(klient);

        return "redirect:/klient";
    }

    @RequestMapping("/edit_klient/{id}")
    public ModelAndView showEditForm(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("klient/edit_klient");
        Klient klient = dao.get(id);
        mav.addObject("klient", klient);

        return mav;
    }

    @RequestMapping(value = "/update_klient", method = RequestMethod.POST)
    public String update(@ModelAttribute("klient") Klient klient) {
        dao.update(klient);

        return "redirect:/klient";
    }

    @RequestMapping("/delete_klient/{id}")
    public String delete(@PathVariable(name = "id") int id) {
        dao.delete(id);

        return "redirect:/klient";
    }
}
