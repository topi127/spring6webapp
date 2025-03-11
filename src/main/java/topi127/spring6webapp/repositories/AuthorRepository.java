package topi127.spring6webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import topi127.spring6webapp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
