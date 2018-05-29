package com.gcimpoies.project.repository;

import com.gcimpoies.project.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    public Admin save(Admin admin);

    public Optional<Admin> findById(Integer id);

    public Optional<Admin> findAdminByUsernameAndPassword(String username, String password);

    public void deleteAdminById(int id);
}
