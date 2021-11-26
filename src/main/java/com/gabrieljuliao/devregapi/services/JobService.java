package com.gabrieljuliao.devregapi.services;

import com.gabrieljuliao.devregapi.repository.JobRepository;
import org.springframework.stereotype.Service;

@Service
public class JobService {
    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }
}
