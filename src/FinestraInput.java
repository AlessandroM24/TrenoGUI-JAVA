// MACALUSO ALESSANDRO 4^C INF. 19/02/2024

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinestraInput extends JFrame {
    private final JTextField JTFmatricola;
    private final JTextField JTFlunghezza;
    private final JTextField JTFpesoVuoto;
    private final String nomeClasse;
    private final JPanel JPcampi;
    private final JButton btnInvia;
    private final Treno treno;
    private final JPanel JPvagoni;


    // VagoneMerci
    private final JTextField JTFcaricoMassimo;
    private final JTextField JTFcaricoAttuale;
    // VagonePasseggeri
    private final JTextField JTFnumMaxPasseggeri;
    private final JTextField JTFnumAttualePasseggeri;

    public FinestraInput(String nomeClasse, Treno treno, JPanel JPvagoni) {
        this.btnInvia = new JButton("Invia informazioni");
        this.nomeClasse = nomeClasse;
        this.JTFmatricola = new JTextField();
        this.JTFlunghezza = new JTextField();
        this.JTFpesoVuoto = new JTextField();
        this.JTFcaricoMassimo = new JTextField();
        this.JTFcaricoAttuale = new JTextField();
        this.JTFnumMaxPasseggeri = new JTextField();
        this.JTFnumAttualePasseggeri = new JTextField();
        this.JPcampi = new JPanel(new GridLayout(5, 2));
        this.JPvagoni = JPvagoni;
        this.treno = treno;
        CreaGUI();
    }

    private void CreaGUI() {
        this.setTitle("Input informazioni vagone");
        this.setSize(550, 350);
        this.setLocationRelativeTo(null); // Finestra al centro dello schermo.
        this.setIconImage(new ImageIcon("img/inputLogo.jpg").getImage());
        btnInvia.addActionListener(new AzioniBottone());


        this.add(JPcampi);
        JPcampi.add(new JLabel("Matricola"));
        JPcampi.add(JTFmatricola);
        JPcampi.add(new JLabel("Lunghezza [cm]"));
        JPcampi.add(JTFlunghezza);
        JPcampi.add(new JLabel("Peso vuoto [quintali]"));
        JPcampi.add(JTFpesoVuoto);

        aggiungiCampiSpecifici(nomeClasse);

        this.add(btnInvia, BorderLayout.SOUTH);


        this.setVisible(true);
    }

    private void aggiungiCampiSpecifici(String nomeClasse) {
        if (nomeClasse.equalsIgnoreCase("merci")) {
            JPcampi.add(new JLabel("Carico massimo [quintali]"));
            JPcampi.add(JTFcaricoMassimo);
            JPcampi.add(new JLabel("Carico attuale [quintali]"));
            JPcampi.add(JTFcaricoAttuale);
        } else {
            JPcampi.add(new JLabel("Numero max passeggeri"));
            JPcampi.add(JTFnumMaxPasseggeri);
            JPcampi.add(new JLabel("Numero attuale passeggeri"));
            JPcampi.add(JTFnumAttualePasseggeri);
        }
    }

    public class AzioniBottone implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String matricola = JTFmatricola.getText();
            if (matricola.isEmpty() || matricola.isBlank()) {
                matricola = "Default";
            }

            int lunghezza = 0;
            double pesoVuoto = 0;
            try {
                lunghezza = Integer.parseInt(JTFlunghezza.getText());
                pesoVuoto = Double.parseDouble(JTFpesoVuoto.getText());
            } catch (Exception ignored) {
                System.err.println("FORMATO DATI ERRATO, IMPOSSIBILE ESEGUIRE LA CONVERSIONE A NUMERICO");
            }

            if (nomeClasse.equalsIgnoreCase("merci")) {
                double caricoMassimo = 0;
                double caricoAttuale = 0;
                try {
                    caricoMassimo = Double.parseDouble(JTFcaricoMassimo.getText());
                    caricoAttuale = Double.parseDouble(JTFcaricoAttuale.getText());
                } catch (Exception ignored) {
                    System.err.println("FORMATO DATI ERRATO, IMPOSSIBILE ESEGUIRE LA CONVERSIONE A NUMERICO");
                }
                treno.aggiungiVagone(new VagoneMerci(matricola, lunghezza, pesoVuoto, caricoMassimo, caricoAttuale));
                JPvagoni.add(new JLabel(new ImageIcon("img/merci.jpg")));
            } else {
                int numMaxPasseggeri = 0;
                int numAttualePasseggeri = 0;
                try {
                    numMaxPasseggeri = Integer.parseInt(JTFnumMaxPasseggeri.getText());
                    numAttualePasseggeri = Integer.parseInt(JTFnumAttualePasseggeri.getText());
                } catch (NumberFormatException ignored) {
                    System.err.println("FORMATO DATI ERRATO, IMPOSSIBILE ESEGUIRE LA CONVERSIONE A NUMERICO");
                }
                treno.aggiungiVagone(new VagonePasseggeri(matricola, lunghezza, pesoVuoto, numMaxPasseggeri, numAttualePasseggeri));
                JPvagoni.add(new JLabel(new ImageIcon("img/passeggeri.jpg")));
            }
            JPvagoni.revalidate();
            JPvagoni.repaint();
            System.out.println(treno);
        }
    }
}
