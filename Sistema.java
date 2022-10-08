import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
public class Sistema {
    static LinkedList<Usuario> lstUsuarios;
    Scanner in = new Scanner(System.in);
    Scanner inS = new Scanner(System.in);
    private static int qtdMedicos;
    private static int qtdPacientes;
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

    public static int getQtdMedicos() { // PEGA TOTAL DE MEDICOS DA LISTA
        return qtdMedicos;
    }

    public static int getQtdPacientes() { // PEGA TOTAL DE PACIENTES DA LISTA
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
        try{
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
    }catch(NullPointerException exception){
        System.out.println("ERRO: USUARIO NÃO ENCONTRADO");
    }
    catch(StringIndexOutOfBoundsException e)
    {
        System.out.println("ERRO: USUARIO NÃO ENCONTRADO");
    }
        return null;
    }

}
