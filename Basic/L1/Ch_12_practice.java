public class Ch_12_practice {
    public static void main(String[] args){
        
        // float a = 7/4 * 9/2;
        // System.out.println(a); 
        // /*  This will give 4, which is wrong. Its is because in java operation between integer will always give a integer.
        //     So, 7/4 will give 1 and then 1 * 9 give 9 ,finally 9/2 give 4
        // */

        // float b = 7/4f * 9/2f;
        // System.out.println(b); 
        // // You have to declare the denominator or numerator a "float" because operation between a float and int give a float.


        // -----------------------------------

        char grade = 'B';

        grade = (char)(grade + 8);
        // operation between char and int will give a int. Here we have change the data type.
        System.out.println(grade);

        // decrypting 
        grade = (char)(grade - 8);
        System.out.println(grade);

        System.out.println((int)'a');


    }
    
}
