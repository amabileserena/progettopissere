import View.AmministratoreView;
import javax.swing.*;

public class MainClass {

        /*JFrame finestra = new JFrame("Prima finestra");

        finestra.setSize(800,600);
        finestra.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Buona Lezione");
        Container c = finestra.getContentPane();
        c.add(label);

        finestra.setVisible(true);*/
        //new PrimaFinestra();
        //new CatalogPanel()
        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {

                new AmministratoreView().setVisible(true);
            });
        }
}


