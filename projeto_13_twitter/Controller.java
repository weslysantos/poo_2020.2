import java.util.TreeMap;

class Controller { 
  private TreeMap<String, User> users;
  private TreeMap<Integer, Tweet> tweets;
  private int nextId;
  public Controller() {
    this.users = new TreeMap<>();
    this.tweets = new TreeMap<>();
    this.nextId = 0;
  }
  public void sendTweet(String nome, String msg) {
    if(!users.containsKey(nome)) {
      throw new NullPointerException("Usuário Não Lozalizado");
    }
    Tweet tweet = new Tweet(this.nextId, nome, msg);
    this.tweets.put(this.nextId, tweet);
    this.users.get(nome).sendTweet(tweet);
    nextId++;
  }
  public void addUser(String nome) {
    if(users.containsKey(nome)) {
      throw new RuntimeException("Usuário Já Cadastrado");
    }
    this.users.put(nome, new User(nome));
  }
  public User getUser(String nome) {
    if(!users.containsKey(nome)) {
      throw new RuntimeException("Usuário Não Lozalizado");
    }
    return this.users.get(nome);
  }
  public String toString() {
    String saida = "";
    for(User user : users.values()) {
      saida += user.toString() + "\n";
    }
    return saida;
  }
}