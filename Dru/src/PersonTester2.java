import java.util.ArrayList;
import java.util.Collections;

public class PersonTester2 {

	public static void main(String[] args) {
        ArrayList<Student2> students=new ArrayList<Student2>();
        //If you want to enter student details manually, i can help with that too
        students.add(new Student2("Alan", 1996, "Computer Science"));
        students.add(new Student2("Laura", 1994, "Mechanical"));
        students.add(new Student2("Deep", 1992, "Electronics"));
        
        Collections.sort(students);
        //System.out.println(students);
        for (Student2 stud : students) {
            System.out.println(stud);
        }
 
       
    }

}