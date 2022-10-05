import java.util.ArrayList;

public class Medico extends Usuario{

    private ArrayList<Autorizacao> autorizacoes;
    public Medico(int id, String nome, String tipo) {
        super(id, nome, tipo);
    }

    public void adicionaAutorizacao(Autorizacao autorizacao){
        autorizacoes.add(autorizacao);
    }

}

