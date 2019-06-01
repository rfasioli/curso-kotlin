package com.rfasioli.pontointeligente.services

import com.rfasioli.pontointeligente.documents.Funcionario
import com.rfasioli.pontointeligente.enums.PerfilEnum
import com.rfasioli.pontointeligente.repositories.FuncionarioRepository
import com.rfasioli.pontointeligente.utils.SenhaUtils
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner
import java.util.*

@RunWith(SpringRunner::class)
@SpringBootTest
class FuncionarioServiceTest {

    @MockBean
    private val funcionarioRepository: FuncionarioRepository? = null

    @Autowired
    private val funcionarioService: FuncionarioService? = null

    private val email: String = "email@email.com"
    private val cpf: String = "35378751500"
    private val id: String = "1"

    @Before
    @Throws(Exception::class)
    fun setUp() {
        BDDMockito.given(funcionarioRepository?.save(Mockito.any(Funcionario::class.java)))
                .willReturn(funcionario())
        BDDMockito.given(funcionarioRepository?.findById(id)).willReturn(Optional.of(funcionario()))
        BDDMockito.given(funcionarioRepository?.findByCpf(cpf)).willReturn(funcionario())
        BDDMockito.given(funcionarioRepository?.findByEmail(email)).willReturn(funcionario())
    }

    @Test
    fun testPersistirFuncionario() {
        val funcionario: Funcionario? = this.funcionarioService?.persistir(funcionario())
        Assert.assertNotNull(funcionario)
    }

    @Test
    fun testBuscarPorCpf() {
        val funcionario: Funcionario? = this.funcionarioService?.buscarPorCpf(cpf)
        Assert.assertNotNull(funcionario)
    }

    @Test
    fun testBuscarPorEmail() {
        val funcionario: Funcionario? = this.funcionarioService?.buscarPorEmail(email)
        Assert.assertNotNull(funcionario)
    }
    @Test
    fun testBuscarPorId() {
        val funcionario: Funcionario? = this.funcionarioService?.buscarPorId(id)
        Assert.assertNotNull(funcionario)
    }

    private fun funcionario(): Funcionario =
            Funcionario( "Nome", email, SenhaUtils().gerarBCrypt("123456"),
                    cpf, PerfilEnum.ROLE_USUARIO, id)

}
