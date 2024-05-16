package br.com.systemmembercontrol.repositories;

import br.com.systemmembercontrol.model.Congregated;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CongregatedRepository extends JpaRepository<Congregated,Long> {

    public boolean existsByEmail(String email);

    public Congregated findByEmail(String email);
}
