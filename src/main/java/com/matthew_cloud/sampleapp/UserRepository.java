package com.matthew_cloud.sampleapp;
import org.springframework.data.repository.CrudRepository;
public interface UserRepository extends CrudRepository<User, Integer>{
    
}
