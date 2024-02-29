package com.will.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.will.entity.Courses;

public interface CourseDao extends JpaRepository<Courses, Long>{
	
	
}
