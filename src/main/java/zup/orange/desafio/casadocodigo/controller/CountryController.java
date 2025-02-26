package zup.orange.desafio.casadocodigo.controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import zup.orange.desafio.casadocodigo.dto.request.NewCountryRequest;
import zup.orange.desafio.casadocodigo.entity.Country;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
public class CountryController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping("/country")
    @Transactional
    public String save(@RequestBody @Valid NewCountryRequest countryRequest){

        Country country = countryRequest.toModel();
        manager.persist(country);
        return country.toString();

    }

}
