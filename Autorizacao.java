    public class Autorizacao {

    private int codigo;
    private String data;
    private Medico medico;
    private Paciente paciente;
    private enumExame exame;
    private boolean realizado;
    private static int qtdAutorizacoes=0;
    private static int qtdExamesRealizados=0;

    public Autorizacao(int codigo, String date, Medico medico, Paciente paciente, enumExame exame) {
        this.codigo = codigo;
        this.data = date;
        this.medico = medico;
        this.paciente = paciente;
        this.exame = exame;
        this.realizado = false;
        qtdAutorizacoes++;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDate() {
        return data;
    }

    public Medico getMedico() {
        return medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public enumExame getExame() {
        return exame;
    }

    public void marcarRealizado() { //EDITAR ESTE METODO PARA MARCAR A DATA QUANDO FOI REALIZADO.
        if (!this.realizado)
        {
            this.realizado = true;
            qtdExamesRealizados++;
        }
    }

    public static int getQtdAutorizacoes() {
        return qtdAutorizacoes;
    }

    public static int getQtdExamesRealizados() {
        return qtdExamesRealizados;
    }

    public static String getPercentualRealizados() {
        double res = ((double)qtdExamesRealizados/(double)qtdAutorizacoes)*100;
        return String.format("%.2f", res);
    }

    @Override
    public String toString() {
        return "\nAutorizacao: " + codigo + "\nData: " + data + "\nMédico: " + medico.getNome() + "\nPaciente: " + paciente.getNome()
                + "\nExame: " + exame;
    }
    
}
