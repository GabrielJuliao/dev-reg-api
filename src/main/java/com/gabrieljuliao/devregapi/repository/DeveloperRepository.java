package com.gabrieljuliao.devregapi.repository;

import com.gabrieljuliao.devregapi.model.Developer;
import org.springframework.data.repository.CrudRepository;

public interface DeveloperRepository extends CrudRepository<Developer, Long> {
}
