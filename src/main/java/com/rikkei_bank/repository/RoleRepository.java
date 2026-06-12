package com.rikkei_bank.repository;

import com.rikkei_bank.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    // Tìm kiếm Role theo tên
    Optional<Role> findByName(String name);
}