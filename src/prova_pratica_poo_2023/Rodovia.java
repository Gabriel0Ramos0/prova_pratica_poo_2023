package prova_pratica_poo_2023;

public class Rodovia {
	
	private String sigla;
	private String grau;

	public Rodovia(String sigla, String grau) {
		this.sigla = sigla;
		this.grau = grau;
	}

	@Override
	public String toString() {
		return getSigla() + ", grau: " + getGrau();
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getGrau() {
		return grau;
	}

	public boolean setGrau(String grau) {
		if ("Alto".equals(grau) || "Medio".equals(grau) || "Baixo".equals(grau)) {
	        this.grau = grau;
	        return true;
	    } else {
	        return false;
	    }
	}
	
}
