package com.example.cheese.MyMVC.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


import java.util.ArrayList;
import java.util.Iterator;


@Controller
@RequestMapping("MyMVC")
public class MyMVCController {

    // Grocery List Variables
    ArrayList<String> groceries = new ArrayList<>();

    // List of Employee Objects. Employee (String ID, String FirstName, String LastName)
    ArrayList<Employee> employees = new ArrayList<>();





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

    //- Add employees to be displayed

    // Read CRUD function = GET HTTP method
    @RequestMapping(value="crud", method = RequestMethod.GET)
    public String displayAddEmployeeForm(Model model){
        model.addAttribute("tabTitle","Add Employees");
        model.addAttribute("pageTitle", "Add Employee Data");
        return "MyMVC/crud";

    }

    // Create CRUD function = POST HTTP method
    @RequestMapping(value="crud", method = RequestMethod.POST)
    public RedirectView processEmployeeData(@RequestParam String employeeID, @RequestParam String firstName,
                                            @RequestParam String lastName){

        // Create new Employee Object and assign user-input values from View to the properties.
        // Add Employee-Object to the Collection (Arraylist)
        Employee e1 = new Employee(employeeID, firstName, lastName);
        employees.add(e1);



        // Redirect to "/myMVC/employee-data" after action is committed
        return new RedirectView("employee-data");

    }

    // Read CRUD function = GET HTTP method
    @RequestMapping(value="employee-data", method = RequestMethod.GET)
    public String displayEmployeeData(Model model){

        model.addAttribute("employees",employees);
        model.addAttribute("tabTitle","Employees Data");
        model.addAttribute("pageTitle", "List of Employees");
        return "MyMVC/employee-data";

    }

    // Should be a POST Method
    // Delete Employee from ArrayList
    @RequestMapping(value="employee-data", method = RequestMethod.POST)
    public String processEmployeeDeletion(@ModelAttribute Employee e1, Model model){

        // Compare Employee-Object ID's to ID passed from delete button
        Iterator<Employee> iter = employees.iterator();
        while(iter.hasNext()) {
            Employee employee = iter.next();
            if (employee == e1) {
                employees.remove(employee);
            }
        }

        // WORKS
        return displayEmployeeData(model);

    }
}