package com.ennachat.springboot.wejob.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {
    private JobService jobService;

    @Autowired
    public JobController(JobService jobService){
        this.jobService=jobService;
    }

    @GetMapping()
    public ResponseEntity<List<Job>> findAllJobs(){
        return new ResponseEntity<List<Job>>(jobService.finAllJobs(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> findJob(@PathVariable long id){
        try {
            return new ResponseEntity<Job>(jobService.findJob(id),HttpStatus.OK);
        }catch (JobNotFoundException ex){
            System.out.println(ex.getMessage());
            return new ResponseEntity<Job>(new Job(),HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<Job> addJob(@RequestBody Job job){
        return new ResponseEntity<Job>(jobService.addJob(job),HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<Job> editJob(@RequestBody Job job){
        return new ResponseEntity<Job>(jobService.editJob(job),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteJob(@PathVariable long id){
        jobService.deleteJob(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
