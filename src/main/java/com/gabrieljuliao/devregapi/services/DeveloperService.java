package com.gabrieljuliao.devregapi.services;

import com.gabrieljuliao.devregapi.exceptions.DeveloperNotFoundException;
import com.gabrieljuliao.devregapi.exceptions.RFC7807ProblemsDetails;
import com.gabrieljuliao.devregapi.resources.DeveloperResource;
import com.gabrieljuliao.devregapi.model.Developer;
import com.gabrieljuliao.devregapi.repository.DeveloperRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class DeveloperService {

    private final DeveloperRepository developerRepository;

    public DeveloperService(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    public DeveloperResource getById(Long id) {
        Optional<Developer> opt = developerRepository.findById(id);
//        return opt.map(DeveloperResource::new).orElse(null);
        if (opt.isPresent()){
            return new DeveloperResource(opt.get());
        }
        throw new DeveloperNotFoundException();
    }

    public DeveloperResource create(DeveloperResource resource) {
        return new DeveloperResource(
                developerRepository.save(resource.toEntity())
        );
    }

    public Iterable<DeveloperResource> getAll() {
        Iterable<Developer> developers = developerRepository.findAll();
        ArrayList<DeveloperResource> developerResources = new ArrayList<>();
        developers.forEach(developer -> {
            developerResources.add(new DeveloperResource(developer));
        });
        return developerResources;
    }
}
