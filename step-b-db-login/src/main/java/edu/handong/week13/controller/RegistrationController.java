package edu.handong.week13.controller;
import edu.handong.week13.dto.RegisterForm;
import edu.handong.week13.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
@Controller
public class RegistrationController {
   private final MemberService memberService;
   public RegistrationController(MemberService memberService){this.memberService=memberService;}
   @GetMapping("/register") public String form(Model model){
      model.addAttribute("form",new RegisterForm());return "register";
   }
   @PostMapping("/register") public String create(
         @Valid @ModelAttribute("form") RegisterForm form,BindingResult result,Model model){
      if(result.hasErrors())return "register";
      try{memberService.register(form);}
      catch(IllegalArgumentException ex){model.addAttribute("error",ex.getMessage());return "register";}
      return "redirect:/login?registered";
   }
}
