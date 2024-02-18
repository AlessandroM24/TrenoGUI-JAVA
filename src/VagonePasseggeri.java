// MACALUSO ALESSANDRO 4^C INF. 19/02/2024

public class VagonePasseggeri extends Vagone {
    private int numMaxPasseggeri; // Numero massimo di passeggeri.
    private int numAttualePasseggeri; // Numero attuale di passeggeri.

    //COSTRUTTORE CON PARAMETRI.
    public VagonePasseggeri(String matricola, int lunghezza, double pesoVuoto, int numMaxPasseggeri, int numAttualePasseggeri) {
        super(matricola, lunghezza, pesoVuoto);
        this.numMaxPasseggeri = numMaxPasseggeri;
        this.numAttualePasseggeri = numAttualePasseggeri;
    }

    //COSTRUTTORE SENZA PARAMETRI CHE ASSEGNA DEI VALORE DI DEFUALT.
    public VagonePasseggeri() {
        setMatricola(getClass().getSimpleName());
        setLunghezza(2600);
        setPesoVuoto(2500);
        this.numMaxPasseggeri = 100;
        this.numAttualePasseggeri = 60;
    }

    //GETTERS
    public int getNumMaxPasseggeri() {
        return numMaxPasseggeri;
    }

    public int getNumAttualePasseggeri() {
        return numAttualePasseggeri;
    }

    //SETTERS
    public void setNumMaxPasseggeri(int numMaxPasseggeri) {
        if (numMaxPasseggeri > 0) {
            this.numMaxPasseggeri = numMaxPasseggeri;
        }
    }

    public void setNumAttualePasseggeri(int numAttualePasseggeri) {
        if (numAttualePasseggeri > 0 && numAttualePasseggeri <= 60) {
            this.numAttualePasseggeri = numAttualePasseggeri;
        }
    }

    //toString
    @Override
    public String toString() {
        return "VagonePasseggeri{" +
                "matricola=" + getMatricola() + '\'' +
                ", lunghezza=" + getLunghezza() +
                ", pesoVuoto=" + getPesoVuoto() +
                ", numMaxPasseggeri=" + numMaxPasseggeri +
                ", numAttualePasseggeri=" + numAttualePasseggeri +
                '}';
    }
}
