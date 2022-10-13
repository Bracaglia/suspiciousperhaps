package com.samanthabracaglia.bundleofjoy.controllers;

import com.samanthabracaglia.bundleofjoy.models.BabyName;
import com.samanthabracaglia.bundleofjoy.models.User;
import com.samanthabracaglia.bundleofjoy.services.BabyNameService;
import com.samanthabracaglia.bundleofjoy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class BabyNameController {
    @Autowired
    BabyNameService babyNameService;
    @Autowired
    UserService userService;
///////////////////////////////CREATE///////////////////////////////
    @GetMapping("/babyNames/new")
    public String newBabyname(@ModelAttribute("babyName") BabyName babyName, Model model, HttpSession session){
        Long id = (Long) session.getAttribute("userId");
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "babynames/new.jsp";
    }
    @PostMapping("/babyNames")
    public String createBabyname(@Valid @ModelAttribute("babyName") BabyName babyName, BindingResult result) {
        if (result.hasErrors()) {
            return "babynames/new.jsp";
        } else {
            babyNameService.create(babyName);
            return "redirect:/babyNames";
        }
    }
    ///////////////////////////////READ ALL///////////////////////////////
    @GetMapping("/babyNames")
    public String allBooks(Model model, HttpSession session){
       List<BabyName> babyNames = babyNameService.getAll();
        Long id = (Long) session.getAttribute("userId");
        User user = (User) userService.findById(id);
        model.addAttribute("user", user);
        model.addAttribute("babyNames", babyNames);
        return "babynames/index.jsp";
    }

    ///////////////////////////////READ ONE///////////////////////////////
    @GetMapping("/babyNames/{id}")
    public String show(HttpSession session, Model model, @PathVariable Long id){
        BabyName babyName = babyNameService.getOne(id);
        model.addAttribute("babyName", babyName);
        Long userId = (Long) session.getAttribute("userId");
        User user = userService.findById(userId);
        model.addAttribute("user", user);
        return "babynames/show.jsp";
    }

    ///////////////////////////////EDIT///////////////////////////////

    @GetMapping("/babyNames/edit/{id}")
    public String edit(@PathVariable("id")Long id, Model model, HttpSession session){
        BabyName babyName = babyNameService.getOne(id);
        model.addAttribute("babyName", babyName);

        Long userId = (Long) session.getAttribute("userId");
        User user = userService.findById(userId);

        model.addAttribute("user", user);
        return "babynames/edit.jsp";
    }

    @PutMapping("/babyNames/{id}")
    public String updateBabyName(@Valid @ModelAttribute("babyName")BabyName babyName, BindingResult result, @PathVariable("id")Long id){
        if(result.hasErrors()){
            return "babynames/edit.jsp";
        } else {
            babyNameService.update(babyName);
            return "redirect:/babyNames";
        }
    }
    ///////////////////////////////DELETE///////////////////////////////
    @DeleteMapping("/babyNames/destroy/{id}")
    public String destroy(@PathVariable("id")Long id){
        babyNameService.destroy(babyNameService.getOne(id));
        return "redirect:/babyNames";
    }
}
