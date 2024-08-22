package servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import service.BookService.BookService;
import service.UserService.UserService;

public abstract class BaseServlet extends HttpServlet{
    protected UserService userService;
    protected BookService bookService;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        userService = (UserService) servletContext.getAttribute("userService");
        bookService = (BookService) servletContext.getAttribute("bookService");
    }
}
