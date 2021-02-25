package zup.orange.desafio.casadocodigo.dto.response;

import zup.orange.desafio.casadocodigo.entity.Book;

public class BookResponseDto {

    private Long id;
    private String title;

    public BookResponseDto(Book book){
        this.id = book.getId();
        this.title = book.getTitle();
    }

    @Deprecated
    public BookResponseDto() {
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "BookOutDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
