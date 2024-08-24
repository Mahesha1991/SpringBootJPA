package com.mahesha.repository;

import com.mahesha.model.JobDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
//@Component
//public class JobRepo {
//    private final List<JobDetails> jobDetails;
//
//    public JobRepo() {
//        this.jobDetails = new ArrayList<>();
//    }
//
//    public boolean add(JobDetails jobPost) {
//        return jobDetails.add(jobPost);
//    }
//
//    public List<JobDetails> getAll() {
//        return jobDetails;
//    }
//
//    public Optional<JobDetails> get(int jobId) {
//        return jobDetails.stream()
//                .filter(j -> j.getId() == jobId)
//                .findFirst();
//    }
//}

@Repository
public interface JobRepo extends JpaRepository<JobDetails, Integer> {


    //We need not give the query if the column name is used by findBy
    //@Query("select j from job_details j where j.description = ?1")
    List<JobDetails> findByDescription(String Description);
    List<JobDetails> findByExperience(Integer years);
    //If we need to find the tech years greater than then the method name will be
    List<JobDetails> findByExperienceGreaterThan(Integer years);
}
