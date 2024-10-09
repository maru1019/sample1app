package com.example.sample1app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.io.IOException;
import java.io.Writer;
import com.samskivert.mustache.Mustache.Lambda;
import com.samskivert.mustache.Template.Fragment;

@Controller
public class HelloController {
  @RequestMapping("/")
  public ModelAndView index(ModelAndView mav) {
    mav.setViewName("index");
    mav.addObject("title","ラムダ式のサンプル");
    mav.addObject("msg", "これはラムダ式を利用してメッセージを表示したものです。");

    Lambda fn = new Lambda() {
      public void execute (Fragment frag, Writer out)
          throws IOException {
        out.write("<div class=\"alert alert-primary\">");
        frag.execute(out);
        out.write("</div>");
      }
    };
    mav.addObject("fn",fn);
    return mav;
  }
}
