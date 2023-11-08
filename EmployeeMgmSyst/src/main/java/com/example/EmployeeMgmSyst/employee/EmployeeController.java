package com.example.EmployeeMgmSyst.employee;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public String getEmployees(Model model) {
        List<Employees> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);

        int totalEmployeeCount = employeeService.getTotalEmployeeCount();
        model.addAttribute("totalEmployeeCount", totalEmployeeCount);

        return "employeeList";
    }

    @GetMapping("/")
    public String home(Model model) {
        int totalEmployeeCount = employeeService.getTotalEmployeeCount();
        model.addAttribute("totalEmployeeCount", totalEmployeeCount);
        return "employeeList";
    }

    @GetMapping("/employees/search")
    public String getEmployees(Model model, @RequestParam(required = false) String search) {
        List<Employees> employees;

        if (search != null && !search.isEmpty()) {
            employees = employeeService.searchEmployees(search);
        } else {
            employees = employeeService.getAllEmployees();
        }

        model.addAttribute("employees", employees);
        return "employeeList";
    }

    @GetMapping("/employees/new")
    public String showCreateForm(Model model) {
        model.addAttribute("employee", new Employees());
        return "createEmployee";
    }

    @PostMapping("/employees")
    public String createEmployee(@ModelAttribute Employees employee) {
        employeeService.createEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employees/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Employees employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "updateEmployee";
    }

    @PostMapping("/employees/{id}/edit")
    public String updateEmployee(@PathVariable Long id, @ModelAttribute Employees employee) {
        employeeService.updateEmployee(id, employee);
        return "redirect:/employees";
    }

    @GetMapping("/employees/aboutUs")
    public String aboutUsPage() {
        return "aboutUs";
    }

    @GetMapping("/employees/{id}/delete")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }
}
