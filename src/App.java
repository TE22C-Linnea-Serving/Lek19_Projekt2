/* Boknings.java programmet Programmet låter användaren 
 * välja vilken plats dom vill boka på en buss. Det går 
 * även att avboka, kolla vilka som har bokat och totala 
 * vinster som företaget gjort.
 * @author Linnea Serving
 * @versin 1.0
 * @since 2024
 */

import java.util.Scanner;

public class App {


    /*
     * Metoden "laddar" lägger till en väntetid med texten "Laddar...".
     */
    public static void laddar() throws InterruptedException {
        System.out.println("");
        System.out.print("Laddar");

        for (int i = 0; i < 3; i++) {
            System.out.print(".");
            Thread.sleep(250);
        }
        System.out.println("\n");
    }

    /*
     * Metoden "bild" skriver ut bilden av bussen.
     */
    public static void bild(String[] plats) {
        System.out.println("[ " + plats[0] + "][" + plats[1] + " ][ ][ " + plats[2] + "][" + plats[3] + " ]\n[ "
                + plats[4] + "][" + plats[5] + " ][ ][ " + plats[6] + "][" + plats[7] + " ]\n[ " + plats[8] + "]["
                + plats[9] + "][ ][" + plats[10] + "][" + plats[11] + "]\n[" + plats[12] + "][" + plats[13] + "][ ]["
                + plats[14] + "][" + plats[15] + "]\n[" + plats[16] + "][" + plats[17] + "][ ][" + plats[18] + "]["
                + plats[19] + "]");
    }

    /*
     * Metoden "reset" gör om alla värden till standardvärden efter avbokning
     */
    public static void reset(String[] plats, int avbokaVal, String[] fornamnPerson, String[] efternamnPerson, int[] personnummerPerson, int[] alder){
        plats[avbokaVal] = avbokaVal + 1 + "";
        fornamnPerson[avbokaVal] = null;
        efternamnPerson[avbokaVal] = null;
        personnummerPerson[avbokaVal] = 0;
        alder[avbokaVal] = 0;
    }

    public static void main(String[] args) throws Exception {

        Scanner tangentbord = new Scanner(System.in);

        /*
         * plats (String[]) är namnet på platsen.
         * Namnet ändras till "X" när platsen bokas.
         */
        String plats[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17","18", "19", "20" };

        /*
         * fornamnPerson (String[]) är användarens förnamn. 
         * Platsen i arrayen som användarens förnamn får, beror på den plats de bokar.
         */
        String fornamnPerson[] = new String[20];

        /*
         * efternamnPerson (String[]) är användarens efternamn. 
         * Platsen i arrayen som användarens efternamn får, beror på den plats de bokar.
         */
        String efternamnPerson[] = new String[20];

        /*
         * personnummerPerson (int[]) är användarens personnummer.
         * Platsen i arrayen som användarens personnummer får, beror på den plats de bokar.
         */
        int[] personnummerPerson = new int[20];

        /*
         * alder (int[]) är användarens ålder.
         * Platsen i arrayen som användarens ålder får, beror på den plats de bokar.
         */
        int[] alder = new int[20];

        /*
         * summa (double) är den totala vinsten.
         * Variabeln ändras vid bokning och avbokning.
         */
        double summa = 0;

        /*
         * barnPris (final double) är barnpriset på biljetterna.
         */
        final double barnPris = 149.90;

        /*
         * vuxenPris (final double) är vuxenPris på biljetterna.
         */
        final double vuxenPris = 299.90;

        while (true) {
            laddar();
            System.out.println("Meny:\n1. Boka plats\n2. Avboka plats\n3. Bokade platser\n4. Beräkna vinster\n5. Avsluta\n");
            if(!tangentbord.hasNextInt()){
                System.out.println("Du skrev in ett ogiltigt svar. Avslutar program...");
                return;
            }
            int svar = tangentbord.nextInt();
            
            switch (svar) {

                //Boka platser
                case 1:
                    laddar();
                    System.out.println("Välj vilken plats du vill boka:");
                    bild(plats);
                    if (!tangentbord.hasNextInt()) {
                        System.out.println("Du skrev in ett ogiltigt svar. Avslutar program...");
                        return;
                    } else {
                        int valPlats = tangentbord.nextInt();
                        valPlats -= 1;
                        if (plats[valPlats] == "X") {
                            System.out.println("Du försökte boka en upptagen plats. Välj en annan plats");
                            bild(plats);
                            valPlats = tangentbord.nextInt();
                            valPlats -= 1;
                        }

                        laddar();

                        System.out.println("Skriv in ditt förnamn:");
                        String enter = tangentbord.nextLine();
                        String namn = tangentbord.nextLine();
                        fornamnPerson[valPlats] = namn;

                        laddar();

                        System.out.println("Skriv in ditt efternamn:");
                        if (!tangentbord.hasNextLine()) {
                            System.out.println("Använd bokstäve, försök igen:");
                        }
                        namn = tangentbord.nextLine();
                        efternamnPerson[valPlats] = namn;

                        laddar();

                        System.out.println("Skriv in ditt personnummer (YYYYMMDD):");
                        personnummerPerson[valPlats] = tangentbord.nextInt();
                        //Om användaren var född innan 1880-talet (över 140 år)
                        if ((personnummerPerson[valPlats] - 18799999) <= 0) {
                            System.out.println("Felaktigt personnummer. Avslutar program...");
                            return;
                        }

                        laddar();

                        System.out.println("Skriv in din ålder:");
                        if(!tangentbord.hasNextInt()){
                            System.out.println("Du skrev in ett ogiltigt svar. Avslutar program...");
                            return;
                        }

                        alder[valPlats] = tangentbord.nextInt();
                        double subpersonnummer = personnummerPerson[valPlats];

                        //Om personnummer stämmer överräns med ålder
                        if (((int) (20240000 - subpersonnummer) / 10000) == alder[valPlats] || (((int) (20240000 - subpersonnummer) / 10000) + 1) == alder[valPlats]) {
                            if (alder[valPlats] < 18) {
                                summa += barnPris;
                            } else if (alder[valPlats] >= 18) {
                                summa += vuxenPris;
                            }
                            plats[valPlats] = "X";
                            laddar();
                            System.out.println("Din plats är nu bokad.");
                        } else {
                            reset(plats, valPlats, fornamnPerson, efternamnPerson, personnummerPerson, alder);
                            System.out.println("Åldern stämmer inte överräns med personnummret, försök igen...");
                        }

                    }
                    break;

                //Avboka platser
                case 2:

                    laddar();

                    System.out.println("Vilken plats vill du avboka?");
                    bild(plats);
                    System.out.print("Tryck på \"0\" för att gå tillbaka.");

                    laddar();

                    if (!tangentbord.hasNextInt()) {
                        System.out.println("Du skrev in ett ogiltigt svar. Avslutar program...");
                        return;
                    }

                    int avbokaVal = tangentbord.nextInt();
                    if(avbokaVal!=0){
                        avbokaVal -= 1;
                        while (plats[avbokaVal] != "X") {
                            laddar();
                            System.out.println("Du försökte avboka en obokad plats. Välj en annan plats:");
                            bild(plats);
                            avbokaVal = tangentbord.nextInt();
                            avbokaVal -= 1;
                        }
                        System.out.println("Vill du avboka med ditt namn eller personnummer?\n1. Namn\n2. Personnummer");
                        while (!tangentbord.hasNextInt()) {
                            System.out.println("Du angav ett ogiltigt svar. Avslutar programmet...");
                            return;
                        }
                    }else{
                        break;
                    }
                    int val = tangentbord.nextInt();

                    laddar();

                    if(val==1){
                        System.out.println("Vad är ditt förnamn?");
                        String enter = tangentbord.nextLine();
                        String namn = tangentbord.nextLine();

                        if (!namn.equals(fornamnPerson[avbokaVal])) {
                            System.out.println("Ogiltigt namn, försök igen:");
                        }
                        
                        laddar();
                        
                        System.out.println("Vad är ditt efternamn?");
                        namn = tangentbord.nextLine();
                        
                        if (namn.equals(efternamnPerson[avbokaVal])) { 
                            if(alder[avbokaVal]<18){
                                summa-=barnPris;
                            }else if(alder[avbokaVal]>=18){
                                summa-=vuxenPris;
                            }
                            reset(plats, avbokaVal, fornamnPerson, efternamnPerson, personnummerPerson, alder);
                        } else {
                            System.out.println("Ogiltigt namn, försök igen:");
                        }
                    
                    }else if(val==2){
                        System.out.println("Vad är ditt personnummer?");
                        String enter1 = tangentbord.nextLine();
                        int svarPersonnummer = tangentbord.nextInt();

                        if (svarPersonnummer == personnummerPerson[avbokaVal]) {
                            if(alder[avbokaVal]<18){
                                summa-=barnPris;
                            }else if(alder[avbokaVal]>=18){
                                summa-=vuxenPris;
                            }
                            reset(plats, avbokaVal, fornamnPerson, efternamnPerson, personnummerPerson, alder);
                        } else {
                            System.out.println("Ogiltigt personnummer, försök igen:");
                        }
                    }

                    laddar();

                    System.out.println("Din plats är nu avbokad");
                    break;

                //Bokade platser
                case 3:
                    laddar();
                    bild(plats);
                    int antalLedigt = 0;
                    int over18 = 0;
                    int under18 = 0;
                    for (int i = 0; i < plats.length; i++) {
                        if (plats[i] != "X") {
                            antalLedigt++;
                        }
                        if (alder[i] < 18 && alder[i] != 0) {
                            under18++;
                        } else if (alder[i] >= 18) {
                            over18++;
                        }
                    }

                    System.out.println("Det finns " + antalLedigt + " lediga platser\n" + under18+ " av kunderna är under 18 år, " + over18 + " är över 18 år.\n");

                    for (int i = 0; i < alder.length; i++) {
                        System.out.println("Namn: " + fornamnPerson[i] + " " + efternamnPerson[i] + "     Ålder: " + alder[i]+ "       Personnummer: " + personnummerPerson[i] + "     Plats: " + (i + 1));
                    }

                    laddar();

                    break;
                //Beräkna vinster
                case 4:
                    laddar();

                    summa += 0.5; // Avrundar till heltal
                    System.out.println("Den totala vinsen är: " + (int) summa + " kr");
                    summa -= 0.5; // Tillbaka till orginala priset
                    break;
                //Avsluta
                case 5:
                    laddar();
                    System.out.println("Avslutar...");
                    return;
            }
        }
    }
}
