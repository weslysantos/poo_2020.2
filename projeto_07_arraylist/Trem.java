import java.util.ArrayList;
import java.util.Scanner;

class Pessoa{
    String nome;
	
	public Pessoa(String nome) { //construtor;
		this.nome = nome;
	}
	
	public String toString() { //imprimir com toString;
		return nome;
	}
}

class Trem {
    ArrayList<Pessoa> assentos; //criando um array com infinitas posições;
	ArrayList<Pessoa> terminal; //criando um array com infinitas posições;

	public Trem(int quantidade) { //construtor
		assentos = new ArrayList<>();
		terminal = new ArrayList<>();
		for(int i = 0; i < quantidade; i++) { //preenchendo o vetor;
			assentos.add(new Pessoa(" - ")); //adiciona dentro do arraylist [ - - - - ];
		}
	}

	public void esperando(Pessoa pessoa) {
        terminal.add(0, pessoa); // adicionando pessoas na posição 0;
	}

	
	public void entrar(int assento) {
		if(this.terminal.isEmpty()) { //verifica se alguém está esperando;
			System.out.println("fail: nao tem ninguem esperando");
			return;
		}
		Pessoa primeira = terminal.get(terminal.size() - 1);//pegando quem está na última posição
		
		if(assentos.get(assento).nome != " - ") {
			System.out.println("fail: assento ocupado.");
			return;
		}

		assentos.set(assento, primeira);
        System.out.println("Pessoa adicionado(a) com sucesso !!!");
		terminal.remove(terminal.size() - 1);
	}
 
    public void buscar(){
		boolean lotado = true;
		for(int i = 0; i < assentos.size(); i++) {
			if(assentos.get(i).nome.equals(" - ")) {
				System.out.println("Assento " + i + " vazio.");
				lotado = false;
			}
		}
		if(lotado) {
			System.out.println("fail: trem lotado.");
		}
    }

    public void liberarAssento(String nome){
		for(int i = 0; i < assentos.size(); i++) {
			if(assentos.get(i).nome.equals(nome)) {
				assentos.set(i, new Pessoa(" - "));
				System.out.println(nome + " saiu.");
				return;
			} 
		}
    }


    public String toString() { //imprimir com toString;
		return "=>" + terminal + " => " + assentos;
	}

    public static void main(String[] args) {
		Trem trem = new Trem(10);
        Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.println("ESCOLHA UMA OPÇÃO: ");
			System.out.println("show - INFORMAÇÕES DO TREM");
            System.out.println("esperando- ADICIONAR PESSOAS NA FILA DE ESPERA");
            System.out.println("entrar - ADICIONAR PESSOAS NO TREM");
            System.out.println("liberar - LIBERAR ASSENTO");
			System.out.println("buscar - BUSCAR ASSENTOS LIVRES");
            System.out.println("sair - SAIR");
			String line = scanner.nextLine();
			String ui[] = line.split(" ");
            if(ui[0].equals("esperando")){
                trem.esperando(new Pessoa(ui[1]));
			}
			else if(ui[0].equals("show")){
				System.out.println(trem);
            }
            else if(ui[0].equals("entrar")){
				trem.entrar(Integer.parseInt(ui[1]));
            }
            else if(ui[0].equals("liberar")){
				trem.liberarAssento(ui[1]);
            }
            else if(ui[0].equals("buscar")){
				trem.buscar();
            }
            else if(ui[0].equals("sair")){
                break;
            }
            else{
                System.out.println("Comando Inválido !!!");
            }
		}    
		scanner.close();
    }
}
