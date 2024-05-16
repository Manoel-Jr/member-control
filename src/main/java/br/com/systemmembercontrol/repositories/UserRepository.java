package br.com.systemmembercontrol.repositories;

import br.com.systemmembercontrol.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    public boolean existsByEmail(String email);
}
