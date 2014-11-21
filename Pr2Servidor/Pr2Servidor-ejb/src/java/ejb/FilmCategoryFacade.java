/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.FilmCategory;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author FRANCISCOJAVIER
 */
@Stateless
public class FilmCategoryFacade extends AbstractFacade<FilmCategory> {
    @PersistenceContext(unitName = "Pr2Servidor-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FilmCategoryFacade() {
        super(FilmCategory.class);
    }
    
}
