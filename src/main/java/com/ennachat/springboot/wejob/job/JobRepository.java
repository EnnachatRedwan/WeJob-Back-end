package com.ennachat.springboot.wejob.job;

import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<Job,Long> {
}
