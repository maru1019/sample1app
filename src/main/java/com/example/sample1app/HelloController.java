package com.example.sample1app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

  @RequestMapping(value="/", method=RequestMethod.GET)
  public ModelAndView index(ModelAndView mav) {
    mav.setViewName("index");
    mav.addObject("msg","HelloController/indecxのページです");
    return mav;
  }

  @RequestMapping("/other")
  public String other() {
    return "redirect:/";
  }

  @RequestMapping("/home")
  public String home() {
    return "forward:/";
  }
}