import java.io.Serializable;

public class Student implements Serializable{
private int id;
private String name;
private double gpa;
public Student(int id, String name, double gpa) {
	super();
	this.id = id;
	this.name = name;
	this.gpa = gpa;
}


public double getGpa() {
	return gpa;
}


public void setGpa(double gpa) {
	this.gpa = gpa;
}


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Override
public String toString() {
	return "id:" + id + ", name:" + name + ", gpa:"+gpa;
}
 
}
