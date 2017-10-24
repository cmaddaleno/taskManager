package com.nabenik.facade;

import com.nabenik.model.Estado;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * DAO for Post
 */
@Stateless
public class EstadoFacade extends AbstractFacade<Estado> {

    @PersistenceContext(unitName = "demo-persistence-unit")
    private EntityManager em;

   
    public EstadoFacade() {
        super(Estado.class);
    }
    
    public EstadoFacade(Class<Estado> entityClass) {
        super(entityClass);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
