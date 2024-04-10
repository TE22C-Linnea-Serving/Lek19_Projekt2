import java.util.Scanner;

public class App {

    public static void laddar() throws InterruptedException
    {
        System.out.print("Laddar");
        
        for(int i=0; i<3; i++)
        {
            System.out.print(".");
            Thread.sleep(250);
        }
        System.out.println("\n");
    }

    public static void main(String[] args) throws Exception {
        Scanner tangentbord = new Scanner(System.in);

        boolean x=true;
        while(x==true)
        {
        laddar();
        System.out.println("Meny:\n1. Boka plats\n2. Avboka plats\n3. Beräkna vinster\n4. Avsluta\n");

        int svar = tangentbord.nextInt();

        if(svar==1){                                    //Boka plats
            String X = tangentbord.nextLine();          //tar bort enter
            System.out.println("Ange namn:");
            String namn = tangentbord.nextLine();
            System.out.println("Vilken plats");
            
            char[] chars = namn.toCharArray();
            for(int i =0 ; i<chars.length;i++){
               if(Character.isDigit(chars[i] )){
                  // Nu har vi hittat en siffra jippie
                  System.out.println("Du skrev ett ogiltigt namn. Försök igen");        //FORTSÄTT
                  break; 
               }
            }

        }else if(svar==2)                               //Avboka plats
        {

        }else if(svar==3)                   //Beräkna vinst
        {

        }else if(svar==4)                   //Avsluta
        {
            laddar();
            x=false;
        }else
        {
            System.out.println("Du angav ett fel svar. Vänligen välj bland alternativen");
        }
    }
}
}
