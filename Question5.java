import java.util.Scanner;

public class Question5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String palavra = sc.nextLine();
        String Inversa = "";

        for (int i = palavra.length() - 1; i >= 0; i--) {
            Inversa += palavra.charAt(i);
            //System.out.println(Inversa);
        }
        System.out.println(Inversa);
    }
}
