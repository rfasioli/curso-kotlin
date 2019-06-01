package com.rfasioli.pontointeligente.services.impl

import com.rfasioli.pontointeligente.documents.Empresa
import com.rfasioli.pontointeligente.repositories.EmpresaRepository
import com.rfasioli.pontointeligente.services.EmpresaService
import org.springframework.stereotype.Service

@Service
class EmpresaServiceImpl(val empresaRepository: EmpresaRepository) : EmpresaService {

    override fun buscarPorCnpj(cnpj: String): Empresa? = empresaRepository.findByCnpj(cnpj)

    override fun persistir(empresa: Empresa): Empresa = empresaRepository.save(empresa)

}