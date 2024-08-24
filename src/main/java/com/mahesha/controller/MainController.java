package com.mahesha.controller;

import com.mahesha.model.JobDetails;
import com.mahesha.service.JobService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;
import java.util.Map;

@RestController
public class MainController {

    private JobService jobService;
    public MainController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/")
    public List<String> getHome(){
        List<String> hello = Stream.of("This","That").toList();
        System.out.println("hello");
        return hello;
    }

   @PostMapping("jobPost")
    public Map<String, Boolean> postJob(@RequestBody JobDetails jobPost){

       boolean added = jobService.add(jobPost);
       Map<String, Boolean> response = new HashMap<>();
       response.put("acknowledged", added);
       return response;
   }

   @GetMapping("jobPost")
    public List<JobDetails> getJobs(){
        return jobService.getAll();
   }

    @GetMapping("jobPost/{jobId}")
    public JobDetails getJobs(@PathVariable int jobId){
        return jobService.get(jobId);
    }
}
