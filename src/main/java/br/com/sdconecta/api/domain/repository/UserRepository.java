package br.com.sdconecta.api.domain.repository;

import br.com.sdconecta.api.domain.model.User;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    UserDetails findByLogin(String login);
}
