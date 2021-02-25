package zup.orange.desafio.casadocodigo.dto.request;

import org.springframework.util.Assert;
import zup.orange.desafio.casadocodigo.entity.Country;
import zup.orange.desafio.casadocodigo.entity.StateOfCountry;
import zup.orange.desafio.casadocodigo.validators.annotations.ExistsId;
import zup.orange.desafio.casadocodigo.validators.annotations.UniqueValue;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class StateOfCountryRequestDto {

    @NotBlank
    @UniqueValue(fieldName = "name",domainClass = StateOfCountry.class)
    private String name;
    @NotNull
    @ExistsId(fieldName = "id",domainClass = Country.class)
    private Long countryId;

    @Deprecated
    public StateOfCountryRequestDto() {
    }

    public StateOfCountryRequestDto(String name, Long countryId) {
        this.name = name;
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public Long getCountryId() {
        return countryId;
    }

    public StateOfCountry toModel(EntityManager manager){

        @NotNull Country country = manager.find(Country.class,this.countryId);

        Assert.state(country!=null, "O País informado não existe. id:"+this.countryId);

        return new StateOfCountry(this.name,country);
    }
}
