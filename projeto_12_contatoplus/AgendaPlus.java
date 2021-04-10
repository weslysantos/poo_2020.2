import java.util.TreeMap;
import java.util.ArrayList;

public class AgendaPlus extends Agenda {
  private TreeMap<String, ContatoPlus> favs;
  public AgendaPlus() {
    favs = new TreeMap<>();
  }
  public ArrayList<ContatoPlus> getFavs() {
		ArrayList<ContatoPlus> temp = new ArrayList<>();
		for(ContatoPlus contato : this.favs.values()) {
			temp.add(contato);
		}
		return temp;
	}
  @Override
	public void rmContato(String label) {
		if(this.getContato(label) == null) {
			throw new NullPointerException("Contato Inexistente");
		}

		super.rmContato(label);
		this.favs.remove(label);
	}
  public void favoritar(String label) {
    if(this.favs.containsKey(label)) {
			throw new NullPointerException("Contato já é um Favorito");
		}

		if(this.getContato(label) == null) {
			throw new NullPointerException("Contato Inexistente");
		}
    ContatoPlus contato = (ContatoPlus) getContato(label);
    contato.setStarred(true);
    this.favs.put(label, contato);
  }
  public void desfavoritar(String label) {
    if(!this.favs.containsKey(label)) {
			throw new NullPointerException("Contato não é um Favorito");
		}

		if(this.getContato(label) == null) {
			throw new NullPointerException("Contato Inexistente");
		}
    ContatoPlus contato = (ContatoPlus) getContato(label);
    contato.setStarred(false);
    this.favs.remove(label, contato);
  }
}
