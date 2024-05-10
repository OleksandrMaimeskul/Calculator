
package Service;

import java.awt.*;
import java.awt.event.*;

public class Background implements ActionListener {
    TextField textField;
    private final ExpressionEvaluator evaluator = new ExpressionEvaluator();

    public void calculator() {
        Frame frame = new Frame("Calculator");
        frame.setLayout(new BorderLayout());

        textField = new TextField(20);
        frame.add(textField, BorderLayout.NORTH);

        Panel panel = new Panel(new GridLayout(4, 4));

        String[] buttons = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", "CLR", "=", "+"};

        for (String text : buttons) {
            Button button = new Button(text);
            button.addActionListener(this);
            panel.add(button);
        }

        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(250, 250);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("CLR")) {
            textField.setText("");
        } else if (command.equals("=")) {
            try {
                String expression = textField.getText().trim();
                if (expression.isEmpty()) {
                    textField.setText("Expression is empty");
                    return;
                }
                double result = evaluator.evaluateExpression(textField.getText().trim());
                textField.setText(Double.toString(result));
            } catch (Exception ex) {
                textField.setText("Error evaluating expression");
            }
        } else {
            textField.setText(textField.getText() + command);
        }
    }
}
