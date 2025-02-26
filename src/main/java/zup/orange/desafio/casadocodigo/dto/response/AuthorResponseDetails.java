package zup.orange.desafio.casadocodigo.dto.response;

import zup.orange.desafio.casadocodigo.entity.Author;

public class AuthorResponseDetails {

    private final String name;
    private final String description;

    public AuthorResponseDetails(Author author) {
        this.name = author.getName();
        this.description = author.getDescription();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "AuthorResponseDetails{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
