package com.example.servingwebcontent.error;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

    @GetMapping("/403")
    public String forbidden(Model model) {
        return "errors/403";
    }

    @GetMapping("/404")
    public String notFound(Model model) {
        return "errors/404";
    }

    @GetMapping("/500")
    public String internal(Model model) {
        return "errors/500";
    }

    @GetMapping("/database_integrity_error")
    public String integrity(Model model) { return "errors/database_integrity_error"; }
//
//    @GetMapping("/access-denied")
//    public String accessDenied() {
//        return "error/access-denied";
//    }
}
