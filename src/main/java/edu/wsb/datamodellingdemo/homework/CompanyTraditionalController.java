package edu.wsb.datamodellingdemo.homework;

import edu.wsb.datamodellingdemo.companies.CompanyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

}
