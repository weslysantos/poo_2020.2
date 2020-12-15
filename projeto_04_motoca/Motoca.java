import java.util.Scanner;
class Moto {
    Pessoa pessoa;
    int potencia;
    int tempo;
    
    Moto(int potencia){
        // valores de inicializaçao
        this.potencia = potencia;
        this.tempo = 0;
    }
    
    void Iniciar(int potencia){
        this.potencia = potencia;
    }

    void Subir(Pessoa piloto){
        if(pessoa == null){
            pessoa = piloto;
        }else{
            System.out.println("Moto ocupada");
        }
    }
    void Descer(){
        if(pessoa != null){
            pessoa = null;
        }else{
            System.out.println("Moto vazia !!");
        }
    }
    void comprarTempo(int tempo){
        this.tempo += tempo;
    }
    void dirigir(int tempo){
        if(pessoa == null){
            System.out.println("Adicione uma pessoa na moto !!!");
            return;
        }else if(pessoa.idade > 10){
            System.out.println("Pessoa impossibilitada de dirigir !!!");
        }else if(this.tempo >= tempo){
            this.tempo -= tempo;
            System.out.println("Complete o seu trajeto !!!");
        }else if(this.tempo == 0) {
            System.out.println("Tempo zerado");
        }else {
            System.out.println("Andou " + this.tempo + " min e acabou o tempo");
            this.tempo = 0;
        }
    } 
    public String toString() {
        return "Potencia:  " +  this.potencia + " / " + "Minutos:  " + this.tempo + " / " + "Pessoa:  " +  this.pessoa;
    }
}

class Pessoa{
    String name;
    int idade;
    Pessoa(String name, int idade){
        // valores de inicializaçao
        this.name = name;
        this.idade = idade;
    }

    public String toString() {
        return this.name + " " + this.idade;
    }
}

public class Motoca {
    public static void main(String[] args) {
        Moto moto = new Moto(1);
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("ESCOLHA UMA OPÇÃO: ");
            System.out.println("show - MOSTRAR ESTADO DA MOTO");
            System.out.println("init - INICIAR A POTÊNCIA");
            System.out.println("in - SUBIR");
            System.out.println("out - DESCER");
            System.out.println("buy - COMPRAR TEMPO");
            System.out.println("drive - DIRIGIR");
            System.out.println("end - SAIR");
            String line = scanner.nextLine();  
            String ui[] = line.split(" ");
            if(ui[0].equals("show")){
                System.out.println(moto);
            }else if(ui[0].equals("init")){//init _nome
                moto.Iniciar(Integer.parseInt(ui[1]));
            }else if(ui[0].equals("in")){
                Pessoa pessoa = new Pessoa(ui[1], Integer.parseInt(ui[2]));
                moto.Subir(pessoa);
            }else if(ui[0].equals("out")){
                moto.Descer();
            }else if(ui[0].equals("buy")){
               moto.comprarTempo(Integer.parseInt(ui[1]));
            }else if(ui[0].equals("drive")){
                moto.dirigir(Integer.parseInt(ui[1]));
            }else if(ui[0].equals("end")){
                break;
            } else {
                System.out.println("Comando invalido");
                break;
            }
        }
        scanner.close();          
    }
}