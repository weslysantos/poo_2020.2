import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Controller sistema = new Controller();
    while(true){
        String line = scanner.nextLine();
        String ui[] = line.split(" ");
        try{
            if(ui[0].equals("addUser")) {
                sistema.addUser(ui[1]);
            } else if(ui[0].equals("follow")) {
                User user = sistema.getUser(ui[1]);
                User other = sistema.getUser(ui[2]);
                user.follow(other);
            }  else if(ui[0].equals("unfollow")) {
                User user = sistema.getUser(ui[1]);
                User other = sistema.getUser(ui[2]);
                user.unfollow(other);
            }  else if(ui[0].equals("like")) {
                User user = sistema.getUser(ui[1]);
                Tweet tweet = user.getTweet(Integer.parseInt(ui[2]));
                tweet.gostei(ui[1]);
            } else if(ui[0].equals("twittar")) {
                // twittar goku jkhhhh
                String nome = ui[1];
                String msg = "";
                for(int i = 2; i < ui.length; i++) {
                    msg += ui[i] + " ";
                }
                sistema.sendTweet(nome, msg);
            } else if(ui[0].equals("timeline")) {
                User user = sistema.getUser(ui[1]);
                System.out.print(user.getTimeline());
            } else if(ui[0].equals("show")) {
                System.out.print(sistema);
            } else if(ui[0].equals("end")){
                break;
            } else {
                System.out.println("Comando Inválido");
            }
        } catch(IndexOutOfBoundsException ex) {
            System.out.println(ex.getMessage());
        } catch(RuntimeException err) {
            System.out.println(err.getMessage());
        }
    }
    scanner.close();
  }
}