package com.tw.web.api;

import com.tw.core.Course;
import com.tw.core.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by twer on 7/24/14.
 */
@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    private CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Course> findAll() {
        return courseService.findAll();
    }

    @RequestMapping(value = "/{courseId}", method = RequestMethod.GET)
    public ResponseEntity<Course> findOne(@PathVariable("courseId") long id) {
        Course course = courseService.findOne(id);

        if (course == null) {
            return new ResponseEntity<Course>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Course>(course, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Course course, HttpServletRequest request, HttpServletResponse response) {
        courseService.create(course);
        response.setHeader("Location", request.getRequestURL().append("/").append(course.getId()).toString());
    }

    @RequestMapping(value = "/{courseId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("courseId") long id, @RequestBody Course course) {
        courseService.update(course);
    }


    @RequestMapping(value = "/{courseId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("courseId") long id) {
        courseService.delete(id);
    }

    @RequestMapping(value = "/:batch", method = RequestMethod.DELETE )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAll(@RequestBody long[] ids) {
        courseService.deleteAll(ids);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<Course> search( @RequestParam(value = "keyword") String keyword) {
        return courseService.search(keyword);
    }

}
