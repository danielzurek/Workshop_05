package pl.coderslab.bookstore.service;

import org.springframework.stereotype.Service;
import pl.coderslab.bookstore.model.Book;

import java.util.*;

@Service
public class MemoryBookService implements BookService {

    private final Map<Long, Book> books = new HashMap<>();

    public MemoryBookService() {
        books.put(1L, new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel", "Helion", "programming"));
        books.put(2L, new Book(2L, "9788324627738", "Rusz glowa, Java.","Sierra Kathy, Bates Bert", "Helion", "programming"));
        books.put(3L, new Book(3L, "9780130819338", "Java 2. Podstawy", "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }

    @Override
    public Book findById(long id) {
        return books.get(id);
    }

    @Override
    public Book save(Book book) {
        book.setId(getNextId());
        books.put(book.getId(), book);
        return book;
    }

    @Override
    public Book update(long id, Book book) {

        final Book bookToUpdate = findById(id);

        if (bookToUpdate == null) {
            return null;
        }

        bookToUpdate.update(book);
        return bookToUpdate;
    }

    @Override
    public Book delete(long id) {

        if (books.containsKey(id)) {
            return books.remove(id);
        }

        return null;
    }

    private long getNextId() {

        if (books.isEmpty()) {
            return 1L;
        }

        final List<Long> keys = new ArrayList<>(books.keySet());
        keys.sort(Comparator.reverseOrder());
        return keys.get(0) + 1L;
    }
}
