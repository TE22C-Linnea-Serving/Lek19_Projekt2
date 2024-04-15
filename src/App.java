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

        boolean x = true;
        while (x == true) {
            laddar();
            System.out.println(
                    "Meny:\n1. Boka plats\n2. Avboka plats\n3. Bokade platser\n4. Beräkna vinster\n5. Avsluta\n");

            int svar = tangentbord.nextInt();

            if (svar == 1) { // Boka plats
                laddar();
                String X1 = tangentbord.nextLine(); // tar bort enter
                System.out.println("Välj:\n1. Ange namn\n2. Ange personnummer");
                int val1 = tangentbord.nextInt();
                if (val1 == 1) {
                    System.out.println("Ange namn:");
                    String X2 = tangentbord.nextLine(); // tar bort enter
                    String namn = tangentbord.nextLine();
                    laddar();

                    char[] chars = namn.toCharArray();
                    for (int i = 0; i < chars.length; i++) {
                        if (Character.isAlphabetic(chars[i])) {

                        } else {
                            System.out.println("Du skrev ett ogiltigt namn. Försök igen");
                            namn = tangentbord.nextLine();
                            break;
                        }
                    }
                } else if (val1 == 2) {
                    System.out.println("Ange personnummer");
                    int personnummer = tangentbord.nextInt();
                    System.out.println(personnummer);

                }

                int antalPlatser = 0;
                int[] platser = new int[19];
                platser[3] = 7;
                for (int i = 0; i > platser.length; i++) {
                    if ( platser[i] != 0) {
                        antalPlatser++;
                        // Fungerar inte
                    }
                    System.out.println("Just nu finns det " + antalPlatser + " bokade platser");
                }

            } else if (svar == 2) // Avboka plats
            {

            } else if (svar == 3) // Bokade platser
            {

            } else if (svar == 4) // Bärkana vinst
            {
            } else if (svar == 5) { // Avsluta
                laddar();
                x = false;
            } else {
                System.out.println("Du angav ett fel svar. Vänligen välj bland alternativen");
            }
        }
    }
}
