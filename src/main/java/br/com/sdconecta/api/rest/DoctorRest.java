package br.com.sdconecta.api.rest;

import br.com.sdconecta.api.domain.dto.ListMedicoDTO;
import br.com.sdconecta.api.domain.dto.MedicoDTO;
import br.com.sdconecta.api.domain.dto.SaveMedicoDTO;
import br.com.sdconecta.api.domain.dto.UpdateMedicoDTO;
import br.com.sdconecta.api.domain.model.Medico;
import br.com.sdconecta.api.domain.repository.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/doctor")
public class DoctorRest {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity register(@RequestBody @Valid SaveMedicoDTO doc, UriComponentsBuilder uriBuilder) {
        var medico = new Medico(doc);
        medicoRepository.save(medico);
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(uri).body(new MedicoDTO(medico));
    }

    @GetMapping
    public ResponseEntity<Page<ListMedicoDTO>> list(@PageableDefault(size = 8, sort = {"nome"}) Pageable pageable) {
        var page = medicoRepository.findAllByAtivoTrue(pageable).map(ListMedicoDTO::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid UpdateMedicoDTO doc) {
        var medico = medicoRepository.getReferenceById(doc.id());
        medico.updateInfo(doc);
        return ResponseEntity.ok(new MedicoDTO(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        var medico = medicoRepository.getReferenceById(id);
        medico.delete();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity getDetails(@PathVariable Long id){
        var medico = medicoRepository.getReferenceByIdAndAtivoTrue(id);
        return ResponseEntity.ok(new MedicoDTO(medico));
    }


}
