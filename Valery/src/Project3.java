// Valery Njong LE01
/* * * * * * * * * * * * * * * * ** * * * * * * * * * * * * **
* *
* Programmer: Valery Njong Program Name: Project3.java *
* Course: INT 2200 Instructor: C. A. Thomas *
* Assignment: Project #3 Due Date: 9 April 15 *
* Date Created: 5 April 15 Date Revised: 9 April 15 *
* Input: None *
* Output: Screen Report *
* Functions Called: main(), *
* User Functions Called: print_header(), writter() *
* Description:read file create file *
* *
* Other Notes: This program was a little diffcult to tackle *
* *
* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
import static java.lang.System.out;

import java.util.Scanner;
import java.io.*;
public class Project3 {

public static void main(String[] args) {
writter();
print_header();
}

private static void print_header() {
out.println("* * * * * * * * * * * * * * * * ** * * * * * * * * * * * * * *");
out.println("* *");
out.println("* Programmer: Valery Njong Program Name: Project2.java *");
out.println("* Course: INT 2200 Instructor: C. A. Thomas *");
out.println("* Assignment: Project 03 Due Date: 9 April 15 *");
out.println("* Date Created: 5 April 15 Date Revised: 9 April 15 *");
out.println("* Input: None *");
out.println("* Output: Screen Report *");
out.println("* Functions Called: main(), *");
out.println("* User Functions Called: print_header(), writter() *");
out.println("* Description:read file create file *");
out.println("* *");
out.println("* Other Notes:This program was a little diffcult to tackle *");
out.println("* *");
out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
}

private static void writter() {
// TODO Auto-generated method stub
Scanner input = null;
try{
input = new Scanner(new FileInputStream("inrecords.dat"));
}catch(FileNotFoundException e){
System.out.println("File not found");
}// end catch
PrintWriter output = null;
try{
output = new PrintWriter(new FileOutputStream("outrecords.dat"));
}catch(FileNotFoundException e){
System.out.println("File not found");
}// end catch
while(input.hasNextLine()){
String number = input.nextLine();
if(number.contains("(301)735")){
output.println(number);
}// end if
}//while
output.close();
input.close();
}//writer

}// end class