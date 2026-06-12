package com.rikkei_bank.repository;

import com.rikkei_bank.model.entity.KycProfile;
import com.rikkei_bank.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KycProfileRepository extends JpaRepository<KycProfile, Long> {
    Optional<KycProfile> findByUser(User user);
    boolean existsByIdNumber(String idNumber);
}
