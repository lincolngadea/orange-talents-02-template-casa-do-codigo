package zup.orange.desafio.casadocodigo.dto.request;

import zup.orange.desafio.casadocodigo.entity.City;
import zup.orange.desafio.casadocodigo.entity.Client;
import zup.orange.desafio.casadocodigo.entity.Country;
import zup.orange.desafio.casadocodigo.entity.StateOfCountry;
import zup.orange.desafio.casadocodigo.validators.annotations.CPFOrCNPJ;
import zup.orange.desafio.casadocodigo.validators.annotations.UniqueValue;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NewClientRequest {
    @NotBlank
    @UniqueValue(fieldName = "email", domainClass = Client.class)
    private String email;
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    @CPFOrCNPJ
    private String document;
    @NotBlank
    private String address;
    @NotBlank
    private String complement;
    @NotBlank
    private String phone;
    @NotBlank
    private String cep;

    @NotNull
    private Long cityId;
    @NotNull
    private Long countryId;
    private Long stateId;


    public NewClientRequest(
            @NotBlank String email,
            @NotBlank String name,
            @NotBlank String surname,
            @NotBlank String document,
            @NotBlank String address,
            @NotBlank String complement,
            @NotBlank String phone,
            @NotBlank String cep,
            @NotNull Long cityId,
            @NotNull Long countryId, Long stateId) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.document = document;
        this.address = address;
        this.complement = complement;
        this.phone = phone;
        this.cep = cep;
        this.cityId = cityId;
        this.countryId = countryId;
        this.stateId = stateId;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDocument() {
        return document;
    }

    public String getAddress() {
        return address;
    }

    public String getComplement() {
        return complement;
    }

    public String getPhone() {
        return phone;
    }

    public String getCep() {
        return cep;
    }

    public Long getCityId() {
        return cityId;
    }

    public Long getCountryId() {
        return countryId;
    }

    public Long getStateId() {
        return stateId;
    }

    public Client toModel(EntityManager manager) {

            @NotNull Country country = manager.find(Country.class,this.countryId);

            StateOfCountry state = null;
            if(this.stateId != null){
                state = manager.find(StateOfCountry.class,this.stateId);
            }
            @NotNull City city = manager.find(City.class,this.cityId);


            return new Client(this.email,this.name,this.surname,this.document,this.address,this.complement,this.phone,this.cep,city, country,state);

    }



}
