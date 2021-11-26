package com.gabrieljuliao.devregapi.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Developer extends Person{
    @OneToOne
    private Job job;

    /**
     * Required Empty Constructor
     */
    public Developer() {

    }

    public Developer(String firstName, String lastName, Job job) {
        super.setFirstName(firstName);
        super.setLastName(lastName);
        this.job = job;
    }
}
