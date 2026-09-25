public class Livro {

    private final int id;
    @SuppressWarnings("FieldMayBeFinal")
    private String titulo;
    @SuppressWarnings("FieldMayBeFinal")
    private String autor;
    private boolean disponivel;

    public Livro(int id, String titulo, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void emprestar() {
        disponivel = false;
    }

    public void devolver() {
        disponivel = true;
    }

    @Override
    public String toString() {

        String status;

        if (disponivel) {
            status = "Disponível";
        } else {
            status = "Emprestado";
        }

        return "ID: " + id
                + " | Título: " + titulo
                + " | Autor: " + autor
                + " | Status: " + status;
    }
}