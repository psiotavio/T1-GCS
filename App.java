import java.util.Scanner;

public class App {
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        Sistema s = new Sistema();
        s.leArquivo();
        System.out.println("\n-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\n");
        System.out.println("\nOLÁ ESCOLHA SEU TIPO UM USUARIO PELO NOME: \n");
        String nome  = scan.nextLine();
        System.out.println(s.getUsuario(nome));
    }
}
