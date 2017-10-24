package com.nabenik.model;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Tarea implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    @Column
    //@Size(min = 1, max = 500)
    private String nombre;

    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaInicio;

    @Column
   // @Size(min = 1, max = 24)
    private Integer horaInicio;

    @Column
//    @Size(min = 0, max = 59)
    private Integer minutoInicio;

    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaFin;

    @Column
    //@Size(min = 1, max = 24)
    private Integer horaFin;

    @Column
    //@Size(min = 0, max = 59)
    private Integer minutoFin;

    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private TipoTarea idTipoTarea;

    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private Estado idEstado;

    @OneToMany(mappedBy = "idTarea")
    private List<DetalleTarea> listDetalleTarea;

    @OneToMany(mappedBy = "idTarea")
    private List<CategoriaTarea> listCategoriaTarea;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Estado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Estado idEstado) {
        this.idEstado = idEstado;
    }

    public List<DetalleTarea> getListDetalleTarea() {
        return listDetalleTarea;
    }

    public void setListDetalleTarea(List<DetalleTarea> listDetalleTarea) {
        this.listDetalleTarea = listDetalleTarea;
    }

    public TipoTarea getIdTipoTarea() {
        return idTipoTarea;
    }

    public void setIdTipoTarea(TipoTarea idTipoTarea) {
        this.idTipoTarea = idTipoTarea;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Integer getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Integer horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Integer getMinutoInicio() {
        return minutoInicio;
    }

    public void setMinutoInicio(Integer minutoInicio) {
        this.minutoInicio = minutoInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Integer horaFin) {
        this.horaFin = horaFin;
    }

    public Integer getMinutoFin() {
        return minutoFin;
    }

    public void setMinutoFin(Integer minutoFin) {
        this.minutoFin = minutoFin;
    }

    public List<CategoriaTarea> getListCategoriaTarea() {
        return listCategoriaTarea;
    }

    public void setListCategoriaTarea(List<CategoriaTarea> listCategoriaTarea) {
        this.listCategoriaTarea = listCategoriaTarea;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Tarea)) {
            return false;
        }
        Tarea other = (Tarea) obj;
        if (id != null) {
            if (!id.equals(other.id)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

}
