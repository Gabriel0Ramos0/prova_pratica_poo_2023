package prova_pratica_poo_2023;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DepartamentoTransitoTest {
	
	List<Pessoa> pessoas1 = new ArrayList<>();
	List<Pessoa> pessoas2 = new ArrayList<>();
	List<Veículo> veiculosCaso1 = new ArrayList<>();
	Rodovia rodoviaTest;
	Acidente acidenteTest;

	
	@BeforeEach
	void executarPrimeiro() {
		
		rodoviaTest = new Rodovia("SC108", "Alta");
		
		pessoas1.add(new Pessoa("Joao", 30, "Masculino", true, false));
		pessoas1.add(new Pessoa("Maria", 25, "Feminino", false, false));
		
        pessoas2.add(new Pessoa("Pedro", 35, "Masculino", true, false));
        pessoas2.add(new Pessoa("Ana", 28, "Feminino", false, false));
        pessoas2.add(new Pessoa("Lucas", 22, "Masculino", false, false));
        
        veiculosCaso1.add(new Veículo(2010, "Carro", pessoas1));
        veiculosCaso1.add(new Veículo(2020, "Moto", pessoas2));
        
        acidenteTest = new Acidente(rodoviaTest, 1, 4, 10, veiculosCaso1);
	}
	
	//TESTANDO O CADASTRO DE RODOVIAS PELA CLASSE DEPARTAMENTOTRANSITO INSTANCIANDO A RODOVIA
	@Test
	void cadastroRodoviasNaoInstanciadas() {
		DepartamentoTransito dentran = new DepartamentoTransito();
		
		dentran.cadastrarRodovia("SC108", "Alto");
		assertEquals("SC108", dentran.rodovias.get(0).getSigla());
	}
	
	//TESTANDO O CADASTRO DE RODOVIAS PELA CLASSE DEPARTAMENTOTRANSITO RECEBENDO A RODOVIA JÁ INSTANCIADA
		@Test
		void cadastroRodoviasInstanciadas() {
			DepartamentoTransito dentran = new DepartamentoTransito();
			
			dentran.cadastrarRodovia(rodoviaTest);
			assertEquals("SC108", dentran.rodovias.get(0).getSigla());
		}
	
	//TESTANDO O CADASTRO DE ACIDENTES PELA CLASSE DEPARTAMENTOTRANSITO INSTANCIANDO O ACIDENTE
	@Test
	void cadastroAcidentesNaoInstanciadas() {
		DepartamentoTransito dentran = new DepartamentoTransito();
		
		dentran.cadastrarAcidente(rodoviaTest, 1, 4, 10, veiculosCaso1);
		assertEquals("SC108", dentran.acidentes.get(0).getRodovia().getSigla());
		assertEquals(1, dentran.acidentes.get(0).getVitimasFatais());
		assertEquals(4, dentran.acidentes.get(0).getFeridos());
		assertEquals(2, dentran.acidentes.get(0).getVeículosEnvolvidos().size());
	}
	
	//TESTANDO O CADASTRO DE ACIDENTES PELA CLASSE DEPARTAMENTOTRANSITO RECEBENDO O ACIDENTE JÁ INSTANCIADO
	@Test
	void cadastroAcidentesInstanciadas() {
			DepartamentoTransito dentran = new DepartamentoTransito();
			
			dentran.cadastrarAcidente(acidenteTest);
			assertEquals("SC108", dentran.acidentes.get(0).getRodovia().getSigla());
			assertEquals(1, dentran.acidentes.get(0).getVitimasFatais());
			assertEquals(4, dentran.acidentes.get(0).getFeridos());
			assertEquals(2, dentran.acidentes.get(0).getVeículosEnvolvidos().size());
		}

	//TESTANDO LISTAGEM DE ACIDENTES SEM CONDUTOR EMBRIAGADO -- NÃO COMPLETO -------------------------------
	@Test
	void listarAcidentesSemCondutorEmbriagado() {
		DepartamentoTransito dentran = new DepartamentoTransito();
		
		dentran.cadastrarAcidente(acidenteTest);
		dentran.listarAcidentes();	
	}
		
	//TESTANDO O CONSTRUTOR DE VEÍCULO PREENCHIDO
	@Test
	void construtorVeículoPreenchidoTest() {
		Veículo veiculoConstrutorPreenchido = new Veículo(2020, "Carro", pessoas1);
		assertEquals(2020, veiculoConstrutorPreenchido.getAno());
		assertEquals("Carro", veiculoConstrutorPreenchido.getTipo());
		assertEquals("Joao", veiculoConstrutorPreenchido.getPessoas().get(0).getNome());
		assertEquals("Maria", veiculoConstrutorPreenchido.getPessoas().get(1).getNome());
	}
	
	//TESTANDO O CONSTRUTOR DE VEÍCULO SEM VARIÁVEIS
	@Test
	void construtorVeículoVazioTest() {
		Veículo veiculoConstrutorVazio = new Veículo();
		assertEquals(0, veiculoConstrutorVazio.getAno());
		assertEquals("", veiculoConstrutorVazio.getTipo());
		assertEquals(null, veiculoConstrutorVazio.getPessoas());
	}

	

	
	//TESTANDO O CONSTRUTOR DE RODOVIA PREENCHIDO
	@Test
	void construtorRodoviaPreenchidoTest() {
		Rodovia rodoviaConstrutorPreenchido = new Rodovia("SC101", "Alta");
		assertEquals("SC101", rodoviaConstrutorPreenchido.getSigla());
		assertEquals("Alta", rodoviaConstrutorPreenchido.getGrau());
	}
	
	//TESTANDO O CONSTRUTOR DE RODOVIA VAZIO
	@Test
	void construtorRodoviaVazioTest() {
			Rodovia rodoviaConstrutorVazio = new Rodovia();
			assertEquals("", rodoviaConstrutorVazio.getSigla());
			assertEquals("", rodoviaConstrutorVazio.getGrau());
		}

	
	
	//TESTANDO O CONSTRUTOR DE PESSOA PREENCHIDO
	@Test
	void construtorPessoaPreenchidoTest() {
		Pessoa pessoaConstrutorPreenchido = new Pessoa("Wesley", 21, "Masculino", true, false);
		assertEquals("Wesley", pessoaConstrutorPreenchido.getNome());
		assertEquals(21, pessoaConstrutorPreenchido.getIdade());
		assertEquals("Masculino", pessoaConstrutorPreenchido.getSexo());
		assertEquals(true, pessoaConstrutorPreenchido.isCondutor());
		assertEquals(false, pessoaConstrutorPreenchido.isEmbriagado());
	}
	
	//TESTANDO O CONSTRUTOR DE PESSOA VAZIO
	@Test
	void construtorPessoaVazioTest() {
		Pessoa pessoaConstrutorVazio = new Pessoa();
		assertEquals("", pessoaConstrutorVazio.getNome());
		assertEquals(0, pessoaConstrutorVazio.getIdade());
		assertEquals("", pessoaConstrutorVazio.getSexo());
		assertEquals(false, pessoaConstrutorVazio.isCondutor());
		assertEquals(false, pessoaConstrutorVazio.isEmbriagado());
	}
	
	
	
	//TESTANDO O CONSTRUTOR DE ACIDENTE PREENCHIDO
	@Test
	void construtorRodoviaPreenchido() {
		Rodovia rodovia = new Rodovia("SC108", "Alta");
		Acidente acidenteConstrutorPreenchido = new Acidente(rodovia, 2, 4, 10, veiculosCaso1);
		assertEquals("SC108", acidenteConstrutorPreenchido.getRodovia().getSigla());
		assertEquals(2, acidenteConstrutorPreenchido.getVitimasFatais());
		assertEquals(4, acidenteConstrutorPreenchido.getFeridos());
		assertEquals(10, acidenteConstrutorPreenchido.getMes());
		assertEquals(veiculosCaso1, acidenteConstrutorPreenchido.getVeículosEnvolvidos());
	}
	
	//TESTANDO O CONSTRUTOR DE ACIDENTE VAZIO
	@Test
	void construtorRodoviaVazio() {
		Acidente acidenteConstrutorPreenchido = new Acidente();
		assertEquals(null, acidenteConstrutorPreenchido.getRodovia());
		assertEquals(0, acidenteConstrutorPreenchido.getVitimasFatais());
		assertEquals(0, acidenteConstrutorPreenchido.getFeridos());
		assertEquals(0, acidenteConstrutorPreenchido.getMes());
		assertEquals(null, acidenteConstrutorPreenchido.getVeículosEnvolvidos());
	}
}
