package edu.handong.week13.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
@Controller
public class PageController {
    @GetMapping("/") public String home(Model model, @AuthenticationPrincipal UserDetails user) {
        model.addAttribute("username", user == null ? "Guest" : user.getUsername());
        return "home";
    }
    @GetMapping("/mypage") public String mypage(Model model, @AuthenticationPrincipal UserDetails user) {
        model.addAttribute("username",user == null ? "Guest" : user.getUsername());
        return "mypage";
    }
    @GetMapping("/admin") public String admin() { return "admin"; }
}
