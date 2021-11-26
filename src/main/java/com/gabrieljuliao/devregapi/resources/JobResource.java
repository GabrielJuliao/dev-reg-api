package com.gabrieljuliao.devregapi.resources;

import com.gabrieljuliao.devregapi.model.Job;
import com.gabrieljuliao.devregapi.model.Level;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class JobResource extends RepresentationModel<JobResource> {
    private Long id;
    @NotBlank
    @Pattern(regexp = "Back-End Engineer|Front-End Engineer|Full-Stack Engineer", flags = Pattern.Flag.CASE_INSENSITIVE, message = "Not one of the values accepted. Allowed: [Back-End Engineer, Front-End Engineer, Full-Stack Engineer]")
    private String title;

//    @Pattern(regexp = "MID|ENTRY|HIGH", flags = Pattern.Flag.CASE_INSENSITIVE, message = "Not one of the values accepted. Allowed: [MID, ENTRY, HIGH]")
    private Level level;

    public JobResource() {
    }

    public JobResource(Job job) {
        this.id = job.getId();
        this.title = job.getTitle();
        this.level = job.getLevel();
    }
}
