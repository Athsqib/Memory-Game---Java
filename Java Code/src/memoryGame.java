import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class memoryGame{
    public static String randomizeString(int length){
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz" + "0123456789";

        Random random = new Random();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            // System.out.println(index);
            result.append(characters.charAt(index));
            // System.out.println(result);
        }

        return result.toString();
    }

    public static void clearScreen(){
       try {
            String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                // For Windows cmd
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // For Linux and Mac
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException e) {
            System.getLogger(memoryGame.class.getName()).log(System.Logger.Level.ERROR, (String) null, e);
        }
    }

    public static void sleep(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            System.getLogger(memoryGame.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    public static void sleepPendek(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.getLogger(memoryGame.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    public static void main(String[] args){
        clearScreen();
        System.out.println("SELAMAT DATANG DI DALAM PERMAINAN MEMORI");
        try (Scanner input = new Scanner(System.in)) {

            System.out.println("Pilih kesulitan: \n1. Easy\n2. Medium\n3. Hard ");
            int kesulitan = input.nextInt();
            input.nextLine();
            int panjang;
            switch (kesulitan) {
                case 1 -> panjang = 4;
                case 2 -> panjang = 5;
                case 3 -> panjang = 10;
                default -> panjang = 4;
            }
            clearScreen();
            String kunci = randomizeString(panjang);
            System.out.println(kunci);
            sleep();
            clearScreen();

            int pengulangan = 3;
            while(pengulangan > 0){
                System.out.println("Masukkan String yang kamu lihat: ");
                String jawaban = input.nextLine();
                if(jawaban.equals(kunci)){
                    System.out.println("Benar");
                    sleepPendek();
                    break;
                } else{
                    System.out.println("Salah");
                    sleepPendek();
                }
                pengulangan -= 1;
                clearScreen();
            }

            if (pengulangan == 0) {
                System.out.println("GAME OVER");
            } else {
                System.out.println("SELAMAT ANDA BENAR");
            }
        }
    }
}