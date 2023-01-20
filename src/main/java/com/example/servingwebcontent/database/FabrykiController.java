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
public class FabrykiController {

    @Autowired
    private FabrykiDAO dao;

    @RequestMapping(value={"/fabryka"})
    public String showDbPage(Model model) {
        String text = "Some text to display at view";
        model.addAttribute("someText", text);
        List<Fabryka> listFabryka = dao.findAll();
        model.addAttribute("listFabryka", listFabryka);

        return "fabryka/fabryka";}

    @GetMapping("/new_fabryka")
    public String showNewForm(Model model) {
        Fabryka fabryka = new Fabryka();
        model.addAttribute("fabryka",fabryka);

        return "fabryka/new_fabryka";
    }

    @RequestMapping(value = "/save_fabryka", method = RequestMethod.POST)
    public String save(@ModelAttribute("fabryka") Fabryka fabryka) {
        dao.save(fabryka);

        return "redirect:/fabryka";
    }

    @RequestMapping("/edit_fabryka/{id}")
    public ModelAndView showEditForm(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("fabryka/edit_fabryka");
        Fabryka fabryka = dao.get(id);
        mav.addObject("fabryka", fabryka);

        return mav;
    }

    @RequestMapping(value = "/update_fabryka", method = RequestMethod.POST)
    public String update(@ModelAttribute("fabryka") Fabryka fabryka) {
        dao.update(fabryka);

        return "redirect:/fabryka";
    }

    @RequestMapping("/delete_fabryka/{id}")
    public String delete(@PathVariable(name = "id") int id) {
        dao.delete(id);

        return "redirect:/fabryka";
    }
}
