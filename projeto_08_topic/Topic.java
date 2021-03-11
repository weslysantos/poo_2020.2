import java.util.ArrayList;
import java.util.Scanner;

class Passageiro{
    String id;
    int idade;

    public Passageiro(String id, int idade) {
		this.id = id;
    this.idade = idade;
    }
    public String toString() {
		return this.id + ":" + this.idade;
	}
    
}

class Topic{
    ArrayList<Passageiro> cadeirasN;
    ArrayList<Passageiro> cadeirasP;
    
	public Topic(int quantidade, int quantidadeP) { 
        cadeirasN = new ArrayList<>();   
        cadeirasP = new ArrayList<>();   
		for(int i = 0; i < quantidade; i++) { 
        if(i < quantidadeP){
            cadeirasP.add(null);  
        }else{
          cadeirasN.add(null);
        }
      }
    }
    
    public boolean subir(Passageiro passageiro){
      if(passageiro.idade > 64){
        for(int i = 0; i < cadeirasP.size(); i++){
          if(cadeirasP.get(i) == null){
            cadeirasP.set(i, passageiro);
            return true;
          }     
        }
      }
      for(int i = 0; i < cadeirasN.size(); i++){
        if(cadeirasN.get(i) == null){
          cadeirasN.set(i, passageiro);
          return true;
        }
      }
      for(int i = 0; i < cadeirasP.size(); i++){
        if(cadeirasP.get(i) == null){
          cadeirasP.set(i, passageiro);
          return true;
        }
      }
      System.out.println("Falha, topic lotada !!!");
      return false;

    }

    public Passageiro descer(String id){
      for(int i = 0; i < cadeirasN.size(); i++){
        if(cadeirasN.get(i) != null && cadeirasN.get(i).id.equals(id)){
          cadeirasN.set(i, null);
          return cadeirasN.get(i);
        }
      } 

      for(int i = 0; i < cadeirasP.size(); i++){
        if(cadeirasP.get(i) != null && cadeirasP.get(i).id.equals(id)){
          cadeirasP.set(i, null);
          return cadeirasP.get(i);
        }
      }
      System.out.println("Falha: o passageiro não está presente na topic !!!");
      return null;
    }

    public String toString() { 
      String saida = "[ ";
      for(Passageiro passageiro : cadeirasP) {
        if(passageiro != null) {
          saida += "@" + passageiro + " ";
        } else {
          saida += "@ ";
        }
      }
  
      for(Passageiro passageiro : cadeirasN) {
        if(passageiro != null) {
          saida += "=" + passageiro + " ";
        } else {
          saida += "= ";
        }
      }
      return saida + "]"; 
	}

  public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    Topic topic = null;
    while(true){
      String line = scanner.nextLine();
      String[] ui = line.split(" ");
      
      if(ui[0].equals("init")){
        topic = new Topic(Integer.parseInt(ui[1]), Integer.parseInt(ui[2]));
      } else if(ui[0].equals("in")) {
        topic.subir(new Passageiro(ui[1], Integer.parseInt(ui[2])));
      } else if(ui[0].equals("out")) {
        topic.descer(ui[1]);
      } else if(ui[0].equals("show")) {
        System.out.println(topic);
      } else if(ui[0].equals("end")) {
        break;	
      } else {
       System.out.println("Comando invalido");
     }
    }
    scanner.close();
  }
}