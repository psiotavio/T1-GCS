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

            public String estatisticas(){ 
                String descricao = "";
                descricao += Sistema.getQtdMedicos() + "\n";
                descricao += Sistema.getQtdPacientes() + "\n";
                descricao += Autorizacao.getQtdAutorizacoes() + "\n";
                descricao += Autorizacao.getPercentualRealizados() + "%\n";
                return descricao;
            }
            
            public void buscarAutNome(){
                System.out.println("Deseja buscar as autorizacoes de um medico ou paciente?\n\n[1] Paciente\n[2] Medico");
                int escolha = in.nextInt();
                in.nextLine();
                switch(escolha){
                    case 1:
                        System.out.println("Qual o nome do paciente?");
                        String nomeP = in.nextLine();
                        Paciente p = (Paciente) Sistema.getUsuario(nomeP);
                        if(p == null){System.out.println("\nPaciente nao existe!");}
                        else if(p.getAutorizacoes().equals("[]")){
                            System.out.println("\nNão há nenhuma autorizacao deste paciente");
                        }
                        else{
                            System.out.println(p.getAutorizacoes() + "\n");
                        }
                        break;
                    case 2:
                        System.out.println("Qual o nome do medico?");
                        String nomeM = in.nextLine();
                        Medico m = (Medico) Sistema.getUsuario(nomeM);
                        if(m == null){System.out.println("\nMedico nao existe!");}
                        else if(m.getAutorizacoes().equals("[]")){
                            System.out.println("\nNão há nenhuma autorizacao deste medico");
                        }
                        else{
                            System.out.println(m.getAutorizacoes() + "\n");
                        }
                }
            }

}