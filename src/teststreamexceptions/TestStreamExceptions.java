import java.util.ArrayList
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Esercizio per la gestione di eccezioni e stream
 * 
 * @author filippo mattioli
 */
public class TestStreamExceptions {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        
        System.out.println("Inserisci numeri interi. Digita 'stop' per terminare:");

        while (true) {
            System.out.print("Numero: ");
            String input = in.next();

            if (input.equalsIgnoreCase("stop")) {
                break;
            }

            try {
                int number = Integer.parseInt(input);
                numbers.add(number);
            } catch (NumberFormatException e) {
                System.out.println("Input non valido. Inserisci un numero intero o 'stop'.");
            }
        }

        // Calcolo della somma e media utilizzando stream
        try {
            int sum = numbers.stream().mapToInt(Integer::intValue).sum();
            double average = numbers.stream().mapToInt(Integer::intValue).average().orElse(0.0);

            System.out.println("Numeri inseriti: " + numbers.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            System.out.println("Somma: " + sum);
            System.out.println("Media: " + average);
        } catch (Exception e) {
            System.out.println("Errore durante il calcolo: " + e.getMessage());
        } finally {
            System.out.println("Programma terminato (messaggio che si esegue sempre)");
            in.close();
        }
    }
}