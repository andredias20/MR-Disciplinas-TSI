package br.edu.utfpr.endemiasapi.infrastructure.repositories;

import br.edu.utfpr.endemiasapi.domain.entity.security.AppUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface UserRepository extends MongoRepository<AppUser, String> {
    @Query("{username:'?0'}")
    Optional<AppUser> findUserByUsername(String username);
}
