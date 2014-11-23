/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Daniel Alejandro Castro García <dandev237@gmail.com>
 */
@Entity
@Table(name = "comentario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comentario.findAll", query = "SELECT c FROM Comentario c"),
    @NamedQuery(name = "Comentario.findByComentarioId", query = "SELECT c FROM Comentario c WHERE c.comentarioId = :comentarioId"),
    @NamedQuery(name = "Comentario.findByComentarioDate", query = "SELECT c FROM Comentario c WHERE c.comentarioDate = :comentarioDate"),
    @NamedQuery(name = "Comentario.findByComentarioAutor", query = "SELECT c FROM Comentario c WHERE c.comentarioAutor = :comentarioAutor")})
public class Comentario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "comentario_id")
    private Integer comentarioId;
    @Lob
    @Size(max = 65535)
    @Column(name = "comentario_text")
    private String comentarioText;
    @Basic(optional = false)
    @NotNull
    @Column(name = "comentario_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date comentarioDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "comentario_autor")
    private String comentarioAutor;
    @JoinColumn(name = "film_id", referencedColumnName = "film_id")
    @ManyToOne(optional = false)
    private Film filmId;

    public Comentario() {
    }

    public Comentario(Integer comentarioId) {
        this.comentarioId = comentarioId;
    }

    public Comentario(Integer comentarioId, Date comentarioDate, String comentarioAutor) {
        this.comentarioId = comentarioId;
        this.comentarioDate = comentarioDate;
        this.comentarioAutor = comentarioAutor;
    }

    public Integer getComentarioId() {
        return comentarioId;
    }

    public void setComentarioId(Integer comentarioId) {
        this.comentarioId = comentarioId;
    }

    public String getComentarioText() {
        return comentarioText;
    }

    public void setComentarioText(String comentarioText) {
        this.comentarioText = comentarioText;
    }

    public Date getComentarioDate() {
        return comentarioDate;
    }

    public void setComentarioDate(Date comentarioDate) {
        this.comentarioDate = comentarioDate;
    }

    public String getComentarioAutor() {
        return comentarioAutor;
    }

    public void setComentarioAutor(String comentarioAutor) {
        this.comentarioAutor = comentarioAutor;
    }

    public Film getFilmId() {
        return filmId;
    }

    public void setFilmId(Film filmId) {
        this.filmId = filmId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (comentarioId != null ? comentarioId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comentario)) {
            return false;
        }
        Comentario other = (Comentario) object;
        if ((this.comentarioId == null && other.comentarioId != null) || (this.comentarioId != null && !this.comentarioId.equals(other.comentarioId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Comentario[ comentarioId=" + comentarioId + " ]";
    }

}
