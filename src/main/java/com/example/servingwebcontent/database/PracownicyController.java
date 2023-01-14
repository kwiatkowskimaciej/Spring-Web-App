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
        String text = "Some text to display at view";
        model.addAttribute("someText", text);
        List<Pracownik> listPracownik = dao.findAll();
        model.addAttribute("listPracownik", listPracownik);

        return "pracownik";}

    @GetMapping("/user/registration")
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "registration";
    }

    @GetMapping("/new")
    public String showNewForm(Model model) {
        Pracownik pracownik = new Pracownik();
        model.addAttribute("pracownik",pracownik);

        return "new_form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("pracownik") Pracownik pracownik) {
        dao.save(pracownik);

        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_form");
        Pracownik pracownik = dao.get(id);
        mav.addObject("pracownik", pracownik);

        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("pracownik") Pracownik pracownik) {
        dao.update(pracownik);

        return "redirect:/";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") int id) {
        dao.delete(id);

        return "redirect:/";
    }
}


