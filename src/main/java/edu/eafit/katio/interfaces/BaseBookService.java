package edu.eafit.katio.interfaces;

import edu.eafit.katio.dtos.BooksByAuthor;
import edu.eafit.katio.models.Books;

public interface BaseBookService {
    Iterable<Books> getAllBooks();
    Iterable<Books> getBooksByName(String Name);
    Iterable<Books> getBooksByEdition(String Name);
    Iterable<Books> getBooksByGenre(String Genre);
    Iterable<Books> getBooksById(Integer Id);

    Books addBooks(Books books);

    Books updateBookByName(String Name, Books updateBooks);

    Iterable<BooksByAuthor> getAllBooksByAuthorId(Integer idAuthor);
    Iterable<BooksByAuthor> getAllBooksByAuthorName(String nameAuthor);
    Iterable<BooksByAuthor> getAllBooksByAuthor(String nameAuthor, String lastNameAuthor);
}
