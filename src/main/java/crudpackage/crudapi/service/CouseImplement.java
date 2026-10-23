package crudpackage.crudapi.service;

import crudpackage.crudapi.dto.AdminDTO;
import crudpackage.crudapi.dto.CourseDTO;
import crudpackage.crudapi.model.Adminmodel;
import crudpackage.crudapi.model.Coursemodel;
import crudpackage.crudapi.repository.AdminRepostiroy;
import crudpackage.crudapi.repository.CourseRepostiory;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CouseImplement implements Courseservice {
    @Autowired
    private CourseRepostiory courseRepostiory;// query logic

    @Override
    public String CourseAddlogic(@NonNull CourseDTO courseDTO) {
        Coursemodel savetheinfo = new Coursemodel(courseDTO.getSname()
                , courseDTO.getCourseduration(), courseDTO.getCoursename(),
                courseDTO.getCoursetime(), courseDTO.getDays(), courseDTO.getPhoneno());
        courseRepostiory.save(savetheinfo);
        return "data stored successfully";

    }

    @Override
    public List<CourseDTO> Coursedisplayall() {
        List<Coursemodel> getdata = courseRepostiory.findAll();
        List<CourseDTO> transfer = new ArrayList<>();
        for (Coursemodel getdataall : getdata) {
            CourseDTO set = new CourseDTO();
            set.setStudentid(getdataall.getStudentid());
            set.setSname(getdataall.getSname());
            set.setCourseduration(getdataall.getCourseduration());
            set.setCoursename(getdataall.getCoursename());
            set.setDays(getdataall.getDays());
            set.setPhoneno(getdataall.getPhoneno());
            set.setCoursetime(getdataall.getCoursetime());
            transfer.add(set);
        }
        return transfer;
    }

//    @Override
//    public String AdminAddlogic(AdminDTO adminDTO) {
//        Adminmodel saveadmintheinfo = new Adminmodel(adminDTO.getAdminid(),
//                adminDTO.getAdminname(), adminDTO.getAdminpassword()
//        );
//        AdminRepostiroy.save(saveadmintheinfo);
//        return "data stored successfully";
//    }

    @Override
    public String Updatecouselogic(CourseDTO courseDTO){
        Optional<Coursemodel> coursemodel = courseRepostiory.findById(courseDTO.getStudentid());
        if(coursemodel.isPresent()){
            Coursemodel savetheupdate= coursemodel.get();
            savetheupdate.setSname(courseDTO.getSname());
            savetheupdate.setCoursename(courseDTO.getCoursename());
            savetheupdate.setCourseduration(courseDTO.getCourseduration());
            savetheupdate.setDays(courseDTO.getDays());
            savetheupdate.setCoursetime(courseDTO.getCoursetime());
            savetheupdate.setPhoneno(courseDTO.getPhoneno());
             courseRepostiory.save(savetheupdate);
             return "student data updated";
        }else {
            return "student data not updated";
        }
    }

    @Override
    public String Deletestudentlogic(int studentid){
        Optional<Coursemodel> getdata=courseRepostiory.findById(studentid);// select * from course where studentid=?
        if(getdata.isPresent()){
            courseRepostiory.deleteByStudentid(studentid);// delete * from course where studentid=?;
            return "student id:"+studentid+" is deleted";
        }else {
            return "student id:"+studentid+" is not present in database";
        }
    }


}