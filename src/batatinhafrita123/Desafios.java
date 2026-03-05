package batatinhafrita123;

public class Desafios {

	import java.util.ArrayList;
	import java.util.List;

	public class Desafio {
	    private String nome;
	    private int minimoParticipantes;
	    private int classificados;
	    private List<String> regras;
	    private Local local;

	    public Desafio(String nome, int minimoParticipantes, int classificados, List<String> regras, Local local) {
	        this.nome = nome;
	        this.minimoParticipantes = minimoParticipantes;
	        this.classificados = classificados;
	        this.regras = regras;
	        this.local = local;
	    }

	    public String getNome() {
	        return nome;
	    }

	    public int getMinimoParticipantes() {
	        return minimoParticipantes;
	    }

	    public int getClassificados() {
	        return classificados;
	    }

	    public List<String> getRegras() {
	        return regras;
	    }

	    public Local getLocal() {
	        return local;
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
	    }

	    public void setMinimoParticipantes(int minimoParticipantes) {
	        this.minimoParticipantes = minimoParticipantes;
	    }

	    public void setClassificados(int classificados) {
	        this.classificados = classificados;
	    }

	    public void setRegras(List<String> regras) {
	        this.regras = regras;
	    }

	    public void setLocal(Local local) {
	        this.local = local;
	    }

	    @Override
	    public String toString() {
	        return "Desafio - Nome: " + nome +
	                ", Min.Participantes: " + minimoParticipantes +
	                ", Classificados: " + classificados +
	                ", Regras: " + regras +
	                ", Local: " + local.getNome();
	    }
	}

}
