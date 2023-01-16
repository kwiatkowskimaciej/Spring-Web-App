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
public class SerwisyController {

    @Autowired
    private SerwisyDAO dao;

    @RequestMapping(value={"/serwis"})
    public String showDbPage(Model model) {
        String text = "Some text to display at view";
        model.addAttribute("someText", text);
        List<Serwis> listSerwis = dao.findAll();
        model.addAttribute("listSerwis", listSerwis);

        return "serwis/serwis";}

    @GetMapping("/new_serwis")
    public String showNewForm(Model model) {
        Serwis serwis = new Serwis();
        model.addAttribute("serwis",serwis);

        return "serwis/new_serwis";
    }

    @RequestMapping(value = "/save_serwis", method = RequestMethod.POST)
    public String save(@ModelAttribute("serwis") Serwis serwis) {
        dao.save(serwis);

        return "redirect:/";
    }

    @RequestMapping("/edit_serwis/{id}")
    public ModelAndView showEditForm(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("serwis/edit_serwis");
        Serwis serwis = dao.get(id);
        mav.addObject("serwis", serwis);

        return mav;
    }

    @RequestMapping(value = "/update_serwis", method = RequestMethod.POST)
    public String update(@ModelAttribute("serwis") Serwis serwis) {
        dao.update(serwis);

        return "redirect:/";
    }

    @RequestMapping("/delete_serwis/{id}")
    public String delete(@PathVariable(name = "id") int id) {
        dao.delete(id);

        return "redirect:/";
    }
}
