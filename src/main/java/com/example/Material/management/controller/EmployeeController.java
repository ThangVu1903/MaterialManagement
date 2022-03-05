package com.example.Material.management.controller;

import com.example.Material.management.entity.Employee;
import com.example.Material.management.service.base.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public String list(Model model) {
        model.addAttribute("employees",employeeService.findAllEmployee());
        return "employee";
    }

    @GetMapping("/employee/search")
    public String search(@RequestParam("term") String term, Model model) {
        if (StringUtils.isEmpty(term)) {
            return "redirect:/employee";
        }

        model.addAttribute("employees", employeeService.SearchEmployee(term));
        return "employee";
    }

    @GetMapping("/employee/add")
    public String add(Model model) {
        model.addAttribute("employee", new Employee());
        return "formEmployee";
    }

    @GetMapping("/employee/{id}/edit")
    public String edit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("contact", employeeService.findOneEmployee(id));
        return "formEmployee";
    }

    @GetMapping("/employee/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirect) {
       employeeService.deleteEmployee(id);
        redirect.addFlashAttribute("successMessage", "Deleted employee successfully!");
        return "redirect:/employee";
    }

    @PostMapping("/employee/save")
    public String save(@Valid Employee employee, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "formEmployee";
        }
        employeeService.saveEmployee(employee);
        redirect.addFlashAttribute("successMessage", "Saved employee successfully!");
        return "redirect:/employee";
    }

}
