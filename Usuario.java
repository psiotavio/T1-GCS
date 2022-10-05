import java.io.BufferedReader;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class Usuario {
    // Cada usuário tem um identificador, um nome e o seu tipo: médico, paciente
    // ou administrador.

    private int id;
    private String nome;
    private String tipo;

    public Usuario(int id, String nome, String tipo) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "----------------\nUsuario: " + id + "\nNome: " + nome + "\nTipo: " + tipo + "\n----------------";
    }

    public String toCsv() { // TRANSFORMA EM CSV ID;NOME;TIPO
        Path path = Paths.get("toCsv.csv");

        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path, Charset.defaultCharset()));
                BufferedReader reader = Files.newBufferedReader(path, Charset.defaultCharset())) {
            writer.format("%d;%s;%s", getId(), getNome(), getTipo());
            writer.flush();
            String line = null;
            line = reader.readLine();
            return line;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}