package crudpackage.crudapi.service;


import crudpackage.crudapi.dto.AdminDTO;
import crudpackage.crudapi.model.Adminmodel;
import crudpackage.crudapi.repository.AdminRepostiroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminImplement implements Adminservice{

    @Autowired
    private AdminRepostiroy adminRepostiroy;


    @Override
    public String AdminAddlogic(AdminDTO adminDTO){
        Adminmodel saveadmin = new Adminmodel(adminDTO.getAdminid(),
                adminDTO.getAdminname(),adminDTO.getAdminpassword());
        adminRepostiroy.save(saveadmin);
        return "data stored successfully";
    }

    @Override
    public boolean adminloginlogic(AdminDTO adminDTO){
        Optional<Adminmodel> check= adminRepostiroy.findByAdminidAndAdminpassword(adminDTO.getAdminid(),adminDTO.getAdminpassword());
        return check.isPresent();
    }

    @Override
    public AdminDTO admindisplaylogic(String adminid){
        Adminmodel get=adminRepostiroy.findByAdminid(adminid);
        if(get!=null) {
            AdminDTO transfer = new AdminDTO();
            transfer.setSerialno(get.getSerialno());
            transfer.setAdminid(get.getAdminid());
            transfer.setAdminname(get.getAdminname());
            transfer.setAdminpassword(get.getAdminpassword());
            return transfer;
        }else {
            AdminDTO transfer = new AdminDTO();
            transfer.setSerialno(0);
            transfer.setAdminid("not present");
            transfer.setAdminname("not present");
            transfer.setAdminpassword("not present");
            return transfer;

        }
    }
}
