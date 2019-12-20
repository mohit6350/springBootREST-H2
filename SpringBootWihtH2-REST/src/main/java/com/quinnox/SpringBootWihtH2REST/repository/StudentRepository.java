package com.quinnox.SpringBootWihtH2REST.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quinnox.SpringBootWihtH2REST.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
