package batatinhafrita123;

public class Main {

	import java.util.ArrayList;
	import java.util.List;
	import java.util.Scanner;

	public class Round6App {
	    private static List<Participantes> participantes = new ArrayList<>();
 static List<Lugares> locais = new ArrayList<>();
	    private static List<Desafio> desafios = new ArrayList<>();

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int opcao;

	        do {
	            System.out.println("\n--- MENU ROUND 6 ---");
	            System.out.println("1 - Cadastrar Participante");
	            System.out.println("2 - Cadastrar Local");
	            System.out.println("3 - Cadastrar Desafio");
	            System.out.println("4 - Editar Participante");
	            System.out.println("5 - Editar Desafio");
	            System.out.println("6 - Excluir Participante");
	            System.out.println("7 - Excluir Desafio");
	            System.out.println("8 - Visualizar Participantes");
	            System.out.println("9 - Visualizar Locais");
	            System.out.println("10 - Visualizar Desafios");
	            System.out.println("0 - Sair");
	            System.out.print("Escolha uma opção: ");
	            opcao = sc.nextInt();
	            sc.nextLine();

	            switch (opcao) {
	                case 1 -> cadastrarParticipante(sc);
	                case 2 -> cadastrarLocal(sc);
	                case 3 -> cadastrarDesafio(sc);
	                case 4 -> editarParticipante(sc);
	                case 5 -> editarDesafio(sc);
	                case 6 -> excluirParticipante(sc);
	                case 7 -> excluirDesafio(sc);
	                case 8 -> visualizarParticipantes();
	                case 9 -> visualizarLocais();
	                case 10 -> visualizarDesafios();
	                case 0 -> System.out.println("Encerrando o programa...");
	                default -> System.out.println("Opção inválida.");
	            }
	        } while (opcao != 0);
	    }

	    // Métodos de Participante
	    private static void cadastrarParticipante(Scanner sc) {
	        System.out.print("Nome: ");
	        String nome = sc.nextLine();
	        System.out.print("Número: ");
	        String numero = sc.nextLine();
	        System.out.print("Idade: ");
	        int idade = sc.nextInt();
	        sc.nextLine();

	        if (idade < 18) {
	            System.out.println("Participante deve ter 18 anos ou mais.");
	            return;
	        }

	        participantes.add(new Participantes(nome, numero, idade));
	        System.out.println("Participante cadastrado.");
	    }

	    private static void editarParticipante(Scanner sc) {
	        System.out.print("Número do participante para editar: ");
	        String numero = sc.nextLine();
	        for (Participantes p : participantes) {
	            if (p.getNumero().equals(numero)) {
	                System.out.print("Novo nome: ");
	                p.setNome(sc.nextLine());
	                System.out.print("Nova idade: ");
	                int idade = sc.nextInt();
	                sc.nextLine();
	                if (idade >= 18) {
	                    p.setIdade(idade);
	                } else {
	                    System.out.println("Idade inválida. Deve ser 18 ou mais.");
	                }
	                System.out.print("Novo número: ");
	                p.setNumero(sc.nextLine());
	                System.out.println("Participante editado.");
	                return;
	            }
	        }
	        System.out.println("Participante não encontrado.");
	    }

	    private static void excluirParticipante(Scanner sc) {
	        System.out.print("Número do participante para excluir: ");
	        String numero = sc.nextLine();
	        participantes.removeIf(p -> p.getNumero().equals(numero));
	        System.out.println("Participante excluído, se existia.");
	    }

	    private static void visualizarParticipantes() {
	        if (participantes.isEmpty()) {
	            System.out.println("Nenhum participante cadastrado.");
	        } else {
	            participantes.forEach(System.out::println);
	        }
	    }

	    // Métodos de Local
	    private static void cadastrarLocal(Scanner sc) {
	        System.out.print("Nome do local: ");
	        String nome = sc.nextLine();
	        System.out.print("Capacidade máxima: ");
	        int capacidade = sc.nextInt();
	        sc.nextLine();

	        locais.add(new Lugares(nome, capacidade));
	        System.out.println("Local cadastrado.");
	    }

	    private static void visualizarLocais() {
	        if (locais.isEmpty()) {
	            System.out.println("Nenhum local cadastrado.");
	        } else {
	            locais.forEach(System.out::println);
	        }
	    }

	    // Métodos de Desafio
	    private static void cadastrarDesafio(Scanner sc) {
	        if (desafios.size() >= 5) {
	            System.out.println("Limite de 5 desafios atingido.");
	            return;
	        }

	        System.out.print("Nome do desafio: ");
	        String nome = sc.nextLine();
	        System.out.print("Número mínimo de participantes: ");
	        int minimo = sc.nextInt();
	        System.out.print("Número de classificados: ");
	        int classificados = sc.nextInt();
	        sc.nextLine();

	        System.out.print("Quantidade de regras: ");
	        int qtdRegras = sc.nextInt();
	        sc.nextLine();
	        List<String> regras = new ArrayList<>();
	        for (int i = 0; i < qtdRegras; i++) {
	            System.out.print("Regra " + (i + 1) + ": ");
	            regras.add(sc.nextLine());
	        }

	        if (locais.isEmpty()) {
	            System.out.println("Nenhum local cadastrado.");
	            return;
	        }

	        System.out.println("Locais disponíveis:");
	        for (int i = 0; i < locais.size(); i++) {
	            System.out.println((i + 1) + " - " + locais.get(i));
	        }
	        System.out.print("Escolha o local (número): ");
	        int escolhaLocal = sc.nextInt();
	        sc.nextLine();

	        if (escolhaLocal < 1 || escolhaLocal > locais.size()) {
	            System.out.println("Local inválido.");
	            return;
	        }

	        Lugares localEscolhido = locais.get(escolhaLocal - 1);

	        if (localEscolhido.getCapacidade() < minimo) {
	            System.out.println("Capacidade do local insuficiente para o mínimo de participantes.");
	            return;
	        }

	        desafios.add(new Desafios(nome, minimo, classificados, regras, localEscolhido));
	        System.out.println("Desafio cadastrado.");
	    }

	    private static void editarDesafio(Scanner sc) {
	        System.out.print("Nome do desafio para editar: ");
	        String nome = sc.nextLine();
	        for (Desafio d : desafios) {
	            if (d.getNome().equalsIgnoreCase(nome)) {
	                System.out.print("Novo nome: ");
	                d.setNome(sc.nextLine());
	                System.out.print("Novo número mínimo de participantes: ");
	                int minimo = sc.nextInt();
	                System.out.print("Novo número de classificados: ");
	                int classificados = sc.nextInt();
	                sc.nextLine();

	                d.setMinimoParticipantes(minimo);
	                d.setClassificados(classificados);

	                System.out.print("Quantidade de regras: ");
	                int qtdRegras = sc.nextInt();
	                sc.nextLine();
	                List<String> regras = new ArrayList<>();
	                for (int i = 0; i < qtdRegras; i++) {
	                    System.out.print("Regra " + (i + 1) + ": ");
	                    regras.add(sc.nextLine());
	                }
	                d.setRegras(regras);

	                System.out.println("Locais disponíveis:");
	                for (int i = 0; i < locais.size(); i++) {
	                    System.out.println((i + 1) + " - " + locais.get(i));
	                }
	                System.out.print("Escolha o local (número): ");
	                int escolhaLocal = sc.nextInt();
	                sc.nextLine();

	                if (escolhaLocal < 1 || escolhaLocal > locais.size()) {
	                    System.out.println("Local inválido.");
	                    return;
	                }

	                Lugares localEscolhido = locais.get(escolhaLocal - 1);

	                if (localEscolhido.getCapacidade() < minimo) {
	                    System.out.println("Capacidade do local insuficiente para o mínimo de participantes.");
	                    return;
	                }

	                d.setLugares(localEscolhido);
	                System.out.println("Desafio editado.");
	                return;
	            }
	        }
	        System.out.println("Desafio não encontrado.");
	    }

	    private static void excluirDesafio(Scanner sc) {
	        System.out.print("Nome do desafio para excluir: ");
	        String nome = sc.nextLine();
	        desafios.removeIf(d -> d.getNome().equalsIgnoreCase(nome));
	        System.out.println("Desafio excluído, se existia.");
	    }

	    private static void visualizarDesafios() {
	        if (desafios.isEmpty()) {
	            System.out.println("Nenhum desafio cadastrado.");
	        } else {
	            desafios.forEach(System.out::println);
	        }
	    }
	
}
