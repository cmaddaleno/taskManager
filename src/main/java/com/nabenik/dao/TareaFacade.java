package com.nabenik.dao;

import com.nabenik.facade.AbstractFacade;
import com.nabenik.model.Tarea;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * DAO for Post
 */
@Stateless
public class TareaFacade extends AbstractFacade<Tarea> {

    @PersistenceContext(unitName = "demo-persistence-unit")
    private EntityManager em;


    public TareaFacade() {
        super(Tarea.class);
    }
    
    
    public TareaFacade(Class<Tarea> entityClass) {
        super(entityClass);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    

}
