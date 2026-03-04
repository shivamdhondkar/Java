import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

// 1. Data Model: Account Class
class Account {
    private String accountNumber;
    private String name;
    private String password;
    private double balance;
    private List<String> transactions;

    public Account(String name, String password, double initialDeposit) {
        this.accountNumber = "AC" + (1000 + new Random().nextInt(9000));
        this.name = name;
        this.password = password;
        this.balance = initialDeposit;
        this.transactions = new ArrayList<>();
        addTransaction("Initial Deposit: $" + initialDeposit);
    }

    // Getters and Business Logic
    public String getAccountNumber() { return accountNumber; }
    public String getName() { return name; }
    public String getPassword() { return password; }
    public double getBalance() { return balance; }
    public List<String> getTransactions() { return transactions; }

    public void deposit(double amount) {
        balance += amount;
        addTransaction("Deposited: $" + amount + " | Balance: $" + balance);
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            addTransaction("Withdrew: $" + amount + " | Balance: $" + balance);
            return true;
        }
        return false;
    }

    public void addTransaction(String message) {
        transactions.add(new java.util.Date() + " - " + message);
    }
}

// 2. Main Application & UI
public class BankingApp extends JFrame {
    private Map<String, Account> accounts = new HashMap<>();
    private Account currentUser = null;

    // UI Components
    private CardLayout cardLayout = new CardLayout();
    private JPanel mainPanel = new JPanel(cardLayout);

    public BankingApp() {
        setTitle("Secure Bank Prototype");
        setSize(500, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Add Panels
        mainPanel.add(createLoginPanel(), "Login");
        mainPanel.add(createRegisterPanel(), "Register");
        mainPanel.add(createDashboardPanel(), "Dashboard");

        add(mainPanel);
        setVisible(true);
    }

    // --- PANEL: LOGIN ---
    private JPanel createLoginPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        JTextField accField = new JTextField();
        JPasswordField passField = new JPasswordField();
        JButton loginBtn = new JButton("Login");
        JButton goToRegBtn = new JButton("No Account? Register");

        panel.add(new JLabel("Account Number:"));
        panel.add(accField);
        panel.add(new JLabel("Password:"));
        panel.add(passField);
        panel.add(loginBtn);
        panel.add(goToRegBtn);

        loginBtn.addActionListener(e -> {
            Account acc = accounts.get(accField.getText());
            if (acc != null && acc.getPassword().equals(new String(passField.getPassword()))) {
                currentUser = acc;
                cardLayout.show(mainPanel, "Dashboard");
                refreshDashboard();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Credentials!");
            }
        });

        goToRegBtn.addActionListener(e -> cardLayout.show(mainPanel, "Register"));
        return panel;
    }

    // --- PANEL: REGISTER ---
    private JPanel createRegisterPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 2, 5, 5));
        panel.setBorder(BorderFactory.createTitledBorder("User Registration"));

        JTextField nameF = new JTextField();
        JTextField passF = new JTextField();
        JTextField depositF = new JTextField();
        JButton regBtn = new JButton("Register");
        JButton backBtn = new JButton("Back");

        panel.add(new JLabel("Full Name:")); panel.add(nameF);
        panel.add(new JLabel("Password:")); panel.add(passF);
        panel.add(new JLabel("Initial Deposit:")); panel.add(depositF);
        panel.add(backBtn); panel.add(regBtn);

        regBtn.addActionListener(e -> {
            try {
                double dep = Double.parseDouble(depositF.getText());
                Account newAcc = new Account(nameF.getText(), passF.getText(), dep);
                accounts.put(newAcc.getAccountNumber(), newAcc);
                JOptionPane.showMessageDialog(this, "Success! Your Acc No: " + newAcc.getAccountNumber());
                cardLayout.show(mainPanel, "Login");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid Input!");
            }
        });

        backBtn.addActionListener(e -> cardLayout.show(mainPanel, "Login"));
        return panel;
    }

    // --- PANEL: DASHBOARD ---
    private JLabel balLabel = new JLabel();
    private JTextArea stmtArea = new JTextArea(10, 30);

    private JPanel createDashboardPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel(new GridLayout(3, 1));
        
        topPanel.add(new JLabel("Welcome to your Bank Account", SwingConstants.CENTER));
        topPanel.add(balLabel);
        
        JPanel actions = new JPanel();
        JButton depBtn = new JButton("Deposit");
        JButton witBtn = new JButton("Withdraw");
        JButton transBtn = new JButton("Transfer");
        JButton logoutBtn = new JButton("Logout");

        actions.add(depBtn); actions.add(witBtn); 
        actions.add(transBtn); actions.add(logoutBtn);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(new JScrollPane(stmtArea), BorderLayout.CENTER);
        panel.add(actions, BorderLayout.SOUTH);

        // Action Listeners
        depBtn.addActionListener(e -> {
            String amt = JOptionPane.showInputDialog("Enter Deposit Amount:");
            if (amt != null) {
                currentUser.deposit(Double.parseDouble(amt));
                refreshDashboard();
            }
        });

        witBtn.addActionListener(e -> {
            String amt = JOptionPane.showInputDialog("Enter Withdrawal Amount:");
            if (amt != null) {
                if (!currentUser.withdraw(Double.parseDouble(amt))) {
                    JOptionPane.showMessageDialog(this, "Insufficient Funds!");
                }
                refreshDashboard();
            }
        });

        transBtn.addActionListener(e -> {
            String targetAcc = JOptionPane.showInputDialog("Recipient Account Number:");
            String amt = JOptionPane.showInputDialog("Amount to Transfer:");
            if (accounts.containsKey(targetAcc) && amt != null) {
                double val = Double.parseDouble(amt);
                if (currentUser.withdraw(val)) {
                    accounts.get(targetAcc).deposit(val);
                    JOptionPane.showMessageDialog(this, "Transfer Successful!");
                } else {
                    JOptionPane.showMessageDialog(this, "Transfer Failed: Low Balance.");
                }
                refreshDashboard();
            } else {
                JOptionPane.showMessageDialog(this, "Recipient Not Found!");
            }
        });

        logoutBtn.addActionListener(e -> cardLayout.show(mainPanel, "Login"));

        return panel;
    }

    private void refreshDashboard() {
        if (currentUser != null) {
            balLabel.setText("Account: " + currentUser.getAccountNumber() + " | Balance: $" + currentUser.getBalance());
            stmtArea.setText("--- Transaction History ---\n");
            for (String s : currentUser.getTransactions()) {
                stmtArea.append(s + "\n");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BankingApp::new);
    }
}