

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TreeInHashTable implements Serializable {
	 Tree<Student>[] hashArray;
	int size=0;
    ObjectOutputStream out;
    ObjectInputStream In;

    public TreeInHashTable(int size) {
		hashArray = new Tree[size];
		for (int j = 0; j < hashArray.length; j++)
			hashArray[j] = new Tree<Student>();
	}
	


	public void displayTable() {
		for (int j = 0; j < hashArray.length; j++) {
			if (hashArray[j] != null) {
				System.out.println(j + ": ");
				hashArray[j].traverse(2);
			}
			else
				System.out.println("** ");
		}
		
		System.out.println("--------------------");
	}

	// -------------------------------------------------------------
	public int hashFunc(int key) {
		return (key/100000)-2000;
	}
	

	public void insert(int id, String name, double gpa) {
		Student x =new Student(id, name, gpa);
		insert(id, x);
	}

	public void insert(int id, Student d) {
	int hashVal=hashFunc(id);
	while(hashVal>hashArray.length) {hashVal%=hashArray.length;}
	hashArray[hashVal].insert(id%100000, d);
		
	}

	public boolean delete(int id) {
		int hashVal=hashFunc(id);
		return delete(hashVal, id);
		
	}
	public boolean delete(int hash,int id) {
	while(hash>hashArray.length) {hash%=hashArray.length;}
		return hashArray[hash].delete(id%100000);
	}

	public Student find(int id) {
		int hashVal=hashFunc(id);
		return find(hashVal, id);
	}
	public Student find(int hash, int id) {
		while(hash>hashArray.length) {hash%=hashArray.length;}
		return hashArray[hash].search(id%100000);
	}

	// -------------------------------------------------------------
public void exit() throws FileNotFoundException, IOException {
    out= new ObjectOutputStream(new FileOutputStream("HashArray.dat"));
	out.writeObject(hashArray);
	out.close();
}

public void Read() throws FileNotFoundException, IOException, ClassNotFoundException {
	try {
		Tree<Student>[] hashArray=null;
	 In= new ObjectInputStream(new FileInputStream("HashArray.dat"));
	 hashArray=(Tree<Student>[])In.readObject();
		In.close();
		//System.out.println(hashArray);
	 } catch (FileNotFoundException e) {
	System.out.println("");
	 } catch (IOException e) {
			System.out.println("");
	
} catch (ClassNotFoundException e) {
	System.out.println("");
}

}
}

