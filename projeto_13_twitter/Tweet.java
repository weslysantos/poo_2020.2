import java.util.TreeSet;

public class Tweet {
  private String nome;
  private String msg;
  private int num;
  private TreeSet<String> likes;
  public Tweet(int num, String nome, String msg) {
    this.num = num;
    this.nome = nome;
    this.msg = msg;
    this.likes = new TreeSet<>();
  }
  public int getNum() {
    return this.num;
  }
  public String getNome() {
    return this.nome;
  }
  public String getMessage() {
    return this.msg;
  }
  public void gostei(String nome) {
    for(String user : likes) {
      if(user.equals(nome)) {
        throw new RuntimeException("Você Já Curtiu Esse Tweet");
      }
    }
    this.likes.add(nome);
  }
  public String toString() {
    String aux = "";
    String users = "";
    if(likes.size() == 0) {
      aux += this.num + ":" + this.nome + "( " + this.msg + ")\n"; 
      return aux;
    } else {
      for(String user : this.likes) {
        users += user + " ";
      }
      aux += this.num + ":" + this.nome + "( " + this.msg + ")" + "[ " + users + "]\n";
    }
    return aux;
  }
}
