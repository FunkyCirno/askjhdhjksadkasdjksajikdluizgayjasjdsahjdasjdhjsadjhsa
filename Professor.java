package sistemaAcademico;
import sistemaAcademico.interfaces.*;

public class Professor extends Pessoa implements LinhaObjeto<Professor> {

    private String siape;
    private String titulacao;
    private double salario;
    public Professor() {
        super();
    }
    public Professor(String nome, String cpf, String siape, String titulacao, double salario) {
        super(nome, cpf);
        this.siape = siape;
        this.titulacao = titulacao;
        this.salario = salario;
    }
    public String getSiape() {
        return siape;
    }
    public void setSiape(String siape) {
        this.siape = siape;
    }
    public String getTitulacao() {
        return titulacao;
    }
    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
    @Override
    public void exibirdados() {
        System.out.println("Professor: " + nome + " | CPF: " + cpf + " | SIAPE: " + siape
                + " | Titulacao: " + titulacao + " | Salario: " + salario);
    }
    public void calcularBonus() {
        if (titulacao == null) {
            return;
        }
        switch (titulacao.toLowerCase()) {
            case "doutor":
                salario *= 1.20;
                break;
            case "mestre":
                salario *= 1.10;
                break;
            default:
                salario *= 1.05;
                break;
        }
    }
    @Override
    public String toString() {
        return nome + ";" + cpf + ";" + siape + ";" + titulacao + ";" + salario;
    }
    public static Professor toObject(String linha) {
        String[] campos = linha.split(";", -1);
        Professor professor = new Professor();
        professor.setNome(campos[0]);
        professor.setCpf(campos[1]);
        professor.setSiape(campos[2]);
        professor.setTitulacao(campos[3]);
        professor.setSalario(Double.parseDouble(campos[4]));
        return professor;
    }
}