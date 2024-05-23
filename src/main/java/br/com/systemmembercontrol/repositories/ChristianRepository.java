package br.com.systemmembercontrol.repositories;

import br.com.systemmembercontrol.model.Christian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChristianRepository extends JpaRepository<Christian,Long> {

    public boolean existsByEmail(String email);

    public Christian findByEmail(String email);
}
