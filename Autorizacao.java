    public class Autorizacao {


    private int codigo;
    private String data;
    private Medico medico;
    private Paciente paciente;
    private enumExame exame;

    public Autorizacao(int codigo, String date, Medico medico, Paciente paciente, enumExame exame) {
        this.codigo = codigo;
        this.data = date;
        this.medico = medico;
        this.paciente = paciente;
        this.exame = exame;
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
}
