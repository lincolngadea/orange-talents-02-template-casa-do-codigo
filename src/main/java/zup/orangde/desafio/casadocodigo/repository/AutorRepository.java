package zup.orangde.desafio.casadocodigo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import zup.orangde.desafio.casadocodigo.entities.Autor;

import java.util.Optional;

@Repository
public interface AutorRepository extends CrudRepository<Autor, Long> {
    Optional<Autor> findByEmail(Object email);
}
