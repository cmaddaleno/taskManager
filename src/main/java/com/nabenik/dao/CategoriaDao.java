package com.nabenik.dao;

import com.nabenik.model.Automovil;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


/**
 * DAO for Post
 */
@Stateless
public class AutomovilDao {
	@PersistenceContext(unitName = "demo-persistence-unit")
	private EntityManager em;

	public void create(Automovil entity) {
		em.persist(entity);
	}

	public void deleteById(Long id) {
		Automovil entity = em.find(Automovil.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public Automovil findById(Long id) {
		return em.find(Automovil.class, id);
	}

	public Automovil update(Automovil entity) {
		return em.merge(entity);
	}

	public List<Automovil> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Automovil> findAllQuery = em.createQuery(
				"SELECT DISTINCT p FROM Automovil p ORDER BY p.id", Automovil.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
