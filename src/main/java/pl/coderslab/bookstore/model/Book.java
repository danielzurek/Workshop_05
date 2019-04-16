package pl.coderslab.bookstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {

    Long id;
    String isbn;
    String title;
    String author;
    String publisher;
    String type;

    public void update(Book other) {

        if (other != null) {

            // intentionally ignore ID

            if (other.getIsbn() != null) {
                isbn = other.getIsbn();
            }

            if (other.getTitle() != null) {
                title = other.getTitle();
            }

            if (other.getAuthor() != null) {
                author = other.getAuthor();
            }

            if (other.getPublisher() != null) {
                publisher = other.getPublisher();
            }

            if (other.getType() != null) {
                type = other.getType();
            }
        }
    }
}
