
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class Concerto extends Evento {

    private LocalTime ora;
    private double prezzo;

    public Concerto(String titolo, LocalDate data, int postiTotali) throws IllegalArgumentException {
        super(titolo, data, postiTotali);
        this.ora = ora;
        this.prezzo= prezzo;
    }

    public LocalTime getOra() {
        return ora;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    
    public String getDataOraFormattata() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " " + ora.format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    public String getPrezzoFormattato () {
        return String.format( "%.2f€", prezzo);
    }
    @Override
    public String toString() {
        return getDataOraFormattata() + " - " + getTitolo() + " - " + getPrezzoFormattato();
    }

}
