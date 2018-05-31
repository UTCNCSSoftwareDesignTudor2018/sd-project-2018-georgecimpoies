package com.gcimpoies.project.service;

import com.gcimpoies.project.model.Admin;
import com.gcimpoies.project.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    AdminRepository adminRepository;

    public Admin createAdmin(Admin admin) {
        adminRepository.save(admin);
        return admin;
    }

    public Admin findById(int id) {
        if (adminRepository.findByAdminId(id).isPresent()) {
            return adminRepository.findByAdminId(id).get();
        } else return null;
    }

    public Admin getAdminByUsername(String username) {
        return adminRepository.findAdminByUsername(username);
    }

    public void delete(int id) {
        adminRepository.deleteAdminByAdminId(id);
    }
}
