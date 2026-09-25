import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    @SuppressWarnings("FieldMayBeFinal")
    private List<Livro> livros;
    @SuppressWarnings("FieldMayBeFinal")
    private List<Leitor> leitores;
    @SuppressWarnings("FieldMayBeFinal")
    private List<Emprestimo> emprestimos;

    public Biblioteca() {
        livros = new ArrayList<>();
        leitores = new ArrayList<>();
        emprestimos = new ArrayList<>();
    }

    // ==============================
    // CADASTRAR LIVRO
    // ==============================

    public void cadastrarLivro(Livro livro) {
        livros.add(livro);

        System.out.println();
        System.out.println("Livro cadastrado com sucesso!");
    }

    // ==============================
    // CADASTRAR LEITOR
    // ==============================

    public void cadastrarLeitor(Leitor leitor) {
        leitores.add(leitor);

        System.out.println();
        System.out.println("Leitor cadastrado com sucesso!");
    }

    // ==============================
    // BUSCAR LIVRO
    // ==============================

    public Livro buscarLivro(int id) {

        for (Livro livro : livros) {

            if (livro.getId() == id) {
                return livro;
            }
        }

        return null;
    }

    // ==============================
    // BUSCAR LEITOR
    // ==============================

    public Leitor buscarLeitor(int id) {

        for (Leitor leitor : leitores) {

            if (leitor.getId() == id) {
                return leitor;
            }
        }

        return null;
    }

    // ==============================
    // REALIZAR EMPRÉSTIMO
    // ==============================

    public void realizarEmprestimo(int idLivro, int idLeitor) {

        Livro livro = buscarLivro(idLivro);
        Leitor leitor = buscarLeitor(idLeitor);

        if (livro == null) {
            System.out.println();
            System.out.println("Livro não encontrado.");
            return;
        }

        if (leitor == null) {
            System.out.println();
            System.out.println("Leitor não encontrado.");
            return;
        }

        if (!livro.isDisponivel()) {
            System.out.println();
            System.out.println("Este livro já está emprestado.");
            return;
        }

        Emprestimo emprestimo = new Emprestimo(livro, leitor);

        emprestimos.add(emprestimo);

        livro.emprestar();

        System.out.println();
        System.out.println("Empréstimo realizado com sucesso!");
    }

    // ==============================
    // DEVOLVER LIVRO
    // ==============================

    public void devolverLivro(int idLivro) {

        Livro livro = buscarLivro(idLivro);

        if (livro == null) {
            System.out.println();
            System.out.println("Livro não encontrado.");
            return;
        }

        for (Emprestimo emprestimo : emprestimos) {

            if (emprestimo.getLivro().getId() == idLivro
                    && emprestimo.estaAtivo()) {

                emprestimo.devolver();

                livro.devolver();

                System.out.println();
                System.out.println("Livro devolvido com sucesso!");

                return;
            }
        }

        System.out.println();
        System.out.println("Este livro não possui empréstimo ativo.");
    }

    // ==============================
    // LISTAR LIVROS
    // ==============================

    public void listarLivros() {

        System.out.println();
        System.out.println("========== LIVROS ==========");

        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
            return;
        }

        for (Livro livro : livros) {
            System.out.println(livro);
        }
    }

    // ==============================
    // LISTAR LEITORES
    // ==============================

    public void listarLeitores() {

        System.out.println();
        System.out.println("========== LEITORES ==========");

        if (leitores.isEmpty()) {
            System.out.println("Nenhum leitor cadastrado.");
            return;
        }

        for (Leitor leitor : leitores) {
            System.out.println(leitor);
        }
    }

    // ==============================
    // LISTAR EMPRÉSTIMOS
    // ==============================

    public void listarEmprestimos() {

        System.out.println();
        System.out.println("========== EMPRÉSTIMOS ==========");

        if (emprestimos.isEmpty()) {
            System.out.println("Nenhum empréstimo registrado.");
            return;
        }

        for (Emprestimo emprestimo : emprestimos) {
            System.out.println(emprestimo);
        }
    }
}