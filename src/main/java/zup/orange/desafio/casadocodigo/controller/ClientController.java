package zup.orange.desafio.casadocodigo.controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import zup.orange.desafio.casadocodigo.dto.request.NewClientRequest;
import zup.orange.desafio.casadocodigo.entity.Client;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
public class ClientController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping("/client")
    @Transactional
    public String save(@RequestBody @Valid NewClientRequest clientRequest){
        Client client = clientRequest.toModel(manager);
        manager.persist(client);
        return client.toString();
    }
}
