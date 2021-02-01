package moneycalculator.control;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import moneycalculator.model.Currency;
import moneycalculator.model.CurrencyList;
import moneycalculator.swing.SwingMoneyDialog;
import moneycalculator.swing.SwingMoneyDisplay;
import moneycalculator.ui.MoneyDialog;
import moneycalculator.ui.MoneyDisplay;

public class MoneyCalculatorFrame extends JFrame{
    private final Currency[] currencies;
    private final Map<String, Command> commands = new HashMap<>();
    private MoneyDialog moneyDialog;
    private MoneyDisplay moneyDisplay;

    public MoneyCalculatorFrame(Currency[] currencies) {
        this.currencies = currencies;
        this.setTitle("Money Calculator");
        this.setSize(400, 150);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(toolbar(), BorderLayout.SOUTH);
        this.add(moneyDialog(), BorderLayout.NORTH);
        this.add(moneyDisplay(), BorderLayout.CENTER);
        this.setVisible(true);
    }
    
    public MoneyDialog getMoneyDialog() {
        return moneyDialog;
    }

    public MoneyDisplay getMoneyDisplay() {
        return moneyDisplay;
    }

    public void add(Command command) {
        commands.put(command.name(), command);
    }
    
    private Component toolbar() {
        JPanel panel = new JPanel();
        panel.add(calculateButton());
        return panel;
    }

    private Component moneyDialog() {
        SwingMoneyDialog dialog = new SwingMoneyDialog(currencies);
        moneyDialog = dialog;
        return dialog;
    }

    private Component moneyDisplay() {
        SwingMoneyDisplay display = new SwingMoneyDisplay();
        moneyDisplay = display;
        return display;
    }


    private JButton calculateButton() {
        JButton button = new JButton("Calculate");
        button.addActionListener(calculate());
        return button;
    }

    private ActionListener calculate() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                commands.get("calculate").execute();
            }
        };
    }
     
}
