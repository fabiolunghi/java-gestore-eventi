
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UsaEvento {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Evento evento = null;

        // Creazione dell'evento con input utente
        try {
            System.out.print("Inserisci il titolo dell'evento: ");
            String titolo = scanner.nextLine();
            
            System.out.print("Inserisci la data dell'evento (dd/MM/yyyy): ");
            String dataInput = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate data = LocalDate.parse(dataInput, formatter);
            
            System.out.print("Inserisci il numero di posti totali: ");
            int postiTotali = Integer.parseInt(scanner.nextLine()); 
            evento = new Evento(titolo, data, postiTotali);
            System.out.println("Evento creato con successo: " + evento);
        } catch (Exception e) {
            System.out.println("Errore nella creazione dell'evento: " + e.getMessage());
            return;
        }
        
        // Richiesta prenotazioni

        System.out.print("Vuoi effettuare prenotazioni? (s/n): ");
        String rispostaPrenotazioni = scanner.nextLine().trim().toLowerCase();
        
        if (rispostaPrenotazioni.equals("s")) {
            System.out.print("Quante prenotazioni vuoi effettuare? ");
            int prenotazioni = Integer.parseInt(scanner.nextLine()); 
            
            for (int i = 0; i < prenotazioni; i++) {
                try {
                    evento.prenota();
                } catch (Exception e) {
                    System.out.println("Errore durante la prenotazione: " + e.getMessage());
                    break;
                }
            }
            System.out.println("Posti prenotati: " + evento.getPostiPrenotati() + "/" + evento.getPostiTotali());
        } else {
            System.out.println("Nessuna prenotazione effettuata.");
        }
        
        // Richiesta disdette

        System.out.print("Vuoi disdire prenotazioni? (s/n): ");
        String rispostaDisdette = scanner.nextLine().trim().toLowerCase();
        
        if (rispostaDisdette.equals("s")) {
            System.out.print("Quante prenotazioni vuoi disdire? ");
            int disdette = Integer.parseInt(scanner.nextLine());
            
            for (int i = 0; i < disdette; i++) {
                try {
                    evento.disdici();
                } catch (Exception e) {
                    System.out.println("Errore durante la disdetta: " + e.getMessage());
                    break;
                }
            }
            System.out.println("Posti prenotati: " + evento.getPostiPrenotati() + "/" + evento.getPostiTotali());
        } else {
            System.out.println("Nessuna disdetta effettuata.");
        }
    }
}

