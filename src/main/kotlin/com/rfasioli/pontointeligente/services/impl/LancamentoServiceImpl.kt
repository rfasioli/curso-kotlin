package com.rfasioli.pontointeligente.services.impl

import com.rfasioli.pontointeligente.documents.Lancamento
import com.rfasioli.pontointeligente.repositories.LancamentoRepository
import com.rfasioli.pontointeligente.services.LancamentoService
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class LancamentoServiceImpl(val lancamentoRepository: LancamentoRepository) : LancamentoService {

    override fun buscarPorFuncionarioId(funcionarioId: String, pageRequest: PageRequest): Page<Lancamento> =
            lancamentoRepository.findByFuncionarioId(funcionarioId, pageRequest)

    override fun buscarPorId(id: String): Lancamento? =
            lancamentoRepository.findById(id).orElseGet(null)

    override fun persistir(lancamento: Lancamento): Lancamento =
            lancamentoRepository.save(lancamento)

    override fun remover(id: String) =
            lancamentoRepository.deleteById(id)

}