package sistemaAcademico.execoes;
public class ObjetoNaoEncontradoException extends Exception {
    private static final long serialVersionUID = 1L;
    public ObjetoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}