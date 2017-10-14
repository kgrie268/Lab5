package sait.cprg352;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 742227
 */
public class ShoppingServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        
        ArrayList<String> itemlist = new ArrayList<String>();; //just change this it could give a error
        if(session.getAttribute("item") != null){
            itemlist = (ArrayList<String>) session.getAttribute("item");
        }
        
        if (action != null && action.equals("register")) {
            String userName = request.getParameter("userName");

            session.setAttribute("userName", userName);
        }
        if (action != null && action.equals("add")) {
            String itemString = request.getParameter("item");
           
            itemlist.add(itemString);
            System.out.println(itemlist);
            session.setAttribute("item", itemlist);

        }
        if (action != null && action.equals("delete")) {

            String value = request.getParameter("item");
            for (int i = 0; i < itemlist.size(); i++) {
                if(value.equals(itemlist.get(i))){
                    itemlist.remove(i);
                }
                
              
            }
            System.out.println(itemlist);
            

            session.setAttribute("item", itemlist); //save it back to session
        }
        if (action != null && action.equals("logout")) {

            session.invalidate();
        }
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
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

        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }
}
