package com.rfasioli.pontointeligente.services

import com.rfasioli.pontointeligente.documents.Empresa

/**
 *
 */
interface EmpresaService {

    fun buscarPorCnpj(cnpj: String): Empresa?

    fun persistir(empresa: Empresa): Empresa

}