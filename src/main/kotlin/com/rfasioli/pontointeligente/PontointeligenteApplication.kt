package com.rfasioli.pontointeligente

import com.rfasioli.pontointeligente.documents.Empresa
import com.rfasioli.pontointeligente.documents.Funcionario
import com.rfasioli.pontointeligente.enums.PerfilEnum
import com.rfasioli.pontointeligente.repositories.EmpresaRepository
import com.rfasioli.pontointeligente.repositories.FuncionarioRepository
import com.rfasioli.pontointeligente.repositories.LancamentoRepository
import com.rfasioli.pontointeligente.utils.SenhaUtils
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class PontointeligenteApplication(val empresaRepository: EmpresaRepository,
								  val funcionarioRepository: FuncionarioRepository,
								  val lancamentoRepository: LancamentoRepository) : CommandLineRunner {

	override fun run(vararg args: String?) {
		lancamentoRepository.deleteAll()
		funcionarioRepository.deleteAll()
		empresaRepository.deleteAll()

		var empresa: Empresa = Empresa("Empresa", "10443887000146")
		empresa = empresaRepository.save(empresa)

		var admin: Funcionario = Funcionario( "Admin", "admin@empresa.com",
				SenhaUtils().gerarBCrypt("123456"), "35343419100",
				PerfilEnum.ROLE_ADMIN, empresa.id!!)
		admin = funcionarioRepository.save(admin)

		var funcionario: Funcionario = Funcionario( "Funcionario",
				"funcionario@empresa.com", SenhaUtils().gerarBCrypt("123456"),
				"78719186800", PerfilEnum.ROLE_USUARIO, empresa.id!!)
		funcionario = funcionarioRepository.save(funcionario)

		println("Empresa ID: " + empresa.id)
		println("Admin ID: " + admin.id)
		println("Funcionario ID: " + funcionario.id)

	}
}

fun main(args: Array<String>) {
	SpringApplication.run(PontointeligenteApplication::class.java, *args)
}
