package test;

import java.util.Scanner;

class Pawn 
{
    public void muovi(Scacchiera scacchiera, int rigaPedina, int colonnaPedina, char pedina) 
    {
        //inizializzo scanner e chiedo le cordinate di destinazione
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci le coordinate per il movimento del pedone (ad esempio e4): ");
        String coordinateDestinazione = scanner.next();
        
        scacchiera.getSecondo(coordinateDestinazione);
        //li trasformo in dati validi per essere inseriti nel codice
        int colonnaDestinazione = coordinateDestinazione.charAt(0) - 'a';               //metodo che utilizzo per prendere il carattere della colonna
        int rigaDestinazione = 8 - Character.getNumericValue(coordinateDestinazione.charAt(1));     //metodo che uso per rendere un char la cifra
        
        char dato = scacchiera.getPedina(rigaDestinazione, colonnaDestinazione);    //prendo la pedina di destinazione dalla scacchiera

        /*
        Il pedone si muove solo in avanti e dritto per la sua colonna
        si muove sempre di una sola casella e non può prendere direzioni
        la prima mossa però gli permette di fare un passo lungo 2 caselle
        */
        if (pedina == 'p') // se è un pedone nero
        {
            if (colonnaPedina == colonnaDestinazione && rigaDestinazione == rigaPedina + 1) // movimento normale di un passo in avanti
            {
                if (dato == '-') // se la posizione di arrivo è vuota
                {
                    scacchiera.muoviPedina(rigaPedina, colonnaPedina, rigaDestinazione, colonnaDestinazione); // movimento
                } 
                    else 
                    {
                        System.out.println("Movimento non valido! Casella occupata."); // messaggio d'errore
                    }
            } 
            // doppio passo consentito solo se il pedone si trova alla sua posizione iniziale
            else if (colonnaPedina == colonnaDestinazione && rigaDestinazione == rigaPedina + 2 && rigaPedina == 1) 
            {
                if (dato == '-' && scacchiera.getPedina(rigaPedina + 1, colonnaPedina) == '-') // controlla che le caselle intermedie siano vuote
                {
                    scacchiera.muoviPedina(rigaPedina, colonnaPedina, rigaDestinazione, colonnaDestinazione); // movimento
                } 
                    else 
                    {
                        System.out.println("Movimento non valido! Casella occupata o pedine nel passaggio."); // messaggio d'errore
                    }
            } 
                else 
                {
                    System.out.println("Movimento non valido!"); // messaggio d'errore
                }
            } 
        
            else if (pedina == 'P') // se è un pedone bianco
            {
                if (colonnaPedina == colonnaDestinazione && rigaDestinazione == rigaPedina - 1) // movimento normale di un passo in avanti
                {
                    if (dato == '-') // se la posizione di arrivo è vuota
                    {
                        scacchiera.muoviPedina(rigaPedina, colonnaPedina, rigaDestinazione, colonnaDestinazione); // movimento
                    } 
                        else 
                        {
                            System.out.println("Movimento non valido! Casella occupata."); // messaggio d'errore
                        }
                } 
                // doppio passo consentito solo se il pedone si trova alla sua posizione iniziale
                else if (colonnaPedina == colonnaDestinazione && rigaDestinazione == rigaPedina - 2 && rigaPedina == 6)
                {
                    if (dato == '-' && scacchiera.getPedina(rigaPedina - 1, colonnaPedina) == '-') // controlla che le caselle intermedie siano vuote
                    {
                        scacchiera.muoviPedina(rigaPedina, colonnaPedina, rigaDestinazione, colonnaDestinazione); // movimento
                    } 
                        else 
                        {
                            System.out.println("Movimento non valido! Casella occupata o pedine nel passaggio."); // messaggio d'errore
                        }
                } 
                    else 
                    {
                        System.out.println("Movimento non valido!"); // messaggio d'errore
                    }
        }
    }
}
