package crudpackage.crudapi.controller;


import crudpackage.crudapi.dto.AdminDTO;
import crudpackage.crudapi.dto.CourseDTO;
import crudpackage.crudapi.service.Courseservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courseapi")
public class CourseController {

    @Autowired
    private Courseservice courseservice;


    @PostMapping("/addcourse")
    public String CourseApi(@RequestBody CourseDTO courseDTO){
        return courseservice.CourseAddlogic(courseDTO);

    }

    @GetMapping("/viewCourse")
    public List<CourseDTO> Displayall(){
        return courseservice.Coursedisplayall();
    }

//    @PostMapping("/addadmin")
//    public String Storeadmin(@RequestBody AdminDTO adminDTO){
//        return courseservice.AdminAddlogic(adminDTO);
//
//    }
    @PutMapping("/updatecourse")
    public ResponseEntity<String> Updatecourse(@RequestBody CourseDTO courseDTO){
        String response=courseservice.Updatecouselogic(courseDTO);
        return ResponseEntity.ok(response);
    }
}