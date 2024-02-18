// MACALUSO ALESSANDRO 4^C INF. 19/02/2024

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrenoGUI extends JFrame {
    private final JPanel JPbottoni;
    private final JButton btnMerci;
    private final JButton btnPasseggeri;
    private final JButton btnLunghezza;
    private final JButton btnPeso;
    private final Treno treno;
    private final JPanel JPvagoni; // Contiene tutte le immagine dei vagoni.


    public TrenoGUI() {
        this.JPbottoni = new JPanel(new GridLayout(2, 2, 1, 1)); // JPanel che contiene i due bottini in basso.
        this.btnMerci = new JButton("CREA VAGONE MERCI");
        this.btnPasseggeri = new JButton("CREA VAGONE PASSEGGERI");
        this.btnLunghezza = new JButton("LUNGHEZZA TOTALE TRENO");
        this.btnPeso = new JButton("PESO TOTALE TRENO");
        this.treno = new Treno();
        JPvagoni = new JPanel(new FlowLayout(FlowLayout.LEFT));

        btnMerci.setName("merci");
        btnPasseggeri.setName("passeggeri");
        btnLunghezza.setName("lunghezza");
        btnPeso.setName("peso");
        creaGUI();
    }

    private void creaGUI() {
        this.setTitle("TrenoGUI");
        this.setSize(1000, 700);
        this.setLocationRelativeTo(null); // Finestra al centro dello schermo.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Permette la corretta chiusura della finestra.
        this.setIconImage(new ImageIcon("img/logo.jpg").getImage()); // Immagine della finestra
        // e dell'icona.

        this.add(JPvagoni);
        this.add(JPbottoni, BorderLayout.SOUTH);
        btnMerci.addActionListener(new AzioniBottone());
        btnPasseggeri.addActionListener(new AzioniBottone());
        btnLunghezza.addActionListener(new AzioniBottone());
        btnPeso.addActionListener(new AzioniBottone());
        JPbottoni.add(btnMerci);
        JPbottoni.add(btnPasseggeri);
        JPbottoni.add(btnLunghezza);
        JPbottoni.add(btnPeso);

        this.setVisible(true);
    }


    public class AzioniBottone implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (((JButton) e.getSource()).getName().equalsIgnoreCase("lunghezza")) {
                JOptionPane.showMessageDialog(null, treno.getLunghezzaTreno() + " cm.");
            } else if (((JButton) e.getSource()).getName().equalsIgnoreCase("peso")) {
                JOptionPane.showMessageDialog(null, treno.getPesoTreno() + " quintali.");
            } else {
                new FinestraInput(((JButton) e.getSource()).getName(), treno, JPvagoni);
            }
        }
    }
}
