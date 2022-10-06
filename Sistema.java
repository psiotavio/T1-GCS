import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Scanner;

public class Sistema {
    static LinkedList<Usuario> lstUsuarios;
    Scanner in = new Scanner(System.in);
    Scanner inS = new Scanner(System.in);
    private int qtdMedicos;
    private int qtdPacientes;
    private int qtdAdmins;

    public Sistema() {
        lstUsuarios = new LinkedList<>();
        leArquivo();
    }

    public void leArquivo() { // LE O ARQUIVO CSV

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

    public void salvaArquivo() {    //SALVA ARQUIVO COM A LISTA DE USUARIOS DO MOMENTO UTILIZADO

        Path path = Paths.get("Usuarios.csv");

        try(PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path, Charset.defaultCharset()));
            BufferedReader reader = Files.newBufferedReader(path, Charset.defaultCharset())) {

            for(Usuario c : lstUsuarios){     //SALVA EM UMA LINHA O CSV ID;NOME;TIPO
                String t = c.toCsv();
                writer.println(t);          //PRINTA NA LINHA E PULA PARA A PROXIMA
                writer.flush();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public int getQtdMedicos() { // PEGA TOTAL DE MEDICOS DA LISTA
        return qtdMedicos;
    }

    public int getQtdPacientes() { // PEGA TOTAL DE PACIENTES DA LISTA
        return qtdPacientes;
    }

    public int getQtdAdmins() { // PEGA TOTAL DE ADMS DA LISTA
        return qtdAdmins;
    }

    public String getMedicos() { // PEGA MEDICOS DA LISTA
        LinkedList<Usuario> lstMedicos = new LinkedList<>();
        for (Usuario lst : lstUsuarios) {
            if (lst.getTipo().equals("Medico")) {
                lstMedicos.add(lst);
            }

        }
        String listaM = lstMedicos.toString();
        return listaM.replaceAll(", ", "\n").replace("[", "").replace("]", "");
    }

    public String getPacientes() { // PEGA PACIENTES DA LISTA
        LinkedList<Usuario> lstPacientes = new LinkedList<>();
        for (Usuario lst : lstUsuarios) {
            if (lst.getTipo().equals("Paciente")) {
                lstPacientes.add(lst);
            }

        }
        String listaP = lstPacientes.toString();
        return listaP.replaceAll(", ", "\n").replace("[", "").replace("]", "");
    }

    public String getAdm() { // PEGA ADMS DA LISTA
        LinkedList<Usuario> lstAdm = new LinkedList<>();
        for (Usuario lst : lstUsuarios) {
            if (lst.getTipo().equals("Administrador")) {
                lstAdm.add(lst);
            }

        }
        String listaA = lstAdm.toString();
        return listaA.replaceAll(", ", "\n").replace("[", "").replace("]", "");
    }

    public static Usuario getUsuario(String nome) { // PEGA USUARIO X DA LISTA
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

    // VERIFICAR ESSE MÉTODO (APARENTEMENTE NÃO SERVE PRA NADA JÁ EXISTE getUsuario())
    public String buscaUsuario(){ // DEPENDENDO DE COMO FICAR A AUTORIZACAO VAI TER QUE MUDAR A SAIDA DO METODO
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

    public String estatisticas(){ 
        String descricao = "";
        descricao += getQtdMedicos() + "\n";
        descricao += getQtdPacientes() + "\n";
        descricao += Autorizacao.getQtdAutorizacoes() + "\n";
        descricao += Autorizacao.getPercentualRealizados() + "%\n";
        return descricao;
    }

}
