package com.xx.dao;

import com.xx.model.Cdkey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CdkeyDAO extends JpaRepository<Cdkey, Long> {
    Cdkey findByUserId(Long id);
}
