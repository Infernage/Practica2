/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Alberto
 */
@WebServlet(name = "SearchServlet", urlPatterns = {"/search"})
public class SearchServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/Pr2Servidor-war/FilmWebService.wsdl")
    private FilmWebService_Service service;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String searchType = request.getParameter("options"), data = request.getParameter("data");
        FilmWebService port = service.getFilmWebServicePort();
        List<Film> res = null;
        switch (searchType) {
            case "title":
                res = port.findByTitle(data);
                request.getSession().setAttribute("result", res);
                break;
            case "category":
                request.getSession().setAttribute("result", port.findByCategory(data));
                break;
            case "year": // release date
                request.getSession().setAttribute("result", port.findByReleaseYear(Integer.parseInt(data)));
                break;
            case "language":
                request.getSession().setAttribute("result", port.findByLanguage(data));
                break;
            case "duration": // rental duration
                request.getSession().setAttribute("result", port.findByRentalDuration(Integer.parseInt(data)));
                break;
            case "rate": // rental rate
                request.getSession().setAttribute("result", port.findByRentalRate(Double.parseDouble(data)));
                break;
            case "length":
                request.getSession().setAttribute("result", port.findByLength(Integer.parseInt(data)));
                break;
            case "cost": // reemplacement cost
                request.getSession().setAttribute("result", port.findByReplacementCost(Double.parseDouble(data)));
                break;
            case "rating":
                request.getSession().setAttribute("result", port.findByRating(data));
                break;
            case "features":
                request.getSession().setAttribute("result", port.findBySpecialFeatures(data));
                break;
        }
        System.out.println("RESULT="+res.size());
        getServletContext().getRequestDispatcher("/show.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private java.util.List<servlet.Film> findByCategory(java.lang.String categoryName) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        servlet.FilmWebService port = service.getFilmWebServicePort();
        return port.findByCategory(categoryName);
    }
    
    

}
