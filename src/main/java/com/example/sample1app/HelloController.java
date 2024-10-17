package com.example.sample1app;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.sample1app.entity.Person;
import com.example.sample1app.repository.PersonRepository;
import jakarta.transaction.Transactional;
import jakarta.annotation.PostConstruct;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

@Controller
public class HelloController {

  @Autowired
  PersonRepository repository;

  @PostConstruct
  public void init() {
    // 1つ目のダミーデータ作成
    Person p1 = new Person();
    p1.setName("taro");
    p1.setAge(39);
    p1.setMail("taro@yamada");
    repository.saveAndFlush(p1);
    // 2つ目のダミーデータ作成
    Person p2 = new Person();
    p2.setName("hanako");
    p2.setAge(28);
    p2.setMail("hanako@flower");
    repository.saveAndFlush(p2);
    // 3つ目のダミーデータ作成
    Person p3 = new Person();
    p3.setName("sachiko");
    p3.setAge(17);
    p3.setMail("sachiko@happy");
    repository.saveAndFlush(p3);
  }

  @RequestMapping("/")
  public ModelAndView index(@ModelAttribute("formModel") Person person, ModelAndView mav) {
    mav.setViewName("index");
    mav.addObject("title","Hello page");
    mav.addObject("msg", "this is JPA sample data.");
    List<Person> list = repository.findAll();
    mav.addObject("data",list);
    return mav;
  }

  @RequestMapping(value = "/", method = RequestMethod.POST)
  @Transactional
  public ModelAndView form(@ModelAttribute("formModel") @Validated Person person, BindingResult result, ModelAndView mav) {
    ModelAndView res = null;
    System.out.println(result.getFieldErrors());
    if (!result.hasErrors()){
      repository.saveAndFlush(person);
      res = new ModelAndView("redirect:/");
    } else {
      mav.setViewName("index");
      mav.addObject("title","Hello page");
      mav.addObject("msg","soory, error is occurres...");
      Iterable<Person> list = repository.findAll();
      mav.addObject("datalist",list);
      res = mav;
    }
    return res;
  }

  @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
  public ModelAndView edit(@ModelAttribute Person person, @PathVariable int id, ModelAndView mav) {
    mav.setViewName("edit");
    mav.addObject("title","edit Person.");
    Optional<Person> data = repository.findById((long)id);
    mav.addObject("formModel",data.get());
    return mav;
  }

  @RequestMapping(value = "/edit", method = RequestMethod.POST)
  @Transactional
  public ModelAndView update(@ModelAttribute Person person, ModelAndView mav) {
    repository.saveAndFlush(person);
    return new ModelAndView("redirect:/");
  }

  @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
  public ModelAndView delete(@PathVariable int id, ModelAndView mav) {
    mav.setViewName("delete");
    mav.addObject("title","Delete Person.");
    mav.addObject("msg","Can I delete this recode?");
    Optional<Person> data = repository.findById((long)id);
    mav.addObject("formModel",data.get());
    return mav;
  }

  @RequestMapping(value = "/delete", method = RequestMethod.POST)
  @Transactional
  public ModelAndView remove(@RequestParam long id, ModelAndView mav) {
    repository.deleteById(id);
    return new ModelAndView("redirect:/");
  }

}
