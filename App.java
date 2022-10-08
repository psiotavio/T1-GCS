import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        String nome;
        Sistema s = new Sistema();

        while (true) {
            System.out.println("\n-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-");
            System.out.println("\nCLIQUE ENTER PARA INCIAR SISTEMA DO HOSPITAL DOS GURIS\n");
            System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\n");
            scan.useDelimiter("\r?\n").nextLine();

            try {
                while (true) {
                    System.out.println(
                            "\nOLÁ QUE TIPO DE USUARIO VOCÊ É: \n\n1- MÉDICO\n2- PACIENTE\n3- ADMINISTRADOR\n4- SAIR\n");
                    int m = scan.nextInt();
                    System.out.println("--------------------------");
                    switch (m) {
                        case 1: // Médico
                            boolean menuMed = true;
                            System.out.println(s.getMedicos());
                            System.out.println("\nOLÁ QUAL MÉDICO VOCÊ É:");
                            scan.nextLine();
                            nome = scan.nextLine();
                            if (Sistema.getUsuario(nome) instanceof Medico) {
                                Medico med = (Medico) Sistema.getUsuario(nome); // MÉTODO PARA USAR O MÉDICO SELECIONADO
                                                                                // E SUAS
                                                                                // FUNÇÕES
                                while (menuMed == true) {
                                    System.out.println(med);
                                    System.out.println("\n-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\n");
                                    System.out.println(
                                            "\nSELECIONE UMA OPÇÃO: \n\n1- NOVO EXAME\n2- LISTAR EXAMES\n 3-REMOVER ULTIMA AUTORIZACAO\n 4- SAIR\n");
                                    int menu2 = scan.nextInt();

                                    switch (menu2) {
                                        case 1:
                                            med.addAutorizacao();
                                            System.out.println(
                                                    "\n\n-----------------------------------------------------\nPRESSIONE ENTER PARA CONTINUAR: ");
                                            scan.useDelimiter("\r?\n").next();
                                            break;
                                        case 2:
                                            med.tipoDeLista();
                                            System.out.println(
                                                    "\n\n-----------------------------------------------------\nPRESSIONE ENTER PARA CONTINUAR: ");
                                            scan.useDelimiter("\r?\n").next();
                                            break;
                                        case 3:
                                            med.retirarUltimaAutorizacao();
                                            System.out.println(
                                                    "\n\n-----------------------------------------------------\nPRESSIONE ENTER PARA CONTINUAR: ");
                                            scan.useDelimiter("\r?\n").next();
                                            break;
                                        case 4:
                                            menuMed = false;
                                            break;
                                    }
                                }
                            } else {
                                System.out.println("\nERRO: MÉDICO NÃO ENCONTRADO\n");
                            }

                            break;

                        case 2: // Paciente
                            boolean menuPac = true;
                            System.out.println(s.getPacientes());
                            System.out.println("\nOLÁ QUAL PACIENTE VOCÊ É:");
                            scan.nextLine();
                            nome = scan.nextLine();
                            if (Sistema.getUsuario(nome) instanceof Paciente) {
                                Paciente pac = (Paciente) Sistema.getUsuario(nome); // MÉTODO PARA USAR O PACIENTE
                                                                                    // SELECIONADO E
                                                                                    // SUAS
                                // FUNÇÕES
                                while (menuPac == true) {
                                    System.out.println(pac);
                                    System.out.println("\n-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\n");
                                    System.out.println(
                                            "\nSELECIONE UMA OPÇÃO: \n\n1- LISTAR AUTORIZAÇÕES DE EXAMES\n2- REALIZAR EXAME\n3- SAIR\n");
                                    int menu2 = scan.nextInt();

                                    switch (menu2) {
                                        case 1:
                                            pac.listarExames();
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
                            } else {
                                System.out.println("\nERRO: PACIENTE NÃO ENCONTRADO\n");
                            }
                            break;

                        case 3: // Administrador
                            Boolean menuAdm = true;
                            System.out.println(s.getAdm());
                            System.out.println("\nOLÁ QUAL ADMINISTRADOR VOCÊ É:");
                            scan.nextLine();
                            nome = scan.nextLine();
                            if (Sistema.getUsuario(nome) instanceof Administrador) {
                                Administrador adm = (Administrador) Sistema.getUsuario(nome); // MÉTODO PARA USAR O ADM
                                                                                              // SELECIONADO
                                                                                              // E SUAS
                                // FUNÇÕES
                                while (menuAdm == true) {
                                    System.out.println(adm);
                                    System.out.println("\n-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\n");
                                    System.out.println(
                                            "\nSELECIONE UMA OPÇÃO: \n\n1- ADICIONAR USUÁRIO\n2- VER ESTATÍSTICAS\n3- LISTAR AUTORIZACOES DE UM PACIENTE OU MEDICO\n4- SAIR\n");
                                    int menu2 = scan.nextInt();

                                    switch (menu2) {
                                        case 1:
                                            adm.addUsuario(); // ADICIONA USUARIO
                                            System.out.println(
                                                    "\n\n-----------------------------------------------------\nPRESSIONE ENTER PARA CONTINUAR: ");
                                            scan.useDelimiter("\r?\n").next();
                                            break;
                                        case 2: // VERIFICA AS ESTATISTICAS
                                            System.out.println(adm.estatisticas());
                                            System.out.println(
                                                    "\n\n-----------------------------------------------------\nPRESSIONE ENTER PARA CONTINUAR: ");
                                            scan.useDelimiter("\r?\n").next();
                                            break;

                                        case 3:
                                            adm.buscarAutNome();
                                            System.out.println(
                                                    "\n\n-----------------------------------------------------\nPRESSIONE ENTER PARA CONTINUAR: ");
                                            scan.useDelimiter("\r?\n").next();
                                            break;
                                        case 4:
                                            menuAdm = false;
                                            break;
                                    }
                                }
                            } else {
                                System.out.println("\nERRO: ADMINISTRADOR NÃO ENCONTRADO\n");
                            }
                            break;

                        case 4: // Fecha o programa
                            System.out.println("Tchauzinho.\nQue a força esteja com você...\n");
                            System.exit(0);

                    }
                }

            } catch (InputMismatchException e) {
                System.out.println("ERRO: DIGITE UM NUMERO!");
            }
        }
    }
}
