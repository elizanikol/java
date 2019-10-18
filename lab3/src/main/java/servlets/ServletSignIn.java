package servlets;

import DAO.DAOhash;
import DAO.DAOpassword;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "ServletSignIn")
public class ServletSignIn extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        DAOpassword daoPass = new DAOpassword();
        DAOhash daohash = new DAOhash();

        if (daoPass.containsLoginPassword(login, password)) {
            Cookie cookie = new Cookie("sessionID", daohash.getAccountByUsername(login).getHash());
            response.addCookie(cookie);
            response.sendRedirect("/registration_war_exploded/users.jsp");
        } else {
            PrintWriter out = response.getWriter();
            out.println("<script>alert('Wrong pair login/password, try again');");
            out.println("location='sign_in.jsp';</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
