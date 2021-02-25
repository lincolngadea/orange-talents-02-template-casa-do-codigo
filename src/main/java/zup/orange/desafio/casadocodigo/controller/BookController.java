package zup.orange.desafio.casadocodigo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import zup.orange.desafio.casadocodigo.dto.request.NewBookRequest;
import zup.orange.desafio.casadocodigo.dto.response.BookResponseDto;
import zup.orange.desafio.casadocodigo.dto.response.BookResponseDetails;
import zup.orange.desafio.casadocodigo.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BookController {

    @PersistenceContext
    private EntityManager manager;


    @Transactional
    @PostMapping("/books")
    public String save(@RequestBody @Valid NewBookRequest request){

        Book book = request.toModel(manager);
        manager.persist(book);
        return book.toString();
    }

    @GetMapping("/books")
    @Transactional(readOnly = true)
    public List<BookResponseDto> bookList(){
        return manager.createQuery("from Book", Book.class)
                .getResultStream()
                .map(BookResponseDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/books/{id}")
    @Transactional
    public ResponseEntity<?> bookList(@PathVariable Long id){

        Book book = manager.find(Book.class,id);
        if(book == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        BookResponseDetails bookResponseDetails = new BookResponseDetails(book);
        return ResponseEntity.ok(bookResponseDetails);
    }
}
