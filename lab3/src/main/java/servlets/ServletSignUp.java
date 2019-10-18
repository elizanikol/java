package servlets;

import DAO.DAOhash;
import DAO.DAOpassword;
import entities.HashEntity;
import entities.PasswordEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;


@WebServlet(name = "ServletSignUp")
public class ServletSignUp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        DAOpassword daoPass = new DAOpassword();
        DAOhash daoHash = new DAOhash();

        PasswordEntity usersPasswords = new PasswordEntity(login, password);

        String hashOfSession = UUID.randomUUID().toString();
        HashEntity usersHashes = new HashEntity(login, hashOfSession);

        if (!daoPass.containsUsername(login)) {
            daoHash.save(usersHashes);
            daoPass.save(usersPasswords);
            Cookie cookie = new Cookie("sessionID", hashOfSession);
            response.addCookie(cookie);
            response.sendRedirect("/registration_war_exploded/users.jsp");
        } else {
            PrintWriter out = response.getWriter();
            out.println("<script>alert('User with this login already exists, chose another one');");
            out.println("location='sign_up.jsp';</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
