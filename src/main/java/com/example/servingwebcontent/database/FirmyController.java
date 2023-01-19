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
public class FirmyController {

    @Autowired
    private FirmyDAO dao;

    @RequestMapping(value={"/firma"})
    public String showDbPage(Model model) {
        String text = "Some text to display at view";
        model.addAttribute("someText", text);
        List<Firma> listFirma = dao.findAll();
        model.addAttribute("listFirma", listFirma);

        return "firma/firma";}

    @GetMapping("/new_firma")
    public String showNewForm(Model model) {
        Firma firma = new Firma();
        model.addAttribute("firma",firma);

        return "firma/new_firma";
    }

    @RequestMapping(value = "/save_firma", method = RequestMethod.POST)
    public String save(@ModelAttribute("firma") Firma firma) {
        dao.save(firma);

        return "redirect:/";
    }

    @RequestMapping("/edit_firma/{id}")
    public ModelAndView showEditForm(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("firma/edit_firma");
        Firma firma = dao.get(id);
        mav.addObject("firma", firma);

        return mav;
    }

    @RequestMapping(value = "/update_firma", method = RequestMethod.POST)
    public String update(@ModelAttribute("firma") Firma firma) {
        dao.update(firma);

        return "redirect:/";
    }

    @RequestMapping("/delete_firma/{id}")
    public String delete(@PathVariable(name = "id") int id) {
        dao.delete(id);

        return "redirect:/";
    }
}
