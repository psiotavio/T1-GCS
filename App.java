import java.util.Scanner;

public class App {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        String nome;
        Sistema s = new Sistema();

        System.out.println("\n-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\n");

        while (true) {
            System.out.println("\nOLÁ QUE TIPO DE USUARIO VOCÊ É: \n\n1- MÉDICO\n2- PACIENTE\n3- ADMINISTRADOR\n");
            int m = scan.nextInt();
            System.out.println("--------------------------");
            switch (m) {
                case 1: // Médico
                    boolean menuMed = true;
                    System.out.println(s.getMedicos());
                    System.out.println("\nOLÁ QUAL MÉDICO VOCÊ É:");
                    nome = scan.next();
                    Medico med = (Medico) s.getUsuario(nome); // MÉTODO PARA USAR O MÉDICO SELECIONADO E SUAS FUNÇÕES
                    while (menuMed == true) {
                        System.out.println(med);
                        System.out.println("\n-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\n");
                        System.out.println("\nSELECIONE UMA OPÇÃO: \n\n1- NOVO EXAME\n2- LISTAR EXAMES\n3- SAIR\n");
                        int menu2 = scan.nextInt();

                        switch (menu2) {
                            case 1:
                               med.addAutorizacao();
                                System.out.println(
                                        "\n\n-----------------------------------------------------\nPRESSIONE ENTER PARA CONTINUAR: ");
                                scan.useDelimiter("\r?\n").next();
                                break;
                            case 2:
                                med.listarTodasAutorizacoesPorExame();
                                System.out.println(
                                        "\n\n-----------------------------------------------------\nPRESSIONE ENTER PARA CONTINUAR: ");
                                scan.useDelimiter("\r?\n").next();
                                break;

                            case 3:
                                menuMed = false;
                                break;
                        }
                    }

                    break;

                case 2: // Paciente
                    boolean menuPac = true;
                    System.out.println(s.getPacientes());
                    System.out.println("\nOLÁ QUAL PACIENTE VOCÊ É:");
                    nome = scan.next();
                    Paciente pac = (Paciente) s.getUsuario(nome); // MÉTODO PARA USAR O PACIENTE SELECIONADO E SUAS
                                                                  // FUNÇÕES
                    while (menuPac == true) {
                        System.out.println(pac);
                        System.out.println("\n-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\n");
                        System.out.println(
                                "\nSELECIONE UMA OPÇÃO: \n\n1- LISTAR AUTORIZAÇÕES DE EXAMES\n2- REALIZAR EXAME\n3- SAIR\n");
                        int menu2 = scan.nextInt();

                        switch (menu2) {
                            case 1:

                                // ADICIONAR FUNÇAO DE LISTAR EXAMES AUTORIZADOS

                                System.out.println(
                                        "\n\n-----------------------------------------------------\nPRESSIONE ENTER PARA CONTINUAR: ");
                                scan.useDelimiter("\r?\n").next();
                                break;
                            case 2:
                                pac.marcarExameComoRealizado();
                                System.out.println(
                                        "\n\n-----------------------------------------------------\nPRESSIONE ENTER PARA CONTINUAR: ");
                                scan.useDelimiter("\r?\n").next();
                                break;

                            case 3:
                                menuPac = false;
                                break;
                        }
                    }
                    break;

                case 3: // Administrador
                    Boolean menuAdm = true;
                    System.out.println(s.getAdm());
                    System.out.println("\nOLÁ QUAL ADMINISTRADOR VOCÊ É:");
                    nome = scan.next();
                    Administrador adm = (Administrador) s.getUsuario(nome); // MÉTODO PARA USAR O ADM SELECIONADO E SUAS
                                                                            // FUNÇÕES
                    while (menuAdm == true) {
                        System.out.println(adm);
                        System.out.println("\n-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\n");
                        System.out.println(
                                "\nSELECIONE UMA OPÇÃO: \n\n1- ADICIONAR USUÁRIO\n2- VER ESTATÍSTICAS\n3- SAIR\n");
                        int menu2 = scan.nextInt();

                        switch (menu2) {
                            case 1:
                                adm.addUsuario(); // ADICIONA USUARIO
                                System.out.println(
                                        "\n\n-----------------------------------------------------\nPRESSIONE ENTER PARA CONTINUAR: ");
                                scan.useDelimiter("\r?\n").next();
                                break;
                            case 2:

                                // ADICIONAR FUNÇAO DE VER ESTATISTICAS

                                System.out.println(
                                        "\n\n-----------------------------------------------------\nPRESSIONE ENTER PARA CONTINUAR: ");
                                scan.useDelimiter("\r?\n").next();
                                break;

                            case 3:
                                menuAdm = false;
                                break;
                        }
                    }
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
