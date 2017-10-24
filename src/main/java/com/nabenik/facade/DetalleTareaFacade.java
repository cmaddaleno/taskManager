package com.nabenik.facade;

import com.nabenik.model.DetalleTarea;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * DAO for Post
 */
@Stateless
public class DetalleTareaFacade extends AbstractFacade<DetalleTarea> {

    @PersistenceContext(unitName = "demo-persistence-unit")
    private EntityManager em;


    public DetalleTareaFacade() {
        super(DetalleTarea.class);
    }
    
    public DetalleTareaFacade(Class<DetalleTarea> entityClass) {
        super(entityClass);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
