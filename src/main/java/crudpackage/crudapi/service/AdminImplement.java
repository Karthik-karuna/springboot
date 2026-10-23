package crudpackage.crudapi.service;


import crudpackage.crudapi.dto.AdminDTO;
import crudpackage.crudapi.model.Adminmodel;
import crudpackage.crudapi.repository.AdminRepostiroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminImplement implements Adminservice{

    @Autowired
    private AdminRepostiroy adminRepostiroy;

    public String AdminAddlogic(AdminDTO adminDTO){
        Adminmodel saveadmin = new Adminmodel(adminDTO.getAdminid(),
                adminDTO.getAdminname(),adminDTO.getAdminpassword());
        adminRepostiroy.save(saveadmin);
        return "data stored successfully";
    }
}
