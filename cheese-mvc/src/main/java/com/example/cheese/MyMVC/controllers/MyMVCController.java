package com.example.cheese.MyMVC.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;


import java.util.ArrayList;


@Controller
@RequestMapping("MyMVC")
public class MyMVCController {

    // Grocery List Variables
    ArrayList<String> groceries = new ArrayList<>();

    ArrayList<String> employeeIdentification = new ArrayList<>();
    ArrayList<String> employeeFirstName = new ArrayList<>();
    ArrayList<String> employeeLastName = new ArrayList<>();




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
    @RequestMapping(value="employee-data", method = RequestMethod.GET)
    public String displayEmployeeData(Model model){
        model.addAttribute("employeeIDs", employeeIdentification);
        model.addAttribute("employeeFN", employeeFirstName);
        model.addAttribute("employeeLN", employeeLastName);

        model.addAttribute("tabTitle","Employees Data");
        model.addAttribute("pageTitle", "List of Employees");
        return "MyMVC/employee-data";

    }

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
        // Retrieve employee data to be displayed on "employee-data" view.
            employeeIdentification.add(employeeID);
            employeeFirstName.add(firstName);
            employeeLastName.add(lastName);



        // Redirect to "/myMVC/list" after action is committed
        return new RedirectView("employee-data");

    }

}

