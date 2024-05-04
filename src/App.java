import java.util.Scanner;

public class App {

    public static void laddar() throws InterruptedException {
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
        String namnPerson[] = new String[19];
        int[] personnummer = new int[19];
        int[] age = new int[19];
        double summa = 0;

        while (true) {
            laddar();
            System.out.println("Meny:\n1. Boka plats\n2. Avboka plats\n3. Bokade platser\n4. Beräkna vinster\n5. Avsluta\n");
            int svar = tangentbord.nextInt();
            
            if (svar == 1) {
                laddar();
                
                System.out.println("[ " + plats[0] + "][" + plats[1] + " ][ ][ " + plats[2] + "][" + plats[3] + " ]\n[ "+ plats[4] + "][" + plats[5] + " ][ ][ " + plats[6] + "][" + plats[7] + " ]\n[ " + plats[8]+ "][" + plats[9] + "][ ][" + plats[10] + "][" + plats[11] + "]\n[" + plats[12] + "]["+ plats[13] + "][ ][" + plats[14] + "][" + plats[15] + "]\n[" + plats[16] + "][" + plats[17]+ "][ ][" + plats[18] + "][" + plats[19] + "]");
                int valPlats = tangentbord.nextInt();
                valPlats -= 1;

                if(plats[valPlats]=="X"){
                    System.out.println("Du försökte boka en upptagen plats. Välj en annan plats");
                    System.out.println("[ " + plats[0] + "][" + plats[1] + " ][ ][ " + plats[2] + "][" + plats[3] + " ]\n[ "+ plats[4] + "][" + plats[5] + " ][ ][ " + plats[6] + "][" + plats[7] + " ]\n[ " + plats[8]+ "][" + plats[9] + "][ ][" + plats[10] + "][" + plats[11] + "]\n[" + plats[12] + "]["+ plats[13] + "][ ][" + plats[14] + "][" + plats[15] + "]\n[" + plats[16] + "][" + plats[17]+ "][ ][" + plats[18] + "][" + plats[19] + "]");
                    valPlats = tangentbord.nextInt();
                    valPlats -= 1;
                }                                                        // Om man väljer en upptagen plats ska man välja igen

                System.out.println("Välj:\n1. Ange namn\n2. Ange personnummer");
                int val1 = tangentbord.nextInt();

                if (val1 == 1) {
                    laddar();
                    System.out.println("Skriv in ditt namn:");
                    String enter = tangentbord.nextLine();
                    String namn = tangentbord.nextLine();
                    namnPerson[valPlats] = namn;
                    plats[valPlats] = "X";

                    System.out.println("Skriv in din ålder:");
                    age[valPlats] = tangentbord.nextInt();
                    if (age[valPlats] < 18) { // Barn priser
                        summa += 149.90;
                    } else if (age[valPlats] >= 18) { // Vuxenpriser
                        summa += 299.90;
                    }
                }

            } else if (svar == 2) {
                System.out.println("Vilken plats vill du avboka?");
                System.out.println("[ " + plats[0] + "][" + plats[1] + " ][ ][ " + plats[2] + "][" + plats[3] + " ]\n[ "+ plats[4] + "][" + plats[5] + " ][ ][ " + plats[6] + "][" + plats[7] + " ]\n[ " + plats[8]+ "][" + plats[9] + "][ ][" + plats[10] + "][" + plats[11] + "]\n[" + plats[12] + "]["+ plats[13] + "][ ][" + plats[14] + "][" + plats[15] + "]\n[" + plats[16] + "][" + plats[17]+ "][ ][" + plats[18] + "][" + plats[19] + "]");
                int avbokaVal = tangentbord.nextInt();
                avbokaVal -= 1;
                while(plats[avbokaVal]!="X"){
                    laddar();
                    System.out.println("Du försökte avboka en obokad plats. Välj en annan plats:");
                    System.out.println("[ " + plats[0] + "][" + plats[1] + " ][ ][ " + plats[2] + "][" + plats[3] + " ]\n[ "+ plats[4] + "][" + plats[5] + " ][ ][ " + plats[6] + "][" + plats[7] + " ]\n[ " + plats[8]+ "][" + plats[9] + "][ ][" + plats[10] + "][" + plats[11] + "]\n[" + plats[12] + "]["+ plats[13] + "][ ][" + plats[14] + "][" + plats[15] + "]\n[" + plats[16] + "][" + plats[17]+ "][ ][" + plats[18] + "][" + plats[19] + "]");
                    avbokaVal = tangentbord.nextInt();
                    avbokaVal -= 1;
                }  
                System.out.println("Vad heter du?");
                String enter = tangentbord.nextLine();
                String svarNamn = tangentbord.nextLine();
                if(svarNamn.equals(namnPerson[avbokaVal])){
                    plats[avbokaVal] = avbokaVal+1 + "";
                }else{
                    System.out.println("Fel namn, försök igen");
                }

            } else if (svar == 3) {
                laddar();
                System.out.println("[ " + plats[0] + "][" + plats[1] + " ][ ][ " + plats[2] + "][" + plats[3]
                        + " ]\n[ "
                        + plats[4] + "][" + plats[5] + " ][ ][ " + plats[6] + "][" + plats[7] + " ]\n[ " + plats[8]
                        + "][" + plats[9] + "][ ][" + plats[10] + "][" + plats[11] + "]\n[" + plats[12] + "]["
                        + plats[13] + "][ ][" + plats[14] + "][" + plats[15] + "]\n[" + plats[16] + "][" + plats[17]
                        + "][ ][" + plats[18] + "][" + plats[19] + "]");

                System.out.println("Det finns " + plats.length + "platser");
                // Gå igenom alla och se vilka som är "null", och skriv ut det.

            } else if (svar == 4) {
                laddar();
                summa += 0.5; // Avrundar till heltal
                System.out.println("Den totala vinsen är: " + (int) summa + " kr");
                summa -= 0.5; // Tillbaka till orginala priset

            } else if (svar == 5) {
                laddar();
                break;
            }
        }
    }

    // public static String checkForNumber(String namn){
    // Scanner tangentbord = new Scanner(System.in);
    // while(true){
    // System.out.println("Ange namn:");
    // namn = tangentbord.nextLine();
    // if (!namn.matches("[a-zA-Z]+")) {
    // System.out.println("Ogiltigt namn");
    // continue;
    // }else{
    // return namn;
    // }
    // }
    // }

}
