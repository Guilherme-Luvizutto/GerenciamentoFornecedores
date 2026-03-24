package com.gp.GerenciamentoFornecedores.Controllers;

import com.gp.GerenciamentoFornecedores.Models.FornecedorModel;
import com.gp.GerenciamentoFornecedores.Repositories.FornecedorRepository;
import com.gp.GerenciamentoFornecedores.Services.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @PostMapping
    public ResponseEntity<FornecedorModel> salvarFornecedor(@RequestBody FornecedorModel fornecedorModel) {
        FornecedorModel request = fornecedorService.salvarFornecedor(fornecedorModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(fornecedorModel.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<FornecedorModel>> listarFornecedores() {
        List<FornecedorModel> request = fornecedorService.findAll();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FornecedorModel> buscarFornecedor(@PathVariable Long id) {
        FornecedorModel request = fornecedorService.findById(id);
        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarFornecedor(@PathVariable Long id) {
        fornecedorService.deletarFornecedor(id);
        return ResponseEntity.noContent().build();
    }
}
