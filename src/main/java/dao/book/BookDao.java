package dao.book;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Book;
import entity.User;
import lombok.RequiredArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
public class BookDao {
    private final ObjectMapper objectMapper;
    private final File file;
    public void saveBook(Book book) throws IOException {
        List<Book> books = getAllBooks();
        books.add(book);
        objectMapper.writeValue(file,books);
    }
    public List<Book> getAllBooks() throws IOException {
        return objectMapper.readValue(file, new TypeReference<List<Book>>() {
        });
    }
}
