package com.will.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.will.dao.CourseDao;
import com.will.entity.Courses;
import com.will.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseDao courseDao;
	//		private List<Courses> list;
	
	
	public CourseServiceImpl() {
//		list = new ArrayList<>();
//		list.add(new Courses(11,"Effctive java","Joshua Block"));
//		list.add(new Courses(12,"Spring boot Course","eating rest"));
	}


	@Override
	public List<Courses> getCourses() {
		return courseDao.findAll();
	}


	@Override
	public Courses getCourse(long courseId) {
				return courseDao.getOne(courseId);
	}


	@Override
	public Courses addCourse(Courses course) {
		courseDao.save(course);
		return course;
	}


	@Override
	public Courses updateCourse(Courses course) {
		courseDao.save(course);
		return course;
	}


	@Override
	public void deleteCourse(long parseLong) {
		Courses entity = courseDao.getOne(parseLong);
		courseDao.delete(entity);
		
	}

}
