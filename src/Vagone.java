// MACALUSO ALESSANDRO 4^C INF. 19/02/2024

abstract public class Vagone {
    private String matricola;
    private int lunghezza; // Lunghezza espressa in cm.
    private double pesoVuoto; // Peso a vuoto espresso in quintali.

    //COSTRUTTORE CON PARAMETRI.
    public Vagone(String matricola, int lunghezza, double pesoVuoto) {
        this.matricola = matricola;
        this.lunghezza = lunghezza;
        this.pesoVuoto = pesoVuoto;
    }

    //COSTRUTTORE SENZA PARAMETRI CHE ASSEGNA DEI VALORI DI DEFAULT.
    public Vagone() {
        this.matricola = getClass().getSimpleName();
        this.lunghezza = 2600; // 26 metri.
        this.pesoVuoto = 2500; // 25 tonnellate.
    }

    //GETTERS
    public String getMatricola() {
        return matricola;
    }

    public int getLunghezza() {
        return lunghezza;
    }

    public double getPesoVuoto() {
        return pesoVuoto;
    }

    //SETTERS
    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public void setLunghezza(int lunghezza) {
        if (lunghezza > 0) {
            this.lunghezza = lunghezza;
        }
    }

    public void setPesoVuoto(double pesoVuoto) {
        if (pesoVuoto > 0) {
            this.pesoVuoto = pesoVuoto;
        }
    }


    @Override
    public String toString() {
        return "Vagone{" +
                "matricola='" + matricola + '\'' +
                ", lunghezza=" + lunghezza +
                ", pesoVuoto=" + pesoVuoto +
                '}';
    }
}
