package com.project.api.repository;

import org.springframework.data.repository.CrudRepository;
import com.project.api.model.*;

public interface RepositoryApi extends CrudRepository<Person, Integer> {
    
}
