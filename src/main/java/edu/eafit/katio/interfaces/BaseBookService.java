package edu.eafit.katio.interfaces;

import edu.eafit.katio.dtos.BooksByAuthor;
import edu.eafit.katio.models.Books;

public interface BaseBookService {
    Iterable<Books> getAllBooks();
    Iterable<Books> getAllBooksByAuthor(int IdAuthor);
    Iterable<BooksByAuthor> getAllBooksByAuthor(String Name, String LastName);
    Iterable<Books> getBooksByName(String Name);
}
