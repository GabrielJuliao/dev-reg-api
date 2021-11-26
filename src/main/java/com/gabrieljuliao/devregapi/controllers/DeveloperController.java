package com.gabrieljuliao.devregapi.controllers;

import com.gabrieljuliao.devregapi.exceptions.DeveloperNotFoundException;
import com.gabrieljuliao.devregapi.resources.DeveloperResource;
import com.gabrieljuliao.devregapi.services.DeveloperService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping(value = "developer", produces = {MediaTypes.HAL_JSON_VALUE})
public class DeveloperController {
    private final DeveloperService developerService;

    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @PostMapping
    public ResponseEntity<?> createDeveloper(@RequestBody @Valid DeveloperResource resource, BindingResult result) {
        if (result.hasErrors()){
            String msg = result.toString();
            System.out.println(msg);
            throw new DeveloperNotFoundException();
        }
        return new ResponseEntity<>(developerService.create(resource), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllDeveloper() {
        return new ResponseEntity<>(
                CollectionModel.of(
                        developerService.getAll()
                        )
                        .add(linkTo(DeveloperController.class).withRel("developers")
                ),
                HttpStatus.OK
        );
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<?> getDeveloperById(@PathVariable Long id){
        DeveloperResource developer = developerService.getById(id);
        if (developer != null) {
            return new ResponseEntity<>(
                    EntityModel.of(developer),
                    HttpStatus.OK
            );
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
