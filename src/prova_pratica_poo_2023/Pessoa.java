package prova_pratica_poo_2023;

public class Pessoa {
	
	private String nome;
	private int idade;
	private String sexo;
	private boolean condutor;
	private boolean embriagado;
	
	public Pessoa() {
		this.nome = "";
		this.idade = 0;
		this.sexo = "";
		this.condutor = false;
		this.embriagado = false;
	}
	
	public Pessoa(String nome, int idade, String sexo, boolean condutor, boolean embriagado) {
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
		this.condutor = condutor;
		this.embriagado = embriagado;
	}

	@Override
    public String toString() {
        StringBuilder pessoaString = new StringBuilder("Nome: " + getNome() + ", Idade: " + getIdade() + ", Sexo: " + getSexo()).append("\n");
        if (this.isCondutor() == true) {
        	if(this.isEmbriagado() == true) {
            	pessoaString.append("Estava Embriagado\n");
        	} else {
        		pessoaString.append("Não estava embriagado\n");
        	}
        	
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
	

	public boolean isCondutor() {
		return condutor;
	}
	

	public void setCondutor(boolean condutor) {
		this.condutor = condutor;
	}
	

	public boolean isEmbriagado() {
		return embriagado;
	}
	

	public void setEmbriagado(boolean embriagado) {
		this.embriagado = embriagado;
	}
	
}

