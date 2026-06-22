package sistemaAcademico.interfaces;
@FunctionalInterface
public interface ConversorLinha<T> {
    T converter(String linha);
}