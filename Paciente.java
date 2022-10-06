import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.ArrayList;

public class Paciente extends Usuario {

    private ArrayList<Autorizacao> autorizacoes;
    Scanner sc = new Scanner(System.in);
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Paciente(int id, String nome, String tipo) {
        super(id, nome, tipo);
        this.autorizacoes = new ArrayList<>();
    }

    public void adicionaAutorizacao(Autorizacao autorizacao){
        this.autorizacoes.add(autorizacao);
    }

    public String getAutorizacoes()
    {
       return this.autorizacoes.toString();
    }

    public void marcarExameComoRealizado() {
        System.out.print("Digite o código de sua autorização: ");
        int codigo = sc.nextInt();
        sc.nextLine();
        boolean found = false;
        for (int pos=0;pos<autorizacoes.size()&&!found;pos++) { //pesquisa o vetor por autorizacao com o codigo correspondente
            if (autorizacoes.get(pos).getCodigo()==codigo) {
                found=true;
                if (autorizacoes.get(pos).getDataRealizacao()==null) { //verifica se o exame ainda não foi realizado (dataRealizado=null)
                    System.out.print("Digite a data da realização do exame no formato dd/MM/yyyy: ");
                    String dataRealizado = sc.nextLine(); //paciente digita a data
                    try {
                        LocalDate l1 = LocalDate.parse(dataRealizado,dateFormat);  //converte a String para LocalDate
                        int dateComparePassado = l1.compareTo(autorizacoes.get(pos).getDate()); //verifica se a data digitada é maior ou igual à do registro
                        LocalDate mais30Dias = autorizacoes.get(pos).getDate().plusDays(30);
                        int dateCompare30Dias = l1.compareTo(mais30Dias); //verifica se a data digitada está dentro da janela de 30 dias da do registro.
                        if (dateComparePassado<0||dateCompare30Dias>0) {
                            System.out.println("Um exame só pode ser marcado como realizado dentro de 30 dias após seu registro.");
                        }
                        else {
                            autorizacoes.get(pos).marcarRealizado(l1);
                        }
                    }
                    catch (DateTimeParseException e1) { //excecao quando não consegue converter a String para LocalDate (digitou com formatacao errada)
                        System.out.println("Formatação inválida para a data.");
                    }
                }
                else {
                    System.out.println("Este exame já foi marcado como realizado.");
                }
            }
        }
        if (!found)
        {
            System.out.println("Você não possui uma autorização de exame com este codigo.");
        }
    }
}
