import java.util.Scanner;

public class Administrador extends Usuario {
    Scanner in = new Scanner(System.in);
    Scanner inS = new Scanner(System.in);

    public Administrador(int id, String nome, String tipo) {
        super(id, nome, tipo);
    }

            public void addUsuario() {
                boolean aux = false;
                int id;

                System.out.println("Qual o id do usuario? ");
                id = in.nextInt();

                for (Usuario lst : Sistema.lstUsuarios) {
                    if (lst.getId() != id) {
                        aux = true;
                    }
                }

                if (aux == false) {
                    System.out.println("Qual o nome do usuario? ");
                    String nome = inS.nextLine();
                    System.out.println("Qual o tipo do usuario? ");
                    String tipo = inS.nextLine();

                    if (tipo.equalsIgnoreCase("Paciente")) { // ADD AS INFOS NA LINKEDLIST
                        Usuario u = new Paciente(id, nome, tipo);
                        Sistema.lstUsuarios.add(u);
                    } else if (tipo.equalsIgnoreCase("Medico")) {
                        Usuario u = new Medico(id, nome, tipo);
                        Sistema.lstUsuarios.add(u);
                    } else if (tipo.equalsIgnoreCase("Administrador")) {
                        Usuario u = new Administrador(id, nome, tipo);
                        Sistema.lstUsuarios.add(u);
                    }
                }
                else System.out.println("ERRO ID JÁ EXISTE!");
            }

}