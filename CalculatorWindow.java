import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorWindow extends JFrame implements ActionListener {
    private JTextField textField;
    private double num1, num2, result;
    private char operator;

    public CalculatorWindow() {
        setTitle("계산기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5));

        textField = new JTextField();
        textField.setEditable(false);
        panel.add(textField);

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };

        for (String button : buttons) {
            JButton btn = new JButton(button);
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel);
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("=")) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }

            textField.setText(Double.toString(result));
        } else if (command.equals("C")) {
            textField.setText("");
        } else if (command.equals(".")) {
            if (!textField.getText().contains(".")) {
                textField.setText(textField.getText() + ".");
            }
        } else {
            num1 = Double.parseDouble(textField.getText());
            operator = command.charAt(0);
            textField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalculatorWindow();
            }
        });
    }
}
