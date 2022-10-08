import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

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
        try {
        System.out.println("Digite o codigo da sua autorizacao");
        int codigo = in.nextInt();
        in.nextLine();

        System.out.println("Digite a data de registro da sua autorizacao");
        String date = in.nextLine();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
       
            LocalDate formattedDate = LocalDate.parse(date, df);

            System.out.println("Digite o paciente da sua autorizacao");
            String p = in.next();
            Paciente pac = (Paciente) Sistema.getUsuario(p);

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
            Autorizacao autorizacao = new Autorizacao(codigo, formattedDate, this, pac, ex);
            pac.adicionaAutorizacao(autorizacao);
            System.out.println(autorizacao.toString());
            adicionaAutorizacao(autorizacao);
        }
        catch(InputMismatchException e){
            System.out.println("Digite um numero não uma String");
        }
        catch (DateTimeParseException e1) {
            System.out.println("Formatação inválida para a data.");
        }
    }

    public void tipoDeLista() {
        System.out.println(
                "\nESCOLHA UM TIPO DE LISTAGEM\n\n[1] LISTAR POR PACIENTE\n[2] LISTAR TODAS AS SOLICITAÇÕES POR EXAME\n[3] VOLTAR");
        int exame = in.nextInt();
        switch (exame) {
            case 1:
                listarTodasAutorizacoesPorPaciente();
                break;
            case 2:
                listarTodasAutorizacoesPorExame();
                break;
            case 3:
                break;
        }
    }

    public void listarTodasAutorizacoesPorPaciente() {
        try{
        System.out.println("DIGITE O NOME DO PACIENTE: ");
        String pac = in.next();
        Paciente p = (Paciente) Sistema.getUsuario(pac);
        System.out.println(p.getAutorizacoes());
        }catch(NullPointerException e){
            System.out.println("Erro.");
        }

    }

    public void listarTodasAutorizacoesPorExame() {
        System.out.println(
                "Escolha o exame da sua autorizacao\n\n[1] RaioX\n[2] Tomografia\n[3] Mamografia\n[4] Colonoscopia\n[5] Endoscopia\n[6] Hemograma\n[7] Audiometria\n[8] Espirometria\n[9] Ultrassonografia\n[10] Eletrocardiograma\n");
        int exame = in.nextInt();
        switch (exame) {
            case 1:
                for (Autorizacao a : autorizacoes) {
                    if (a.getExame().equals(enumExame.RaioX)) {
                        System.out.println(a.toString());
                    }
                }
                break;
            case 2:
                for (Autorizacao a : autorizacoes) {
                    if (a.getExame().equals(enumExame.Tomografia)) {
                        System.out.println(a.toString());
                    }
                }
                break;
            case 3:
                for (Autorizacao a : autorizacoes) {
                    if (a.getExame().equals(enumExame.Mamografia)) {
                        System.out.println(a.toString());
                    }
                }
                break;
            case 4:
                for (Autorizacao a : autorizacoes) {
                    if (a.getExame().equals(enumExame.Colonoscopia)) {
                        System.out.println(a.toString());
                    }
                }
                break;
            case 5:
                for (Autorizacao a : autorizacoes) {
                    if (a.getExame().equals(enumExame.Endoscopia)) {
                        System.out.println(a.toString());
                    }
                }
                break;
            case 6:
                for (Autorizacao a : autorizacoes) {
                    if (a.getExame().equals(enumExame.Hemograma)) {
                        System.out.println(a.toString());
                    }
                }
                break;
            case 7:
                for (Autorizacao a : autorizacoes) {
                    if (a.getExame().equals(enumExame.Audiometria)) {
                        System.out.println(a.toString());
                    }
                }
                break;
            case 8:
                for (Autorizacao a : autorizacoes) {
                    if (a.getExame().equals(enumExame.Espirometria)) {
                        System.out.println(a.toString());
                    }
                }
                break;
            case 9:
                for (Autorizacao a : autorizacoes) {
                    if (a.getExame().equals(enumExame.Ultrassonografia)) {
                        System.out.println(a.toString());
                    }
                }
                break;
            case 10:
                for (Autorizacao a : autorizacoes) {
                    if (a.getExame().equals(enumExame.Eletrocardiograma)) {
                        System.out.println(a.toString());
                    }
                }
                break;

        }
    }
    
    public String getAutorizacoes()
    {
       return this.autorizacoes.toString();
    }
}
