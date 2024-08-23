package servlets.bookServlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servlets.BaseServlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@WebServlet("/main/book")
public class BookServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String sellerBooks = bookService.getAllBooks((UUID) req.getSession().getAttribute("userID"));

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(sellerBooks);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        bookService.saveBook(createBookMap(req));
    }
    private Map<String, Object> createBookMap(HttpServletRequest req){
        Map<String, Object> bookMap = new HashMap<>();
        bookMap.put("bookTitle", req.getParameter("bookTitle"));
        bookMap.put("bookGenre", req.getParameter("bookGenre"));
        bookMap.put("bookPrice", req.getParameter("bookPrice"));
        bookMap.put("count", req.getParameter("count"));
        bookMap.put("userID", req.getParameter("userID"));
        bookMap.put("url", req.getParameter("url"));
        return bookMap;
    }
}
