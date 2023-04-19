package edu.wsb.datamodellingdemo.homework;

import edu.wsb.datamodellingdemo.companies.Company;
import edu.wsb.datamodellingdemo.companies.CompanyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @PostMapping("/{id}/disable")
    public String disable(@PathVariable Long id) {
        Optional<Company> optionalCompany = companyRepository.findById(id);

        optionalCompany.ifPresent((company -> {
            company.setEnabled(false);
            companyRepository.save(company);
        }));

        return "redirect:/company/list";
    }

}
