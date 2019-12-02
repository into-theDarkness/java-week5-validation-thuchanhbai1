package tranminhduc.pro.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import tranminhduc.pro.model.PhoneNumber;

import javax.validation.Valid;

@Controller
public class PhoneController {
    @GetMapping("/haha")
    public ModelAndView showForm(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("phonemunber", new PhoneNumber());
        return modelAndView;
    }
    @PostMapping("/haha")
    public String checkValidation (@Valid @ModelAttribute("phonemunber")PhoneNumber phoneNumber, BindingResult bindingResult, Model model){
        new PhoneNumber().validate(phoneNumber, bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "index";
        }
        else {
            model.addAttribute("phoneNumber", phoneNumber.getNumber());
            return "result";
        }
    }
}
