package com.example.crud.repository;

import com.example.crud.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
// We can use JpaRepository’s methods:
// save(), findOne(), findById(), findAll(), count(), delete(), deleteById()
// without implementing these methods
public interface TutorialRepository extends JpaRepository<Tutorial,Long> {
    //Custom finder methods
    List<Tutorial> findByPublished(boolean published);
    List<Tutorial> findByTitleContaining(String title);
}
