import java.util.ArrayList;
import java.util.Scanner;

public class Medico extends Usuario {
    private enumExame ex;
    Scanner in = new Scanner(System.in);
    private ArrayList<Autorizacao> autorizacoes;

    public Medico(int id, String nome, String tipo) {
        super(id, nome, tipo);
        autorizacoes = new ArrayList<>();
    }

    public void adicionaAutorizacao(Autorizacao autorizacao) {
        autorizacoes.add(autorizacao);
    }

    public void addAutorizacao() {
        Sistema s = new Sistema();

        System.out.println("Digite o codigo da sua autorizacao");
        int codigo = in.nextInt();

        System.out.println("Digite o paciente da sua autorizacao");
        String p = in.next();
        Paciente pac = (Paciente) s.getUsuario(p);

        System.out.println(
                "Escolha o exame da sua autorizacao\n\n[1] RaioX\n[2] Tomografia\n[3] Mamografia\n[4] Colonoscopia\n[5] Endoscopia\n[6] Hemograma\n[7] Audiometria\n[8] Espirometria\n[9] Ultrassonografia\n[10] Eletrocardiograma\n");
        int exame = in.nextInt();
        switch (exame) {
            case 1:
                ex = enumExame.RaioX;
                break;
            case 2:
                ex = enumExame.Tomografia;
                break;
            case 3:
                ex = enumExame.Mamografia;
                break;
            case 4:
                ex = enumExame.Colonoscopia;
                break;
            case 5:
                ex = enumExame.Endoscopia;
                break;
            case 6:
                ex = enumExame.Hemograma;
                break;
            case 7:
                ex = enumExame.Audiometria;
                break;
            case 8:
                ex = enumExame.Espirometria;
                break;
            case 9:
                ex = enumExame.Ultrassonografia;
                break;
            case 10:
                ex = enumExame.Eletrocardiograma;
                break;

        }

        Autorizacao autorizacao = new Autorizacao(codigo, this, pac, ex);
        System.out.println(autorizacao.toString());
        adicionaAutorizacao(autorizacao);
    }

    // private void listarTodasAutorizacoesPorPaciente(){

    // }

    public void listarTodasAutorizacoesPorExame() {
       System.out.println(autorizacoes.toString());
    }
}
