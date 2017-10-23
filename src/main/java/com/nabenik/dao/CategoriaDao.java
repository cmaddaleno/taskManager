package com.nabenik.dao;

import com.nabenik.model.Automovil;
import com.nabenik.model.Categoria;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


/**
 * DAO for Post
 */
@Stateless
public class CategoriaDao {
	@PersistenceContext(unitName = "demo-persistence-unit")
	private EntityManager em;

	public void create(Categoria entity) {
		em.persist(entity);
	}

	public void deleteById(Integer id) {
		Categoria entity = em.find(Categoria.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public Categoria findById(Integer id) {
		return em.find(Categoria.class, id);
	}

	public Categoria update(Categoria entity) {
		return em.merge(entity);
	}

	public List<Categoria> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Categoria> findAllQuery = em.createQuery(
				"SELECT DISTINCT p FROM Categoria p ORDER BY p.id", Categoria.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
