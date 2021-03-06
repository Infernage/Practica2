/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Film;
import entity.FilmCategory;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Alberto
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

    public List<Film> findByCategory(String categoryName) {
        return em.createNamedQuery("Category.findByName").setParameter("name", categoryName).getResultList();
    }

}
