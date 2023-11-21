package prova_pratica_poo_2023;

import java.util.List;

public class Acidente {
	
	Rodovia rodovia;
	int vitimasFatais;
    int feridos;
    int mes;
    List<Veículo> VeículosEnvolvidos;
      
	public Acidente(Rodovia rodovia, int vitimasFatais, int feridos, int mes, List<Veículo> VeículosEnvolvidos) {
		this.rodovia = rodovia;
		this.vitimasFatais = vitimasFatais;
		this.feridos = feridos;
		this.mes = mes;
		this.VeículosEnvolvidos = VeículosEnvolvidos;
	}

	@Override
	public String toString() {
        StringBuilder acidenteString = new StringBuilder("\nAcidente na rodovia: " + rodovia +
                "\nVitimas Fatais: " + getVitimasFatais() + ", Feridos: " + getFeridos() + ", Mes: " + getMes() + "\n");

        if (getVeículosEnvolvidos() != null && !getVeículosEnvolvidos().isEmpty()) {
            acidenteString.append("\nVeiculos Envolvidos:\n");

            for (Veículo veiculo : getVeículosEnvolvidos()) {
                acidenteString.append("- ").append(veiculo.toString()).append("\n");
            }
        } else {
            acidenteString.append("\nNenhum veículo envolvido.");
        }

        return acidenteString.toString();
	}

	public Rodovia getRodovia() {
		return rodovia;
	}

	public void setRodovia(Rodovia rodovia) {
		this.rodovia = rodovia;
	}

	public int getVitimasFatais() {
		return vitimasFatais;
	}

	public void setVitimasFatais(int vitimasFatais) {
		this.vitimasFatais = vitimasFatais;
	}

	public int getFeridos() {
		return feridos;
	}

	public void setFeridos(int feridos) {
		this.feridos = feridos;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public List<Veículo> getVeículosEnvolvidos() {
		return VeículosEnvolvidos;
	}

	public void setVeículosEnvolvidos(List<Veículo> veículosEnvolvidos) {
		VeículosEnvolvidos = veículosEnvolvidos;
	}
		
}
