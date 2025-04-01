
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
    private String titolo;
    private LocalDate data;
    private final int postiTotali;
    private int postiPrenotati;

    public Evento(String titolo, LocalDate data, int postiTotali) throws IllegalArgumentException {
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La data dell'evento non può essere nel passato.");
        }
        if (postiTotali <= 0) {
            throw new IllegalArgumentException("Il numero di posti totali deve essere positivo.");
        }
        this.titolo = titolo;
        this.data = data;
        this.postiTotali = postiTotali;
        this.postiPrenotati = 0;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La data dell'evento non può essere nel passato.");
        }
        this.data = data;
    }

    public int getPostiTotali() {
        return postiTotali;
    }

    public int getPostiPrenotati() {
        return postiPrenotati;
    }

    public void prenota() throws IllegalStateException {
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalStateException("L'evento è già passato, non è possibile prenotare.");
        }
        if (postiPrenotati >= postiTotali) {
            throw new IllegalStateException("Non ci sono posti disponibili.");
        }
        postiPrenotati++;
    }

    public void disdici() throws IllegalStateException {
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalStateException("L'evento è già passato, non è possibile disdire.");
        }
        if (postiPrenotati <= 0) {
            throw new IllegalStateException("Non ci sono prenotazioni da disdire.");
        }
        postiPrenotati--;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatter) + " - " + titolo;
    }
}
