package br.com.sdconecta.api.rest;

import br.com.sdconecta.api.dto.ListMedicoDTO;
import br.com.sdconecta.api.dto.SaveMedicoDTO;
import br.com.sdconecta.api.dto.UpdateMedicoDTO;
import br.com.sdconecta.api.model.Medico;
import br.com.sdconecta.api.repository.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorRest {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid SaveMedicoDTO doc) {
        medicoRepository.save(new Medico(doc));
    }

    @GetMapping
    public Page<ListMedicoDTO> list(@PageableDefault(size = 8, sort = {"nome"}) Pageable pageable) {
        return medicoRepository.findAllByAtivoTrue(pageable).map(ListMedicoDTO::new);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid UpdateMedicoDTO doc) {
        var medico = medicoRepository.getReferenceById(doc.id());
        medico.updateInfo(doc);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        var medico = medicoRepository.getReferenceById(id);
        medico.delete();
    }


}
