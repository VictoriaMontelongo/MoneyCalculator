package moneycalculator.control;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import moneycalculator.model.Currency;
import moneycalculator.swing.SwingMoneyDialog;
import moneycalculator.swing.SwingMoneyDisplay;

public class MoneyCalculatorFrame extends JFrame{
    private final List<Currency> currencies;
    private SwingMoneyDialog moneyDialog;
    private SwingMoneyDisplay moneyDisplay;
    private final Map<String, Command> commands = new HashMap<>();

    public MoneyCalculatorFrame(List<Currency> currencies) {
        this.currencies = currencies;
        setTitle("Money Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400, 200);
        getContentPane().setLayout(new BorderLayout());
        initializeMoneyDialog();
        initializeMoneyDisplay();
        initializeButtons();
    }

    private void initializeMoneyDialog() {
        getContentPane().add(getMoneyDialog(), BorderLayout.NORTH);
    }

    private void initializeMoneyDisplay() {
        getContentPane().add(getMoneyDisplay(), BorderLayout.SOUTH);
    }

    private void initializeButtons() {
        JPanel buttonPanel = new JPanel();
        JButton acceptButton = new JButton("Accept");
        JButton deleteButton = new JButton("Delete");
        acceptButton.addActionListener(accept());
        deleteButton.addActionListener(delete());
        buttonPanel.add(acceptButton);
        buttonPanel.add(deleteButton);
        getContentPane().add(buttonPanel, BorderLayout.CENTER);
    }
    
    public void execute() {
        setVisible(true);
    }

    private Component getMoneyDialog() {
        SwingMoneyDialog dialog  = new SwingMoneyDialog(currencies);
        moneyDialog = dialog;
        return dialog;
    }

    private Component getMoneyDisplay() {
        SwingMoneyDisplay display  = new SwingMoneyDisplay();
        moneyDisplay = display;
        return display;
    }

    private ActionListener accept() {
         return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get("Calculate").execute();
            }
        };
    }

    private ActionListener delete() {
         
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get("Delete").execute();
            }
        };
    }
}
