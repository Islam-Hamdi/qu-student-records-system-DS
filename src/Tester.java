import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public class Tester implements Serializable {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        TreeInHashTable students = new TreeInHashTable(22);
        students.Read();
        boolean stay = true;

        Scanner in = new Scanner(System.in);

        System.out.println("\n----- Qatar University Student records System -----");

        while (stay) {
            System.out.println();
            System.out.println("\t1: Insert a student");
            System.out.println("\t2: Search for a student");
            System.out.println("\t3: Delete a student");
            System.out.println("\t4: Display all students");
            System.out.println("\t5: Exit");
            System.out.println();

            System.out.print("Enter your choice: ");
            String choiceString = in.nextLine();

            switch (choiceString) {
                case "1":
                    System.out.println("\nNew Student");
                    System.out.println("---------------");

                    System.out.print("Enter ID: ");
                    String idString = in.nextLine();
                    int id = Integer.parseInt(idString);

                    while (id / 100000000 != 2) {
                        System.out.print("Invalid ID. Please reenter ID: ");
                        idString = in.nextLine();
                        id = Integer.parseInt(idString);
                    }

                    // ✅ Check for duplicate before inserting
                    if (students.find(id) != null) {
                        System.out.println("\n❌ A student with ID " + id + " already exists.\n");
                        break;
                    }

                    System.out.print("Enter your name: ");
                    String name = in.nextLine();

                    System.out.print("Enter GPA: ");
                    double gpa = Double.parseDouble(in.nextLine());

                    while (gpa > 4.0 || gpa < 0.0) {
                        System.out.print("Invalid GPA. Please reenter: ");
                        gpa = Double.parseDouble(in.nextLine());
                    }

                    students.insert(id, name, gpa);
                    System.out.println("\n✅ Added " + new Student(id, name, gpa) + "\n");
                    break;

                case "2":
                    System.out.print("Enter ID of the student to be found: ");
                    idString = in.nextLine();
                    id = Integer.parseInt(idString);

                    while (id / 100000000 != 2) {
                        System.out.print("Invalid ID. Please reenter ID: ");
                        idString = in.nextLine();
                        id = Integer.parseInt(idString);
                    }

                    Student found = students.find(id);
                    if (found == null) {
                        System.out.println("Student not found");
                    } else {
                        System.out.println(found);
                    }
                    break;

                case "3":
                    System.out.println("\nDelete a Student");
                    System.out.print("Enter ID of the student to be deleted: ");
                    idString = in.nextLine();
                    id = Integer.parseInt(idString);

                    while (id / 100000000 != 2) {
                        System.out.print("Invalid ID. Please reenter ID: ");
                        idString = in.nextLine();
                        id = Integer.parseInt(idString);
                    }

                    boolean deleted = students.delete(id);
                    if (!deleted) {
                        System.out.println("Student not found");
                    } else {
                        System.out.println("✅ Student deleted");
                    }
                    break;

                case "4":
                    System.out.println("\n------ Current Students ------");
                    if (!students.displayAll()) {
                        System.out.println("** System is empty **");
                    }
                    System.out.println("------------------------------");
                    break;

                case "5":
                    stay = false;
                    in.close();
                    System.out.println("Exit");
                    students.exit();
                    break;

                default:
                    System.out.println("Invalid input. Please enter a number from 1 to 5.");
                    break;
            }
        }
    }
}
