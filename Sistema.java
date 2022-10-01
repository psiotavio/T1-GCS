import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Sistema {
    private LinkedList<Usuario> lstUsuarios;
    Scanner in = new Scanner(System.in);
    Scanner inS = new Scanner(System.in);
    private int qtdMedicos;
    private int qtdPacientes;
    private int qtdAdmins;

    public Sistema() {
        lstUsuarios = new LinkedList<>();
    }

    public void leArquivo() {
        String path = "Usuarios.csv"; // ABRE O ARQUVIO
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine(); // COMEÇA A LER O ARQUVO

            while (line != null) { // SEPARA CADA INFORMAÇAO E ARMAZENA EM SEU DEVIDO LUGAR
                String[] vector = line.split(";");
                if (vector[2].equals("Medico")) 
                {
                   Usuario m = new Medico(Integer.parseInt(vector[0]), vector[1], vector[2]); // ARMAZENA USUARIO MEDICO
                   lstUsuarios.add(m);
                   qtdMedicos++;
                }
                else if ((vector[2].equals("Paciente")))
                {
                   Usuario p = new Paciente(Integer.parseInt(vector[0]), vector[1], vector[2]); // ARMAZENA USUARIO PACIENTE
                   lstUsuarios.add(p);
                   qtdPacientes++;
                }
                else if ((vector[2].equals("Administrador")))
                {
                   Usuario a = new Administrador(Integer.parseInt(vector[0]), vector[1], vector[2]); // ARMAZENA USUARIO ADM
                   lstUsuarios.add(a);
                   qtdAdmins++;
                }
                line = br.readLine(); // VAI PARA PRÓXIMA LINHA
            }
        } catch (IOException e) { // SE DER ERRO NO ARQUIVO ELE MOSTRA QUAL FOI O ERRO
            System.out.println("Error: " + e.getMessage());
        }
    }

    public int getQtdMedicos() {
        return qtdMedicos;
    }

    public int getQtdPacientes() {
        return qtdPacientes;
    }

    public int getQtdAdmins() {
        return qtdAdmins;
    }

    public String getMedicos() {
        LinkedList<Usuario> lstMedicos = new LinkedList<>();
        for (Usuario lst : lstUsuarios) {
            if (lst.getTipo().equals("Medico")) {
                lstMedicos.add(lst);
            }

        }
        String listaM = lstMedicos.toString();
        return listaM.replaceAll(", ", "\n").replace("[", "").replace("]", "");
    }

    public String getPacientes() {
        LinkedList<Usuario> lstPacientes = new LinkedList<>();
        for (Usuario lst : lstUsuarios) {
            if (lst.getTipo().equals("Paciente")) {
                lstPacientes.add(lst);
            }

        }
        String listaP = lstPacientes.toString();
        return listaP.replaceAll(", ", "\n").replace("[", "").replace("]", "");
    }

    public String getAdm() {
        LinkedList<Usuario> lstAdm = new LinkedList<>();
        for (Usuario lst : lstUsuarios) {
            if (lst.getTipo().equals("Administrador")) {
                lstAdm.add(lst);
            }

        }
        String listaA = lstAdm.toString();
        return listaA.replaceAll(", ", "\n").replace("[", "").replace("]", "");
    }

    public Usuario getUsuario(String nome) {
        nome = nome.substring(0, 1).toUpperCase() + nome.substring(1);
        for (Usuario lst : lstUsuarios) {
            String subNomes[] = lst.getNome().split(" ");
            String subN[] = nome.split(" ");
            if (lst.getNome().equals(nome)) {
                return lst;
            }
            if (subNomes[0].equals(subN[0])) {
                return lst;
            }
        }
        return null;
    }

    public void addUsuario(){
        boolean aux = false;
        int id = 0;
        do{ //VALIDACAO PARA NAO TER IDS IGUAIS 
            System.out.println("Qual o id do usuario? ");
            id = in.nextInt();

            for (Usuario lst : lstUsuarios) {
                if (lst.getId()!=id) {
                    aux = true;
                }
            }
        }while(aux==false);

        System.out.println("Qual o nome do usuario? "); 
        String nome = inS.nextLine();
        System.out.println("Qual o tipo do usuario? ");
        String tipo = inS.nextLine();

        if(tipo.equalsIgnoreCase("Paciente")){ //ADD AS INFOS NA LINKEDLIST
            Usuario u = new Paciente(id, nome, tipo);
            lstUsuarios.add(u);
        } else if(tipo.equalsIgnoreCase("Medico")){
            Usuario u = new Medico(id, nome, tipo);
            lstUsuarios.add(u);
        } else if(tipo.equalsIgnoreCase("Administrador")){
            Usuario u = new Administrador(id, nome, tipo);
            lstUsuarios.add(u);
        }
    }

    public String buscaUsuario(){ //DEPENDENDO DE COMO FICAR A AUTORIZACAO VAI TER QUE MUDAR A SAIDA DO METODO
        System.out.println("Qual o nome do usuario a ser pesquisado? ");
        String nome = inS.nextLine();
        String[] vector = nome.split(" "); //SEPARA O NOME E SOBRENOME
        for (Usuario lst : lstUsuarios) { //PESQUISA POR TODOS OS USUARIOS
            for(int i=0;i<vector.length;i++){ //PESQUISA O NOME E SOBRENOME PRA VER SE TEM UM IGUAL AO DO VETOR
                if (lst.getNome().equals(vector[i])) {
                    //RETORNA A LISTA DE AUTORIZACOES (ESPERANDO A LISTA)
                }
            }
        }
        return nome;
    }

}
