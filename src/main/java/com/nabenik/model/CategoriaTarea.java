package com.nabenik.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class CategoriaTarea implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idCategoriaTarea", updatable = false, nullable = false)
    private Integer idCategoriaTarea;
   
    @Column
    @ManyToOne(fetch = FetchType.LAZY)
    private Tarea idTarea;
    
    @Column
    @ManyToOne(fetch = FetchType.LAZY)
    private Categoria idCategoria;

    public Integer getIdCategoriaTarea() {
        return idCategoriaTarea;
    }

    public void setIdCategoriaTarea(Integer idCategoriaTarea) {
        this.idCategoriaTarea = idCategoriaTarea;
    }

    public Tarea getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(Tarea idTarea) {
        this.idTarea = idTarea;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

   
    
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CategoriaTarea)) {
            return false;
        }
        CategoriaTarea other = (CategoriaTarea) obj;
        if (idCategoriaTarea != null) {
            if (!idCategoriaTarea.equals(other.idCategoriaTarea)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idCategoriaTarea == null) ? 0 : idCategoriaTarea.hashCode());
        return result;
    }

}
