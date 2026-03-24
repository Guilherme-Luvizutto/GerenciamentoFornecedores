package com.gp.GerenciamentoFornecedores.Repositories;

import com.gp.GerenciamentoFornecedores.Models.FornecedorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<FornecedorModel, Long> {
}
