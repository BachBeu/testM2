package com.bach.controllers;

import com.bach.models.Country;
import com.bach.service.CountryService;
import com.bach.service.impl.CountryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class CountryController {
    @Autowired
    private CountryService countryService;
/*    @GetMapping("countries")
    public ModelAndView listCountries(){
        Iterable<Country> countries = countryService.findAll();
        ModelAndView modelAndView = new ModelAndView("/country/list");
        modelAndView.addObject("countries", countries);
        return modelAndView;
    }*/

    @GetMapping("/create-country")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/country/create");
        modelAndView.addObject("country", new Country());
        return modelAndView;
    }

    @PostMapping("/create-country")
    public ModelAndView saveCountry(@Valid @ModelAttribute("country") Country country, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView("/country/create");
        if(bindingResult.hasErrors()){
            modelAndView.addObject("message", "Fail create country");
            return modelAndView;
        }else{
            countryService.save(country);

            modelAndView.addObject("country", new Country());
            modelAndView.addObject("message", "Add country successfully");
            return modelAndView;
        }
    }
}
