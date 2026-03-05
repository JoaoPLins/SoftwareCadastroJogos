package batatinhafrita123;

public class Lugares {

	public class Local {
	    private String nome;
	    private int capacidade;

	    public Local(String nome, int capacidade) {
	        this.nome = nome;
	        this.capacidade = capacidade;
	    }

	    public String getNome() {
	        return nome;
	    }

	    public int getCapacidade() {
	        return capacidade;
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
	    }

	    public void setCapacidade(int capacidade) {
	        this.capacidade = capacidade;
	    }

	    @Override
	    public String toString() {
	        return "Local - Nome: " + nome + ", Capacidade: " + capacidade;
	    }
	}

}
