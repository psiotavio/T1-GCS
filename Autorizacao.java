    import java.time.*;
import java.time.format.DateTimeFormatter;
    
    public class Autorizacao {

    private int codigo;
    private LocalDate dataRegistro;
    private LocalDate dataRealizado;
    private Medico medico;
    private Paciente paciente;
    private enumExame exame;
    private boolean realizado;
    private static int qtdAutorizacoes=0;
    private static int qtdExamesRealizados=0;
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Autorizacao(int codigo, Medico medico, Paciente paciente, enumExame exame) {
        this.codigo = codigo;
        this.dataRegistro = LocalDate.now();
        this.dataRealizado = null;
        this.medico = medico;
        this.paciente = paciente;
        this.exame = exame;
        this.realizado = false;
        qtdAutorizacoes++;
    }

    public int getCodigo() {
        return codigo;
    }

    public LocalDate getDate() {
        return dataRegistro;
    }

    public LocalDate getDataRealizacao() {
        return dataRealizado;
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

    public void marcarRealizado(LocalDate d) { //EDITAR ESTE METODO PARA MARCAR A DATA QUANDO FOI REALIZADO.
        if (!this.realizado)
        {
            this.realizado = true;
            qtdExamesRealizados++;
            dataRealizado = d;
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
        String str = "\nAutorizacao: " + codigo + "\nData de Solicitação: " + dataRegistro.format(dateFormat);
        if (getDataRealizacao()==null) {str += "\n Data de Realização: " + dataRealizado.format(dateFormat);}
        str += "\nMédico: " + medico.getNome() + "\nPaciente: " + paciente.getNome() + "\nExame: " + exame;
        return str;
    }
    
}
