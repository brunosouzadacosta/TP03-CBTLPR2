import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora extends JFrame {
    private JTextField txtResultado;
    private double num1, num2, resultado;
    private String operador;

    public Calculadora() {
        setTitle("Calculadora");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        txtResultado = new JTextField();
        txtResultado.setEditable(false);
        add(txtResultado, BorderLayout.NORTH);

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(5, 5));

        String[] botoes = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C"
        };

        for (String texto : botoes) {
            JButton botao = new JButton(texto);
            botao.addActionListener(new BotaoClickListener());
            painel.add(botao);
        }

        add(painel, BorderLayout.CENTER);
    }

    private class BotaoClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String comando = e.getActionCommand();

            try {
                switch (comando) {
                    case "C":
                        txtResultado.setText("");
                        num1 = num2 = resultado = 0;
                        operador = "";
                        break;
                    case "=":
                        num2 = Double.parseDouble(txtResultado.getText());
                        calcular();
                        txtResultado.setText(String.valueOf(resultado));
                        break;
                    case "+":
                    case "-":
                    case "*":
                    case "/":
                        num1 = Double.parseDouble(txtResultado.getText());
                        operador = comando;
                        txtResultado.setText("");
                        break;
                    default:
                        txtResultado.setText(txtResultado.getText() + comando);
                        break;
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Entrada inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            } finally {
                System.out.println("Execução do cálculo finalizada.");
            }
        }
    }

    private void calcular() {
        switch (operador) {
            case "+":
                resultado = num1 + num2;
                break;
            case "-":
                resultado = num1 - num2;
                break;
            case "*":
                resultado = num1 * num2;
                break;
            case "/":
                if (num2 == 0) {
                    resultado = 0;
                } else {
                    resultado = num1 / num2;
                }
                break;
            default:
                throw new UnsupportedOperationException("Operação desconhecida.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Calculadora calc = new Calculadora();
            calc.setVisible(true);
        });
    }
}