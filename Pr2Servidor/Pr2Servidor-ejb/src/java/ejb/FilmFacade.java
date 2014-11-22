/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import entity.Film;
import entity.Rating;
import entity.SpecialFeatures;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Daniel Alejandro Castro García <dandev237@gmail.com>
 */
@Stateless
public class FilmFacade extends AbstractFacade<Film> {
    @PersistenceContext(unitName = "pr2Servidor-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FilmFacade() {
        super(Film.class);
    }

    public List<Film> findByTitle(String title){
        return em.createNamedQuery("Film.findByTitle", Film.class).setParameter("title", title)
                .getResultList();
    }
    
    public List<Film> findByReleaseYear(Integer year){
        return em.createNamedQuery("Film.findByReleaseYear", Film.class).setParameter("releaseYear", year)
                .getResultList();
    }
    
    public List<Film> findByRentalDuration(Integer duration){
        return em.createNamedQuery("Film.findByRentalDuration", Film.class).setParameter("rentalDuration",
                duration).getResultList();
    }
    
    public List<Film> findByRentalRate(Double rate){
        return em.createNamedQuery("Film.findByRentalRate", Film.class).setParameter("rentalRate", rate)
                .getResultList();
    }
    
    public List<Film> findByLength(Integer length){
        return em.createNamedQuery("Film.findByLength", Film.class).setParameter("length", length)
                .getResultList();
    }
    
    public List<Film> findByReplacementCost(Double cost){
        return em.createNamedQuery("Film.findByReplacementCost", Film.class)
                .setParameter("replacementCost", cost).getResultList();
    }
    
    public List<Film> findByRating(Rating rating){
        return em.createNamedQuery("Film.findByRating", Film.class).setParameter("rating", rating)
                .getResultList();
    }
    
    public List<Film> findBySpecialFeatures(SpecialFeatures feature){
        return em.createNamedQuery("Film.findBySpecialFeatures", Film.class)
                .setParameter("specialFeatures", feature).getResultList();
    }
}
