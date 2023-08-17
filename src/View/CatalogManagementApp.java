package View;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;

public class CatalogManagementApp extends JFrame {
    private JPanel mainPanel;
    private JTree productTree;
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;

    public CatalogManagementApp() {
        initComponents();
        setupUI();
    }

    private void initComponents() {
        mainPanel = new JPanel();

        // Creazione del nodo radice dell'albero
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Catalogo");

        // Aggiunta delle categorie e sottocategorie come nodi figli
        DefaultMutableTreeNode prodottiNode = new DefaultMutableTreeNode("Prodotti");
        DefaultMutableTreeNode mobiliNode = new DefaultMutableTreeNode("Mobili");
        mobiliNode.add(new DefaultMutableTreeNode("Cucina"));
        mobiliNode.add(new DefaultMutableTreeNode("Soggiorno"));
        mobiliNode.add(new DefaultMutableTreeNode("Camera"));

        DefaultMutableTreeNode illuminazioneNode = new DefaultMutableTreeNode("Illuminazione");
        illuminazioneNode.add(new DefaultMutableTreeNode("Tappeti"));
        illuminazioneNode.add(new DefaultMutableTreeNode("Tende"));
        illuminazioneNode.add(new DefaultMutableTreeNode("Lampadari"));
        illuminazioneNode.add(new DefaultMutableTreeNode("Lampade da esterno"));

        prodottiNode.add(mobiliNode);
        prodottiNode.add(illuminazioneNode);

        DefaultMutableTreeNode serviziNode = new DefaultMutableTreeNode("Servizi");
        serviziNode.add(new DefaultMutableTreeNode("Montaggio"));
        serviziNode.add(new DefaultMutableTreeNode("Trasporto"));

        root.add(prodottiNode);
        root.add(serviziNode);

        DefaultTreeModel treeModel = new DefaultTreeModel(root);
        productTree = new JTree(treeModel);

        addButton = new JButton("Aggiungi");
        editButton = new JButton("Modifica");
        deleteButton = new JButton("Elimina");

        // Qui puoi impostare i listener per i pulsanti e la logica di gestione
        // dell'albero dei prodotti e delle categorie
    }

    private void setupUI() {
        setTitle("Gestione Catalogo");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(new JScrollPane(productTree), BorderLayout.WEST);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        getContentPane().add(mainPanel);
    }

    /*public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CatalogManagementApp().setVisible(true);
        });
    }*/
}



