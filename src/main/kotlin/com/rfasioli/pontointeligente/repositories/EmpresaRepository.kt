package com.rfasioli.pontointeligente.repositories

import com.rfasioli.pontointeligente.documents.Empresa
import org.springframework.data.mongodb.repository.MongoRepository

/**
 *
 */
interface EmpresaRepository : MongoRepository<Empresa, String> {

    fun findByCnpj(cpnj: String): Empresa

}