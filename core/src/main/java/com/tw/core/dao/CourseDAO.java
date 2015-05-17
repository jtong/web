package com.tw.core.dao;

import com.tw.core.Course;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by twer on 7/17/14.
 */
@Repository
@Transactional(readOnly = true)
public class CourseDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public CourseDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Course> listCourse() {
        return sessionFactory.getCurrentSession().createQuery("from Course")
                .list();
    }

    public void addCourse(Course course) {
        sessionFactory.getCurrentSession().save(course);
    }

    public Course findCourseById(long id) {
        Course course = (Course) sessionFactory.getCurrentSession().get(Course.class, id);
        return course;
    }

    public void updateCourse(Course course) {
        sessionFactory.getCurrentSession().update(course);
    }

    public void deleteCourse(long id) {
        Course course = findCourseById(id);
        if (course != null) {
            sessionFactory.getCurrentSession().delete(course);
        }
    }

    public void deleteCourseList(long[] ids) {
        for (int index = 0; index < ids.length; index++) {
            deleteCourse(ids[index]);
        }
    }
    
    public List<Course> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Course")
                .list();
    }

    public Course findOne(long id) {
        Course course = (Course) sessionFactory.getCurrentSession().get(Course.class, id);
        return course;
    }

    public void create(Course course) {
        sessionFactory.getCurrentSession().save(course);
    }

    public void delete(long id) {
        Course course = findOne(id);
        if (course != null) {
            sessionFactory.getCurrentSession().delete(course);
        }
    }

    public void update(Course course) {
        sessionFactory.getCurrentSession().update(course);
    }

    public void deleteAll(long[] idList) {
        for (long id : idList) {
            delete(id);
        }
    }

    public List<Course> search(String keyword) {
        String query = "FROM Course WHERE name LIKE :keyword";

        return sessionFactory.getCurrentSession().createQuery(query)
                .setString("keyword", "%" + keyword + "%")
                .list();
    }
}
