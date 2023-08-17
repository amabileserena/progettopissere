/*package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class ArticoloView extends JFrame implements ActionListener {

    //credenziali connessione al DB MyShop:
    String username_db = "root";
    String password_db = "Davide$2001";

    public void display () {

        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        textField1 = new JTextField();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        label7 = new JLabel();
        label8 = new JLabel();
        textField3 = new JTextField();
        label9 = new JLabel();
        textField4 = new JTextField();
        label10 = new JLabel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        button3 = new JButton();
        button4 = new JButton();
        textField5 = new JTextField();

        comboBox1 = new JComboBox<>();
        comboBox2 = new JComboBox<>();
        comboBox3 = new JComboBox<>();
        comboBox4 = new JComboBox<>(insert);
        comboBox5 = new JComboBox<>(categorieProdotti);
        comboBox6 = new JComboBox<>(categorieServizi);
        comboBox7 = new JComboBox<>(produttori);
        comboBox8 = new JComboBox<>(fornitori);
        comboBox9= new JComboBox<>(puntiVendita);
        comboBox10 = new JComboBox<>(puntiFornitori);

        //======== this ========
        setTitle("Nuovo ");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("Stai inserendo un ");
        contentPane.add(label1);
        label1.setBounds(280,-10,250,80);

        //---- label2 ----
        label2.setText("Creazione di un  ");
        label2.setFont(new Font("Segoe UI", Font.BOLD, 17));
        contentPane.add(label2);
        label2.setBounds(350,20,400,100);

        //---- label3 ----
        label3.setText("Nome ");
        contentPane.add(label3);
        label3.setBounds(129, 120, 120, 16);
        contentPane.add(textField1);
        textField1.setBounds(330, 210, 140, textField1.getPreferredSize().height);

        //---- label4 ----
        label4.setText("Prezzo (EURO) ");
        contentPane.add(label4);
        label4.setBounds(135, 190, label4.getPreferredSize().width, 16);

        //---- label5 ----
        label5.setText("Categoria");
        contentPane.add(label5);
        label5.setBounds(new Rectangle(new Point(150, 255), label5.getPreferredSize()));

        //---- label6 ----
        label6.setText("Produttore/Fornitore");
        contentPane.add(label6);
        label6.setBounds(new Rectangle(new Point(120, 315), label6.getPreferredSize()));

        //---- button1 ----
        button1.setText("Aggiungi Foto");
        contentPane.add(button1);
        button1.setBounds(700, 105, 145, button1.getPreferredSize().height);
        button1.addActionListener(this);

        //---- button2 ----
        button2.setText("Rimuovi tutte le Foto");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(700, 145), button2.getPreferredSize()));
        button2.addActionListener(this);

        //---- label7 ----
        label7.setText("Punto Vendita");
        contentPane.add(label7);
        label7.setBounds(new Rectangle(new Point(140, 375), label7.getPreferredSize()));

        //---- label8 ----
        label8.setText("Posizione - Corsia");
        contentPane.add(label8);
        label8.setBounds(new Rectangle(new Point(350, 120), label8.getPreferredSize()));
        contentPane.add(textField3);
        textField3.setBounds(105, 140, 140, textField3.getPreferredSize().height);

        //---- label9 ----
        label9.setText("Posizione - Scaffale");
        contentPane.add(label9);
        label9.setBounds(new Rectangle(new Point(345, 190), label9.getPreferredSize()));
        contentPane.add(textField4);
        textField4.setBounds(330, 140, 140, textField4.getPreferredSize().height);

        //---- label10 ----
        label10.setText("Descrizione (facoltativa)");
        contentPane.add(label10);
        label10.setBounds(new Rectangle(new Point(340, 250), label10.getPreferredSize()));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(textArea1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(335, 275, 300, 145);

        //---- button3 ----
        button3.setText("Crea il ");
        contentPane.add(button3);
        button3.setBounds(700, 355, 145, button3.getPreferredSize().height);
        button3.addActionListener(this);

        //---- button4 ----
        button4.setText("Torna indietro");
        contentPane.add(button4);
        button4.setBounds(700, 390, 145, button4.getPreferredSize().height);
        button4.addActionListener(this);

        contentPane.add(textField5);
        textField5.setBounds(105, 210, 140, textField5.getPreferredSize().height);

        contentPane.add(comboBox1);
        comboBox1.setBounds(105, 275, 150, 20);
        comboBox1.addActionListener(this);

        contentPane.add(comboBox5);
        comboBox5.setBounds(105, 275, 150, 20);
        comboBox5.addActionListener(this);

        contentPane.add(comboBox6);
        comboBox6.setBounds(105, 275, 150, 20);
        comboBox6.addActionListener(this);

        contentPane.add(comboBox2);
        comboBox2.setBounds(105, 335, 150, 20);
        comboBox2.addActionListener(this);

        contentPane.add(comboBox7);
        comboBox7.setBounds(105, 335, 150, 20);
        comboBox7.addActionListener(this);

        contentPane.add(comboBox8);
        comboBox8.setBounds(105, 335, 150, 20);
        comboBox8.addActionListener(this);

        contentPane.add(comboBox3);
        comboBox3.setBounds(105, 395, 150, 20);
        comboBox3.addActionListener(this);

        contentPane.add(comboBox9);
        comboBox9.setBounds(105, 395, 150, 20);
        comboBox9.addActionListener(this);

        contentPane.add(comboBox10);
        comboBox10.setBounds(105, 395, 150, 20);
        comboBox10.addActionListener(this);

        contentPane.add(comboBox4);
        comboBox4.setBounds(470, 20, 150, 20);
        comboBox4.addActionListener(this);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }

        setLocationRelativeTo(getOwner());
        pack();
        setSize(900,500);
        setLocation(250,150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField1;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JButton button1;
    private JButton button2;
    private JLabel label7;
    private JLabel label8;
    private JTextField textField3;
    private JLabel label9;
    private JTextField textField4;
    private JLabel label10;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JButton button3;
    private JButton button4;
    private JTextField textField5;

    private String[] insert = {"Prodotto","Servizio"};
    private String[] categorieProdotti = {"Mobili","Illuminazione","Tessili"};
    private String[] categorieServizi = {"Montaggio","Trasporto"};
    private String[] puntiVendita = {"Bari","Brindisi","Lecce"};
    private String[] puntiFornitori = {"Milano","Como","Foggia"};
    //private Produttore produttore = new Produttore();
    private String[] produttori = {"Davide,nuovarredo.it","Giuseppe,ikea.it","Franco,bynatuzzi.it"};
    private String[] fornitori = {"Branca","Tamborrini SRL","Made in Italy"};

    private JComboBox<String> comboBox1;
    private JComboBox<String> comboBox2;
    private JComboBox<String> comboBox3;
    private JComboBox<String> comboBox4;
    private JComboBox<String> comboBox5;
    private JComboBox<String> comboBox6;
    private JComboBox<String> comboBox7;
    private JComboBox<String> comboBox8;
    private JComboBox<String> comboBox9;
    private JComboBox<String> comboBox10;

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand()==comboBox4.getActionCommand()){
            if(comboBox4.getSelectedItem().equals("Prodotto")){

                setTitle("Nuovo Prodotto");
                label1.setText("Stai inserendo un Prodotto");
                label2.setText("Creazione di un Prodotto");
                label3.setText("Nome Prodotto");

                comboBox3.setVisible(false);
                comboBox9.setVisible(true);
                comboBox10.setVisible(false);

                comboBox1.setVisible(false);
                comboBox2.setVisible(false);
                comboBox6.setVisible(false);
                comboBox8.setVisible(false);

                comboBox5.setVisible(true);
                comboBox7.setVisible(true);

                label8.setVisible(true);
                label9.setVisible(true);

                textField1.setVisible(true);
                textField4.setVisible(true);

                button3.setText("Crea il Prodotto");

                button1.setVisible(true);
                button2.setVisible(true);

            }
            else if(comboBox4.getSelectedItem().equals("Servizio")){

                setTitle("Nuovo Servizio");
                label1.setText("Stai inserendo un Servizio");
                label2.setText("Creazione di un Servizio");
                label3.setText("Nome Servizio");

                comboBox3.setVisible(false);
                comboBox9.setVisible(false);
                comboBox10.setVisible(true);

                comboBox1.setVisible(false);
                comboBox2.setVisible(false);
                comboBox6.setVisible(true);
                comboBox7.setVisible(false);

                comboBox5.setVisible(false);
                comboBox8.setVisible(true);

                button3.setText("Crea il Servizio");

                label8.setVisible(false);
                label9.setVisible(false);

                button1.setVisible(false);
                button2.setVisible(false);

                textField1.setVisible(false);
                textField4.setVisible(false);
            }
        }
        if(e.getActionCommand()==button3.getActionCommand()){
            if(button3.getText().equals("Crea il ")){
                JOptionPane.showMessageDialog(this,"Specificare l'inserimento di un prodotto/servizio");
            }
            else if(button3.getText().equals("Crea il Prodotto")){
                if(textField3.getText().isEmpty()||textField1.getText().isEmpty()||textField4.getText().isEmpty() ||textField5.getText().isEmpty()){
                    JOptionPane.showMessageDialog(this,"Inserisci i campi richiesti");
                }
                else {
                    int value = JOptionPane.showConfirmDialog(this,"Nome: " + textField3.getText() + "\n" +
                            "Prezzo: " + textField5.getText() + " €" + "\n" + "Corsia: " + textField4.getText() + "\n" + "Scaffale: " + textField1.getText() + "\n" +
                            "Descrizione: " + textArea1.getText(),"Dati",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
                    if(value==JOptionPane.YES_OPTION){
                        //DB:
                        try{
                            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myshop",username_db,password_db);
                            double prezzo = Double.parseDouble(textField5.getText());
                            int corsia = Integer.parseInt(textField4.getText());
                            int scaffale = Integer.parseInt(textField1.getText());
                            if(Objects.equals(comboBox9.getSelectedItem(), "Bari")){
                                String sql = "INSERT INTO myshop.prodotto (nome,prezzo,puntovendita,corsia,scaffale,descrizione,foto) VALUES ( '" +
                                        textField3.getText() + "','" + prezzo + "','" + "Bari" + "', '" + corsia + "','" + scaffale + "','" + textArea1.getText() + "','" + "img.jpg" + "');";
                                Statement stmt = conn.createStatement();
                                int x = stmt.executeUpdate(sql);
                                if(x==0){
                                    JOptionPane.showMessageDialog(this,"Questo prodotto esiste già.");
                                }
                                else {
                                    JOptionPane.showMessageDialog(this,"PRODOTTO INSERITO: " + textField3.getText());
                                }
                                //DB:
                                String insert = "INSERT INTO myshop.catalogo (nome,prezzo,descrizione,foto) VALUES ( '" +
                                        textField3.getText() + "','" + prezzo + "','" +  textArea1.getText() + "','" + "img.jpg" + "');";
                                Statement stmt2 = conn.createStatement();
                                int y = stmt2.executeUpdate(insert);
                                if(y==0){
                                    JOptionPane.showMessageDialog(this,"Questo prodotto nel CATALOGO esiste già.");
                                }
                                else {
                                    JOptionPane.showMessageDialog(this,"PRODOTTO INSERITO NEL CATALOGO: " + textField3.getText());
                                    int val = JOptionPane.showConfirmDialog(this,"Proseguire?","Inserimento NUOVO PRODOTTO",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                                    if(val==JOptionPane.NO_OPTION){
                                        setVisible(false);
                                        new AmministratoreView();
                                    }
                                }
                            }
                            else if(Objects.equals(comboBox9.getSelectedItem(), "Brindisi")){
                                String sql = "INSERT INTO myshop.prodotto (nome,prezzo,puntovendita,corsia,scaffale,descrizione,foto) VALUES ( '" +
                                        textField3.getText() + "','" + prezzo + "', '" + "Brindisi" + "', '" + corsia + "','" + scaffale + "','" + textArea1.getText() + "','" + "img.jpg" + "');";
                                Statement stmt = conn.createStatement();
                                int x = stmt.executeUpdate(sql);
                                if(x==0){
                                    JOptionPane.showMessageDialog(this,"Questo prodotto esiste già.");
                                }
                                else {
                                    JOptionPane.showMessageDialog(this,"PRODOTTO INSERITO: " + textField3.getText());
                                }
                                //DB:
                                String insert = "INSERT INTO myshop.catalogo (nome,prezzo,descrizione,foto) VALUES ('" + textField3.getText() + "','" + prezzo + "','" + textArea1.getText() + "','" + "foto.png" + "');";
                                Statement stmt2 = conn.createStatement();
                                int y = stmt2.executeUpdate(insert);
                                if(y==0){
                                    JOptionPane.showMessageDialog(this,"Questo prodotto nel CATALOGO esiste già.");
                                }
                                else {
                                    JOptionPane.showMessageDialog(this,"PRODOTTO INSERITO NEL CATALOGO: " + textField3.getText());
                                    int val = JOptionPane.showConfirmDialog(this,"Proseguire?","Inserimento NUOVO PRODOTTO",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                                    if(val==JOptionPane.NO_OPTION){
                                        setVisible(false);
                                        new AmministratoreView();
                                    }
                                }
                            }
                            else {
                                String sql = "INSERT INTO myshop.prodotto (nome,prezzo,puntovendita,corsia,scaffale,descrizione,foto) VALUES ( '" +
                                        textField3.getText() + "','" + prezzo + "', '" + "Lecce" + "', '" + corsia + "','" + scaffale + "','" + textArea1.getText() + "','" + "img.jpg" + "');";
                                Statement stmt = conn.createStatement();
                                int x = stmt.executeUpdate(sql);
                                if(x==0){
                                    JOptionPane.showMessageDialog(this,"Questo prodotto esiste già.");
                                }
                                else {
                                    JOptionPane.showMessageDialog(this,"PRODOTTO INSERITO: " + textField3.getText());
                                }
                                //DB:
                                String insert = "INSERT INTO myshop.catalogo (nome,prezzo,descrizione,foto) VALUES ('" + textField3.getText() + "','" + prezzo + "','" + textArea1.getText() + "','" + "foto.png" + "');";
                                Statement stmt2 = conn.createStatement();
                                int y = stmt2.executeUpdate(insert);
                                if(y==0){
                                    JOptionPane.showMessageDialog(this,"Questo prodotto nel CATALOGO esiste già.");
                                }
                                else {
                                    JOptionPane.showMessageDialog(this,"PRODOTTO INSERITO NEL CATALOGO: " + textField3.getText());
                                    int val = JOptionPane.showConfirmDialog(this,"Proseguire?","Inserimento NUOVO PRODOTTO",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                                    if(val==JOptionPane.NO_OPTION){
                                        setVisible(false);
                                        new AmministratoreView();
                                    }
                                }
                            }
                            conn.close();
                        }
                        catch(SQLException sqlException) {
                            sqlException.printStackTrace();
                        }

                    }
                }
            }
            else if(button3.getText().equals("Crea il Servizio")){
                if(textField3.getText().isEmpty() ||textField5.getText().isEmpty()){
                    JOptionPane.showMessageDialog(this,"Inserisci i campi richiesti");
                }
                else {
                    int result = JOptionPane.showConfirmDialog(this,"Nome: " + textField3.getText() + "\n" +
                            "Prezzo: " + textField5.getText() + " €" + "\n" + "Descrizione: " + textArea1.getText(),"Dati",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
                    if(result==JOptionPane.YES_OPTION){
                        //DB:
                        try{
                            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myshop",username_db,password_db);
                            double prezzo = Double.parseDouble(textField5.getText());
                            String sql = "INSERT INTO myshop.servizio (nome,prezzo,descrizione) VALUES ( '" +
                                    textField3.getText() + "','" + prezzo + "', '" + textArea1.getText() + "');";
                            Statement stmt = conn.createStatement();
                            int x = stmt.executeUpdate(sql);
                            if(x==0){
                                JOptionPane.showMessageDialog(this,"Questo servizio esiste già.");
                            }
                            else {
                                JOptionPane.showMessageDialog(this,"SERVIZIO INSERITO: " + textField3.getText());
                                int value = JOptionPane.showConfirmDialog(this,"Proseguire?","Inserimento NUOVO SERVIZIO",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                                if(value==JOptionPane.NO_OPTION){
                                    setVisible(false);
                                    new AmministratoreView();
                                }
                            }
                            conn.close();
                        }
                        catch(SQLException sqlException) {
                            sqlException.printStackTrace();
                        }
                    }
                }
            }
        }

        if(e.getActionCommand()==button4.getActionCommand()){
            setVisible(false);
            new AmministratoreView();
        }

        if(e.getActionCommand()==button1.getActionCommand()){
            new AggiungiFotoView().display();
            //DB:
            try{
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myshop",username_db,password_db);
                String sql = "UPDATE myshop.prodotto SET foto = '" + "photo.jpeg '" + " WHERE foto = '" + "null" + "' ;";
                Statement stmt = conn.createStatement();
                int x = stmt.executeUpdate(sql);
                if(x==0){
                    JOptionPane.showMessageDialog(null,"PRODOTTO SALVATO NELLA SEZIONE 'PRODOTTO'\nProsegui con l'inserimento della foto.");
                }
                conn.close();
            }
            catch(SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }

        if(e.getActionCommand()==button2.getActionCommand()){
            int value = JOptionPane.showConfirmDialog(this,"Vuoi davvero eliminare le foto inserite?","Avviso",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(value==JOptionPane.YES_OPTION){
                //DB:
                try{
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myshop",username_db,password_db);
                    String sql = "UPDATE myshop.prodotto SET foto = '" + "null" + "'" + "WHERE foto = '" + "img.jpg" + "';";
                    Statement stmt = conn.createStatement();
                    int x = stmt.executeUpdate(sql);
                    if(x==0){
                        JOptionPane.showMessageDialog(this,"Operazione non completata.");
                    }
                    else {
                        JOptionPane.showMessageDialog(this,"FOTO RIMOSSE CORRETTAMENTE DALL'ARCHIVIO");
//                        int val = JOptionPane.showConfirmDialog(this,"Proseguire?","Inserimento NUOVO SERVIZIO",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
//                        if(val==JOptionPane.NO_OPTION){
//                            setVisible(false);
//                            new AmministratoreView();
//                        }
                    }
                    conn.close();
                }
                catch(SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        }package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

        public class ArticoloView extends JFrame implements ActionListener {

            //credenziali connessione al DB MyShop:
            String username_db = "root";
            String password_db = "Davide$2001";

            public void display () {

                label1 = new JLabel();
                label2 = new JLabel();
                label3 = new JLabel();
                textField1 = new JTextField();
                label4 = new JLabel();
                label5 = new JLabel();
                label6 = new JLabel();
                button1 = new JButton();
                button2 = new JButton();
                label7 = new JLabel();
                label8 = new JLabel();
                textField3 = new JTextField();
                label9 = new JLabel();
                textField4 = new JTextField();
                label10 = new JLabel();
                scrollPane1 = new JScrollPane();
                textArea1 = new JTextArea();
                button3 = new JButton();
                button4 = new JButton();
                textField5 = new JTextField();

                comboBox1 = new JComboBox<>();
                comboBox2 = new JComboBox<>();
                comboBox3 = new JComboBox<>();
                comboBox4 = new JComboBox<>(insert);
                comboBox5 = new JComboBox<>(categorieProdotti);
                comboBox6 = new JComboBox<>(categorieServizi);
                comboBox7 = new JComboBox<>(produttori);
                comboBox8 = new JComboBox<>(fornitori);
                comboBox9= new JComboBox<>(puntiVendita);
                comboBox10 = new JComboBox<>(puntiFornitori);

                //======== this ========
                setTitle("Nuovo ");
                var contentPane = getContentPane();
                contentPane.setLayout(null);

                //---- label1 ----
                label1.setText("Stai inserendo un ");
                contentPane.add(label1);
                label1.setBounds(280,-10,250,80);

                //---- label2 ----
                label2.setText("Creazione di un  ");
                label2.setFont(new Font("Segoe UI", Font.BOLD, 17));
                contentPane.add(label2);
                label2.setBounds(350,20,400,100);

                //---- label3 ----
                label3.setText("Nome ");
                contentPane.add(label3);
                label3.setBounds(129, 120, 120, 16);
                contentPane.add(textField1);
                textField1.setBounds(330, 210, 140, textField1.getPreferredSize().height);

                //---- label4 ----
                label4.setText("Prezzo (EURO) ");
                contentPane.add(label4);
                label4.setBounds(135, 190, label4.getPreferredSize().width, 16);

                //---- label5 ----
                label5.setText("Categoria");
                contentPane.add(label5);
                label5.setBounds(new Rectangle(new Point(150, 255), label5.getPreferredSize()));

                //---- label6 ----
                label6.setText("Produttore/Fornitore");
                contentPane.add(label6);
                label6.setBounds(new Rectangle(new Point(120, 315), label6.getPreferredSize()));

                //---- button1 ----
                button1.setText("Aggiungi Foto");
                contentPane.add(button1);
                button1.setBounds(700, 105, 145, button1.getPreferredSize().height);
                button1.addActionListener(this);

                //---- button2 ----
                button2.setText("Rimuovi tutte le Foto");
                contentPane.add(button2);
                button2.setBounds(new Rectangle(new Point(700, 145), button2.getPreferredSize()));
                button2.addActionListener(this);

                //---- label7 ----
                label7.setText("Punto Vendita");
                contentPane.add(label7);
                label7.setBounds(new Rectangle(new Point(140, 375), label7.getPreferredSize()));

                //---- label8 ----
                label8.setText("Posizione - Corsia");
                contentPane.add(label8);
                label8.setBounds(new Rectangle(new Point(350, 120), label8.getPreferredSize()));
                contentPane.add(textField3);
                textField3.setBounds(105, 140, 140, textField3.getPreferredSize().height);

                //---- label9 ----
                label9.setText("Posizione - Scaffale");
                contentPane.add(label9);
                label9.setBounds(new Rectangle(new Point(345, 190), label9.getPreferredSize()));
                contentPane.add(textField4);
                textField4.setBounds(330, 140, 140, textField4.getPreferredSize().height);

                //---- label10 ----
                label10.setText("Descrizione (facoltativa)");
                contentPane.add(label10);
                label10.setBounds(new Rectangle(new Point(340, 250), label10.getPreferredSize()));

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(textArea1);
                }
                contentPane.add(scrollPane1);
                scrollPane1.setBounds(335, 275, 300, 145);

                //---- button3 ----
                button3.setText("Crea il ");
                contentPane.add(button3);
                button3.setBounds(700, 355, 145, button3.getPreferredSize().height);
                button3.addActionListener(this);

                //---- button4 ----
                button4.setText("Torna indietro");
                contentPane.add(button4);
                button4.setBounds(700, 390, 145, button4.getPreferredSize().height);
                button4.addActionListener(this);

                contentPane.add(textField5);
                textField5.setBounds(105, 210, 140, textField5.getPreferredSize().height);

                contentPane.add(comboBox1);
                comboBox1.setBounds(105, 275, 150, 20);
                comboBox1.addActionListener(this);

                contentPane.add(comboBox5);
                comboBox5.setBounds(105, 275, 150, 20);
                comboBox5.addActionListener(this);

                contentPane.add(comboBox6);
                comboBox6.setBounds(105, 275, 150, 20);
                comboBox6.addActionListener(this);

                contentPane.add(comboBox2);
                comboBox2.setBounds(105, 335, 150, 20);
                comboBox2.addActionListener(this);

                contentPane.add(comboBox7);
                comboBox7.setBounds(105, 335, 150, 20);
                comboBox7.addActionListener(this);

                contentPane.add(comboBox8);
                comboBox8.setBounds(105, 335, 150, 20);
                comboBox8.addActionListener(this);

                contentPane.add(comboBox3);
                comboBox3.setBounds(105, 395, 150, 20);
                comboBox3.addActionListener(this);

                contentPane.add(comboBox9);
                comboBox9.setBounds(105, 395, 150, 20);
                comboBox9.addActionListener(this);

                contentPane.add(comboBox10);
                comboBox10.setBounds(105, 395, 150, 20);
                comboBox10.addActionListener(this);

                contentPane.add(comboBox4);
                comboBox4.setBounds(470, 20, 150, 20);
                comboBox4.addActionListener(this);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < contentPane.getComponentCount(); i++) {
                        Rectangle bounds = contentPane.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = contentPane.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    contentPane.setMinimumSize(preferredSize);
                    contentPane.setPreferredSize(preferredSize);
                }

                setLocationRelativeTo(getOwner());
                pack();
                setSize(900,500);
                setLocation(250,150);
                setDefaultCloseOperation(EXIT_ON_CLOSE);
                setVisible(true);

            }

            private JLabel label1;
            private JLabel label2;
            private JLabel label3;
            private JTextField textField1;
            private JLabel label4;
            private JLabel label5;
            private JLabel label6;
            private JButton button1;
            private JButton button2;
            private JLabel label7;
            private JLabel label8;
            private JTextField textField3;
            private JLabel label9;
            private JTextField textField4;
            private JLabel label10;
            private JScrollPane scrollPane1;
            private JTextArea textArea1;
            private JButton button3;
            private JButton button4;
            private JTextField textField5;

            private String[] insert = {"Prodotto","Servizio"};
            private String[] categorieProdotti = {"Mobili","Illuminazione","Tessili"};
            private String[] categorieServizi = {"Montaggio","Trasporto"};
            private String[] puntiVendita = {"Bari","Brindisi","Lecce"};
            private String[] puntiFornitori = {"Milano","Como","Foggia"};
            //private Produttore produttore = new Produttore();
            private String[] produttori = {"Davide,nuovarredo.it","Giuseppe,ikea.it","Franco,bynatuzzi.it"};
            private String[] fornitori = {"Branca","Tamborrini SRL","Made in Italy"};

            private JComboBox<String> comboBox1;
            private JComboBox<String> comboBox2;
            private JComboBox<String> comboBox3;
            private JComboBox<String> comboBox4;
            private JComboBox<String> comboBox5;
            private JComboBox<String> comboBox6;
            private JComboBox<String> comboBox7;
            private JComboBox<String> comboBox8;
            private JComboBox<String> comboBox9;
            private JComboBox<String> comboBox10;

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getActionCommand()==comboBox4.getActionCommand()){
                    if(comboBox4.getSelectedItem().equals("Prodotto")){

                        setTitle("Nuovo Prodotto");
                        label1.setText("Stai inserendo un Prodotto");
                        label2.setText("Creazione di un Prodotto");
                        label3.setText("Nome Prodotto");

                        comboBox3.setVisible(false);
                        comboBox9.setVisible(true);
                        comboBox10.setVisible(false);

                        comboBox1.setVisible(false);
                        comboBox2.setVisible(false);
                        comboBox6.setVisible(false);
                        comboBox8.setVisible(false);

                        comboBox5.setVisible(true);
                        comboBox7.setVisible(true);

                        label8.setVisible(true);
                        label9.setVisible(true);

                        textField1.setVisible(true);
                        textField4.setVisible(true);

                        button3.setText("Crea il Prodotto");

                        button1.setVisible(true);
                        button2.setVisible(true);

                    }
                    else if(comboBox4.getSelectedItem().equals("Servizio")){

                        setTitle("Nuovo Servizio");
                        label1.setText("Stai inserendo un Servizio");
                        label2.setText("Creazione di un Servizio");
                        label3.setText("Nome Servizio");

                        comboBox3.setVisible(false);
                        comboBox9.setVisible(false);
                        comboBox10.setVisible(true);

                        comboBox1.setVisible(false);
                        comboBox2.setVisible(false);
                        comboBox6.setVisible(true);
                        comboBox7.setVisible(false);

                        comboBox5.setVisible(false);
                        comboBox8.setVisible(true);

                        button3.setText("Crea il Servizio");

                        label8.setVisible(false);
                        label9.setVisible(false);

                        button1.setVisible(false);
                        button2.setVisible(false);

                        textField1.setVisible(false);
                        textField4.setVisible(false);
                    }
                }
                if(e.getActionCommand()==button3.getActionCommand()){
                    if(button3.getText().equals("Crea il ")){
                        JOptionPane.showMessageDialog(this,"Specificare l'inserimento di un prodotto/servizio");
                    }
                    else if(button3.getText().equals("Crea il Prodotto")){
                        if(textField3.getText().isEmpty()||textField1.getText().isEmpty()||textField4.getText().isEmpty() ||textField5.getText().isEmpty()){
                            JOptionPane.showMessageDialog(this,"Inserisci i campi richiesti");
                        }
                        else {
                            int value = JOptionPane.showConfirmDialog(this,"Nome: " + textField3.getText() + "\n" +
                                    "Prezzo: " + textField5.getText() + " €" + "\n" + "Corsia: " + textField4.getText() + "\n" + "Scaffale: " + textField1.getText() + "\n" +
                                    "Descrizione: " + textArea1.getText(),"Dati",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
                            if(value==JOptionPane.YES_OPTION){
                                //DB:
                                try{
                                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myshop",username_db,password_db);
                                    double prezzo = Double.parseDouble(textField5.getText());
                                    int corsia = Integer.parseInt(textField4.getText());
                                    int scaffale = Integer.parseInt(textField1.getText());
                                    if(Objects.equals(comboBox9.getSelectedItem(), "Bari")){
                                        String sql = "INSERT INTO myshop.prodotto (nome,prezzo,puntovendita,corsia,scaffale,descrizione,foto) VALUES ( '" +
                                                textField3.getText() + "','" + prezzo + "','" + "Bari" + "', '" + corsia + "','" + scaffale + "','" + textArea1.getText() + "','" + "img.jpg" + "');";
                                        Statement stmt = conn.createStatement();
                                        int x = stmt.executeUpdate(sql);
                                        if(x==0){
                                            JOptionPane.showMessageDialog(this,"Questo prodotto esiste già.");
                                        }
                                        else {
                                            JOptionPane.showMessageDialog(this,"PRODOTTO INSERITO: " + textField3.getText());
                                        }
                                        //DB:
                                        String insert = "INSERT INTO myshop.catalogo (nome,prezzo,descrizione,foto) VALUES ( '" +
                                                textField3.getText() + "','" + prezzo + "','" +  textArea1.getText() + "','" + "img.jpg" + "');";
                                        Statement stmt2 = conn.createStatement();
                                        int y = stmt2.executeUpdate(insert);
                                        if(y==0){
                                            JOptionPane.showMessageDialog(this,"Questo prodotto nel CATALOGO esiste già.");
                                        }
                                        else {
                                            JOptionPane.showMessageDialog(this,"PRODOTTO INSERITO NEL CATALOGO: " + textField3.getText());
                                            int val = JOptionPane.showConfirmDialog(this,"Proseguire?","Inserimento NUOVO PRODOTTO",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                                            if(val==JOptionPane.NO_OPTION){
                                                setVisible(false);
                                                new AmministratoreView();
                                            }
                                        }
                                    }
                                    else if(Objects.equals(comboBox9.getSelectedItem(), "Brindisi")){
                                        String sql = "INSERT INTO myshop.prodotto (nome,prezzo,puntovendita,corsia,scaffale,descrizione,foto) VALUES ( '" +
                                                textField3.getText() + "','" + prezzo + "', '" + "Brindisi" + "', '" + corsia + "','" + scaffale + "','" + textArea1.getText() + "','" + "img.jpg" + "');";
                                        Statement stmt = conn.createStatement();
                                        int x = stmt.executeUpdate(sql);
                                        if(x==0){
                                            JOptionPane.showMessageDialog(this,"Questo prodotto esiste già.");
                                        }
                                        else {
                                            JOptionPane.showMessageDialog(this,"PRODOTTO INSERITO: " + textField3.getText());
                                        }
                                        //DB:
                                        String insert = "INSERT INTO myshop.catalogo (nome,prezzo,descrizione,foto) VALUES ('" + textField3.getText() + "','" + prezzo + "','" + textArea1.getText() + "','" + "foto.png" + "');";
                                        Statement stmt2 = conn.createStatement();
                                        int y = stmt2.executeUpdate(insert);
                                        if(y==0){
                                            JOptionPane.showMessageDialog(this,"Questo prodotto nel CATALOGO esiste già.");
                                        }
                                        else {
                                            JOptionPane.showMessageDialog(this,"PRODOTTO INSERITO NEL CATALOGO: " + textField3.getText());
                                            int val = JOptionPane.showConfirmDialog(this,"Proseguire?","Inserimento NUOVO PRODOTTO",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                                            if(val==JOptionPane.NO_OPTION){
                                                setVisible(false);
                                                new AmministratoreView();
                                            }
                                        }
                                    }
                                    else {
                                        String sql = "INSERT INTO myshop.prodotto (nome,prezzo,puntovendita,corsia,scaffale,descrizione,foto) VALUES ( '" +
                                                textField3.getText() + "','" + prezzo + "', '" + "Lecce" + "', '" + corsia + "','" + scaffale + "','" + textArea1.getText() + "','" + "img.jpg" + "');";
                                        Statement stmt = conn.createStatement();
                                        int x = stmt.executeUpdate(sql);
                                        if(x==0){
                                            JOptionPane.showMessageDialog(this,"Questo prodotto esiste già.");
                                        }
                                        else {
                                            JOptionPane.showMessageDialog(this,"PRODOTTO INSERITO: " + textField3.getText());
                                        }
                                        //DB:
                                        String insert = "INSERT INTO myshop.catalogo (nome,prezzo,descrizione,foto) VALUES ('" + textField3.getText() + "','" + prezzo + "','" + textArea1.getText() + "','" + "foto.png" + "');";
                                        Statement stmt2 = conn.createStatement();
                                        int y = stmt2.executeUpdate(insert);
                                        if(y==0){
                                            JOptionPane.showMessageDialog(this,"Questo prodotto nel CATALOGO esiste già.");
                                        }
                                        else {
                                            JOptionPane.showMessageDialog(this,"PRODOTTO INSERITO NEL CATALOGO: " + textField3.getText());
                                            int val = JOptionPane.showConfirmDialog(this,"Proseguire?","Inserimento NUOVO PRODOTTO",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                                            if(val==JOptionPane.NO_OPTION){
                                                setVisible(false);
                                                new AmministratoreView();
                                            }
                                        }
                                    }
                                    conn.close();
                                }
                                catch(SQLException sqlException) {
                                    sqlException.printStackTrace();
                                }

                            }
                        }
                    }
                    else if(button3.getText().equals("Crea il Servizio")){
                        if(textField3.getText().isEmpty() ||textField5.getText().isEmpty()){
                            JOptionPane.showMessageDialog(this,"Inserisci i campi richiesti");
                        }
                        else {
                            int result = JOptionPane.showConfirmDialog(this,"Nome: " + textField3.getText() + "\n" +
                                    "Prezzo: " + textField5.getText() + " €" + "\n" + "Descrizione: " + textArea1.getText(),"Dati",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
                            if(result==JOptionPane.YES_OPTION){
                                //DB:
                                try{
                                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myshop",username_db,password_db);
                                    double prezzo = Double.parseDouble(textField5.getText());
                                    String sql = "INSERT INTO myshop.servizio (nome,prezzo,descrizione) VALUES ( '" +
                                            textField3.getText() + "','" + prezzo + "', '" + textArea1.getText() + "');";
                                    Statement stmt = conn.createStatement();
                                    int x = stmt.executeUpdate(sql);
                                    if(x==0){
                                        JOptionPane.showMessageDialog(this,"Questo servizio esiste già.");
                                    }
                                    else {
                                        JOptionPane.showMessageDialog(this,"SERVIZIO INSERITO: " + textField3.getText());
                                        int value = JOptionPane.showConfirmDialog(this,"Proseguire?","Inserimento NUOVO SERVIZIO",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                                        if(value==JOptionPane.NO_OPTION){
                                            setVisible(false);
                                            new AmministratoreView();
                                        }
                                    }
                                    conn.close();
                                }
                                catch(SQLException sqlException) {
                                    sqlException.printStackTrace();
                                }
                            }
                        }
                    }
                }

                if(e.getActionCommand()==button4.getActionCommand()){
                    setVisible(false);
                    new AmministratoreView();
                }

                if(e.getActionCommand()==button1.getActionCommand()){
                    new AggiungiFotoView().display();
                    //DB:
                    try{
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myshop",username_db,password_db);
                        String sql = "UPDATE myshop.prodotto SET foto = '" + "photo.jpeg '" + " WHERE foto = '" + "null" + "' ;";
                        Statement stmt = conn.createStatement();
                        int x = stmt.executeUpdate(sql);
                        if(x==0){
                            JOptionPane.showMessageDialog(null,"PRODOTTO SALVATO NELLA SEZIONE 'PRODOTTO'\nProsegui con l'inserimento della foto.");
                        }
                        conn.close();
                    }
                    catch(SQLException sqlException) {
                        sqlException.printStackTrace();
                    }
                }

                if(e.getActionCommand()==button2.getActionCommand()){
                    int value = JOptionPane.showConfirmDialog(this,"Vuoi davvero eliminare le foto inserite?","Avviso",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                    if(value==JOptionPane.YES_OPTION){
                        //DB:
                        try{
                            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myshop",username_db,password_db);
                            String sql = "UPDATE myshop.prodotto SET foto = '" + "null" + "'" + "WHERE foto = '" + "img.jpg" + "';";
                            Statement stmt = conn.createStatement();
                            int x = stmt.executeUpdate(sql);
                            if(x==0){
                                JOptionPane.showMessageDialog(this,"Operazione non completata.");
                            }
                            else {
                                JOptionPane.showMessageDialog(this,"FOTO RIMOSSE CORRETTAMENTE DALL'ARCHIVIO");
//                        int val = JOptionPane.showConfirmDialog(this,"Proseguire?","Inserimento NUOVO SERVIZIO",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
//                        if(val==JOptionPane.NO_OPTION){
//                            setVisible(false);
//                            new AmministratoreView();
//                        }
                            }
                            conn.close();
                        }
                        catch(SQLException sqlException) {
                            sqlException.printStackTrace();
                        }
                    }
                }

            }

        }

    }

*/


package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class ArticoloView extends JFrame implements ActionListener {

    // Credenziali connessione al DB MyShop:
    String username_db = "root";
    String password_db = "Davide$2001";

    private JComboBox<String> tipoComboBox;
    private JTextField nomeTextField;
    private JTextField prezzoTextField;
    // Altri componenti simili...

    public ArticoloView() {
        initComponents();
        setSize(900, 500);
        setLocation(250, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void initComponents() {
        setTitle("Nuovo ");
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        JLabel label1 = new JLabel("Stai inserendo un ");
        JLabel label2 = new JLabel("Creazione di un  ");
        label2.setFont(new Font("Segoe UI", Font.BOLD, 17));
        topPanel.add(label1);
        topPanel.add(label2);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(new JLabel("Tipo:"), gbc);

        tipoComboBox = new JComboBox<>(new String[]{"Prodotto", "Servizio"});
        tipoComboBox.addActionListener(this);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 10, 0, 0);
        formPanel.add(tipoComboBox, gbc);

        // Aggiungi altri componenti al formPanel usando la stessa logica...

        JPanel buttonPanel = new JPanel();
        JButton creaButton = new JButton("Crea");
        creaButton.addActionListener(this);
        JButton indietroButton = new JButton("Torna indietro");
        indietroButton.addActionListener(this);
        buttonPanel.add(creaButton);
        buttonPanel.add(indietroButton);

        add(topPanel, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tipoComboBox) {
            // Gestisci la selezione del tipo
            String selectedType = (String) tipoComboBox.getSelectedItem();
            // Aggiorna il form in base al tipo selezionato
        } else if (e.getActionCommand().equals("Crea")) {
            // Esegui la logica di creazione
            // ...
        } else if (e.getActionCommand().equals("Torna indietro")) {
            setVisible(false);
            new AmministratoreView();
        }
    }

    // Il resto del codice per la gestione degli eventi e l'interazione con il database rimane invariato.

    /*public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ArticoloView();
        });
    }*/
}



