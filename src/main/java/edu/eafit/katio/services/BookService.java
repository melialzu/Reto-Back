package edu.eafit.katio.services;

import java.util.ArrayList;

import edu.eafit.katio.dto.BooksByAuthor;
import edu.eafit.katio.interfaces.BaseBookService;
import edu.eafit.katio.models.Books;
import edu.eafit.katio.repository.BookRepository;
import edu.eafit.katio.repository.BooksByAuthorRepository;

public class BookService implements BaseBookService {
    
    private BookRepository _bookRepository;
    private BooksByAuthorRepository _BooksByAuthorRepository;

    public BookService(BookRepository bookRepository){
        _bookRepository = bookRepository;
    }

    public BookService(BooksByAuthorRepository booksByAuthorRepository){
    _BooksByAuthorRepository = booksByAuthorRepository;
    }

    @Override
    public Iterable<Books> getAllBooks() {
        var bookList = _bookRepository.findAll();
        return bookList;
    }

    @Override
    public Iterable<Books> getAllBooksByAuthor(int idAuthor) {
       var booklist = _bookRepository.findByAuthorId(idAuthor);
       return booklist;
    }

    @Override
    public Iterable<BooksByAuthor> getAllBooksByAuthor(String Name, String LastName) {
        Iterable<BooksByAuthor> bookList = new ArrayList<BooksByAuthor>();

        if (LastName.length() > 0 && Name.length() <= 0) 
        {
            bookList = _BooksByAuthorRepository.findByAuthorLastName(LastName);
        }
        else if (LastName.length() <= 0 && Name.length() > 0) 
        {
            bookList = _BooksByAuthorRepository.findByAuthorName(Name);
        }
        else 
        {
            bookList = _BooksByAuthorRepository.findByAuthorFullName(LastName, Name);
        }
        return bookList;
    } 

    @Override
    public Iterable<Books> getBooksByName(String Name) {
        var bookList = _bookRepository.findByName(Name);
        return bookList;
    }

}
