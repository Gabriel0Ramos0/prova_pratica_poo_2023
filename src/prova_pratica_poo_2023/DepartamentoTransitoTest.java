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
	List<Pessoa> pessoas5 = new ArrayList<>();
	List<Pessoa> pessoas6 = new ArrayList<>();
	List<Pessoa> pessoas7 = new ArrayList<>();
	List<Veículo> veiculosCaso1 = new ArrayList<>();
	List<Veículo> veiculosCaso2 = new ArrayList<>();
	List<Veículo> veiculosCaso3 = new ArrayList<>();
	
	@BeforeEach
	void ExecultaAntes() {
        DepartamentoTransito departamento = new DepartamentoTransito();

        departamento.cadastrarRodovia("BR-101", "Alto");
        departamento.cadastrarRodovia("BR-222", "Medio");

        List<Acidente> acidentes = new ArrayList<>();

        // Caso 1: Carro e Moto
        pessoas1.add(new Pessoa("Joao", 30, "Masculino", true, true));
        pessoas1.add(new Pessoa("Maria", 25, "Feminino", false, false));
      
        pessoas2.add(new Pessoa("Pedro", 35, "Masculino", true, false));
        pessoas2.add(new Pessoa("Ana", 28, "Feminino", false, false));
        pessoas2.add(new Pessoa("Lucas", 22, "Masculino", false, false));
       
        veiculosCaso1.add(new Veículo(2010, "Carro", pessoas1));
        veiculosCaso1.add(new Veículo(2020, "Moto", pessoas2));

        departamento.cadastrarAcidente(departamento.rodovias.get(0), 2, 3, 10, veiculosCaso1);
        acidentes.add(departamento.acidentes.get(0));
        
        // Caso 2: Caminhao e Bicicleta        
        pessoas3.add(new Pessoa("Marcio", 50, "Masculino", true, false));
        pessoas3.add(new Pessoa("Mariana", 15, "Feminino", false, false));

        pessoas4.add(new Pessoa("Pedro", 35, "Masculino", true, false));
       
        veiculosCaso2.add(new Veículo(2010, "Caminhao", pessoas3));
        veiculosCaso2.add(new Veículo(2015, "Bicicleta", pessoas4));

        departamento.cadastrarAcidente(departamento.rodovias.get(1), 1, 2, 9, veiculosCaso2);
        acidentes.add(departamento.acidentes.get(1));
	
        // Caso 3: Caminhao e Bicicleta e Moto
        pessoas5.add(new Pessoa("Rogerio", 42, "Masculino", true, false));
        pessoas5.add(new Pessoa("Julia", 24, "Feminino", false, false));
        
        pessoas6.add(new Pessoa("Lucas", 19, "Masculino", true, true));
        pessoas6.add(new Pessoa("Leandro", 19, "Masculino", false, false));
        
        pessoas7.add(new Pessoa("Luzia", 39, "Feminino", true, true));

        veiculosCaso3.add(new Veículo(2011, "Moto", pessoas5));
        veiculosCaso3.add(new Veículo(2022, "Bicicleta", pessoas6));
        veiculosCaso3.add(new Veículo(2014, "Moto", pessoas7));

        departamento.cadastrarAcidente(departamento.rodovias.get(1), 3, 3, 10, veiculosCaso3);
        acidentes.add(departamento.acidentes.get(2));
        
        //Esses são os métodos que precisam ser testados, acima eu só criei 3 casos de acidentes, talvez de pra ultilizar em todos
        //departamento.listarAcidentes(acidentes);
        departamento.listaQuantAcidporGrau();
        departamento.listarVeiculosDeCargaEnvolvidos();
        departamento.rodoviaComMaisAcidenteDeBicicleta();
        departamento.rodoviaAcidentesFatais();
        departamento.contarAcidentesComVeiculosNovos();
        departamento.rodoviasComAcidentesNoCarnaval();
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
