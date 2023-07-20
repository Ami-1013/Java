
import java.util.Scanner;

public class L4_array2_project {
    public static void main(String[] args) {

        // Project 1- Average temperature calculator and give days number above average temp.

        Scanner sc = new Scanner(System.in);

        System.out.print("How many days temperature: ");
        int days = sc.nextInt();

        float[] temp_arr = new float [days]; 
        float tot_temp = 0;

        for (int i=0; i< days; ++i){

            System.out.print("Day " + (i+1) +"'s temperature: ");
            temp_arr[i] = sc.nextInt();
            tot_temp += temp_arr[i];
        }

        sc.close();
        
        float avg_temp = tot_temp / days;
        int above_avg = 0;
        
        for (float t: temp_arr){
            if (t > avg_temp){
                above_avg ++;
            }
        }

        System.out.println("\nAverage temperature = "+ avg_temp + "\n"+ above_avg + " days are above average temperature.");




    }
    
}
