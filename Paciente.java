import java.util.ArrayList;

public class Paciente extends Usuario {

    private ArrayList<Autorizacao> autorizacoes;
    public Paciente(int id, String nome, String tipo) {
        super(id, nome, tipo);
    }

    public void adicionaAutorizacao(Autorizacao autorizacao){
        autorizacoes.add(autorizacao);
    }


}
