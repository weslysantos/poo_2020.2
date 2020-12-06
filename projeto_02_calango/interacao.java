import java.util.Arrays;
import java.util.Scanner;
public class interacao {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite vários números até -1: ");
        String line = scanner.nextLine();
        String[] tokens = line.split(" ");
        int qtd = tokens.length;
        System.out.println("Voce digitou " + qtd + " elementos");
        System.out.println("[ ");
        for(int i = 0; i < tokens.length; i++)
            //System.out.println(Arrays.asList(tokens));
            System.out.println(tokens[i] + " ");
        System.out.println("]");
        //SOMANDO TODOS

        int acc = 0;
        for(int i = 0; i < tokens.length; i++)
            acc += Float.parseFloat(tokens[i]);
        
        scanner.close();
        /*int a = scanner.nextInt();
        int b = scanner.nextInt();
        int soma = a + b;
        System.out.println(soma);
        */
        /*
        int acc = 0;
        while (true){
            int a = scanner.nextInt();
            if(a == -1)
                break;
            acc += a;
        }
        System.out.println(acc);
        scanner.close();
        */
    }
    
}
