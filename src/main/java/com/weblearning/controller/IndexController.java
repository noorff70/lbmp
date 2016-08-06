package com.weblearning.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.ModelMap;


@Controller
public class IndexController{

		
   @RequestMapping("/index")
   public String index(ModelMap model) {
      model.addAttribute("message", "Main Page");

      return "index";
   }
   
}
