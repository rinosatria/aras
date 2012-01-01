/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.DaftarSiswa;
import entity.Siswa;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Margo Utomo
 */
public class TambahSiswa extends HttpServlet {

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
        
        String nis = request.getParameter("nis");
        String namasiswa = request.getParameter("namasiswa");
        String kelas = request.getParameter("kelas");
        String semester = request.getParameter("semester");
        String namaortu = request.getParameter("namaortu");
        String alamat = request.getParameter("alamat");
        String nmrtlp = request.getParameter("nmrtlp");
        
        DaftarSiswa siswax = new DaftarSiswa();
        Siswa siswa = new Siswa();
        
        if (nis.equals("") && namasiswa.equals("") && kelas.equals("") && semester.equals("") && namaortu.equals("") && alamat.equals("") && nmrtlp.equals("")){
            request.setAttribute("Perhatian", "Semua kolom harus di isi");
        }else{
            siswa.setNis(nis);
            siswa.setNamasiswa(namasiswa);
            siswa.setKelas(kelas);
            siswa.setSemester(semester);
            siswa.setNamaortu(namaortu);
            siswa.setnmrtlp(nmrtlp);
        }
        
                
        
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TambahSiswa</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TambahSiswa at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
            RequestDispatcher rdp = request.getRequestDispatcher("/pages/TambahSiswa.jsp") ;
            rdp.forward(request, response);
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