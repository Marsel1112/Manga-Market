package listener;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.book.BookDao;
import dao.user.UserDao;
import entity.Book;
import entity.User;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import service.BookService.BookService;
import service.UserService.UserService;

import java.io.File;
import java.util.List;

@WebListener
public class Context implements ServletContextListener{

    private final String USER_DATA = "C:\\Projects\\Manga-Market\\src\\main\\resources\\UserData";
    private final String BOOK_DATA = "C:\\Projects\\Manga-Market\\src\\main\\resources\\BookData";

    @Override
    public void contextInitialized(ServletContextEvent sce) {
            ServletContext servletContext = sce.getServletContext();

            ObjectMapper objectMapper = new ObjectMapper();
            File fileUser = new File(USER_DATA);
            File fileBook = new File(BOOK_DATA);

            UserDao userDao = new UserDao(objectMapper, fileUser, new TypeReference<List<User>>() {
            });
            BookDao bookDao = new BookDao(objectMapper, fileBook, new TypeReference<List<Book>>() {
            });

            UserService userService = new UserService(userDao);
            BookService bookService = new BookService(bookDao);

            servletContext.setAttribute("userService", userService);
            servletContext.setAttribute("bookService", bookService);
            servletContext.setAttribute("objectMapper", objectMapper);
    }
}
