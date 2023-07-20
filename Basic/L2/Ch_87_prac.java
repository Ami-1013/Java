
class Calculator{

    public int check_max(int x, int y) throws Cal_excep{

        if (x > 100000 || y > 100000){

            try{
                throw new Cal_excep();
            }
            catch( Cal_excep e){
                e.max_input();
                return -1;
            }
        }

        return 0;

    }

    public int add(int a , int b) throws Cal_excep{

        if(check_max(a,b) == -1){
            return  -1;
        }

        return  a+b;
    }

    public int subtract(int a, int b) throws Cal_excep{

        if (check_max(a, b) == -1){
            return -1;
        }

        return a-b;
    }

    public int mulpy(int a, int b) throws Cal_excep{
        if (a>7000 || b > 7000){
            try{
            throw new Cal_excep();
            }

            catch (Cal_excep e){
                e.max_mulpy();
                return -1;
            }

        }
        return a*b;
    }

    public double divide(int a, int b) throws Cal_excep{

        if (check_max(a, b) == -1){
            return -1;
        }

        if (b==0){
            
            try {
            throw new Cal_excep();
            
            }

            catch(Cal_excep e){
                e.div_zero();
                return -1;
            }
        }

        return a/b;

    }

}


class Cal_excep extends Exception {

    public String toString(){
        return "This is cal error";
    }

    public String getMessage(){
        return "Wrong input ";
    }

    public void div_zero(){
        System.out.println("Number can't be divided by zero.");
    }

    public void max_input(){
        System.out.println("The max input limit is 100000. Pass the argument within the limit.");
    }

    public void max_mulpy(){
        System.out.println("Max multiplier limit is 7000.");
    }
}



public class Ch_87_prac {
    

    public static void main(String[] args) throws Cal_excep {
        
        Calculator cal = new Calculator();
        // System.out.println(cal.divide(34,0));

        // System.out.println(cal.mulpy(300000, 789));
        System.out.println(cal.add(2222222,333333333));
   
        
    }
    
}
