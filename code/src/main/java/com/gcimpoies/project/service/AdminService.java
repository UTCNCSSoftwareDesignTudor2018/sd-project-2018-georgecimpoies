package com.gcimpoies.project.service;

import com.gcimpoies.project.model.Admin;
import com.gcimpoies.project.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    AdminRepository adminRepository;

    public Admin createAdmin(int id, String name, String username, String password) {
        Admin admin = new Admin(id, name, username, password);
        adminRepository.save(admin);
        return admin;
    }

    public Admin findById(int id) {
        if (adminRepository.findById(id).isPresent()) {
            return adminRepository.findById(id).get();
        } else return null;
    }

    public Admin findByUsernameAndPassword(String username, String password){
        if(adminRepository.findAdminByUsernameAndPassword(username, password).isPresent()){
            return adminRepository.findAdminByUsernameAndPassword(username, password).get();
        }
        return null;
    }

    public void delete(int id) {
        adminRepository.deleteAdminById(id);
    }
}
