package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/DangKi399"})
public class DangKi399 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var userName = request.getParameter("userName");
        var passWord = request.getParameter("passWord");
        var name = request.getParameter("name");
        var address = request.getParameter("address");
        var sdt = request.getParameter("sdt");
        var email = request.getParameter("email");

        getDangKi(response, userName, passWord, name, address, sdt, email);
    }

    private void getDangKi(HttpServletResponse response, String userName, String passWord, String name, String address, String sdt, String email) throws IOException {
        System.out.println("Button clicked!");
        response.sendRedirect("GDThatBai399.jsp");
    }
}
