package com.example.demomongo.http;

import com.example.demomongo.data.DataRepository;
import com.example.demomongo.data.PersonForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Validated
public class PersonFormController {
    private final DataRepository repository;

    @Autowired
    public PersonFormController(DataRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String showForm(PersonForm personForm) {
        return "form";
    }

    @PostMapping("/")
    public String checkPersonInfo(PersonForm personForm) {
        repository.save(personForm);
        return "results";
    }
}
