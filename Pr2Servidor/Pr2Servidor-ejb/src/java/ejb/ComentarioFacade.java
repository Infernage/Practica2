/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import entity.Comentario;
import entity.Film;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Daniel Alejandro Castro García <dandev237@gmail.com>
 */
@Stateless
public class ComentarioFacade extends AbstractFacade<Comentario> {
    @PersistenceContext(unitName = "pr2Servidor-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComentarioFacade() {
        super(Comentario.class);
    }
    
    /**
     * Inserta un nuevo comentario asociado a una película en la base de datos.
     * @param film
     * @param comentarioText 
     */
    public void addComentario(Film film, String comentarioText, String comentarioAutor){
        em.getTransaction().begin();
        
        Comentario comentario = new Comentario();
        comentario.setFilmId(film);
        comentario.setComentarioText(comentarioText);
        comentario.setComentarioAutor(comentarioAutor);
        comentario.setComentarioDate(new Date());
        
        em.persist(comentario);
        
        em.getTransaction().commit();
    }

}
