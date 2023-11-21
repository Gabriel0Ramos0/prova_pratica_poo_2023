package prova_pratica_poo_2023;

import java.util.ArrayList;
import java.util.List;

public class DepartamentoTransito {
	
	List<Rodovia> rodovias = new ArrayList<>();
    List<Acidente> acidentes = new ArrayList<>();

    public DepartamentoTransito() {
        this.rodovias = new ArrayList<>();
        this.acidentes = new ArrayList<>();
    }

    public void cadastrarRodovia(String sigla, String grau) {
        Rodovia rodovia = new Rodovia(sigla, grau);
        rodovias.add(rodovia);
    }

    public void cadastrarAcidente(Rodovia rodovia, int vitimasFatais, int feridos, int mes, List<Veículo> VeículosEnvolvidos) {
        Acidente acidente = new Acidente(rodovia, vitimasFatais, feridos, mes, VeículosEnvolvidos);
        acidentes.add(acidente);
    }

    public void listarAcidentes(List<Acidente> acidentes) {
    	for (Acidente acidente : acidentes) {
            for (Veículo veiculo : acidente.getVeículosEnvolvidos()) {
                for (Pessoa pessoa : veiculo.getPessoas()) {
                    if ("SIM".equalsIgnoreCase(pessoa.getEmbriagado())) {
                        System.out.println("Acidente com condutor embriagado: " + acidente.toString());
                        break;
                    }
                }
            }
        }
    }

    public void listaQuantAcidporGrau() {
    	List<String> periculosidades = new ArrayList<>();
        List<Integer> quantidadePorPericulosidade = new ArrayList<>();

        for (Acidente acidente : acidentes) {
            String periculosidade = acidente.rodovia.getGrau();
            int index = periculosidades.indexOf(periculosidade);
            if (index == -1) {
                periculosidades.add(periculosidade);
                quantidadePorPericulosidade.add(1);
            } else {
                int quantidadeAtual = quantidadePorPericulosidade.get(index);
                quantidadePorPericulosidade.set(index, quantidadeAtual + 1);
            }
        }
        System.out.println("Quantidade de acidentes por periculosidade:");
        for (int i = 0; i < periculosidades.size(); i++) {
            String periculosidade = periculosidades.get(i);
            int quantidade = quantidadePorPericulosidade.get(i);
            System.out.println(periculosidade + ": " + quantidade);
        }
    }
    
    public void listarVeiculosDeCargaEnvolvidos() {
        for (Acidente acidente : acidentes) {
            for (Veículo veiculo : acidente.getVeículosEnvolvidos()) {
                if ("Caminhao".equals(veiculo.getTipo())) {
                    System.out.println("\nLista de Veiculo de Carga Envolvido: " + veiculo.toString());
                }
            }
        }
    }
    
    public void rodoviaComMaisAcidenteDeBicicleta() {
        Rodovia rodoviaComMaisAcidentes = null;
        int maxAcidentesBicicleta = 0;
        for (Rodovia rodovia : rodovias) {
            int countAcidentesBicicleta = 0;
            for (Acidente acidente : acidentes) {
                if (rodovia.equals(acidente.getRodovia())) {
                    for (Veículo veiculo : acidente.getVeículosEnvolvidos()) {
                        if ("Bicicleta".equals(veiculo.getTipo())) {
                            countAcidentesBicicleta++;
                        }
                    }
                }
            }
            if (countAcidentesBicicleta > maxAcidentesBicicleta) {
                maxAcidentesBicicleta = countAcidentesBicicleta;
                rodoviaComMaisAcidentes = rodovia;
            }
        }
        if (rodoviaComMaisAcidentes != null) {
            System.out.println("Rodovia com Mais Acidentes com Bicicletas" + rodoviaComMaisAcidentes.toString());
        } else {
            System.out.println("Não houve acidentes com bicicletas registrados.");
        }
    }
    
    public void rodoviaAcidentesFatais() {
        Rodovia rodoviaComMaisAcidentesFatais = null;
        int maxAcidentesFatais = 0;
        for (Rodovia rodovia : rodovias) {
            int countAcidentesFatais = 0;
            for (Acidente acidente : acidentes) {
                if (rodovia.equals(acidente.getRodovia())) {
                    countAcidentesFatais += acidente.getVitimasFatais();
                }
            }
            if (countAcidentesFatais > maxAcidentesFatais) {
                maxAcidentesFatais = countAcidentesFatais;
                rodoviaComMaisAcidentesFatais = rodovia;
            }
        }
        if (rodoviaComMaisAcidentesFatais != null) {
            System.out.println("Rodovia com Mais Acidentes com Vitimas Fatais" + rodoviaComMaisAcidentesFatais.toString());
        } else {
            System.out.println("Não houve acidentes com vítimas fatais registrados.");
        }
    }
    
    public void contarAcidentesComVeiculosNovos() {
        int countAcidentesVeiculosNovos = 0;

        for (Acidente acidente : acidentes) {
            for (Veículo veiculo : acidente.getVeículosEnvolvidos()) {
                if (veiculo.getAno() >= 2013) {
                    countAcidentesVeiculosNovos++;
                    break;
                }
            }
        }
        System.out.println("Quantidade de Acidentes com Veiculos Novos (a partir de 2013): " + countAcidentesVeiculosNovos);
    }
    
    public List<Rodovia> rodoviasComAcidentesNoCarnaval() {
        List<Rodovia> rodoviasNoCarnaval = new ArrayList<>();
        for (Acidente acidente : acidentes) {
            if (acidente.getMes() == 10) {
                Rodovia rodovia = acidente.getRodovia();
                if (!rodoviasNoCarnaval.contains(rodovia)) {
                    rodoviasNoCarnaval.add(rodovia);
                }
            }
        }
        System.out.println("\nRodovias que Registraram Acidentes no Carnaval " + rodoviasNoCarnaval);
        return rodoviasNoCarnaval;
    }
}
