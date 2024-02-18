// MACALUSO ALESSANDRO 4^C INF. 19/02/2024

public class VagoneMerci extends Vagone {
    private double caricoMassimo; // Carico massimo espresso in quintali.
    private double caricoAttuale; // Carico attuale espresso in quintali;

    //COSTRUTTORE CON PARAMETRI.
    public VagoneMerci(String matricola, int lunghezza, double pesoVuoto, double caricoMassimo, double caricoAttuale) {
        super(matricola, lunghezza, pesoVuoto);
        this.caricoMassimo = caricoMassimo;
        this.caricoAttuale = caricoAttuale;
    }

    //COSTTRUTTORE SENZA PARAMETRI CHE ASSEGNA DEI VALORI DI DEFAULT.
    public VagoneMerci() {
        setMatricola(getClass().getSimpleName());
        setLunghezza(2600);
        setPesoVuoto(2500);
        this.caricoMassimo = 300;
        this.caricoAttuale = 200;
    }

    //GETTERS
    public double getCaricoMassimo() {
        return caricoMassimo;
    }

    public double getCaricoAttuale() {
        return caricoAttuale;
    }

    //SETTERS
    public void setCaricoMassimo(double caricoMassimo) {
        if (caricoMassimo > 0) {
            this.caricoMassimo = caricoMassimo;
        }
    }

    public void setCaricoAttuale(double caricoAttuale) {
        if (caricoAttuale > 0 && caricoAttuale <= 60) {
            this.caricoAttuale = caricoAttuale;
        }
    }

    //toString
    @Override
    public String toString() {
        return "VagoneMerci{" +
                "matricola='" + getMatricola() + '\'' +
                ", lunghezza=" + getLunghezza() +
                ", pesoVuoto=" + getPesoVuoto() +
                ", caricoMassimo=" + caricoMassimo +
                ", caricoAttuale=" + caricoAttuale +
                '}';
    }
}
