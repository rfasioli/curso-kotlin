package com.rfasioli.pontointeligente.controllers

import com.rfasioli.pontointeligente.enums.TipoEnum
import com.rfasioli.pontointeligente.services.FuncionarioService
import com.rfasioli.pontointeligente.services.LancamentoService
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import java.lang.Exception
import java.util.*

@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureMockMvc
class LancamentoControllerTest {

    @Autowired
    private val mvc: MockMvc? = null

    @MockBean
    private val lancamentoService: LancamentoService? = null

    @MockBean
    private val funcionarioService: FuncionarioService? = null

    private val urlBase: String = "/api/lancamentos/"
    private val idFuncionario: String = "1"
    private val idLancamento: String = "1"
    private val tipo: String = TipoEnum.INICIO_TRABALHO.name
    private val data: Date = Date()

    @Test
    @Throws(Exception::class)
    fun testCadastrarLancamento() {

    }

}