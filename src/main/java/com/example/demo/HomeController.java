package com.example.demo;

import com.example.demo.Model.DTO;
import com.example.demo.Model.Link;
import com.example.demo.Model.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;

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
        model.addAttribute("links", linkRepository.findAllByOrderByTimeStampAsc());
        return "index";
    }

    @RequestMapping("/addlink")
    public String addlinks(@Valid Link link, BindingResult bindingResult, Model model){

        model.addAttribute("link", new Link());

        if (bindingResult.hasErrors()){
            model.addAttribute("links", linkRepository.findAll());
            return "index";
        }

        Date thisDate = new Date();

        link.setTimeStamp(thisDate);
        linkRepository.save(link);


        model.addAttribute("links", linkRepository.findAllByOrderByTimeStampAsc());
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }



}
