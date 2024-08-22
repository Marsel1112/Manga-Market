package servlets.LibraruEndPoints;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servlets.BaseServlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/main/library")
public class LibraryServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sellerBooks = bookService.getAllBooks();

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(sellerBooks);
    }

}
