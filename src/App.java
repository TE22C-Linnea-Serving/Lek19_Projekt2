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
        String plats[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
                "18", "19", "20" };
        String[] namnPlats = new String[19];
        String namnPerson[] = new String[19];
        int[] personnummer = new int[19];
        double summa = 0;

        Scanner tangentbord = new Scanner(System.in);
        while (true) {
            laddar();
            System.out.println(
                    "Meny:\n1. Boka plats\n2. Avboka plats\n3. Bokade platser\n4. Beräkna vinster\n5. Avsluta\n");
            int svar = tangentbord.nextInt();
            if (svar == 1) {
                // ______________________________
                laddar();

                System.out.println("[ " + plats[0] + "][" + plats[1] + " ][ ][ " + plats[2] + "][" + plats[3] + " ]\n[ "
                        + plats[4] + "][" + plats[5] + " ][ ][ " + plats[6] + "][" + plats[7] + " ]\n[ " + plats[8]
                        + "][" + plats[9] + "][ ][" + plats[10] + "][" + plats[11] + "]\n[" + plats[12] + "]["
                        + plats[13] + "][ ][" + plats[14] + "][" + plats[15] + "]\n[" + plats[16] + "][" + plats[17]
                        + "][ ][" + plats[18] + "][" + plats[19] + "]");

                int valPlats = tangentbord.nextInt();
                // Lägg till om vald plats är upptagen

                System.out.println("Välj:\n1. Ange namn\n2. Ange personnummer");

                int val1 = tangentbord.nextInt();
                if (val1 == 1) {

                    System.out.println("Skriv in ditt namn:");
                    String enter = tangentbord.nextLine();
                    String namn = tangentbord.nextLine();
                    namnPlats[valPlats] = namn;
                    valPlats-=1;
                    namnPerson[valPlats] = namn;
                    plats[valPlats] = "X";

                    System.out.println("Skriv in din ålder:");
                    int age = tangentbord.nextInt();
                    if(age<18){                         //Barn priser
                        summa+=149.90;
                    }else if(age>18){                   //Vuxenpriser
                        summa+=299.90;
                    }else{
                        //När man skiver in en felaktig ålder t.ex X<0
                    }

                    // checkForNumber(namn);

                    // ________________________________
                } else if (svar == 2) {

                } else if (svar == 3) {

                } else if (svar == 4) {

                } else if (svar == 5) {
                    laddar();
                    break;
                }
            }
        }
    }

    private static String nextLine() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'nextLine'");
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
