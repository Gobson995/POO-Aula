import java.util.*;

// etiquetas
enum Quadrante {
    PRIMEIRO, SEGUNDO, TERCEIRO, QUARTO
}

public class Matriz<T> {
    private int linhas;
    private int colunas;
    private Object[][] elementos;

    public Matriz(int n, int m) {
        this.linhas = n;
        this.colunas = m;
        this.elementos = new Object[n][m];
    }

    public boolean set(T objeto, int i, int j) {
        if (i >= 0 && i < linhas && j >= 0 && j < colunas) {
            elementos[i][j] = objeto;
            return true;
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public T get(int i, int j) {
        if (i >= 0 && i < linhas && j >= 0 && j < colunas) {
            return (T) elementos[i][j];
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public List<T> getLinha(int linha) {
        List<T> listaLinha = new ArrayList<>();
        if (linha >= 0 && linha < linhas) {
            for (int j = 0; j < colunas; j++) {
                listaLinha.add((T) elementos[linha][j]);
            }
        }
        return  listaLinha;
    }

    @SuppressWarnings("unchecked")
    public List<T> getColuna(int coluna) {
        List<T> listaColuna = new ArrayList<>();
        if (coluna >= 0 && coluna < colunas) {
            for (int i = 0; i < linhas; i++) {
                listaColuna.add((T) elementos[i][coluna]);
            }
        }
        return listaColuna;
    }

    @SuppressWarnings("unchecked")
    public List<T> getElementosQuadrante(Quadrante quadrante) {
        List<T> lista = new ArrayList<>();

        int metadeLinhas = (linhas + 1) / 2;
        int metadeColunas = (colunas + 1) / 2;

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {

                if (quadrante == Quadrante.PRIMEIRO) {
                    if (i < metadeLinhas && j < metadeColunas) {
                        lista.add((T) elementos[i][j]);
                    }
                } 
                else if (quadrante == Quadrante.SEGUNDO) {
                    if (i < metadeLinhas && j >= metadeColunas) {
                        lista.add((T) elementos[i][j]);
                    }
                } 
                else if (quadrante == Quadrante.TERCEIRO) {
                    if (i >= metadeLinhas && j < metadeColunas) {
                        lista.add((T) elementos[i][j]);
                    }
                } 
                else if (quadrante == Quadrante.QUARTO) {
                    if (i >= metadeLinhas && j >= metadeColunas) {
                        lista.add((T) elementos[i][j]);
                    }
                }   
            }
        }
        return lista;
    }
}


