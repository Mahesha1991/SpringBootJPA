package com.mahesha.service;

import com.mahesha.model.JobDetails;
import com.mahesha.repository.JobRepo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JobService {

    private JobRepo jobRepo;

    public JobService(JobRepo jobRepo) {
        this.jobRepo = jobRepo;
    }

    public boolean add(JobDetails jobPost) {

       // return jobRepo.add(jobPost);
        jobRepo.save(jobPost);
        return true;
    }

    public List<JobDetails> getAll() {
       return jobRepo.findAll();
    }

    public JobDetails get(int jobId) {
       return jobRepo.findById(jobId).orElse(new JobDetails());
    }
}
