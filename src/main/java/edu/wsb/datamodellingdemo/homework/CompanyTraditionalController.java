package edu.wsb.datamodellingdemo.homework;

import edu.wsb.datamodellingdemo.companies.Company;
import edu.wsb.datamodellingdemo.companies.CompanyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.core.model.Model;

import java.util.Optional;

// Zadanie 3
@Controller
@RequestMapping("/company")
public class CompanyTraditionalController {

    private final CompanyRepository companyRepository;

    public CompanyTraditionalController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping("/list")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("company", companyRepository.findAll());
        modelAndView.setViewName("company/list");

        return modelAndView;
    }

    @GetMapping("/{id}/disable")
    public String disable(@PathVariable Long id) {
        Optional<Company> optionalCompany = companyRepository.findById(id);

        optionalCompany.ifPresent((company -> {
            company.setEnabled(false);
            companyRepository.save(company);
        }));

        return "redirect:/company/list";
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("company/create");
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(@RequestParam String name) {
        ModelAndView modelAndView = new ModelAndView();
        
        Company company = new Company();
        company.setName(name);

        companyRepository.save(company);

        modelAndView.setViewName("redirect:/company/list");

        return modelAndView;
    }

}
