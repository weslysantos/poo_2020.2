import java.util.Scanner;
public class Treino {
    String name;
    int forca;
    int peso;
    int qtd = 0;
    int energia;
    Treino(String name){
        this.name = name;
        // valores de inicializaçao
        this.forca = 0;
        this.peso = 0;
        this.qtd = 0;
        this.energia = 20;
    }
    void Comer(int qtd){
        if(energia > 0){
            energia -= 1;
            if(peso <= 150){
                peso += qtd * 5;
                System.out.println("Estou focado, aumentei mais alguns quilos !!");
            }else{
                System.out.println("Já estou no meu limite de peso !!");
            }
        }else{
            System.out.println("Estou esgotado !!"); 
        }
    }
    void Treinar(int qtd){
        if(energia > 0){
            energia -= 1;
            forca += qtd * 10;
            System.out.println("Estou focado, minha força esta cada vez maior !!");
        }else{
            System.out.println("Estou esgotado !!"); 
        }
    }
    void Correr(){
        if(energia > 0){
            energia -= 1;
            peso -= qtd * 2;
            System.out.println("Realizei meu cardio, estou com bem menos gordura !!");
        }else{
            System.out.println("Estou esgotado !!"); 
        }
    }
    void Renovar(){
        if(energia != 0){
            energia += 5;
            System.out.println("Renovei minhas energias, estou pronto !!");
        }
    }
    public String toString() {
        return "Nome:  " +  name + " " + "Forca:  " + forca + " " + "Peso:  " +  peso + " " + "Energia: " + this.energia;
    }
    public static void main(String[] args) {
        Treino treino = new Treino("Wesly Santos");
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("ESCOLHA UMA OPÇÃO: ");
            System.out.println("1 - COMER");
            System.out.println("2 - TREINAR");
            System.out.println("3 - MOSTRAR ESTADO DO ATLETA");
            System.out.println("4 - CORRER");
            System.out.println("5 - RENOVAR ENERGIA");
            String line = scanner.nextLine();
            String ui[] = line.split(" ");
            if(ui[0].equals("1")){
                int qtd = Integer.parseInt(ui[1]);
                treino.Comer(qtd);
            }else if(ui[0].equals("2")){//init _nome
                int qtd = Integer.parseInt(ui[1]);
                treino.Treinar(qtd);
            }else if(ui[0].equals("3")){
                System.out.println(treino);
            }else if(ui[0].equals("4")){
                treino.Correr();
            }else if(ui[0].equals("5")){
                treino.Renovar();
            } else {
                System.out.println("Comando invalido");
                break;
            }
        }
        scanner.close();
    }
}