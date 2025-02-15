package org.launchcode.techjobs.persistent.controllers;

import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Job;
import org.launchcode.techjobs.persistent.models.data.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("employers")
public class EmployerController {


    @Autowired
    private EmployerRepository employerRepository;


    //Add an index method that responds at /employers with a list of all employers in the database. This method should use the template --> employers/index
    @GetMapping("")
    public String index(Model model){
        model.addAttribute("employers", employerRepository.findAll());
    return "employers/index";
}


    @GetMapping("add")
    public String displayAddEmployerForm(Model model) {
        model.addAttribute("employer", new Employer());
        return "employers/add";
    }


    // Controllers part 3. Use employerRepository and the appropriate method to save a valid object...
    @PostMapping("add")
    public String processAddEmployerForm(@ModelAttribute @Valid Employer newEmployer,
                                    Errors errors, Model model) {

        if (errors.hasErrors()) {
//            model.addAttribute("title", "Add Employer");
//            model.addAttribute("employer", employerRepository);
            return "employers/add";
        }
        //add save method here for object...

        employerRepository.save(newEmployer);
        //model.addAttribute("employer", employerRepository.findAll());

        return "redirect:";
    }

    @GetMapping("view/{employerId}")
    public String displayViewEmployer(Model model, @PathVariable int employerId) {


        //Replace -->null<-- with .findById() method with the right argument to look for the given employer object from the data layer.

        Optional optEmployer = employerRepository.findById(employerId);
        if (optEmployer.isPresent()) {
            Employer employer = (Employer) optEmployer.get();
            model.addAttribute("employer", employer);
            return "employers/view";
        } else {
            return "redirect:../";
        }
    }
}
