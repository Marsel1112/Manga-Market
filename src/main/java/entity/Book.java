package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Book {
    private UUID    bookId;
    private String  bookTitle;
    private String  bookGenre;
    private long    bookPrice;
    private int     count;
    private UUID    sellerID;
    private String     url;
}
