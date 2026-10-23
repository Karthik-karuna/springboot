package crudpackage.crudapi.service;

import crudpackage.crudapi.dto.AdminDTO;
import crudpackage.crudapi.dto.CourseDTO;

import java.util.List;

public interface Courseservice {
//    public String CourseAddlogic(CourseDAO courseDAO);
    String CourseAddlogic(CourseDTO courseDTO);
    List<CourseDTO> Coursedisplayall();
//    String AdminAddlogic(AdminDTO adminDTO);
public String Updatecouselogic(CourseDTO courseDTO);

    public String Deletestudentlogic(int studentid);
}