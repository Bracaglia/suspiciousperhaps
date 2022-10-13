package com.samanthabracaglia.bundleofjoy.repositories;

import com.samanthabracaglia.bundleofjoy.models.BabyName;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BabyNameRepository extends CrudRepository<BabyName, Long> {
    List<BabyName> findAll();
}

