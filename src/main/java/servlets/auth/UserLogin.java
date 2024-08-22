package servlets.auth;

import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import servlets.BaseServlet;

import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class UserLogin extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.html").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        User user = null;
        try {
            user = userService.getUser(name,password);
            addSession(req.getSession(),user);

            resp.sendRedirect("/Market/main");
        }catch (NullPointerException e){
            resp.sendRedirect("login.html");
        }
    }
    private void addSession(HttpSession session, User user){
        session.setAttribute("userID", user.getId());
    }
}
