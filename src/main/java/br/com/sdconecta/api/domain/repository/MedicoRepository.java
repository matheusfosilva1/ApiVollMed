package br.com.sdconecta.api.domain.repository;

import br.com.sdconecta.api.domain.model.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

    Page<Medico> findAllByAtivoTrue(Pageable pageable);

    @Query("select m from Medico m where id= :id and ativo=true")
    Medico getReferenceByIdAndAtivoTrue(@Param("id") Long id);
}
