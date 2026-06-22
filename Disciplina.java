package sistemaAcademico;
import sistemaAcademico.interfaces.*;

public class Disciplina implements LinhaObjeto<Disciplina> {
    private String codigo;
    private String nome;
    private int cargaHoraria;
    public Disciplina(String codigo, String nome, int cargaHoraria) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    @Override
    public String toString() {
        return codigo + ";" + nome + ";" + cargaHoraria;
    }
    public static Disciplina toObject(String linha) {
        String[] campos = linha.split(";");
        String codigo = campos[0];
        String nome = campos[1];
        int cargaHoraria = Integer.parseInt(campos[2]);
        return new Disciplina(codigo, nome, cargaHoraria);
    }
}