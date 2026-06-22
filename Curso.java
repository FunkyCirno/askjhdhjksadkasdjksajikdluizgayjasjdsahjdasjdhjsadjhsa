package sistemaAcademico;

import java.util.ArrayList;
import java.util.List;
import sistemaAcademico.interfaces.*;
public class Curso implements LinhaObjeto<Curso> {

    private String nome;
    private int codigo;
    private int duracaoAno;
    private List<Disciplina> disciplinas;
    public String[] codigosDisciplinasPendentes;

    public Curso() {
        this.disciplinas = new ArrayList<>();
    }

    public Curso(String nome, int codigo, int duracaoAno) {
        this.nome = nome;
        this.codigo = codigo;
        this.duracaoAno = duracaoAno;
        this.disciplinas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getDuracaoAno() {
        return duracaoAno;
    }

    public void setDuracaoAno(int duracaoAno) {
        this.duracaoAno = duracaoAno;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void adicionarDisciplina(Disciplina d) {
        this.disciplinas.add(d);
    }
    @Override
    public String toString() {
        StringBuilder codigosDisciplinas = new StringBuilder();
        for (int i = 0; i < disciplinas.size(); i++) {
            codigosDisciplinas.append(disciplinas.get(i).getCodigo());
            if (i < disciplinas.size() - 1) {
                codigosDisciplinas.append(",");
            }
        }
        return nome + ";" + codigo + ";" + duracaoAno + ";" + codigosDisciplinas;
    }
    public static Curso toObject(String linha) {
        String[] campos = linha.split(";", -1);
        String nome = campos[0];
        int codigo = Integer.parseInt(campos[1]);
        int duracaoAno = Integer.parseInt(campos[2]);
        Curso curso = new Curso(nome, codigo, duracaoAno);
        if (campos.length > 3 && !campos[3].isEmpty()) {
            curso.codigosDisciplinasPendentes = campos[3].split(",");
        }
        return curso;
    }
}