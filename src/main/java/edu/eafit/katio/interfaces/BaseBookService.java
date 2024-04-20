package edu.eafit.katio.interfaces;

import edu.eafit.katio.Dto.BooksByAuthor;
import edu.eafit.katio.models.Books;

public interface BaseBookService {
    Iterable<Books> getAllBooks();
    Iterable<Books> getAllBooksByAuthor(int IdAuthor);
    Iterable<BooksByAuthor> getAllBooksByAuthor(String Name, String LastName);
    Iterable<Books> getBooksByName(String Name);
}
