import java.time.LocalDate;

public class Emprestimo {

    @SuppressWarnings("FieldMayBeFinal")
    private Livro livro;
    @SuppressWarnings("FieldMayBeFinal")
    private Leitor leitor;
    @SuppressWarnings("FieldMayBeFinal")
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo(Livro livro, Leitor leitor) {

        this.livro = livro;
        this.leitor = leitor;

        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = null;
    }

    public Livro getLivro() {
        return livro;
    }

    public Leitor getLeitor() {
        return leitor;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void devolver() {
        dataDevolucao = LocalDate.now();
    }

    public boolean estaAtivo() {
        return dataDevolucao == null;
    }

    @Override
    public String toString() {

        String status;

        if (estaAtivo()) {
            status = "Em aberto";
        } else {
            status = "Devolvido em " + dataDevolucao;
        }

        return "Livro: " + livro.getTitulo()
                + " | Leitor: " + leitor.getNome()
                + " | Data: " + dataEmprestimo
                + " | Status: " + status;
    }
}