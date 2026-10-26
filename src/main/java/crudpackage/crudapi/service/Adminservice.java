package crudpackage.crudapi.service;

import crudpackage.crudapi.dto.AdminDTO;

public interface Adminservice {
    public String AdminAddlogic(AdminDTO adminDTO);
    public boolean adminloginlogic(AdminDTO adminDTO);
}
