package com.guitar.db.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.guitar.db.model.Manufacturer;

@Repository
public class ManufacturerRepository {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private ManufacturerJpaRepository manufactureJpaRepository;

	/**
	 * Create
	 */
	public Manufacturer create(Manufacturer man) {
		return manufactureJpaRepository.saveAndFlush(man);
	}

	/**
	 * Update
	 */
	public Manufacturer update(Manufacturer man) {
		return manufactureJpaRepository.saveAndFlush(man);
	}

	/**
	 * Delete
	 */
	public void delete(Manufacturer man) {
		manufactureJpaRepository.delete(man);
	}

	/**
	 * Find
	 */
	public Manufacturer find(Long id) {
		return manufactureJpaRepository.findOne(id);
	}

	/**
	 * Custom finder
	 */
	public List<Manufacturer> getManufacturersFoundedBeforeDate(Date date) {
		
		return manufactureJpaRepository.findByFoundedDateBefore(date);
	}

	/**
	 * Custom finder
	 */
	public Manufacturer getManufacturerByName(String name) {
		Manufacturer man = (Manufacturer)entityManager
				.createQuery("select m from Manufacturer m where m.name like :name")
				.setParameter("name", name + "%").getSingleResult();
		return man;
	}

	/**
	 * Native Query finder
	 */
	public List<Manufacturer> getManufacturersThatSellModelsOfType(String modelType) {
		@SuppressWarnings("unchecked")
		List<Manufacturer> mans = entityManager
				.createNamedQuery("Manufacturer.getAllThatSellAcoustics")
				.setParameter(1, modelType).getResultList();
		return mans;
	}
}
