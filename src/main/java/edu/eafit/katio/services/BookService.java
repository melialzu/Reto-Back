package edu.eafit.katio.services;

import java.util.ArrayList;

import edu.eafit.katio.dtos.BooksByAuthor;
import edu.eafit.katio.interfaces.BaseBookService;
import edu.eafit.katio.models.Books;
import edu.eafit.katio.repositories.BookRepository;
import edu.eafit.katio.repositories.BooksByAuthorRepository;

public class BookService implements BaseBookService {
    
    private BookRepository _bookRepository;
    private BooksByAuthorRepository _BooksByAuthorRepository;

    public BookService(BookRepository bookRepository){
        _bookRepository = bookRepository;
    }

    public BookService(BooksByAuthorRepository booksByAuthorRepository){
    _BooksByAuthorRepository = booksByAuthorRepository;
    }

    // Traer todos los Libros
    @Override
    public Iterable<Books> getAllBooks() {
        var bookList = _bookRepository.findAll();
        return bookList;
    }

    // Traer Libros por Id
    @Override
    public Iterable<Books> getBooksById(Integer Id) {
        var bookList = _bookRepository.findById(Id);
        return bookList;
    }

    // Traer Libros por Nombre
    @Override
    public Iterable<Books> getBooksByName(String Name) {
        var bookList = _bookRepository.findByName(Name);
        return bookList;
    }

    //Traer Libros por Editorial
    @Override
    public Iterable<Books> getBooksByEdition(String Edition) {
        var bookList = _bookRepository.findByEdition(Edition);
        return bookList;
    }

    //Traer Libros por Genero
    @Override
    public Iterable<Books> getBooksByGenre(String Genre) {
        var bookList = _bookRepository.findByGenre(Genre);
        return bookList;
    }

    
    // Crear Libro
    @Override
    public Books addBooks(Books books) {
        var response = new Books();
        response = _bookRepository.saveAndFlush(books);
        return response;
    }



    @Override
    public Iterable<BooksByAuthor> getAllBooksByAuthorId(Integer idAuthor) {
       Iterable<BooksByAuthor> bookList = new ArrayList<BooksByAuthor>();
       bookList = _BooksByAuthorRepository.findByAuthorId(idAuthor);
       return bookList;
    }

    @Override 
    public Iterable<BooksByAuthor> getAllBooksByAuthorName(String nameAuthor) {
        Iterable<BooksByAuthor> bookList = new ArrayList<BooksByAuthor>();
        bookList = _BooksByAuthorRepository.findByAuthorName(nameAuthor);
        return bookList;
    }

    @Override
    public Iterable<BooksByAuthor> getAllBooksByAuthor(String nameAuthor, String lastNameAuthor) {
        Iterable<BooksByAuthor> bookList = new ArrayList<BooksByAuthor>();

        if (lastNameAuthor.length() > 0 && nameAuthor.length() <= 0) 
        {
            bookList = _BooksByAuthorRepository.findByAuthorLastName(lastNameAuthor);
        }
        else if (lastNameAuthor.length() <= 0 && nameAuthor.length() > 0) 
        {
            bookList = _BooksByAuthorRepository.findByAuthorName(nameAuthor);
        }
        else 
        {
            bookList = _BooksByAuthorRepository.findByAuthorFullName(lastNameAuthor, nameAuthor);
        }
        return bookList;
    } 
}
