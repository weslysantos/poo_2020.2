import java.util.Scanner;

public class Mago {
  String name;
  Mago(String name) {
    this.name = name;
  }
  public String toString() {
    return "Nome: " + this.name;
  }
  public static void main(String[] args) {
    Mago mago = new Mago("John Doe");
    Scanner scanner = new Scanner(System.in);
    while(true) {
      String line = scanner.nextLine();
      String[] ui = line.split(" ");
      if(ui[0].equals("end")) {
        break;
      } else if(ui[0].equals("init")){
        mago = new Mago(ui[1]);
      } else if(ui[0].equals("show")) {
        System.out.println(mago);
      } else {
        System.out.println("Comando invalido");
      }
    }
    scanner.close();
  }
}