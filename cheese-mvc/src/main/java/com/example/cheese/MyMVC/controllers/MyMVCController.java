package com.example.cheese.MyMVC.controllers;

import com.example.cheese.MyMVC.controllers.DefaultWeatherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.math.BigDecimal;
import java.util.ArrayList;


@Controller
@RequestMapping("MyMVC")
public class MyMVCController {

    // Grocery List Variables
    ArrayList<String> groceries = new ArrayList<>();



    // Request Path is set to: "/MyMVC" instead of default: "/"
    @RequestMapping(value = "")
    public String index(Model model){

        model.addAttribute("tabTitle", "Index");
        model.addAttribute("pageTitle","Homepage");
        // Returns index.html
        return "MyMVC/index";
    }

    // List Page: Read CRUD function = GET HTTP method
    @RequestMapping(value="list", method = RequestMethod.GET)
    public String list(Model model){

        model.addAttribute("groceries", groceries);
        model.addAttribute("tabTitle","List");
        model.addAttribute("pageTitle","Current List");
        return "MyMVC/list";

    }


    // Read CRUD function = GET HTTP method
    @RequestMapping(value="add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model){
        model.addAttribute("tabTitle","Add");
        model.addAttribute("pageTitle", "Add Groceries");
        return "MyMVC/add";

    }


    // Create CRUD function = POST HTTP method
    @RequestMapping(value="add", method = RequestMethod.POST)
    public RedirectView processAddGroceryForm(@RequestParam String groceryName){
        groceries.add(groceryName);

        // Redirect to "/myMVC/list" after action is committed
        return new RedirectView("list");

    }

    // Default view (page) for "MyMVC/weather" route (Shows default weather values)
    @RequestMapping(value="weather", method = RequestMethod.GET)
    public String weather(Model model){
        model.addAttribute("tabTitle","Weather");
        model.addAttribute("pageTitle","Check the Weather");
        model.addAttribute("currentWeather", new DefaultWeatherService().getCurrentWeather());
        return "MyMVC/weather";
    }

    // CREATE CRUD function = POST HTTP method (Takes user input for location Ex: (City, State, Country))
    //  and returns the corresponding weather for that location.
    @RequestMapping(value="add", method=RequestMethod.POST)
    public RedirectView processWeatherForm(){

        // Look-Up given location and return weather information to user. Redirect user to updated weather page.


        return new RedirectView("weather");
    }

}

