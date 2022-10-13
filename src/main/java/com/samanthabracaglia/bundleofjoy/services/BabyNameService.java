package com.samanthabracaglia.bundleofjoy.services;

import com.samanthabracaglia.bundleofjoy.models.BabyName;
import com.samanthabracaglia.bundleofjoy.repositories.BabyNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BabyNameService {
    @Autowired
    BabyNameRepository babyNameRepository;


    public void create(BabyName babyName) {
        babyNameRepository.save(babyName);

    }

    public List<BabyName> getAll() {
        return (List<BabyName>) babyNameRepository.findAll();
    }

    public BabyName getOne(Long id) {
        Optional<BabyName> babyName = babyNameRepository.findById(id);
        return babyName.orElse(null);
    }

    public void update(BabyName babyName) {
        babyNameRepository.save(babyName);
    }

    public void destroy(BabyName babyName) {
        babyNameRepository.delete(babyName);
    }



    public BabyName findBabyName(Long id) {
        Optional<BabyName> babyName = babyNameRepository.findById(id);
        return babyName.orElse(null);
    }
}
