package com.gabrieljuliao.devregapi.resources;

import com.gabrieljuliao.devregapi.controllers.DeveloperController;
import com.gabrieljuliao.devregapi.model.Developer;
import com.gabrieljuliao.devregapi.model.Job;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@EqualsAndHashCode(callSuper = true)
@Data
@Relation(collectionRelation = "developers")
public class DeveloperResource extends RepresentationModel<DeveloperResource> {
    private Long id;
    @NotBlank
    @Size(min = 2)
    private String firstName;
    @NotBlank
    @Size(min = 2)
    private String lastName;
    @Valid
    private JobResource job;

    public DeveloperResource() {
    }

    public DeveloperResource(Developer developer) {
        this.id = developer.getId();
        this.firstName = developer.getFirstName();
        this.lastName = developer.getLastName();
        this.job = new JobResource(developer.getJob());
        this.add(linkTo(methodOn(DeveloperController.class).getDeveloperById(this.id)).withSelfRel());
    }

    public Developer toEntity() {
        Job job = new Job();
        job.setId(this.job.getId());
        job.setTitle(this.job.getTitle());
        job.setLevel(this.job.getLevel());
        return new Developer(this.firstName, this.lastName, job);
    }
}
