package edu.eafit.katio.controllers;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.eafit.katio.dtos.BooksByAuthor;
import edu.eafit.katio.models.Books;
import edu.eafit.katio.repositories.BookRepository;
import edu.eafit.katio.repositories.BooksByAuthorRepository;
import edu.eafit.katio.services.BookService;


@RestController
@RequestMapping("/katio/books")
@CrossOrigin(origins = "*")
public class BookController {
    
    @Autowired
    private BookRepository _bookRepository;

    @Autowired
    private BooksByAuthorRepository _BooksByAuthorRepository;


    //Metodos de model Book
    // Traer Todos los Libros
    @GetMapping("/getall")
    public ResponseEntity<Iterable<Books>> getAllBooks() {
        var books = new BookService(_bookRepository) .getAllBooks();
        return new ResponseEntity<Iterable<Books>>(books, HttpStatus.OK);
    }

    // Traer Libros por Id del Libro
    @GetMapping("/getById")
    public ResponseEntity<Iterable<Books>> getBooksById(@RequestParam ("Id") Integer Id)
    {
        var response = new BookService(_bookRepository).getBooksById(Id);
        return new ResponseEntity<Iterable<Books>>(response, HttpStatus.OK);
    }

    // Traer Libros por Nombre del Libro
    @GetMapping("/getByName")
    public ResponseEntity<Iterable<Books>> getBookByName(@RequestParam ("Name") String Name)
    {
        var response = new BookService(_bookRepository).getBooksByName(Name);
        return new ResponseEntity<Iterable<Books>>(response, HttpStatus.OK);
    }

    // Traer Libros por Editorial
    @GetMapping("/getByEdition")
    public ResponseEntity<Iterable<Books>> getBooksByEdition(@RequestParam ("Edition") String Edition)
    {
        var response = new BookService(_bookRepository).getBooksByEdition(Edition);
        return new ResponseEntity<Iterable<Books>>(response, HttpStatus.OK);
    }

    // Traer Libros por Genero
    @GetMapping("/getByGenre")
    public ResponseEntity<Iterable<Books>> getBooksByGenre(@RequestParam ("Genre") String Genre)
    {
        var response = new BookService(_bookRepository).getBooksByGenre(Genre);
        return new ResponseEntity<Iterable<Books>> (response, HttpStatus.OK);
    }


    // Crear un Libro
    @PostMapping("/add")
    public ResponseEntity<Books> addBooks(@RequestBody Books books) 
    {
        var response = new BookService(_bookRepository).addBooks(books);
        return response.getId() == 0 ? new ResponseEntity<Books>(response, HttpStatus.BAD_REQUEST)
                : new ResponseEntity<Books>(response, HttpStatus.OK);
    }


    // Metodos del Dto BooksByAuthor
    // Traer libros por Id del Autor
    @GetMapping("/getByAuthorId/{Id}")
    public ResponseEntity<Iterable<BooksByAuthor>> getAllBooksByAuthorId(@PathVariable("Id") Integer idAuthor)
    {
        var response = new BookService(_BooksByAuthorRepository).getAllBooksByAuthorId(idAuthor);
        return new ResponseEntity<Iterable<BooksByAuthor>>(response, HttpStatus.OK);
    }

    // Traer libros por Nombre del Autor
    @GetMapping("/getByAuthorName/{Name}")
    public ResponseEntity<Iterable<BooksByAuthor>> getAllBooksByAuthorName(@PathVariable("Name") String nameAuthor) 
    {
        var response = new BookService(_BooksByAuthorRepository).getAllBooksByAuthorName(nameAuthor);
        return new ResponseEntity<Iterable<BooksByAuthor>>(response, HttpStatus.OK);
    }

    // Traer Libros por Nombre y Apellido del Autor
    @GetMapping("/getByAuthor/{Name}/{LastName}")
    public ResponseEntity<Iterable<BooksByAuthor>> getAllBooksByAuthor(@PathVariable("Name") String nameAuthor, @PathVariable("LastName") String lastNameAuthor)
    {
        var response = new BookService(_BooksByAuthorRepository).getAllBooksByAuthor(nameAuthor, lastNameAuthor);
        return new ResponseEntity<Iterable<BooksByAuthor>>(response, HttpStatus.OK);
    }
}
