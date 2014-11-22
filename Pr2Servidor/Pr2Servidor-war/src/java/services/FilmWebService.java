/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import ejb.ComentarioFacade;
import ejb.FilmCategoryFacade;
import ejb.FilmFacade;
import ejb.LanguageFacade;
import entity.Film;
import entity.Rating;
import entity.SpecialFeatures;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author FRANCISCOJAVIER
 */
@WebService(serviceName = "FilmWebService")
public class FilmWebService {
    @EJB
    private ComentarioFacade ejbRefComentario;
    @EJB
    private LanguageFacade ejbRefLanguage;
    @EJB
    private FilmCategoryFacade ejbRefCategory;
    @EJB
    private FilmFacade ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "create")
    @Oneway
    public void create(@WebParam(name = "entity") Film entity) {
        ejbRef.create(entity);
    }

    @WebMethod(operationName = "edit")
    @Oneway
    public void edit(@WebParam(name = "entity") Film entity) {
        ejbRef.edit(entity);
    }

    @WebMethod(operationName = "remove")
    @Oneway
    public void remove(@WebParam(name = "entity") Film entity) {
        ejbRef.remove(entity);
    }

    @WebMethod(operationName = "find")
    public Film find(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAll")
    public List<Film> findAll() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRange")
    public List<Film> findRange(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "count")
    public int count() {
        return ejbRef.count();
    }

    /**
     * Web service operation
     * @param title
     * @return 
     */
    @WebMethod(operationName = "findByTitle")
    public List<Film> findByTitle(@WebParam(name = "title") String title) {
        return ejbRef.findByTitle(title);
    }

    /**
     * Web service operation
     * @param categoryName
     * @return 
     */
    @WebMethod(operationName = "findByCategory")
    public List<Film> findByCategory(@WebParam(name = "categoryName") String categoryName) {
        return ejbRefCategory.findByCategory(categoryName);
    }

    /**
     * Web service operation
     * @param year
     * @return 
     */
    @WebMethod(operationName = "findByReleaseYear")
    public List<Film> findByReleaseYear(@WebParam(name = "year") Integer year) {
        return ejbRef.findByReleaseYear(year);
    }

    /**
     * Web service operation
     * @param language
     * @return 
     */
    @WebMethod(operationName = "findByLanguage")
    public Collection<Film> findByLanguage(@WebParam(name = "language") String language) {
        return ejbRefLanguage.findByName(language).getFilmCollection1();
    }

    /**
     * Web service operation
     * @param rentalDur
     * @return 
     */
    @WebMethod(operationName = "findByRentalDuration")
    public List<Film> findByRentalDuration(@WebParam(name = "rentalDur") Integer rentalDur) {
        return ejbRef.findByRentalDuration(rentalDur);
    }

    /**
     * Web service operation
     * @param rate
     * @return 
     */
    @WebMethod(operationName = "findByRentalRate")
    public List<Film> findByRentalRate(@WebParam(name = "rate") Double rate) {
        return ejbRef.findByRentalRate(rate);
    }

    /**
     * Web service operation
     * @param length
     * @return 
     */
    @WebMethod(operationName = "findByLength")
    public List<Film> findByLength(@WebParam(name = "length") Integer length) {
        return ejbRef.findByLength(length);
    }

    /**
     * Web service operation
     * @param cost
     * @return 
     */
    @WebMethod(operationName = "findByReplacementCost")
    public List<Film> findByReplacementCost(@WebParam(name = "cost") Double cost) {
        return ejbRef.findByReplacementCost(cost);
    }

    /**
     * Web service operation
     * @param rating
     * @return 
     */
    @WebMethod(operationName = "findByRating")
    public List<Film> findByRating(@WebParam(name = "rating") String rating) {
        return ejbRef.findByRating(Rating.valueOf(rating));
    }

    /**
     * Web service operation
     * @param features
     * @return 
     */
    @WebMethod(operationName = "findBySpecialFeatures")
    public List<Film> findBySpecialFeatures(@WebParam(name = "features") String features) {
        return ejbRef.findBySpecialFeatures(SpecialFeatures.valueOf(features));
    }

    /**
     * Web service operation
     * @param film
     * @param comentario
     */
    @WebMethod(operationName = "addComentario")
    @Oneway
    public void addComentario(@WebParam(name = "film") Film film, @WebParam(name = "comentario") String comentario) {
        ejbRefComentario.addComentario(film, comentario);
    }
    
    
    
}
