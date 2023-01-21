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
public class PracownicyController {

    @Autowired
    private PracownicyDAO dao;

    @RequestMapping(value={"/pracownik"})
    public String showDbPage(Model model) {
        List<Pracownik> listPracownik = dao.findAll();
        model.addAttribute("listPracownik", listPracownik);

        return "pracownik/pracownik";}

    @GetMapping("/new_pracownik")
    public String showNewForm(Model model) {
        Pracownik pracownik = new Pracownik();
        model.addAttribute("pracownik",pracownik);

        return "pracownik/new_pracownik";
    }

    @RequestMapping(value = "/save_pracownik", method = RequestMethod.POST)
    public String save(@ModelAttribute("pracownik") Pracownik pracownik) {
        try {
            dao.save(pracownik);
        } catch (Exception exception) {
            return "redirect:/database_integrity_error";
        }
        return "redirect:/pracownik";
    }

    @RequestMapping("/edit_pracownik/{id}")
    public ModelAndView showEditForm(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("pracownik/edit_pracownik");
        Pracownik pracownik = dao.get(id);
        mav.addObject("pracownik", pracownik);

        return mav;
    }

    @RequestMapping(value = "/update_pracownik", method = RequestMethod.POST)
    public String update(@ModelAttribute("pracownik") Pracownik pracownik) {
        try {
            dao.update(pracownik);
        } catch (Exception exception) {
            return "redirect:/database_integrity_error";
        }
        return "redirect:/pracownik";
    }

    @RequestMapping("/delete_pracownik/{id}")
    public String delete(@PathVariable(name = "id") int id) {
        dao.delete(id);

        return "redirect:/pracownik";
    }
}


