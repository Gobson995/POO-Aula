package persistencia;

import exceptions.*;
import java.util.*;
import java.io.*;

public class EditorTexto {
    public void gravaTexto(String caminho, List<String> dados) throws ErroNaEscritaException {
        Writer arquivo;

        try {
            arquivo = new FileWriter(caminho);
            for (String i : dados) {
                arquivo.write(i + "\n");
            }
            arquivo.close();
        }
        catch (IOException e) {
            ErroNaEscritaException eg = new ErroNaEscritaException("Não foi possivel abrir o arquivo");
            eg.setCaminho(caminho);
            throw eg;
        }
    }

    public List<String> leTexto (String caminho) throws ErroNaLeituraException{
        List<String> dados = new ArrayList<String>();

        Reader arquivo;
        Scanner r;

        try {
            arquivo = new FileReader(caminho);
            r = new Scanner(arquivo);

            while (r.hasNextLine()) {
                dados.add(r.nextLine());
            }

            arquivo.close();
        }
        catch (IOException e) {
            ErroNaLeituraException al = new ErroNaLeituraException("Erro na leitura do arquivo.");
            al.setCaminho(caminho);
            throw al;
        }

        return dados;
    }
}
