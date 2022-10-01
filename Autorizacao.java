import java.time.LocalDate;

public class Autorizacao implements Comparable<Autorizacao>{

    private int codigo;
    private LocalDate date;
    private Medico medico;
    private Paciente paciente;
    private enumExame exame;

    public Autorizacao(int codigo, LocalDate date, Medico medico, Paciente paciente, enumExame exame) {
        this.codigo = codigo;
        this.date = date;
        this.medico = medico;
        this.paciente = paciente;
        this.exame = exame;
    }

    public int getCodigo() {
        return codigo;
    }

    public LocalDate getDate() {
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

    @Override
    public int compareTo(Autorizacao o) {
        return getDate().compareTo(o.getDate());
    }


    @Override
    public String toString() {
        return "Autorizacao{" +
                "codigo=" + codigo +
                ", date=" + date +
                ", medico=" + medico +
                ", paciente=" + paciente +
                ", exame=" + exame +
                '}';
    }
}
