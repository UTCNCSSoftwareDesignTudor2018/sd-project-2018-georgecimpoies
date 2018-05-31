package com.gcimpoies.project.repository;

import com.gcimpoies.project.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    public Admin save(Admin admin);

    public Optional<Admin> findByAdminId(Integer adminId);

    public Admin findAdminByUsername(String username);

    public void deleteAdminByAdminId(int adminId);
}
