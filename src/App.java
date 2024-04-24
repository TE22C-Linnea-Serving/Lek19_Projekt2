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

    public static void bokaPlats() throws InterruptedException {
        Scanner tangentbord = new Scanner(System.in);
        laddar();
        System.out.println("Välj:\n1. Ange namn\n2. Ange personnummer");

        int val1 = tangentbord.nextInt();
        if (val1 == 1) {
            System.out.println("Ange namn:");
            String X2 = tangentbord.nextLine(); // tar bort enter
            String namn = tangentbord.nextLine();

            if (!namn.matches("[a-zA-Z]+")) {
                System.out.println("Ogiltigt namn");
                return;
            }

            String[] plats= new String[19];
            System.out.println("[ 1][2 ][ ][ 3][4 ]\n[ 5][6 ][ ][ 7][8 ]\n[ 9][10][ ][11][12]\n[13][14][ ][15][16]\n[17][18][ ][19][20]");

            String[] namnPlats = new String[19];
            int bokarPlats = tangentbord.nextInt();

            bokarPlats-=1;                          //den platsen som användaren vill boka
            namnPlats[bokarPlats] = namn;           //namnPlats = namnet som tillhör platsen
            plats[bokarPlats] = "X";
            







        } else if (val1 == 2) {
            System.out.println("Ange personnummer (YYYYMMDD):");
            int personnummer = tangentbord.nextInt();
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner tangentbord = new Scanner(System.in);
        while (true) {
            laddar();
            System.out.println("Meny:\n1. Boka plats\n2. Avboka plats\n3. Bokade platser\n4. Beräkna vinster\n5. Avsluta\n");
            int svar = tangentbord.nextInt();
            if (svar == 1) {
                bokaPlats();
            }else if(svar == 2){

            }else if(svar == 3){

            }else if(svar == 4){

            }else if(svar == 5){
                laddar();
                break;
            }
        }
    }
}
