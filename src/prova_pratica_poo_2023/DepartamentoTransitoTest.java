package prova_pratica_poo_2023;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DepartamentoTransitoTest {
	
	List<Pessoa> pessoas1 = new ArrayList<>();
	List<Pessoa> pessoas2 = new ArrayList<>();
	List<Pessoa> pessoas3 = new ArrayList<>();
	List<Pessoa> pessoas4 = new ArrayList<>();
	List<Veículo> veiculosCaso1 = new ArrayList<>();
	List<Veículo> veiculosCaso2 = new ArrayList<>();
	Rodovia rodoviaTest;
	Rodovia rodoviaTest2;
	Acidente acidenteTest;
	Acidente acidenteTest2;

	
	@BeforeEach
	void executarPrimeiro() {
		
		//PRIMEIRO ACIDENTE, NINGUEM EMBRIAGADO
		rodoviaTest = new Rodovia("SC108", "Alta");
		rodoviaTest2 = new Rodovia("BR101", "Baixa");
		
		pessoas1.add(new Pessoa("Pessoa1Test1", 30, "Masculino", true, false));
		pessoas1.add(new Pessoa("Pessoa1.1Test1", 25, "Feminino", false, false));
        pessoas2.add(new Pessoa("Pessoa2Test1", 35, "Masculino", true, false));
        pessoas2.add(new Pessoa("Pessoa2.1Test1", 28, "Feminino", false, false));
        pessoas2.add(new Pessoa("Pessoa2.2Test1", 22, "Masculino", false, false));
        
        veiculosCaso1.add(new Veículo(2010, "Bicicleta", pessoas1));
        veiculosCaso1.add(new Veículo(2020, "Bicicleta", pessoas2));
        
        acidenteTest = new Acidente(rodoviaTest, 1, 4, 10, veiculosCaso1);
        
        //SEGUNDO ACIDENTE, UM MOTORISTA EMBRIAGADO
        pessoas3.add(new Pessoa("Pessoa3Test2", 30, "Masculino", true, true));
        pessoas3.add(new Pessoa("Pessoa3.1Test2", 30, "Masculino", false, false)); 
        pessoas4.add(new Pessoa("Pessoa4Test2", 30, "Masculino", true, false)); 
        pessoas4.add(new Pessoa("Pessoa4.1Test2", 30, "Masculino", false, false)); 
        
        veiculosCaso2.add(new Veículo(2015, "Bicicleta", pessoas3));
        veiculosCaso2.add(new Veículo(2019, "Bicicleta", pessoas4));
        
        acidenteTest2 = new Acidente(rodoviaTest2, 2, 2, 8, veiculosCaso2);
        
        
        
	}
	
	//TESTANDO O CADASTRO DE RODOVIAS PELA CLASSE DEPARTAMENTOTRANSITO INSTANCIANDO A RODOVIA
	@Test
	void cadastroRodoviasNaoInstanciadasTest() {
		DepartamentoTransito dentran = new DepartamentoTransito();
		
		dentran.cadastrarRodovia("SC108", "Alto");
		assertEquals("SC108", dentran.rodovias.get(0).getSigla());
	}
	
	//TESTANDO O CADASTRO DE RODOVIAS PELA CLASSE DEPARTAMENTOTRANSITO RECEBENDO A RODOVIA JÁ INSTANCIADA
		@Test
		void cadastroRodoviasInstanciadasTest() {
			DepartamentoTransito dentran = new DepartamentoTransito();
			
			dentran.cadastrarRodovia(rodoviaTest);
			assertEquals("SC108", dentran.rodovias.get(0).getSigla());
		}
	
	//TESTANDO O CADASTRO DE ACIDENTES PELA CLASSE DEPARTAMENTOTRANSITO INSTANCIANDO O ACIDENTE
	@Test
	void cadastroAcidentesNaoInstanciadasTest() {
		DepartamentoTransito dentran = new DepartamentoTransito();
		
		dentran.cadastrarAcidente(rodoviaTest, 1, 4, 10, veiculosCaso1);
		assertEquals("SC108", dentran.acidentes.get(0).getRodovia().getSigla());
		assertEquals(1, dentran.acidentes.get(0).getVitimasFatais());
		assertEquals(4, dentran.acidentes.get(0).getFeridos());
		assertEquals(2, dentran.acidentes.get(0).getVeículosEnvolvidos().size());
	}
	
	//TESTANDO O CADASTRO DE ACIDENTES PELA CLASSE DEPARTAMENTOTRANSITO RECEBENDO O ACIDENTE JÁ INSTANCIADO
	@Test
	void cadastroAcidentesInstanciadasTest() {
			DepartamentoTransito dentran = new DepartamentoTransito();
			
			dentran.cadastrarAcidente(acidenteTest);
			assertEquals("SC108", dentran.acidentes.get(0).getRodovia().getSigla());
			assertEquals(1, dentran.acidentes.get(0).getVitimasFatais());
			assertEquals(4, dentran.acidentes.get(0).getFeridos());
			assertEquals(2, dentran.acidentes.get(0).getVeículosEnvolvidos().size());
		}

	//TESTANDO LISTAGEM DE ACIDENTES SEM CONDUTOR EMBRIAGADO
	@Test
	void listarAcidentesSemCondutorEmbriagadoTest() {
		DepartamentoTransito dentran = new DepartamentoTransito();
		
		dentran.cadastrarAcidente(acidenteTest);
		assertEquals("Não há acidentes com condutor embreagado", dentran.listarAcidentes());	
	}
	
	//-----------------INCOMPLETO-----------------------
	//VOU VER COMO TRANSFORMAR A SAIDA DE VOID PARA STRING
	//TESTANDO LISTAGEM DE ACIDENTES COM CONDUTOR EMBRIAGADO
	@Test
	void listarAcidentesComCondutorEmbriagadoTest() {
		DepartamentoTransito dentran = new DepartamentoTransito();
			
		dentran.cadastrarAcidente(acidenteTest);
		dentran.cadastrarAcidente(acidenteTest2);
		dentran.listarAcidentes();		
	}
	
	//-----------------INCOMPLETO-----------------------
	//VOU VER COMO TRANSFORMAR A SAIDA DE VOID PARA STRING
	//TESTANDO O LISTAR QUANTIDADE DE ACIDENTES POR GRAU DE PERICULOSIDADE
	@Test
	void listarQntAcidentesGrauPericulosidadeTest(){
		DepartamentoTransito dentran = new DepartamentoTransito();
		
		dentran.cadastrarAcidente(acidenteTest);
		dentran.cadastrarAcidente(acidenteTest2);
		
		//dentran.listaQuantAcidporGrau();
	}
	
	//-----------------INCOMPLETO-----------------------
	//VOU VER COMO TRANSFORMAR A SAIDA DE VOID PARA STRING
	//TESTANDO O LISTAR VEICULOS DE CARGA ENVOLVIDO EM ACIDENTE 
	@Test
	void listarVeiculosDeCargaEnvolvidosTest() {
		DepartamentoTransito dentran = new DepartamentoTransito();
		
		dentran.cadastrarAcidente(acidenteTest);
		dentran.cadastrarAcidente(acidenteTest2);
		
		dentran.listarVeiculosDeCargaEnvolvidos();
	}
	
	
	// --------------INCOMPLETO ------------------------
	//TESTANDO O LISTAR RODOVIAS COM MAIS BICICLETAS ENVOLVIDAS EM ACIDENTE
	//VOU VER COMO TRANSFORMAR A SAIDA DE VOID PARA STRING
	//NÃO ESTA MOSTRANDO OS ACIDENTES DE BICICLETA
	@Test
	void listarRodoviasMaisAcidentesBicicletaTest() {
		DepartamentoTransito dentran = new DepartamentoTransito();
		
		dentran.cadastrarAcidente(acidenteTest);
		dentran.cadastrarAcidente(acidenteTest2);
		
		dentran.rodoviaComMaisAcidenteDeBicicleta();
	}
	
	
	
	
	//TESTANDO O CONSTRUTOR DE VEÍCULO PREENCHIDO
	@Test
	void construtorVeículoPreenchidoTest() {
		Veículo veiculoConstrutorPreenchido = new Veículo(2020, "Carro", pessoas1);
		assertEquals(2020, veiculoConstrutorPreenchido.getAno());
		assertEquals("Carro", veiculoConstrutorPreenchido.getTipo());
		assertEquals("Pessoa1Test1", veiculoConstrutorPreenchido.getPessoas().get(0).getNome());
		assertEquals("Pessoa1.1Test1", veiculoConstrutorPreenchido.getPessoas().get(1).getNome());
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
	void construtorAcidentePreenchidoTest() {
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
	void construtorAcidenteVazioTest() {
		Acidente acidenteConstrutorPreenchido = new Acidente();
		assertEquals(null, acidenteConstrutorPreenchido.getRodovia());
		assertEquals(0, acidenteConstrutorPreenchido.getVitimasFatais());
		assertEquals(0, acidenteConstrutorPreenchido.getFeridos());
		assertEquals(0, acidenteConstrutorPreenchido.getMes());
		assertEquals(null, acidenteConstrutorPreenchido.getVeículosEnvolvidos());
	}
}
