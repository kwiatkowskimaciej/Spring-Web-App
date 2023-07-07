package com.example.servingwebcontent.database;

import com.example.servingwebcontent.registration.UserDto;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SamochodyController {
    @Autowired
    private SamochodyDAO dao;

    @RequestMapping(value={"/car"})
    public String showDbPage(Model model) {
        List<Samochod> listSamochod = dao.findAll();
        model.addAttribute("listSamochod", listSamochod);

        return "car/car";}

    @GetMapping("/new_car")
    public String showNewForm(Model model) {
        Samochod samochod = new Samochod();
        model.addAttribute("samochod",samochod);

        return "car/new_car";
    }

    @RequestMapping(value = "/save_car", method = RequestMethod.POST)
    public String save(@ModelAttribute("samochod") Samochod samochod) {
        try {
            dao.save(samochod);
        } catch (Exception exception) {
            return "redirect:/database_integrity_error";
        }
        return "redirect:/car";
    }

    @RequestMapping("/edit_car/{id}")
    public ModelAndView showCarEditForm(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("car/edit_car");
        Samochod samochod = dao.get(id);
        mav.addObject("samochod", samochod);

        return mav;
    }

    @RequestMapping("/buy_car/{id}")
    public ModelAndView showCarBuyForm(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("car/buy_car");
        Samochod samochod = dao.get(id);
        mav.addObject("samochod", samochod);

        return mav;
    }

    public static final String ACCOUNT_SID = "${TWILIO_ACCOUNT_SID}";
    public static final String AUTH_TOKEN = "${TWILIO_AUTH_TOKEN}";

    @RequestMapping(value = "/update_car", method = RequestMethod.POST)
    public String update(@ModelAttribute("samochod") Samochod samochod, HttpServletRequest request) {
        try {
            dao.update(samochod);
        } catch (Exception exception) {
            return "redirect:/database_integrity_error";
        }
        if (request.isUserInRole("CLIENT")) {
            Twilio.init(
                    ACCOUNT_SID,
                    AUTH_TOKEN);

            Message.creator(
                            new PhoneNumber("${TWILIO_PHONE_NUMBER_FIRST}"),
                            new PhoneNumber("{TWILIO_PHONE_NUMBER_SECOND}"),
                            "Twoje zamówienie niedługo zostanie dostarczone do Twojego garażu.")
                    .create();
        }

        return "redirect:/car";
    }

    @RequestMapping("/delete_car/{id}")
    public String delete(@PathVariable(name = "id") int id) {
        dao.delete(id);

        return "redirect:/car";
    }
}


