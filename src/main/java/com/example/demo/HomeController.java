package com.example.demo;

import com.example.demo.Model.Link;
import com.example.demo.Model.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;

/**
 * Created by student on 6/22/17.
 */
@Controller
public class HomeController {

    @Autowired
    private LinkRepository linkRepository;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("link", new Link());
        model.addAttribute("links", linkRepository.findAll());
        return "index";
    }

    @RequestMapping("/addlink")
    public String addlinks(@Valid Link link, BindingResult bindingResult, Model model){
        model.addAttribute("link", new Link());
        //if (bindingResult.hasErrors()){
          //  model.addAttribute("links", linkRepository.findAll());
         //   return "index";
        //}

        linkRepository.save(link);
        model.addAttribute("links", linkRepository.findAll());
        return "index";
    }



}
