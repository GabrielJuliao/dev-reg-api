package com.gabrieljuliao.devregapi.repository;

import com.gabrieljuliao.devregapi.model.Job;
import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<Job, Long> {
}
