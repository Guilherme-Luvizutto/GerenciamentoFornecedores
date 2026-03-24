package com.gp.GerenciamentoFornecedores.Services;

import com.gp.GerenciamentoFornecedores.Models.FornecedorModel;
import com.gp.GerenciamentoFornecedores.Repositories.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public FornecedorModel salvarFornecedor(FornecedorModel fornecedorModel) {
        return fornecedorRepository.save(fornecedorModel);
    }

    public List<FornecedorModel> findAll() {
        return fornecedorRepository.findAll();
    }

    public FornecedorModel findById(Long id) {
        return fornecedorRepository.findById(id).get();
    }

    public void deletarFornecedor(FornecedorModel fornecedorModel) {
        fornecedorRepository.delete(fornecedorModel);
    }
}
