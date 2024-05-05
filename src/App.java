import java.util.Arrays;
import java.util.Scanner;

public class App {

    public static void laddar() throws InterruptedException {
        System.out.println("");
        System.out.print("Laddar");

        for (int i = 0; i < 3; i++) {
            System.out.print(".");
            Thread.sleep(250);
        }
        System.out.println("\n");
    }


    public static void main(String[] args) throws Exception {

        Scanner tangentbord = new Scanner(System.in);

        String plats[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17","18", "19", "20" };
        String namnPerson[] = new String[20];
        int[] personnummerPerson = new int[20];
        int[] age = new int[20];
        double summa = 0;
        final double barnpris = 149.90;
        final double vuxenpris = 299.90;

        while (true) {
            laddar();
            System.out.println("Meny:\n1. Boka plats\n2. Avboka plats\n3. Bokade platser\n4. Beräkna vinster\n5. Avsluta\n");
            int svar = tangentbord.nextInt();

            switch (svar) {
            case 1:
                laddar();
                System.out.println("Välj vilken plats du vill boka:");
                System.out.println("[ " + plats[0] + "][" + plats[1] + " ][ ][ " + plats[2] + "][" + plats[3] + " ]\n[ "+ plats[4] + "][" + plats[5] + " ][ ][ " + plats[6] + "][" + plats[7] + " ]\n[ " + plats[8]+ "][" + plats[9] + "][ ][" + plats[10] + "][" + plats[11] + "]\n[" + plats[12] + "]["+ plats[13] + "][ ][" + plats[14] + "][" + plats[15] + "]\n[" + plats[16] + "][" + plats[17]+ "][ ][" + plats[18] + "][" + plats[19] + "]");
                if (!tangentbord.hasNextInt()) {
                    System.out.println("Du skrev in ett ogiltigt svar");
                    break;
                } else {

                    int valPlats = tangentbord.nextInt();
                    valPlats -= 1;

                    if (plats[valPlats] == "X") {
                        System.out.println("Du försökte boka en upptagen plats. Välj en annan plats");
                        System.out.println("[ " + plats[0] + "][" + plats[1] + " ][ ][ " + plats[2] + "][" + plats[3] + " ]\n[ "+ plats[4] + "][" + plats[5] + " ][ ][ " + plats[6] + "][" + plats[7] + " ]\n[ " + plats[8]+ "][" + plats[9] + "][ ][" + plats[10] + "][" + plats[11] + "]\n[" + plats[12] + "]["+ plats[13] + "][ ][" + plats[14] + "][" + plats[15] + "]\n[" + plats[16] + "][" + plats[17]+ "][ ][" + plats[18] + "][" + plats[19] + "]");
                        valPlats = tangentbord.nextInt();
                        valPlats -= 1;
                    } // Om man väljer en upptagen plats ska man välja igen

                    laddar();

                    System.out.println("Skriv in ditt namn:");
                    String enter = tangentbord.nextLine();
                    String namn = tangentbord.nextLine();
                    namnPerson[valPlats] = namn;

                    laddar();
                    System.out.println("Skriv in ditt personnummer (YYYYMMDD):");
                    int personnummer = tangentbord.nextInt();
                    if ((personnummer - 18799999) <= 0) { // Född innan 1880-talet
                        System.out.println("Felaktigt personnummer.");
                        return;
                    }
                    personnummerPerson[valPlats] = personnummer;

                    laddar();

                    System.out.println("Skriv in din ålder:");
                    age[valPlats] = tangentbord.nextInt();

                    double test1 = personnummerPerson[valPlats];
                    if (((int) (20240000 - test1) / 10000) == age[valPlats]
                            || (((int) (20240000 - test1) / 10000) + 1) == age[valPlats]) {
                        if (age[valPlats] < 18) {
                            summa += barnpris;
                        } else if (age[valPlats] >= 18) { // Vuxenpriser
                            summa += vuxenpris;
                        }
                        plats[valPlats] = "X";
                        personnummerPerson[valPlats] = personnummer;
                        laddar();
                        System.out.println("Din plats är nu bokad.");
                    } else {
                        System.out.println("Åldern stämmer inte överräns med personnummret");
                    }
                }

            case 2:
                
                laddar();

                System.out.println("[ " + plats[0] + "][" + plats[1] + " ][ ][ " + plats[2] + "][" + plats[3] + " ]\n[ "+ plats[4] + "][" + plats[5] + " ][ ][ " + plats[6] + "][" + plats[7] + " ]\n[ " + plats[8]+ "][" + plats[9] + "][ ][" + plats[10] + "][" + plats[11] + "]\n[" + plats[12] + "]["+ plats[13] + "][ ][" + plats[14] + "][" + plats[15] + "]\n[" + plats[16] + "][" + plats[17]+ "][ ][" + plats[18] + "][" + plats[19] + "]");
                System.out.println("Vilken plats vill du avboka?");

                laddar();

                if (!tangentbord.hasNextInt()) {
                    break;
                }
                int avbokaVal = tangentbord.nextInt();
                avbokaVal -= 1;
                while (plats[avbokaVal] != "X") {
                    laddar();
                    System.out.println("Du försökte avboka en obokad plats. Välj en annan plats:");
                    System.out.println("[ " + plats[0] + "][" + plats[1] + " ][ ][ " + plats[2] + "][" + plats[3] + " ]\n[ "+ plats[4] + "][" + plats[5] + " ][ ][ " + plats[6] + "][" + plats[7] + " ]\n[ " + plats[8]+ "][" + plats[9] + "][ ][" + plats[10] + "][" + plats[11] + "]\n[" + plats[12] + "]["+ plats[13] + "][ ][" + plats[14] + "][" + plats[15] + "]\n[" + plats[16] + "][" + plats[17]+ "][ ][" + plats[18] + "][" + plats[19] + "]");
                    avbokaVal = tangentbord.nextInt();
                    avbokaVal -= 1;
                }
                System.out.println("Vill du avboka med ditt namn eller personnummer?\n1. Namn\n2. Personnummer");

                laddar();

                while (!tangentbord.hasNextInt()) {
                    System.out.println("Ogiltigt!!");
                }
                int val1 = tangentbord.nextInt();
                if (val1 == 1) {
                    System.out.println("Vad heter du?");
                    String enter = tangentbord.nextLine();
                    String svarNamn = tangentbord.nextLine();
                    if (svarNamn.equals(namnPerson[avbokaVal])) {
                        plats[avbokaVal] = avbokaVal + 1 + "";
                        namnPerson[avbokaVal] = null;
                        personnummerPerson[avbokaVal] = 0;
                    } else {
                        System.out.println("Ogiltigt namn, försök igen:");
                    }
                } else if (val1 == 2) {
                    System.out.println("Vad är ditt personnummer?");
                    String enter = tangentbord.nextLine();
                    int svarPersonnummer = tangentbord.nextInt();
                    if (svarPersonnummer == personnummerPerson[avbokaVal]) {
                        plats[avbokaVal] = avbokaVal + 1 + "";
                        namnPerson[avbokaVal] = null;
                        personnummerPerson[avbokaVal] = 0;
                    } else {
                        System.out.println("Ogiltigt personnummer, försök igen:");
                    }
                    if (age[avbokaVal] < 18) {
                        summa -= barnpris;
                    } else if (age[avbokaVal] >= 18) {
                        summa -= vuxenpris;
                    }
                }

                laddar();

                System.out.println("Din plats är nu avbokad");

            case 3:
                laddar();
                System.out.println("[ " + plats[0] + "][" + plats[1] + " ][ ][ " + plats[2] + "][" + plats[3] + " ]\n[ "+ plats[4] + "][" + plats[5] + " ][ ][ " + plats[6] + "][" + plats[7] + " ]\n[ " + plats[8]+ "][" + plats[9] + "][ ][" + plats[10] + "][" + plats[11] + "]\n[" + plats[12] + "]["+ plats[13] + "][ ][" + plats[14] + "][" + plats[15] + "]\n[" + plats[16] + "][" + plats[17]+ "][ ][" + plats[18] + "][" + plats[19] + "]");
                int antalLedigt = 0;
                for (int i = 0; i < plats.length; i++) {
                    if (plats[i] != "X") {
                        antalLedigt++;
                    }
                }

                System.out.println("Det finns " + antalLedigt + " lediga platser\n");

            int[] sortering = {age[0], age[1],age[2],age[3],age[4],age[5],age[6],age[7],age[8],age[9],age[10],age[11],age[12],age[13],age[14],age[15],age[16],age[17],age[18],age[19]};

            for(int i = 0; i < sortering.length; i++){
                System.out.println("Namn: "+namnPerson[i]+"     Ålder: "+age[i]+"       Personnummer: "+personnummerPerson[i]+"     Plats: "+(i+1));
            }

            case 4:
                laddar();
                summa += 0.5; // Avrundar till heltal
                System.out.println("Den totala vinsen är: " + (int) summa + " kr");
                summa -= 0.5; // Tillbaka till orginala priset

            case 5:
                laddar();
                System.out.println("Avslutar...");
                break;
            }
        }
    }
}
