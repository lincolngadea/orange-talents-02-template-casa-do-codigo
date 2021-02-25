package zup.orange.desafio.casadocodigo.dto.request;

import org.springframework.util.Assert;
import zup.orange.desafio.casadocodigo.entity.City;
import zup.orange.desafio.casadocodigo.entity.StateOfCountry;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;

public class NewCityRequest {
    private String name;

    private Long stateId;

    @Deprecated
    public NewCityRequest() {
    }

    public NewCityRequest(String name, Long cityId) {
        this.name = name;
        this.stateId = cityId;
    }

    public String getName() {
        return name;
    }

    public Long getCityId() {
        return stateId;
    }

    public City toModel(EntityManager manager){
        @NotNull StateOfCountry state = manager.find(StateOfCountry.class, this.stateId);
        Assert.state(state!=null, "O País informado não existe. id:"+this.stateId);
        return new City(this.name,state);
    }
}
