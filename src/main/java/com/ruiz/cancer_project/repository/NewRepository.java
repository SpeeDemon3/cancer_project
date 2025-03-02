package com.ruiz.cancer_project.repository;

import com.ruiz.cancer_project.entity.NewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewRepository extends JpaRepository<NewEntity, Long> {
}
