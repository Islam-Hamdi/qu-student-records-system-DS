import java.io.*;
import java.util.Arrays;

/** Hash-table where each bucket is a BST (Tree<Student>). */
public class TreeInHashTable implements Serializable {

    private static final long serialVersionUID = 1L;

    /*------------------------------------------------------------------
     *  Data
     *----------------------------------------------------------------*/
    private final Tree<Student>[] hashArray;           // buckets

    @SuppressWarnings("unchecked")
    public TreeInHashTable(int size) {
        hashArray = new Tree[size];
        for (int i = 0; i < size; i++) hashArray[i] = new Tree<>();
    }

    /*------------------------------------------------------------------
     *  Hash helper  —  QU ID (e.g., 202004552)  →  0-(size-1)
     *----------------------------------------------------------------*/
    private int hashFunc(int id) {
        return Math.floorMod((id / 100000) - 2000, hashArray.length);
    }

    /*------------------------------------------------------------------
     *  Display all students  (in-order within each bucket)
     *----------------------------------------------------------------*/
    /** @return <code>true</code> if at least one student printed. */
    public boolean displayAll() {
        boolean any = false;
        for (Tree<Student> bucket : hashArray) {
            if (bucket != null) any |= bucket.printInOrder();
        }
        return any;
    }

    /*------------------------------------------------------------------
     *  CRUD
     *----------------------------------------------------------------*/
    public void insert(int id, String name, double gpa) {
        insert(id, new Student(id, name, gpa));
    }

    public void insert(int id, Student s) {
        hashArray[hashFunc(id)].insert(id % 100000, s);
    }

    public boolean delete(int id) {
        return hashArray[hashFunc(id)].delete(id % 100000);
    }

    public Student find(int id) {
        return hashArray[hashFunc(id)].search(id % 100000);
    }

    /*------------------------------------------------------------------
     *  Persistence
     *----------------------------------------------------------------*/
    /** Serialize hashArray to <i>HashArray.dat</i>. */
    public void exit() throws IOException {
        try (ObjectOutputStream out =
                 new ObjectOutputStream(new FileOutputStream("HashArray.dat"))) {
            out.writeObject(hashArray);
        }
    }

    /** Load table from <i>HashArray.dat</i> if it exists; otherwise keep empty. */
    @SuppressWarnings("unchecked")
    public void Read() {
        try (ObjectInputStream in =
                 new ObjectInputStream(new FileInputStream("HashArray.dat"))) {

            Tree<Student>[] saved = (Tree<Student>[]) in.readObject();
            for (int i = 0; i < Math.min(saved.length, hashArray.length); i++) {
                hashArray[i] = saved[i];
            }

        } catch (FileNotFoundException e) {
            /* first run – nothing to restore */ 
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /*------------------------------------------------------------------
     *  Debug helper
     *----------------------------------------------------------------*/
    public void displayTable() {
        System.out.println(Arrays.toString(hashArray));
    }
}
