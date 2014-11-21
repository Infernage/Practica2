/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Film;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FRANCISCOJAVIER
 */
@Stateless
public class FilmFacade extends AbstractFacade<Film> {
    @PersistenceContext(unitName = "Pr2Servidor-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FilmFacade() {
        super(Film.class);
    }
    
    public Film findByTitle(String title){
        return em.createNamedQuery("Film.findByTitle", Film.class).setParameter("title", title).getSingleResult();
    }
    
}
