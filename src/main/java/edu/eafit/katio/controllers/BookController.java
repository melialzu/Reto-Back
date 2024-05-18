package edu.eafit.katio.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.eafit.katio.dtos.BooksByAuthor;
import edu.eafit.katio.models.Books;
import edu.eafit.katio.repositories.BookRepository;
import edu.eafit.katio.repositories.BooksByAuthorRepository;
import edu.eafit.katio.models.Authors;
import edu.eafit.katio.services.BookService;


@RestController
@RequestMapping("/katio/books")
@CrossOrigin(origins = "*")
public class BookController {
    
    @Autowired
    private BookRepository _bookRepository;

    @Autowired
    private BooksByAuthorRepository _BooksByAuthorRepository;

    @GetMapping("/getall")
    public ResponseEntity<Iterable<Books>> getAllBooks() {
        var books = new BookService(_bookRepository) .getAllBooks();
        return new ResponseEntity<Iterable<Books>>(books, HttpStatus.OK);
    }

    @GetMapping("/getByAuthor")
    public ResponseEntity<Iterable<Books>> getAllBooksByAuthor(@RequestParam Integer Id)
    {
        var response = new BookService(_bookRepository).getAllBooksByAuthor(Id);
        return new ResponseEntity<Iterable<Books>>(response, HttpStatus.OK);
    }
    
    // Traer libros por Id del Autor
    @GetMapping("/getByAuthorId")
    public ResponseEntity<Iterable<BooksByAuthor>> getAllBooksByAuthorsId(@RequestBody Integer Id)
    {
        var response = new ArrayList<BooksByAuthor>();
        response.add(new BooksByAuthor());
        return new ResponseEntity<Iterable<BooksByAuthor>>(response, HttpStatus.OK);
    }

    // Traer libros por Nombre del Autor
    @GetMapping("/getByAuthorNames")
    public ResponseEntity<Iterable<BooksByAuthor>> getAllBooksByAuthorsName(@RequestBody Authors author) 
    {
        var response = new ArrayList<BooksByAuthor>();
        response.add(new BooksByAuthor());
        return new ResponseEntity<Iterable<BooksByAuthor>>(response, HttpStatus.OK);
    }

    // Traer Libros por Nombre del Libro
    @GetMapping("/getBooksByName")
    public ResponseEntity<Iterable<Books>> getBookByName(@RequestBody Books book) 
    {
        var response = new BookService(_bookRepository).getBooksByName(book.getName());
        return new ResponseEntity<Iterable<Books>>(response, HttpStatus.OK);
    }

    // Traer libros por Nombre y Apellido del Autor
    @GetMapping("/getByAuthor/{Name}/{LastName}")
    public ResponseEntity<Iterable<BooksByAuthor>> getAllBooksByAuthor(@PathVariable("Name") String Name, @PathVariable("LastName") String LastName)
    {
        var response = new BookService(_BooksByAuthorRepository).getAllBooksByAuthor(Name, LastName);
        return new ResponseEntity<Iterable<BooksByAuthor>>(response, HttpStatus.OK);
    }


}
