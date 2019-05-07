package com.example.mystore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.mystore.model.Tag;

@Transactional(readOnly = true)
public interface TagRepository extends JpaRepository<Tag, Long> {

	

}
