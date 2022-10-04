import java.util.Scanner;

public class App {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        Sistema s = new Sistema();
        s.leArquivo();
        System.out.println("\n-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\n");
        System.out.println("\nOLÁ ESCOLHA UM USUARIO PELO NOME: \n");
        
        // System.out.println(s.getQtdAdmins()); TESTA SE CONTA OS ADMS
        // System.out.println(s.getQtdMedicos()); TESTA SE CONTA OS ADMS
        // System.out.println(s.getQtdPacientes()); TESTA SE CONTA OS ADMS
        String nome = scan.nextLine();
        System.out.println(s.getUsuario(nome));
    }
}
