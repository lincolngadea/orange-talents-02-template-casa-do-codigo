package zup.orange.desafio.casadocodigo.controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import zup.orange.desafio.casadocodigo.dto.request.StateOfCountryRequestDto;
import zup.orange.desafio.casadocodigo.entity.StateOfCountry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
public class StateController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping("/state")
    @Transactional
    public String save(@RequestBody @Valid StateOfCountryRequestDto stateRequest){

        StateOfCountry stateOfCountry = stateRequest.toModel(manager);
        manager.persist(stateOfCountry);
        return stateOfCountry.toString();
    }
}
