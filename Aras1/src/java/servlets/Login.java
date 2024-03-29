/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.DaftarPengguna;
import entity.Pengguna;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Margo Utomo
 */
public class Login extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String namapengguna = request.getParameter("namapengguna");
        String katasandi = request.getParameter("katasandi");
        
        DaftarPengguna penggunax = new DaftarPengguna();
        
        //Pengguna pengguna = penggunax.getPengguna("Nama Pengguna", "Kata Sandi"); 
        //Pengguna admin = penggunax.check("admin", "123456");
        if (penggunax.check("admin","123456") == false ) {
            penggunax.addAdmin();
        }
        
        Pengguna pengguna = penggunax.getPengguna(namapengguna, katasandi);
               
        if (namapengguna == "" || katasandi == "") {
            request.setAttribute("Peringatan","Nama pengguna dan kata sandi harus di isi");
            //response.sendRedirect("halamanlogin.jsp");
            RequestDispatcher rdp = request.getRequestDispatcher("pages/halamanlogin.jsp");
            rdp.forward(request, response);
       }else if(penggunax.check(namapengguna, katasandi)==false){
            request.setAttribute("Peringatan","Nama pengguna atau kata sandi tidak ditemukan");
            //response.sendRedirect("halamanlogin.jsp");
            RequestDispatcher rdp = request.getRequestDispatcher("pages/halamanlogin.jsp");
            rdp.forward(request, response);
        } else {
            HttpSession session = request.getSession(true);
            if(pengguna.getPeran()=="admin"){
                session.setAttribute("namapengguna", namapengguna);
                session.setAttribute("peran", pengguna.getPeran() );
                //response.sendRedirect("/pages/home.jsp");
            } else if(pengguna.getPeran()=="guru"){
                session.setAttribute("namapengguna", namapengguna);
                session.setAttribute("peran", pengguna.getPeran());
                //request.getRequestDispatcher("/pages/home.jsp").forward(request, response);
            } else if (pengguna.getPeran() == "TU"){
                session.setAttribute("namapengguna", namapengguna);
                session.setAttribute("peran", pengguna.getPeran());
                //request.getRequestDispatcher("/pages/home.jsp").forward(request, response);
            }
            
            RequestDispatcher rdp = request.getRequestDispatcher("pages/home.jsp");
            rdp.forward(request, response);
            //session.setAttribute("nama", namapengguna);
          //  session.setAttribute("pengguna", pengguna);
            
            //RequestDispatcher rdp = request.getRequestDispatcher("/index.jsp");
            //rdp.forward(request, response);
            
        }
        
        
        try {
            //RequestDispatcher rdp = request.getRequestDispatcher("pages/halamanlogin.jsp");
            //rdp.forward(request, response);
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Login at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
        } finally {            
           out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
