// WJZU1A1Classroom Gradebook
// 16/02/20
/* Enter a certain number of classes with a certain number of students
    Returns the average mark for each student and each class.
    At the end returns the highest mark
    Option 5 100%
*/


public class Student {
    String studentNum;
    double mark1, mark2, mark3, mark4;

    //Custom class holds the student number as a string and the 4 marks as doubles.
    public Student(String studentNum, double mark1, double mark2, double mark3, double mark4){
        this.studentNum = studentNum;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
        this.mark4 = mark4;
    }

    //Checks for -1 values then takes the average of any NON -1 values
    public double calculateAverage(double g1, double g2, double g3, double g4){
        
        int w = 4;
            if(g1 == -1){
                w--;
                g1 = 0;
            }
            if(g2 == -1){
                w--;
                g2 = 0;
            }
            if(g3 == -1){
                w--;
                g3 = 0;
            }
            if(g4 == -1){
                w--;
                g4 = 0;
            }
        

        return (g1+g2+g3+g4)/w;
    }
    
}
