package zup.orange.desafio.casadocodigo.controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import zup.orange.desafio.casadocodigo.dto.request.NewCityRequest;
import zup.orange.desafio.casadocodigo.entity.City;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
public class CityController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping("/city")
    @Transactional
    public String save(@RequestBody @Valid NewCityRequest cityRequest){
        City city = cityRequest.toModel(manager);
        manager.persist(city);
        return city.toString();
    }
}
