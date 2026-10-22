package crudpackage.crudapi.service;

import crudpackage.crudapi.dao.CourseDAO;

import java.util.List;

public interface Courseservice {
//    public String CourseAddlogic(CourseDAO courseDAO);
    String CourseAddlogic(CourseDAO courseDAO);
    List<CourseDAO> Coursedisplayall();
}