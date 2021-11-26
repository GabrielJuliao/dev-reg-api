package com.gabrieljuliao.devregapi.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

@Entity
@Data
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Pattern(regexp = "MID| ENTRY|HIGH", flags = Pattern.Flag.CASE_INSENSITIVE, message = "Not one of the values accepted. Allowed: [MID, ENTRY, HIGH]")
    private Level level;
}
