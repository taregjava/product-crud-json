package com.crudjsp.demo_crud.repoistory;

import com.crudjsp.demo_crud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
