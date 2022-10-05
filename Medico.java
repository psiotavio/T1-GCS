import java.util.ArrayList;
import java.util.Scanner;

public class Medico extends Usuario {
    Scanner in = new Scanner(System.in);
    Scanner inS = new Scanner(System.in);

    private ArrayList<Autorizacao> autorizacoes;

    public Medico(int id, String nome, String tipo) {
        super(id, nome, tipo);
    }

    public void adicionaAutorizacao(Autorizacao autorizacao) {
        autorizacoes.add(autorizacao);
    }

    public void addAutorizacao() {
        Sistema s = new Sistema();
        System.out.println("Digite o codigo da sua autorizacao");
        int codigo = in.nextInt();
        System.out.println("Digite a data da sua autorizacao");
        String data = inS.nextLine();
        System.out.println("Digite o medico que fez autorizacao");
        String medico = inS.nextLine();
        Medico med = (Medico) s.getUsuario(medico);
        System.out.println("Digite o paciente da sua autorizacao");
        String paciente = inS.nextLine();
        Paciente p = (Paciente) s.getUsuario(paciente);
        System.out.println("Digite o exame  da sua autorizacao");

        Autorizacao autorizacao = new Autorizacao(codigo, data, med, p, enumExame.Espirometria);
        adicionaAutorizacao(autorizacao);
    }

    // private void listarTodasAutorizacoesPorPaciente(){

    // }

    // private void listarTodasAutorizacoesPorExame(){

    // }

}
