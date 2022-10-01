import javax.xml.crypto.Data;

public class Autorizacao {

    private int codigo;
    private Data date;
    private Medico medico;
    private Paciente paciente;
    private enumExame exame;

    public Autorizacao(int codigo, Data date, Medico medico, Paciente paciente, enumExame exame) {
        this.codigo = codigo;
        this.date = date;
        this.medico = medico;
        this.paciente = paciente;
        this.exame = exame;
    }

    public int getCodigo() {
        return codigo;
    }

    public Data getDate() {
        return date;
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
