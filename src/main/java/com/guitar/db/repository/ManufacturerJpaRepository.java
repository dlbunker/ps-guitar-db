package com.guitar.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guitar.db.model.Manufacturer;

@Repository
public interface ManufacturerJpaRepository extends JpaRepository<Manufacturer, Long> {

}
