import javax.swing.JFrame;
//import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.TextField;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
        MeuFrame meuFrame = new MeuFrame();
        meuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        meuFrame.setResizable(false);

        //JPanel painel1 = new JPanel();
        //meuFrame.setContentPane(painel1);
        //JPanel painel2 = new JPanel();

        JButton button1 = new JButton("Botao 1");
        meuFrame.add(button1, BorderLayout.NORTH);
        JButton button2 = new JButton("Botao 2");
        meuFrame.add(button2, BorderLayout.CENTER);
        JButton button3 = new JButton("Botao 3");
        meuFrame.add(button3, BorderLayout.SOUTH);

        TextField temp = new TextField("Digite aqui o seu valor");
        meuFrame.add(temp);

        button3.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent arg0) {
                    temp.setText("Hello Word");
                }
            }
        );



        //meuFrame.add(painel1, BorderLayout.NORTH);
        //meuFrame.add(painel2, BorderLayout.NORTH);
        
        meuFrame.setVisible(true);
    }
}
