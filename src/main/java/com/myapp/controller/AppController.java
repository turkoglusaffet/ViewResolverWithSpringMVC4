package com.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myapp.model.Car;

@Controller
public class AppController {
 
    @RequestMapping(value="/cargarage/{carname}", method = RequestMethod.GET)
    public String getPizza(@PathVariable String carname, ModelMap model) {
    	Car car = new Car(carname);
        model.addAttribute("car", car);
        return "car";
  
    }
}