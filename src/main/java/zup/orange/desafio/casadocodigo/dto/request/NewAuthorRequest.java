package zup.orange.desafio.casadocodigo.dto.request;

import zup.orange.desafio.casadocodigo.validators.annotations.UniqueValue;
import zup.orange.desafio.casadocodigo.entity.Author;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NewAuthorRequest {

    private final @NotBlank @Size(max = 100) String name;
    private final @Email @NotBlank @UniqueValue(domainClass = Author.class, fieldName = "email") String email;
    private final @Size(max = 400) @NotBlank String description;

    public NewAuthorRequest(@NotBlank @Size(max = 100) String name,
                            @Email @NotBlank String email,
                            @Size(max = 400) @NotBlank String description){
        this.name = name;
        this.email = email;
        this.description = description;

    }

    public Author toModel(){return new Author(this.name,this.email,this.description);}

}
