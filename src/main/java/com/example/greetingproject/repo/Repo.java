package com.example.greetingproject.repo;

import com.example.greetingproject.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface Repo extends JpaRepository<Greeting ,Long> {

}
