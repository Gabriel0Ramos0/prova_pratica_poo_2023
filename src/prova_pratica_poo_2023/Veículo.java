package prova_pratica_poo_2023;

import java.util.List;

public class Veículo {
	
	private int ano;
	private String tipo;
	List<Pessoa> pessoas;

    public Veículo(int ano,String tipo, List<Pessoa> pessoas) {
        this.ano = ano;
        this.tipo = tipo;
        this.pessoas = pessoas;
    }

    @Override
    public String toString() {
        StringBuilder veiculoString = new StringBuilder(getTipo() + ", ano: " + getAno() + "\nCondutor: ");

        for (int i = 0; i < pessoas.size(); i++) {
            veiculoString.append(pessoas.get(i).toString());

            if (i < pessoas.size() - 1) {
                veiculoString.append("Passageiro: ");
            }
        }

        return veiculoString.toString();
    }


	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
}
