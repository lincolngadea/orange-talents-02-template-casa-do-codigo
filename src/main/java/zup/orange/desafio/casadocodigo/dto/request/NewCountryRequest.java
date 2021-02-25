package zup.orange.desafio.casadocodigo.dto.request;

import zup.orange.desafio.casadocodigo.entity.Country;
import zup.orange.desafio.casadocodigo.validators.annotations.UniqueValue;

import javax.validation.constraints.NotBlank;

public class NewCountryRequest {
    @NotBlank
    @UniqueValue(fieldName = "name", domainClass = Country.class)
    private String name;

    public void setName(String name) {this.name = name;}

    public String getName() { return name;}

    public Country toModel() { return new Country(this.name); }
}
