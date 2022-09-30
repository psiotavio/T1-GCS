import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Sistema {
    private LinkedList<Usuario> lstUsuarios;
    private int qtdMedicos;
    private int qtdPacientes;
    private int qtdAdmins;

    public Sistema() {
        lstUsuarios = new LinkedList<>();
    }

    public void leArquivo() {
        String path = "src/Usuarios.csv"; // ABRE O ARQUVIO
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine(); // COMEÇA A LER O ARQUVO

            while (line != null) { // SEPARA CADA INFORMAÇAO E ARMAZENA EM SEU DEVIDO LUGAR
                String[] vector = line.split(";");
                Usuario u = new Usuario(Integer.parseInt(vector[0]), vector[1], vector[2]); // ARMAZENA USUARIO
                lstUsuarios.add(u);
                line = br.readLine(); // VAI PARA PRÓXIMA LINHA

                if (vector[2].equals("Medico")) { // CONTA QUANTOS MEDICOS TEM
                    qtdMedicos++;
                }
                if (vector[2].equals("Paciente")) { // CONTA QUANTOS PACIENTES TEM
                    qtdPacientes++;
                } else { // CONTA QUANTOS ADMNS TEM
                    qtdAdmins++;
                }
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

}
