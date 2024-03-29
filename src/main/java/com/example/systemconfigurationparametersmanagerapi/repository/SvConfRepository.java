package com.example.systemconfigurationparametersmanagerapi.repository;


import com.example.systemconfigurationparametersmanagerapi.model.SvConf;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SvConfRepository extends JpaRepository<SvConf, String> {

    @Transactional
    Optional<SvConf> findByAttrName(String attrName);
    @Transactional
    void deleteByAttrName(String attrName);

}
