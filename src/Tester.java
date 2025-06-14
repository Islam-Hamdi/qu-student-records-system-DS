import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public class Tester implements Serializable{
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
	 TreeInHashTable students = new TreeInHashTable(22);
	 students.Read();
	 boolean stay=true;
	 System.out.println("------Qatar University Students’ records System------");

	 while (stay) {
			System.out.println();
			System.out.println("\t1: Insert a student");
			System.out.println("\t2: Search for a student");
			System.out.println("\t3: Delete a student");
			System.out.println("\t4: Exit");
			System.out.println();
		Scanner in = new Scanner(System.in);

		System.out.println("Enter your choice: ");
		String choiceString = in.nextLine();

		//int choice = Integer.parseInt(choiceString);
		switch(choiceString) {
		case "1":
			System.out.println("\nNew Student");
			System.out.println("---------------");

			System.out.print("Enter ID: ");
			String idString = in.nextLine();
			int id = Integer.parseInt(idString);
			
			while(id/100000000!=2) {
				System.out.print("Inavlid ID. Please reenter ID:");
				 idString = in.nextLine();
				 id = Integer.parseInt(idString);

			}
			
			System.out.print("Enter your name: ");
			String name = in.nextLine();
			
			System.out.print("Enter GPA: ");
			double gpa = Double.parseDouble(in.nextLine());
			while (gpa > 4.0 || gpa < 0.0) {
				System.out.println("invalid gpa. Please reenter");
				 String Stringgpa = in.nextLine();
				 gpa = Double.parseDouble(Stringgpa);
		}
			students.insert(id,name,gpa);
			System.out.println("\nAdded " + new Student(id,name,gpa) + "\n");
		    break;

		
		case "2":
			System.out.print("Enter ID of the student to be found: ");
			 idString = in.nextLine();
			 id = Integer.parseInt(idString);
			while(id/100000000!=2) {
				System.out.print("Inavlid ID. Please reenter ID:");
				 idString = in.nextLine();
				 id = Integer.parseInt(idString);

			}
			Student x=students.find(id);
			if(x==null) {System.out.println("Student not found"); break;}
			System.out.println(x);
		    break;
		case "3":
			System.out.println("\nDelete a Student");
			System.out.print("Enter ID of the student to be deleted: ");
			idString = in.nextLine();
			 id = Integer.parseInt(idString);
			while(id/100000000!=2) {
				System.out.print("Inavlid ID. Please reenter ID:");
				 idString = in.nextLine();
				 id = Integer.parseInt(idString);
			}
			boolean y=students.delete(id);
			if(y==false) {System.out.println("Student not found");}
			break;
		case "4":
			stay=false;
			in.close();
			System.out.println("Exit");
			students.exit();
			
			break;
		default:
			System.out.println("Invalid input please enter number from 1 to 4");
			break;
	}
	 }
		
					
}
}
