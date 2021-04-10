import java.util.TreeMap;

public class User {
  private String nome;
  private TreeMap<String, User> usrseguindo;
  private TreeMap<String, User> usrseguidores;
  private TreeMap<Integer, Tweet> timeline;
  private int unreadCount;
  public User(String nome) {
    this.nome = nome;
    this.usrseguindo = new TreeMap<>();
    this.usrseguidores = new TreeMap<>();
    this.timeline = new TreeMap<>();
    unreadCount = 0;
  }
  public String getNome() {
    return this.nome;
  }
  public Tweet getTweet(int id) {
    if(!timeline.containsKey(id)) {
      throw new RuntimeException("fail: tweet nao encontrado");
    }
    return this.timeline.get(id);
  }
  public String getUnread() {
    String saida = "";
    for(int i = this.timeline.size() - unreadCount; i < this.timeline.size(); i++) {
      saida += this.timeline.get(i);
    }
    unreadCount = 0;
    return saida;
  }
  public String getTimeline() {
    String saida = "";
    for(Tweet tweet : this.timeline.values()) {
      saida += tweet;
    }
    unreadCount = 0;
    return saida;
  }
  public void follow(User user) {
    if(usrseguidores.containsKey(user.nome)) {
      throw new RuntimeException("Você Já Segue Esse Usuário");
    }
    this.usrseguidores.put(user.nome, user);
    user.usrseguindo.put(this.nome, this);
  }
  public void unfollow(User user) {
    if(!usrseguidores.containsKey(user.getNome())) {
      throw new NullPointerException("Você Não Segue Esse Usuário");
    }
    this.usrseguidores.remove(user.getNome());
    user.usrseguindo.remove(this.getNome());
  }
  public void sendTweet(Tweet tweet) {
    this.timeline.put(tweet.getNum(), tweet);
    for(User user : usrseguindo.values()) {
      user.timeline.put(tweet.getNum(), tweet);
      user.unreadCount++;
    }
  }
  public String toString() {
    String saida = "";
    saida += this.getNome() + "\n" + " seguidos\t[";
    for(User user : this.usrseguidores.values()) {
      saida += " " + user.getNome() + " ";
    }
    saida += "]\n seguidores\t[";
    for(User user : this.usrseguindo.values()) {
      saida += " " + user.getNome() + " ";
    }
    saida += "]";
    return saida;
  }
}

