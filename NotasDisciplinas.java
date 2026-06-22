package sistemaAcademico;
import sistemaAcademico.interfaces.*;

public class NotasDisciplinas implements LinhaObjeto<NotasDisciplinas> {

    private Aluno aluno;
    private Disciplina disciplina;
    private double nota;

    public NotasDisciplinas() {
    }

    public NotasDisciplinas(Aluno aluno, Disciplina disciplina, double nota) {
        this.aluno = aluno;
        this.disciplina = disciplina;
        this.nota = nota;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
    @Override
    public String toString() {
        String matricula = (aluno != null) ? aluno.getMatricula() : "";
        String codigoDisciplina = (disciplina != null) ? disciplina.getCodigo() : "";
        return matricula + ";" + codigoDisciplina + ";" + nota;
    }
    public static NotasDisciplinas toObject(String linha) {
        String[] campos = linha.split(";", -1);
        NotasDisciplinas notasdisciplina = new NotasDisciplinas();
        notasdisciplina.matriculaPendente = campos[0];
        notasdisciplina.codigoDisciplinaPendente = campos[1];
        notasdisciplina.setNota(Double.parseDouble(campos[2]));
        return notasdisciplina;
    }

    public String matriculaPendente;
    public String codigoDisciplinaPendente;
}