// WJZU1A1Classroom Gradebook
// 16/02/20
/* Enter a certain number of classes with a certain number of students
    Returns the average mark for each student and each class.
    At the end returns the highest mark
    Option 5 100%
*/


import java.util.ArrayList;
import java.util.Scanner;

public class EvaluateStudents {
    Scanner input = new Scanner(System.in);
    ArrayList<Student> students = new ArrayList<Student>();
    

    //CONSTRUCTOR BEGINS///////////////////
    ///////////////////////////////////////
    public EvaluateStudents(){

        String studentInfo;
        String cont = "";
        boolean c = true;

        while(c){


            /*Note that while some may have done 5 seperate lines for each set of information, 
            I have decided to process all info in one entered string. Make of note of the proper formatting
            */
            System.out.println("Enter student info in one line\nExample:\n322969@address.domain 10 35 97 -1");

        studentInfo = input.nextLine();

        
        createStudent(studentInfo);
        
        //Asks the user to enter another students data
        System.out.println("Add another student? y/n");
        cont = input.nextLine();
        
        if(cont.toUpperCase().equals("N")){
                    c = false;
                }
        }

        //CLEARS CONSOLE
        System.out.println("\033[H");
        System.out.println("\033[2J");


        //Formats the output and adds it to the "students" arraylist using the Student custom class
        for(int i = 0; i < students.size(); i++){
            System.out.println("Student Number " + (i+1) + ": ");
        System.out.println(students.get(i).studentNum + "\n");
            System.out.println("Student " + (i+1) + "'s Average: ");
        System.out.printf("%.2f", students.get(i).calculateAverage(
            students.get(i).mark1, 
            students.get(i).mark2, 
            students.get(i).mark3, 
            students.get(i).mark4)
        );
        System.out.println("\n");
        
        }


        System.out.println("Class Average: ");
        System.out.printf("%.2f", findAverageInClass());
        System.out.println("\n");

    }
    //CONSTRUCTOR ENDS/////////////////////
    ///////////////////////////////////////


//Method to format the string and sort through entered info
    public void createStudent(String info){
        try{
        students.add(new Student(
            info.substring(0, info.indexOf("@")), 
            Double.parseDouble(info.substring(info.indexOf(" "), findSpaceNum(info, " ", 2))), 
            Double.parseDouble(info.substring(findSpaceNum(info, " ", 2), findSpaceNum(info, " ", 3))), 
            Double.parseDouble(info.substring(findSpaceNum(info, " ", 3), findSpaceNum(info, " ", 4))), 
            Double.parseDouble(info.substring(findSpaceNum(info, " ", 4)))
            ));

        } catch(Exception e){
            System.out.println("Invalid input, refer to the example entry for proper formatting");
        }

    }

    //Returns the value of the highest mark
    public double getMark(){
        int[] array = returnHighestMark();

        switch(array[1]){
            case 1: return students.get(array[0]).mark1;
            case 2: return students.get(array[0]).mark2;
            case 3: return students.get(array[0]).mark3;
            case 4: return students.get(array[0]).mark4;
        }
        return 0;
        
    }

    //Returns the student and which of their marks was the highest
    //Note that this does not return the actual value of the highest mark
    //getMark does this
    public int[] returnHighestMark(){
        double h = 0;
        int j = 0;
        int l = 0;
        for(int i = 0; i < students.size(); i++){
            if(students.get(i).mark1 > h){
                h = students.get(i).mark1;
                j = i;
                l = 1;
            } 
            if(students.get(i).mark2 > h){
                h = students.get(i).mark2;
                j = i;
                l = 2;
            }
            if(students.get(i).mark3 > h){
                h = students.get(i).mark3;
                j = i;
                l = 3;
            }
            if(students.get(i).mark4 > h){
                h = students.get(i).mark4;
                j = i;
                l = 4;
            }
        }

        int[] array = {j, l};

        return array;
    }

    //Returns the student number of the student with the highest mark
    public String returnHighestStudent(){
        return students.get(returnHighestMark()[0]).studentNum;
    }




    //Used to format the string that the user enters for the student info
    public static int findSpaceNum(String string, String space, int number) {
        int place = -1;
        for (int i = 0; i < number; i++) {
            place = string.indexOf(space, place + 1);
        }
        return place;
    }


    //Finds the class average using all marks of all students in a for loop
    public double findAverageInClass(){
        int t = 0;
        for(int i = 0; i < students.size(); i++){
            t+=students.get(i).calculateAverage(
                students.get(i).mark1, 
                students.get(i).mark2, 
                students.get(i).mark3, 
                students.get(i).mark4);
        }
        try{
        t/=students.size();
        } catch(Exception e){
            return 0;
        }
        return t;

    }
}
