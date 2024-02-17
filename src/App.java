// WJZU1A1Classroom Gradebook
// 16/02/20
/* Enter a certain number of classes with a certain number of students
    Returns the average mark for each student and each class.
    At the end returns the highest mark
    Option 5 100%
*/

import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        String cont = "";
        boolean pass = true;

        double maxMark = 0;
        String maxStudent = "";

        //This while loop repeats for each class that was entered.
    while(pass){
        EvaluateStudents call = new EvaluateStudents();
        

        System.out.println("Would you like to enter a new class y/n");
        cont = input.nextLine();
        if(cont.toUpperCase().equals("N")){
            pass = false;
            call.returnHighestMark();
        }


        if(call.getMark() > maxMark){
            maxMark = call.getMark();
            maxStudent = call.returnHighestStudent();

        }
    }

    //Prints out the highest mark at the end.
    System.out.println("Highest Mark: ");
    System.out.println("Student: " + maxStudent);
    System.out.printf("%.2f", maxMark);



    }
}
