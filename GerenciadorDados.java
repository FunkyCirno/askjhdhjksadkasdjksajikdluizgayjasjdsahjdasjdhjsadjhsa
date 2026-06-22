package sistemaAcademico;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import sistemaAcademico.interfaces.*;
public class GerenciadorDados<T extends LinhaObjeto<T>> {

    public void salvarDados(String caminho, List<T> lista) throws IOException {
        File arquivo = new File(caminho);
        File diretorioPai = arquivo.getParentFile();
        if (diretorioPai != null && !diretorioPai.exists()) {
            diretorioPai.mkdirs();
        }
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivo, false))) {
            for (T item : lista) {
                escritor.write(item.toString());
                escritor.newLine();
            }
        }
    }
    public List<T> carregarDados(String caminho, ConversorLinha<T> conversor) throws IOException {
        List<T> lista = new ArrayList<>();
        File arquivo = new File(caminho);
        if (!arquivo.exists()) {
            return lista;
        }
        try (BufferedReader leitor = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                if (!linha.trim().isEmpty()) {
                    lista.add(conversor.converter(linha));
                }
            }
        }
        return lista;
    }
}