package apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;

import dados.*;

public class Calculadora extends JFrame {

    private JPanel painel = new JPanel();
    private JPanel painelEntrada = new JPanel();
    private JPanel painelGeradores = new JPanel();
    private JScrollPane scrollResultados = new JScrollPane();
    private JScrollPane scrollValores = new JScrollPane();

    private JLabel infoCaixaEntrada = new JLabel("Digite um valor:");
    private JTextField caixaEntrada = new JTextField();
    private JTextField caixaQuantidade = new JTextField();

    private JButton botaoAdicionar = new JButton("adicionar");
    private JButton botaoLimpar = new JButton("limpar");
    private JButton botaoPrimos = new JButton("Primos");
    private JButton botaoPerfeitos = new JButton("Perfeitos");
    private JButton botaoQuadrados = new JButton("Quadrados");

    private JTable tabelaValores;
    private JTable tabelaResultados;

    private TabelaResultados resultados = new TabelaResultados();
    private TabelaValores valores = new TabelaValores();

    public Calculadora() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(300, 300, 900, 300);
        setResizable(false);
        setTitle("Calculadora Estatística");

        setContentPane(painel);
        painel.setLayout(null);

        scrollResultados.setBounds(10, 10, 880, 50);
        tabelaResultados = new JTable(resultados);
        scrollResultados.setViewportView(tabelaResultados);
        painel.add(scrollResultados);

        painelEntrada.setBounds(15, 75, 280, 180);
        painelEntrada.setLayout(null);
        painelEntrada.setBorder(BorderFactory.createLineBorder(java.awt.Color.GRAY, 1));
        painel.add(painelEntrada);

        infoCaixaEntrada.setBounds(30, 25, 200, 15);
        painelEntrada.add(infoCaixaEntrada);

        caixaEntrada.setBounds(30, 45, 200, 22);
        painelEntrada.add(caixaEntrada);

        botaoAdicionar.setBounds(77, 85, 117, 25);
        painelEntrada.add(botaoAdicionar);

        botaoLimpar.setBounds(77, 118, 117, 25);
        painelEntrada.add(botaoLimpar);

        scrollValores.setBounds(307, 75, 173, 180);
        tabelaValores = new JTable(valores);
        scrollValores.setViewportView(tabelaValores);
        painel.add(scrollValores);

        painelGeradores.setBounds(495, 75, 190, 180);
        painelGeradores.setLayout(null);
        painelGeradores.setBorder(BorderFactory.createTitledBorder("Gerar Valores"));
        painel.add(painelGeradores);

        caixaQuantidade.setBounds(30, 30, 130, 22);
        painelGeradores.add(caixaQuantidade);

        botaoPrimos.setBounds(30, 65, 130, 25);
        painelGeradores.add(botaoPrimos);

        botaoPerfeitos.setBounds(30, 97, 130, 25);
        painelGeradores.add(botaoPerfeitos);

        botaoQuadrados.setBounds(30, 129, 130, 25);
        painelGeradores.add(botaoQuadrados);

        botaoAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int val = Integer.parseInt(caixaEntrada.getText().trim());
                    valores.adicionarValor(val);
                    resultados.atualizar();
                    caixaEntrada.setText("");
                } catch (NumberFormatException ex) {
                    System.out.println("Valor invalido: digite um numero inteiro.");
                    caixaEntrada.setText("");
                }
            }
        });

        botaoLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                valores.limpar();
                resultados.atualizar();
                caixaEntrada.setText("");
            }
        });

        botaoPrimos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gerarSequencia(new Primos());
            }
        });

        botaoPerfeitos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gerarSequencia(new Perfeitos());
            }
        });

        botaoQuadrados.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gerarSequencia(new Quadrados());
            }
        });
    }

    private void gerarSequencia(Gerador gerador) {
        try {
            int qtd = Integer.parseInt(caixaQuantidade.getText().trim());
            gerador.gerar(qtd);
            for (int val : gerador.getSequencia()) {
                valores.adicionarValor(val);
            }
            resultados.atualizar();
            caixaQuantidade.setText("");
        } catch (NumberFormatException ex) {
            System.out.println("Quantidade invalida: digite um numero inteiro.");
            caixaQuantidade.setText("");
        }
    }

    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        calc.setVisible(true);
    }
}