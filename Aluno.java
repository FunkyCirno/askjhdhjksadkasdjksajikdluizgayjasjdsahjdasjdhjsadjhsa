package sistemaAcademico;
import java.util.List;

import sistemaAcademico.interfaces.*;

public class Aluno extends Pessoa implements LinhaObjeto<Aluno> {

    private String matricula;
    private Curso curso;
    private int semestre;
    public int codigoCursoPendente = -1;

    public Aluno() {
        super();
    }

    public Aluno(String nome, String cpf, String matricula, Curso curso, int semestre) {
        super(nome, cpf);
        this.matricula = matricula;
        this.curso = curso;
        this.semestre = semestre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    @Override
    public void exibirdados() {
        System.out.println("Aluno: " + nome + " | CPF: " + cpf + " | Matricula: " + matricula +
                " | Curso: " + (curso != null ? curso.getNome() : "N/D") + " | Semestre: " + semestre);
    }

    public double calcularIRA(List<NotasDisciplinas> todasAsNotas) {
        double soma = 0;
        int cont = 0;
        for (NotasDisciplinas notaDisciplina : todasAsNotas) {
            if (notaDisciplina.getAluno() != null && this.matricula.equals(notaDisciplina.getAluno().getMatricula())) {
                soma += notaDisciplina.getNota();
                cont++;
            }
        }
        return cont == 0 ? 0.0 : soma / cont;
    }

    @Override
    public String toString() {
        int cdCurso = (curso != null) ? curso.getCodigo() : -1;
        return nome + ";" + cpf + ";" + matricula + ";" + cdCurso + ";" + semestre;
    }

    public static Aluno toObject(String linha) {
        String[] campos = linha.split(";", -1);
        Aluno aluno = new Aluno();
        aluno.setNome(campos[0]);
        aluno.setCpf(campos[1]);
        aluno.setMatricula(campos[2]);
        aluno.codigoCursoPendente = Integer.parseInt(campos[3]);
        aluno.setSemestre(Integer.parseInt(campos[4]));
        return aluno;
    }
}
