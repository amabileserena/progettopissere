package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AmministratoreView extends JFrame implements ActionListener {

    // Credenziali connessione al DB MyShop:
    String username_db = "root";
    String password_db = "Davide$2001";

    public AmministratoreView() {
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocation(250, 150);
        setVisible(true);
    }

    private void initComponents() {
        setTitle("Pagina AMMINISTRATORE");
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JLabel label1 = new JLabel("BENVENUTO AMMINISTRATORE, cosa vorresti fare?");
        label1.setFont(new Font("Segoe UI", Font.BOLD, 16));
        topPanel.add(label1);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 2, 10, 10));
        JButton button1 = createButton("Gestione Catalogo");
        JButton button2 = createButton("Inserisci un Prodotto/Servizio");
        JButton button3 = createButton("Inserisci una Categoria");
        JButton button4 = createButton("Inserisci Produttore/Fornitore");
        JButton button5 = createButton("Registra un Punto Vendita");
        JButton button6 = createButton("Aggiungi Manager");
        JButton button7 = createButton("Gestisci Manager");
        JButton button8 = createButton("Elimina UTENTE");
        JButton button9 = createButton("Esci");
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button4);
        buttonPanel.add(button5);
        buttonPanel.add(button6);
        buttonPanel.add(button7);
        buttonPanel.add(button8);
        buttonPanel.add(button9);

        add(topPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.addActionListener(this);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AbstractButton button9 = null;
        if (e.getActionCommand() == button9.getActionCommand()) {
            int risp = JOptionPane.showConfirmDialog(this, "Sei sicuro di voler uscire?", "Avviso", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (risp == JOptionPane.YES_OPTION) {
                setVisible(false);
                new HomePage();
            }
        }
        // ... Altri handler degli eventi per i pulsanti ...
    }

    // Il resto del codice per la gestione degli eventi dei pulsanti e l'interazione con il database rimane invariato.

   public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AmministratoreView();
        });
    }
}

