import java.util.*;

public class Agenda {
	private TreeMap<String, Contato> conts;
	public Agenda() {
		this.conts = new TreeMap<>();
	}
	public ArrayList<Contato> getConts(){
		ArrayList<Contato> aux = new ArrayList<>();
		for(Contato contato : conts.values())
			aux.add(contato);
		return aux;
	}
	public Contato getContato(String label) {
		if(!conts.containsKey(label)) {
			throw new NullPointerException("Contato Inexistente");
		}
		return this.conts.get(label);
	}
	public void addContato(Contato contato) {
		if(contato == null) {
			throw new NullPointerException("Informe um contato");
		}
		if(this.conts.containsKey(contato.getLabel())) {
			for(Fone fone : contato.getFones()) {
				this.conts.get(contato.getLabel()).addFone(fone.getLabel(), fone.getNum());
			}
			return;
		}
		this.conts.put(contato.getLabel(), contato);
	}
	public void rmContato(String label) {
		if(!this.conts.containsKey(label)) {
			throw new NullPointerException("Contato Inexistente");
		}
		this.conts.remove(label);
	}
	public void rmFone(String label, int index) {
		if(!this.conts.containsKey(label)) {
			throw new NullPointerException("Contato Inexistente");
		}
		this.conts.get(label).rmFone(index);
	}
	public ArrayList<Contato> search(String pattern) {
		ArrayList<Contato> search = new ArrayList<>();
		for(Contato contato : this.conts.values()) {
			if(contato.toString().contains(pattern)) {
				search.add(contato);
			}
		}
		return search;
	}
	public String toString(){
		String saida = "";
		for(Contato contato : conts.values()){
				saida += contato + "\n";
		}
		return saida;
	}  
}