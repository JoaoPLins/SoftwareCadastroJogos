package batatinhafrita123;

public class Participantes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		class Participante {
		    private String nome;
		    private String numero;
		    private int idade;

		    public Participante(String nome, String numero, int idade) {
		        this.nome = nome;
		        this.numero = numero;
		        this.idade = idade;
		    }

		    public String getNome() {
		        return nome;
		    }

		    public String getNumero() {
		        return numero;
		    }

		    public int getIdade() {
		        return idade;
		    }

		    public void setNome(String nome) {
		        this.nome = nome;
		    }

		    public void setNumero(String numero) {
		        this.numero = numero;
		    }

		    public void setIdade(int idade) {
		        this.idade = idade;
		    }

		    @Override
		    public String toString() {
		        return "Participante - Nome: " + nome + ", Número: " + numero + ", Idade: " + idade;
		    }
		}

	}

}
