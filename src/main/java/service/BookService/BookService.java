package service.BookService;

import dao.book.BookDao;
import entity.Book;

import lombok.AllArgsConstructor;
import service.Service;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@AllArgsConstructor
public class BookService implements Service {

    private final BookDao bookDao;

    public void saveBook(Map<String, Object> bookMap) throws IOException {
        bookDao.saveBook(insertBook(bookMap));
    }
    public String getAllBooks(UUID userId) throws IOException {
        return bookDao.getAllBookFormatJSON(userId);
    }
    public String getAllBooks() throws IOException {
        return bookDao.getAllBookFormatJSON();
    }
    private Book insertBook(Map<String, Object> bookMap){
        return Book.builder()
                .bookId(UUID.randomUUID())
                .bookTitle((String) bookMap.get("bookTitle"))
                .bookGenre((String) bookMap.get("bookGenre"))
                .bookPrice((Long) bookMap.get("bookPrice"))
                .count((int) bookMap.get("count"))
                .sellerID((UUID) bookMap.get("userID"))
                .url((String) bookMap.get("url"))
                .build();
    }

}
