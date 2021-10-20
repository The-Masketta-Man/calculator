import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainForm extends JFrame{
    private JPanel panel1;
    private JLabel equalsSign;
    private JTextField operand1Field;
    private JTextField operand2Field;
    private JComboBox operationBox;
    private JTextField resultField;
    private JPanel mainPanel;
    private JButton calculateButton;

    public MainForm() {
        super();
        this.setContentPane(mainPanel);
        setVisible(true);
        operationBox.addItem("+");
        operationBox.addItem("-");
        operationBox.addItem("*");
        operationBox.addItem("/");
        initButtons();
        setLocation(0, 0);
        setTitle("Calculator");
        setMinimumSize(new Dimension(500, 100));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private void initButtons() {
        calculateButton.addActionListener(e -> {
            BigDecimal result = null;
            try{
            switch (operationBox.getSelectedIndex()){
                case 0:
                    result = BigDecimal.valueOf(Double.parseDouble(operand1Field.getText())).add(BigDecimal.valueOf(Double.parseDouble(operand2Field.getText())));
                    break;
                case 1:
                    result = BigDecimal.valueOf(Double.parseDouble(operand1Field.getText())).subtract(BigDecimal.valueOf(Double.parseDouble(operand2Field.getText())));
                    break;
                case 2:
                    result = BigDecimal.valueOf(Double.parseDouble(operand1Field.getText())).multiply(BigDecimal.valueOf(Double.parseDouble(operand2Field.getText())));
                    break;
                case 3:
                    result = BigDecimal.valueOf(Double.parseDouble(operand1Field.getText())).divide(BigDecimal.valueOf(Double.parseDouble(operand2Field.getText())), 10, RoundingMode.DOWN);
                    break;
            }
            resultField.setText(String.valueOf(result));
            }
            catch (NumberFormatException | ArithmeticException ex){
                resultField.setText("NaN");
            }
        });
    }
}
