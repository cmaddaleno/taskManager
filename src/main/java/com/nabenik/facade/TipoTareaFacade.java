package com.nabenik.facade;

import com.nabenik.model.TipoTarea;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * DAO for Post
 */
@Stateless
public class TipoTareaFacade extends AbstractFacade<TipoTarea> {

    @PersistenceContext(unitName = "demo-persistence-unit")
    private EntityManager em;


    
    public TipoTareaFacade() {
        super(TipoTarea.class);
    }
    
    
    public TipoTareaFacade(Class<TipoTarea> entityClass) {
        super(entityClass);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
