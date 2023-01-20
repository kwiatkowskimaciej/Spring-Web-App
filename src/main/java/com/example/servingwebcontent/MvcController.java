package com.example.servingwebcontent;

import com.example.servingwebcontent.registration.UserDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@Controller
@Configuration
public class MvcController implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");

        registry.addViewController("/main_admin").setViewName("admin/main_admin");
        registry.addViewController("/main_employee").setViewName("employee/main_employee");
        registry.addViewController("/main_client").setViewName("client/main_client");

        registry.addViewController("/salon").setViewName("salon/salon");
        registry.addViewController("/new_salon").setViewName("salon/new_salon");
        registry.addViewController("/edit_salon").setViewName("salon/edit_salon");
        registry.addViewController("/save_salon").setViewName("salon/save_salon");

        registry.addViewController("/car").setViewName("car/car");
        registry.addViewController("/new_car").setViewName("car/new_car");
        registry.addViewController("/edit_car").setViewName("car/edit_car");
        registry.addViewController("/save_car").setViewName("car/save_car");
    }

    @Controller
    public class DashboardController {
        @RequestMapping("/main")
        public String defaultAfterLogin(HttpServletRequest request) {
            if (request.isUserInRole("ADMIN")) {
                return "redirect:/main_admin";
            } else if (request.isUserInRole("EMPLOYEE")) {
                return "redirect:/main_employee";
            } else if (request.isUserInRole("CLIENT")) {
                return "redirect:/main_client";
            } else {
                return "redirect:/index";
            }
        }
    }

    @RequestMapping(value = {"/main_admin"})
    public String showAdminPage(Model model) {
        return "admin/main_admin";
    }

    @RequestMapping(value = {"/main_user"})
    public String showUserPage(Model model) {
        return "user/main_user";
    }
}
