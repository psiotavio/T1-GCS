import java.util.Scanner;

public class App {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Sistema s = new Sistema();
        s.leArquivo();
        s.executa();

        System.out.println("\n-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\n");
        System.out.println("\nOLÁ ESCOLHA SEU TIPO UM USUARIO PELO NOME: \n");
        System.out.println(s.getQtdAdmins());
        String nome  = scan.nextLine();
        System.out.println(s.getUsuario(nome));
    }
}


