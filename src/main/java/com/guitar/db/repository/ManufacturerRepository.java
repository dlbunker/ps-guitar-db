package com.guitar.db.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.guitar.db.model.Manufacturer;

@Repository
public class ManufacturerRepository {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Create
	 */
	public Manufacturer create(Manufacturer man) {
		entityManager.persist(man);
		entityManager.flush();
		return man;
	}

	/**
	 * Update
	 */
	public Manufacturer update(Manufacturer man) {
		man = entityManager.merge(man);
		entityManager.flush();
		return man;
	}

	/**
	 * Delete
	 */
	public void delete(Manufacturer man) {
		entityManager.remove(man);
		entityManager.flush();
	}

	/**
	 * Find
	 */
	public Manufacturer find(Long id) {
		return entityManager.find(Manufacturer.class, id);
	}

	/**
	 * Custom finder
	 */
	public List<Manufacturer> getManufacturersFoundedBeforeDate(Date date) {
		@SuppressWarnings("unchecked")
		List<Manufacturer> mans = entityManager
				.createQuery("select m from Manufacturer m where m.foundedDate < :date")
				.setParameter("date", date).getResultList();
		return mans;
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
