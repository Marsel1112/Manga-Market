package dao.book;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.BaseDao;
import entity.Book;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


public class BookDao extends BaseDao<Book> {

    public BookDao(ObjectMapper objectMapper, File file, TypeReference<List<Book>> typeReference) {
        super(objectMapper, file,typeReference);
    }

    public void saveBook(Book book) throws IOException {
        List<Book> books = getAllEntity();
        books.add(book);
        writeToFile(books);
    }
    public List<Book> getAllBook() throws IOException {
        return getAllEntity();
    }
    public String getAllBookFormatJSON() throws IOException {
        return objectMapper.writeValueAsString(getAllBook());
    }
    public String getAllBookFormatJSON(UUID userId) throws IOException {
        return objectMapper.writeValueAsString(getAllBook().stream()
                .filter(n-> n.getSellerID().equals(userId))
        );
    }
}
