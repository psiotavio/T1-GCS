import java.util.Collections;
import java.util.LinkedList;

public class Paciente extends Usuario {

    LinkedList<Autorizacao> listaAutorizacao = new LinkedList();

    public Paciente(int id, String nome, String tipo) {
        super(id, nome, tipo);
    }


    public void getList(){
        Collections.sort(listaAutorizacao);
        for(Autorizacao c : listaAutorizacao){
            System.out.println(c);
        }
    }
}