package listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.book.BookDao;
import dao.user.UserDao;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import service.BookService.BookService;
import service.UserService.UserService;

import java.io.File;

@WebListener
public class Context implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent sce) {
            ServletContext servletContext = sce.getServletContext();

            ObjectMapper objectMapper = new ObjectMapper();
            File fileUser = new File("D:\\project\\Market\\src\\main\\resources\\UserData");
            File fileBook = new File("D:\\project\\Market\\src\\main\\resources\\BookData");

            UserDao userDao = new UserDao(objectMapper, fileUser);
            BookDao bookDao = new BookDao(objectMapper,fileBook);

            UserService userService = new UserService(userDao);
            BookService bookService = new BookService(bookDao,objectMapper);

            servletContext.setAttribute("userService", userService);
            servletContext.setAttribute("bookService", bookService);
            servletContext.setAttribute("objectMapper", objectMapper);
    }
}
