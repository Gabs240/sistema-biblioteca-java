public class Leitor {

    @SuppressWarnings("FieldMayBeFinal")
    private int id;
    @SuppressWarnings("FieldMayBeFinal")
    private String nome;
    @SuppressWarnings("FieldMayBeFinal")
    private String cpf;

    public Leitor(int id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {

        return "ID: " + id
                + " | Nome: " + nome
                + " | CPF: " + cpf;
    }
}