package service.BookService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.book.BookDao;
import entity.Book;
import entity.User;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@AllArgsConstructor
public class BookService {
    private final BookDao bookDao;
    private final ObjectMapper objectMapper;
    public void saveBook(Map<String, Object> bookMap) throws IOException {
        bookDao.saveBook(insertBook(bookMap));
    }
    public String getAllBooks(UUID userId) throws IOException {
        return convertToJSON(bookDao.getAllBooks().stream()
                                                    .filter(book -> book.getSellerID().equals(userId))
                                                    .toList());
    }
    public String getAllBooks() throws IOException {
        return convertToJSON(bookDao.getAllBooks());
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
    private String convertToJSON(List<Book> list) throws JsonProcessingException {
        return  objectMapper.writeValueAsString(list);
    }

}
