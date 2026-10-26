package crudpackage.crudapi.controller;


import crudpackage.crudapi.dto.AdminDTO;
import crudpackage.crudapi.service.Adminservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private Adminservice adminservice;
    @PostMapping("/reg")
    public  String AdminAddAPI(@RequestBody AdminDTO  adminDTO){
        return adminservice.AdminAddlogic(adminDTO);

    }
    @PostMapping("/login")
    public ResponseEntity<String> AdminLogin(@RequestBody AdminDTO adminDTO){

        boolean result =adminservice.adminloginlogic(adminDTO);
        if(result){
            return ResponseEntity.ok("login successfully");
        }else {
            return  ResponseEntity.ok("login failed");
        }
    }
}


