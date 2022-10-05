import java.util.Scanner;

public class App {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        Sistema s = new Sistema();
        s.leArquivo();

        System.out.println("\n-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\n");
        System.out.println("\nOLÁ QUE TIPO DE USUARIO VOCÊ É: \n\n1- MÉDICO\n2- PACIENTE\n3- ADMINISTRADOR\n");

        while (true) {
            int m = scan.nextInt();
            System.out.println("--------------------------");
            switch (m) {
                case 1: // Médico
                    System.out.println(s.getMedicos());
                    System.out.println("\nOLÁ QUAL MÉDICO VOCÊ É:");
                    String nome = scan.next();
                    Medico med = (Medico) s.getUsuario(nome); // MÉTODO PARA USAR O MÉDICO SELECIONADO E SUAS FUNÇÕES 
                    System.out.println(med);
                    break;

                case 2: // Paciente
                    System.out.println(s.getPacientes());
                    System.out.println("\nOLÁ QUAL PACIENTE VOCÊ É:");
                    nome = scan.next();
                    Paciente pac = (Paciente) s.getUsuario(nome); // MÉTODO PARA USAR O PACIENTE SELECIONADO E SUAS FUNÇÕES 
                    System.out.println(pac);
                    break;

                case 3: // Administrador
                    System.out.println(s.getAdm());
                    System.out.println("\nOLÁ QUAL ADMINISTRADOR VOCÊ É:");
                    nome = scan.next();
                    Administrador adm = (Administrador) s.getUsuario(nome); // MÉTODO PARA USAR O ADM SELECIONADO E SUAS FUNÇÕES 
                    System.out.println(adm);
                    break;

                case 4: // Fecha o programa
                    System.out.println("Tchauzinho.\nQue a força esteja com você...\n");
                    System.exit(0);

            }
        }
        
        // System.out.println(s.getQtdAdmins()); TESTA SE CONTA OS ADMS
        // System.out.println(s.getQtdMedicos()); TESTA SE CONTA OS ADMS
        // System.out.println(s.getQtdPacientes()); TESTA SE CONTA OS ADMS
    }
}


