import java.util.Scanner;
import java.util.Random;


class Game{
    
    private int attempt;
    private int rand_num;
    private int user_in;


    public void user_input(){
        Scanner sc = new Scanner(System.in);

        attempt ++;
        System.out.print("Make a guess: ");
        user_in = sc.nextInt();
        
        // sc.close(), here give error!
    }

    public boolean result(){
        if (user_in == rand_num){
            
            System.out.println(user_in + " is correct and you took " + attempt + " attempt.");
            return true;
        }

        else if (user_in > rand_num){
            System.out.println("Too high.");
        }
        else if (user_in < rand_num){
            System.out.println("Too low.");
        }

        return false;
    }

    Game(){
        
        Random ran = new Random();
        rand_num = ran.nextInt(101);
        System.out.println(rand_num);
    }


}



public class Ch_43_guess_number_game {

    public static void main(String[] args) {

        Game game = new Game();

        boolean res = false;

        while (!res){
            game.user_input();
            res = game.result();

        }
        
        
        
    }
    
}
