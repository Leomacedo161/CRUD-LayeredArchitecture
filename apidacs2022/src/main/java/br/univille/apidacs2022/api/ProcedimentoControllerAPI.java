package br.univille.apidacs2022.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.apidacs2022.service.ProcedimentoService;
import br.univille.coredacs2022.entity.Procedimento;

@RestController
@RequestMapping("/api/v1/procedimentos")
public class ProcedimentoControllerAPI {
    @Autowired
    private ProcedimentoService service;

    @GetMapping
    public ResponseEntity<List<Procedimento>> getAll() {
        var listaProcedimentos = service.getAll();

        return new ResponseEntity<List<Procedimento>>(listaProcedimentos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Procedimento> insertConsulta(@RequestBody Procedimento procedimento) {
        if (procedimento.getId() == 0) {
            service.save(procedimento);
            return new ResponseEntity<Procedimento>(procedimento, HttpStatus.CREATED);
        }

        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Procedimento> update(@PathVariable long id, @RequestBody Procedimento procedimento) {
        var procedimentoAntigo = service.findById(id);
        if (procedimentoAntigo == null) {
            return ResponseEntity.notFound().build();
        }

        procedimentoAntigo.setDescricao(procedimento.getDescricao());
    

        service.save(procedimentoAntigo);

        return new ResponseEntity<Procedimento>(procedimentoAntigo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Procedimento> delete(@PathVariable("id") long id) {
        var procedimentoAntigo = service.findById(id);
        if (procedimentoAntigo == null) {
            return ResponseEntity.notFound().build();
        }
        service.delete(procedimentoAntigo.getId());

        return new ResponseEntity<Procedimento>(procedimentoAntigo, HttpStatus.OK);
    }
}
