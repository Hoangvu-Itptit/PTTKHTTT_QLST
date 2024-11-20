package Controller;

import DAO.DAO399;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DangNhap399")
public class DangNhap399 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var username = request.getParameter("username");
        var password = request.getParameter("password");

        if (validateUser(username, password)) {
            response.sendRedirect("GDChinhNVQL399.jsp");
        }

        var dao = new DAO399();
    }

    private boolean validateUser(String username, String password) {
        return username.equals("admin") && password.equals("admin");
    }
}
