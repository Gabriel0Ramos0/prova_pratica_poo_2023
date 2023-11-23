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
    
    public void cadastrarRodovia(Rodovia rodovia) {
    	rodovias.add(rodovia);
    }

    public void cadastrarAcidente(Acidente acidente) {
        acidentes.add(acidente);
    }
    
    public void cadastrarAcidente(Rodovia rodovia, int vitimasFatais, int feridos, int mes, List<Veículo> VeículosEnvolvidos) {
        Acidente acidente = new Acidente(rodovia, vitimasFatais, feridos, mes, VeículosEnvolvidos);
        acidentes.add(acidente);
    }

    public String listarAcidentes() {
    	
    	String acidentesTexto = "";
    	boolean temCondutorEmbriagado = false;
    	
    	for (Acidente acidente : acidentes) {
            for (Veículo veiculo : acidente.getVeículosEnvolvidos()) {
                for (Pessoa pessoa : veiculo.getPessoas()) {
                    if (pessoa.isEmbriagado() == true) {
                    	acidentesTexto = "Acidente com condutor embriagado: " + acidente.toString();
                        temCondutorEmbriagado = true;          
                        break;
                    }
                }
            }
        }
    	
    	if(temCondutorEmbriagado == false) {
    		acidentesTexto = "Não há acidentes com condutor embreagado";
    	}
    	 return acidentesTexto;
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
                if ("Carga".equals(veiculo.getTipo())) {
                    System.out.println("\nLista de veiculos de carga envolvidos em acidentes: " + veiculo.toString());
                }
            }
        }
    }
    
    public void rodoviaComMaisAcidenteDeBicicleta() {
        
    	String rodMaisAcidentes = "";
    	int maxAcidentes = 0;
    	int contadorAcidentes = 0;
    	
    	for(Acidente acidente : acidentes) {
    		for(int i = 0; i < acidente.getVeículosEnvolvidos().size(); i++) {
    			String tipoVeiculo = acidente.getVeículosEnvolvidos().get(i).getTipo();
   			
    			if(tipoVeiculo.equalsIgnoreCase("Bicicleta")) {
    				contadorAcidentes += 1;
    			}
    		}
    		
    		if(contadorAcidentes > maxAcidentes) {
    			rodMaisAcidentes = acidente.getRodovia().getSigla();
    			maxAcidentes = contadorAcidentes;   		  			
    		} else if(contadorAcidentes == maxAcidentes && maxAcidentes != 0){
    			rodMaisAcidentes += " - " + acidente.getRodovia().getSigla();
    		}
    		
    		contadorAcidentes = 0;
    	}

    	if(maxAcidentes > 0) {
    		System.out.println("Rodovia com mais acidentes de bicicleta: " + rodMaisAcidentes);
    	} else {
    		System.out.println("Sem registros de acidente com bicicletas");
    	}
    }
    
    public void rodoviaAcidentesFatais() {
    	
    	String rodoviaMaisAcidentesFatais = "";
    	int maxAcidentesFatais = 0;
    	int contadorVitimas = 0;
    	
    	
    	for(Acidente acidente : acidentes) {
    		if(acidente.getVitimasFatais() > 0) {
    			contadorVitimas = acidente.getVitimasFatais();
    		}
    		
    		if(contadorVitimas > maxAcidentesFatais) {
    			maxAcidentesFatais = contadorVitimas;
    			rodoviaMaisAcidentesFatais = acidente.getRodovia().getSigla();
    		} else if(contadorVitimas == maxAcidentesFatais) {
    			rodoviaMaisAcidentesFatais += " - " + acidente.getRodovia().getSigla();
    		}
    		
    	}
    	
    	if(maxAcidentesFatais != 0) {
    		System.out.println("Rodovia com mais acidentes fatais: " + rodoviaMaisAcidentesFatais + "\nQunatidade de vítimas: " + maxAcidentesFatais);
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
        System.out.println("\nRodovias que Registraram Acidentes no Carnaval: " + rodoviasNoCarnaval);
        return rodoviasNoCarnaval;
    }
}
