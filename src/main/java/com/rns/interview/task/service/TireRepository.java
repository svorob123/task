package com.rns.interview.task.service;

import com.rns.interview.task.entity.Tire;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TireRepository extends CrudRepository<Tire, Integer> {
}
