
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
    String titolo;
    LocalDate data;
    int totalePosti;
    int postiPrenotati;

    public Evento(String titolo, LocalDate data, int postiTotali) throws IllegalArgumentException {
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La data dell'evento non può essere nel passato.");
        }
        if (postiTotali <= 0) {
            throw new IllegalArgumentException("Il numero di posti totali deve essere positivo.");
        }
        this.titolo = titolo;
        this.data = data;
        this.totalePosti = totalePosti;
        this.postiPrenotati = 0;
    }

    public String getTitolo() {
        return titolo;
    }

    public LocalDate getData() {
        return data;
    }

    public int getTotalePosti() {
        return totalePosti;
    }

    public int getPostiPrenotati() {
        return postiPrenotati;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
    public  void prenota () throws IllegalStateException {
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalStateException("Impossibile prenotare, l'evento è già passato");
        } 
        if (postiPrenotati > totalePosti) {
            throw new IllegalStateException("Impossibile prenotare, posti esauriti");
        }
        postiPrenotati++;
    }
    public void disdici () throws IllegalStateException {
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalStateException("Impossibile prenotare, l'evento è già passato");
        } if (postiPrenotati < 0) {
            throw new IllegalStateException("Impossibile disdire, non esiste alcuna prenotazione");
        }
        postiPrenotati--;
    }
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatter) + " - " + titolo;
    }
}