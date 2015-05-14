package com.tw.core.service;

import com.tw.core.Course;
import com.tw.core.dao.CourseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by twer on 7/17/14.
 */
@Service
public class CourseService {
    private CourseDAO courseDAO;

    @Autowired
    public CourseService(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    @Transactional
    public List<Course> listCourse() {
        return courseDAO.listCourse();
    }

    @Transactional
    public void addCourse(Course course) {
        courseDAO.addCourse(course);
    }

    @Transactional
    public Course findCourseById(long id) {
        return courseDAO.findCourseById(id);
    }

    @Transactional
    public void updateCourse(Course course) {
        courseDAO.updateCourse(course);
    }

    @Transactional
    public void deleteCourse(long id) {
        courseDAO.deleteCourse(id);
    }

    @Transactional
    public void deleteCourseList(long[] ids) {
        courseDAO.deleteCourseList(ids);
    }
    
    @Transactional
    public List<Course> findAll() {
        return courseDAO.findAll();
    }

    @Transactional
    public Course findOne(long id) {
        return courseDAO.findOne(id);
    }

    @Transactional
    public void create(Course course) {
        courseDAO.create(course);
    }

    @Transactional
    public void delete(long id) {
        courseDAO.delete(id);
    }

    @Transactional
    public void update(Course course) {
        courseDAO.update(course);
    }

    @Transactional
    public void deleteAll(long[] idList) {
        courseDAO.deleteAll(idList);
    }

    @Transactional
    public List<Course> search(String keyword) {
        return courseDAO.search(keyword);
    }
}
