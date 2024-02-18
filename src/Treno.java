// MACALUSO ALESSANDRO 4^C INF. 19/02/2024

import java.util.ArrayList;

public class Treno {
    private final ArrayList<Vagone> treno;

    //COSTRUTTORE
    public Treno() {
        this.treno = new ArrayList<>();
    }

    public void aggiungiVagone(Vagone vagone) {
        treno.add(vagone);
    }

    public ArrayList<Vagone> getTreno() {
        return treno;
    }

    public int getLunghezzaTreno() {
        int lunghezza = 0;

        for (Vagone vagone : treno) {
            lunghezza += vagone.getLunghezza();
        }
        return lunghezza;
    }

    public double getPesoTreno() {
        double peso = 0;

        for (Vagone vagone : treno) {
            if (vagone instanceof VagoneMerci) {
                peso += ((VagoneMerci) vagone).getCaricoAttuale() + vagone.getPesoVuoto();
            } else {
                peso += vagone.getPesoVuoto() + (((VagonePasseggeri) vagone).getNumAttualePasseggeri() * 70);
                // 70 kg peso medio di ciascun passeggero.
            }
        }
        return peso;
    }

    //toString
    @Override
    public String toString() {
        return "Treno{" +
                "treno=" + treno +
                '}';
    }
}
