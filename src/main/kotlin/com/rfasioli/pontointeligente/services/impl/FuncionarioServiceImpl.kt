package com.rfasioli.pontointeligente.services.impl

import com.rfasioli.pontointeligente.documents.Funcionario
import com.rfasioli.pontointeligente.repositories.FuncionarioRepository
import com.rfasioli.pontointeligente.services.FuncionarioService
import org.springframework.stereotype.Service
import java.util.*

@Service
class FuncionarioServiceImpl(val funcionarioRepository: FuncionarioRepository) : FuncionarioService {

    override fun persistir(funcionario: Funcionario): Funcionario =
            funcionarioRepository.save(funcionario)

    override fun buscarPorCpf(cpf: String): Funcionario? =
            funcionarioRepository.findByCpf(cpf)

    override fun buscarPorEmail(email: String): Funcionario? =
            funcionarioRepository.findByEmail(email)

    override fun buscarPorId(id: String): Funcionario? {
        val funcionario: Optional<Funcionario> = funcionarioRepository.findById(id)
        return funcionario.orElseGet(null)
    }

}