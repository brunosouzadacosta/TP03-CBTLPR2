import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPessoa extends JFrame {
    private JTextField nomeField;
    private JTextField idadeField;
    private JTextField sexoField;
    private JTextField numeroField;
    private JButton okButton;
    private JButton mostrarButton;
    
    private Pessoa umaPessoa;
    
    public FormPessoa() {
        setTitle("Cadastro de Pessoa");

        setLayout(new GridLayout(5, 2, 10, 10));

        add(new JLabel("Número:"));
        numeroField = new JTextField();
        numeroField.setEditable(false);
        add(numeroField);

        add(new JLabel("Nome:"));
        nomeField = new JTextField();
        add(nomeField);

        add(new JLabel("Sexo (M/F):"));
        sexoField = new JTextField();
        add(sexoField);

        add(new JLabel("Idade:"));
        idadeField = new JTextField();
        add(idadeField);

        okButton = new JButton("OK");
        mostrarButton = new JButton("Mostrar");

        add(okButton);
        add(mostrarButton);

        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = nomeField.getText();
                char sexo = sexoField.getText().charAt(0); 
                int idade = Integer.parseInt(idadeField.getText());

                umaPessoa = new Pessoa(nome, sexo, idade);

                numeroField.setText(String.valueOf(umaPessoa.getKp()));

                nomeField.setText("");
                sexoField.setText("");
                idadeField.setText("");
            }
        });

        mostrarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (umaPessoa != null) {
                    JOptionPane.showMessageDialog(null, 
                        "Número: " + umaPessoa.getKp() + "\n" +
                        "Nome: " + umaPessoa.getNome() + "\n" +
                        "Sexo: " + umaPessoa.getSexo() + "\n" +
                        "Idade: " + umaPessoa.getIdade(),
                        "Dados da Pessoa", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhuma pessoa cadastrada.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null); 
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FormPessoa().setVisible(true);
            }
        });
    }
}