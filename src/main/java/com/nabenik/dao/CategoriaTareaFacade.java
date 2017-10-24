package com.nabenik.dao;

import com.nabenik.facade.AbstractFacade;
import com.nabenik.model.CategoriaTarea;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * DAO for Post
 */
@Stateless
public class CategoriaTareaFacade extends AbstractFacade<CategoriaTarea> {

    @PersistenceContext(unitName = "demo-persistence-unit")
    private EntityManager em;

    public CategoriaTareaFacade() {
        super(CategoriaTarea.class);
    }

    public CategoriaTareaFacade(Class<CategoriaTarea> entityClass) {
        super(entityClass);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
