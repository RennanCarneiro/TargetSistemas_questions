import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero_escolhido = sc.nextInt();
        int x = 1; int y = 0;
        int proximaEtapa = 0;

        if(numero_escolhido == 1 || numero_escolhido == 0){
        System.out.println("o numero: " + numero_escolhido + "pertence a sequencia de Fibonacci");
        }

        for (int i = 0; i <= numero_escolhido ; i++) {
            proximaEtapa = x + y;
            y = x;
            x = proximaEtapa;
            //System.out.println(proximaEtapa);
        }

        if(proximaEtapa == numero_escolhido){
            System.out.println("O número " + numero_escolhido + " é pertencente à sequência de Fibonacci.");
        }
        else{
            System.out.println("O número " + numero_escolhido + " não é pertencente à sequência de Fibonacci.");
        }
    }
}
