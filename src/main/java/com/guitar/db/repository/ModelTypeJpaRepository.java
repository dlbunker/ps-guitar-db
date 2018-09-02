package com.guitar.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guitar.db.model.ModelType;

@Repository
public interface ModelTypeJpaRepository extends JpaRepository<ModelType, Long> {

}
