package Test;

public class Student implements Comparable<Student> {
    private String name;
    private float gpa;

    public Student(String name, float gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public float getGpa() {
        return gpa;
    }

    @Override
    public int compareTo(Student other) {
        // Sắp xếp giảm dần theo GPA
        return Float.compare(other.gpa, this.gpa);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            return this.gpa == ((Student) obj).gpa;
        }
        return false;
    }
}
