package prova_pratica_poo_2023;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DepartamentoTransitoTest {
	
	@BeforeEach
	void ExecultaAntes() {
        DepartamentoTransito departamento = new DepartamentoTransito();

        departamento.cadastrarRodovia("BR-101", "Alto");
        departamento.cadastrarRodovia("BR-222", "Medio");

        List<Acidente> acidentes = new ArrayList<>();

        // Caso 1: Carro e Moto
        List<Pessoa> pessoas1 = new ArrayList<>();
        pessoas1.add(new Pessoa("Joao", 30, "Masculino", "Sim", "Sim"));
        pessoas1.add(new Pessoa("Maria", 25, "Feminino", "Nao", "Nao"));

        List<Pessoa> pessoas2 = new ArrayList<>();
        pessoas2.add(new Pessoa("Pedro", 35, "Masculino", "Sim", "Nao"));
        pessoas2.add(new Pessoa("Ana", 28, "Feminino", "Nao", "Nao"));
        pessoas2.add(new Pessoa("Lucas", 22, "Masculino", "Nao", "Nao"));

        List<Veículo> veiculosCaso1 = new ArrayList<>();
        veiculosCaso1.add(new Veículo(2010, "Carro", pessoas1));
        veiculosCaso1.add(new Veículo(2020, "Moto", pessoas2));

        departamento.cadastrarAcidente(departamento.rodovias.get(0), 2, 3, 10, veiculosCaso1);
        acidentes.add(departamento.acidentes.get(0));
        
        // Caso 2: Caminhao e Bicicleta
        List<Pessoa> pessoas3 = new ArrayList<>();
        pessoas3.add(new Pessoa("Marcio", 50, "Masculino", "Sim", "Sim"));
        pessoas3.add(new Pessoa("Mariana", 15, "Feminino", "Nao", "Nao"));

        List<Pessoa> pessoas4 = new ArrayList<>();
        pessoas4.add(new Pessoa("Pedro", 35, "Masculino", "Sim", "Nao"));

        List<Veículo> veiculosCaso2 = new ArrayList<>();
        veiculosCaso2.add(new Veículo(2010, "Caminhao", pessoas3));
        veiculosCaso2.add(new Veículo(2015, "Bicicleta", pessoas4));

        departamento.cadastrarAcidente(departamento.rodovias.get(1), 1, 2, 9, veiculosCaso2);
        acidentes.add(departamento.acidentes.get(1));
	
        // Caso 3: Caminhao e Bicicleta e Moto
        List<Pessoa> pessoas5 = new ArrayList<>();
        pessoas5.add(new Pessoa("Rogerio", 42, "Masculino", "Sim", "Nao"));
        pessoas5.add(new Pessoa("Julia", 24, "Feminino", "Nao", "Nao"));

        List<Pessoa> pessoas6 = new ArrayList<>();
        pessoas6.add(new Pessoa("Lucas", 19, "Masculino", "Sim", "Sim"));
        pessoas6.add(new Pessoa("Leandro", 19, "Masculino", "Nao", "Nao"));
        
        List<Pessoa> pessoas7 = new ArrayList<>();
        pessoas7.add(new Pessoa("Luzia", 39, "Feminino", "Sim", "Sim"));

        List<Veículo> veiculosCaso3 = new ArrayList<>();
        veiculosCaso3.add(new Veículo(2011, "Moto", pessoas5));
        veiculosCaso3.add(new Veículo(2022, "Bicicleta", pessoas6));
        veiculosCaso3.add(new Veículo(2014, "Moto", pessoas7));

        departamento.cadastrarAcidente(departamento.rodovias.get(1), 3, 3, 10, veiculosCaso3);
        acidentes.add(departamento.acidentes.get(2));
        
        //Esses são os métodos que precisam ser testados, acima eu só criei 3 casos de acidentes, talvez de pra ultilizar em todos
        departamento.listarAcidentes(acidentes);
        departamento.listaQuantAcidporGrau();
        departamento.listarVeiculosDeCargaEnvolvidos();
        departamento.rodoviaComMaisAcidenteDeBicicleta();
        departamento.rodoviaAcidentesFatais();
        departamento.contarAcidentesComVeiculosNovos();
        departamento.rodoviasComAcidentesNoCarnaval();
	}	
	
	
	@Test
	void listaAcidente() {
		
	}

}
