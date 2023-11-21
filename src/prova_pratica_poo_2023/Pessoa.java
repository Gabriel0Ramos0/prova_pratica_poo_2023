package prova_pratica_poo_2023;

public class Pessoa {
	
	private String nome;
	private int idade;
	private String sexo;
	private String condutor;
	private String embriagado;
	
	public Pessoa(String nome, int idade, String sexo, String condutor, String embriagado) {
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
		this.condutor = condutor;
		this.embriagado = embriagado;
	}


	@Override
    public String toString() {
        StringBuilder pessoaString = new StringBuilder ("Nome: " + getNome() + ", Idade: " + getIdade() + ", Sexo: " + getSexo()).append("\n");
        if (getCondutor().equalsIgnoreCase("Sim")) {
            pessoaString.append("Estava Embriagado: ").append(getEmbriagado()).append("\n");
        }
        return pessoaString.toString();
    }

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getIdade() {
		return idade;
	}


	public void setIdade(int idade) {
		this.idade = idade;
	}


	public String getSexo() {
		return sexo;
	}


	public boolean setSexo(String sexo) {
	    if ("Masculino".equals(sexo) || "Feminino".equals(sexo)) {
	        this.sexo = sexo;
	        return true;
	    } else {
	        return false;
	    }
	}

	public String getCondutor() {
		return condutor;
	}

	public void setCondutor(String condutor) {
		this.condutor = condutor;
	}

	public String getEmbriagado() {
		return embriagado;
	}

	public Boolean setEmbriagado(String embriagado) {
        if ("Sim".equals(embriagado)) {
            this.embriagado = embriagado;
            return true;
        } else {
            this.embriagado = embriagado;
            return false;
        }
    }
}
