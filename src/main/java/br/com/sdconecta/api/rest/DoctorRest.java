package br.com.sdconecta.api.rest;

import br.com.sdconecta.api.dto.DoctorDTO;
import br.com.sdconecta.api.model.Medico;
import br.com.sdconecta.api.repository.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorRest {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping("save")
    @Transactional
    public void register(@RequestBody @Valid DoctorDTO doc){
        medicoRepository.save(new Medico(doc));
    }

    @GetMapping("list")
    public List<Medico> getDoctor(){
        return medicoRepository.findAll(Sort.by("crm"));
    }


}
