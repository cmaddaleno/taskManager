package com.nabenik.facade;

import com.nabenik.model.Categoria;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * DAO for Post
 */
@Stateless
public class CategoriaFacade extends AbstractFacade<Categoria> {

    @PersistenceContext(unitName = "demo-persistence-unit")
    private EntityManager em;

    public CategoriaFacade() {
        super(Categoria.class);
    }

   

    public CategoriaFacade(Class<Categoria> entityClass) {
        super(entityClass);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
