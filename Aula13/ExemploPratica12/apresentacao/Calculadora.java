package apresentacao;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Calculadora extends JFrame{
    private JPanel painel = new JPanel();

    private JPanel painelEntrada = new JPanel();
    private JScrollPane painelScrollTabelaResultados = new JScrollPane();
    private JScrollPane painelScrollTabelaValores = new JScrollPane();

    private JLabel infoCaixaEntrada = new JLabel("Digite um valor");
    private JTextField caixaEntrada = new JTextField();

    private JButton botaoAdicionar = new JButton("Adicionar");
    private JButton botaoLimpar = new JButton("Limpar");
    private JButton botaoTirar = new JButton("Tirar Ultimo");

    private JTable tabelaValores;
    private JTable tabelaResultados;

    public Calculadora() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 300, 900, 300);
        setResizable(false);
        setTitle("Calculadora Estatistica - PRO");

        this.setContentPane(painel);
        painel.setLayout(null);

        painelEntrada.setBounds(15, 80, 200, );
    }
}
