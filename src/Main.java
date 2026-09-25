import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            Biblioteca biblioteca = new Biblioteca();

            int opcao;

            do {

                System.out.println();
                System.out.println("==============================");
                System.out.println("     SISTEMA DE BIBLIOTECA");
                System.out.println("==============================");
                System.out.println("1 - Cadastrar livro");
                System.out.println("2 - Cadastrar leitor");
                System.out.println("3 - Listar livros");
                System.out.println("4 - Listar leitores");
                System.out.println("5 - Realizar empréstimo");
                System.out.println("6 - Devolver livro");
                System.out.println("7 - Listar empréstimos");
                System.out.println("0 - Sair");
                System.out.println("==============================");

                System.out.print("Escolha uma opção: ");

                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {

                    case 1 -> {
                        System.out.println();
                        System.out.println("===== CADASTRO DE LIVRO =====");

                        System.out.print("ID do livro: ");
                        int idLivro = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Título: ");
                        String titulo = scanner.nextLine();

                        System.out.print("Autor: ");
                        String autor = scanner.nextLine();

                        Livro livro =
                                new Livro(idLivro, titulo, autor);

                        biblioteca.cadastrarLivro(livro);
                    }

                    case 2 -> {
                        System.out.println();
                        System.out.println("===== CADASTRO DE LEITOR =====");

                        System.out.print("ID do leitor: ");
                        int idLeitor = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();

                        System.out.print("CPF: ");
                        String cpf = scanner.nextLine();

                        Leitor leitor =
                                new Leitor(idLeitor, nome, cpf);

                        biblioteca.cadastrarLeitor(leitor);
                    }

                    case 3 -> biblioteca.listarLivros();

                    case 4 -> biblioteca.listarLeitores();

                    case 5 -> {
                        System.out.println();
                        System.out.println("===== REALIZAR EMPRÉSTIMO =====");

                        System.out.print("ID do livro: ");
                        int idLivroEmprestimo = scanner.nextInt();

                        System.out.print("ID do leitor: ");
                        int idLeitorEmprestimo = scanner.nextInt();

                        biblioteca.realizarEmprestimo(
                                idLivroEmprestimo,
                                idLeitorEmprestimo
                        );
                    }

                    case 6 -> {
                        System.out.println();
                        System.out.println("===== DEVOLUÇÃO =====");

                        System.out.print("ID do livro: ");
                        int idLivroDevolucao = scanner.nextInt();

                        biblioteca.devolverLivro(idLivroDevolucao);
                    }

                    case 7 -> biblioteca.listarEmprestimos();

                    case 0 -> {
                        System.out.println();
                        System.out.println("Sistema encerrado!");
                    }

                    default -> {
                        System.out.println();
                        System.out.println("Opção inválida!");
                    }
                }

            } while (opcao != 0);
        }
    }
}