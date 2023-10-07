package com.ennachat.springboot.wejob.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;

    public List<Job> finAllJobs(){
        List<Job> jobs = new ArrayList<>();
        jobRepository.findAll().forEach(jobs::add);
        return jobs;
    }

    public  Job findJob(Long id){
        return jobRepository.findById(id).orElseThrow(() -> new JobNotFoundException("User with id "+id+" not found"));
    }

    public Job addJob(Job job){
        return jobRepository.save(job);
    }

    public Job editJob(Job job){
        return jobRepository.save(job);
    }

    public void deleteJob(long id){
        jobRepository.deleteById(id);
    }

}
