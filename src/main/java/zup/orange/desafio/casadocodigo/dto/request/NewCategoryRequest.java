package zup.orange.desafio.casadocodigo.dto.request;

import zup.orange.desafio.casadocodigo.validators.annotations.UniqueValue;
import zup.orange.desafio.casadocodigo.entity.Category;

import javax.validation.constraints.NotBlank;

public class NewCategoryRequest {

    @NotBlank
    @UniqueValue(fieldName = "name",domainClass = Category.class,message = "O Campo Nome é obrigatório...")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category toModel() {
        return new Category(this.name);
    }
}
