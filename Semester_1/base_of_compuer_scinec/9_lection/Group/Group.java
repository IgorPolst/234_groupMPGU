package Group;

import java.util.*;

public class Group {

    private int maxSize;
    private int minSize;
    private List<Student> group;

    public void addStudent(Student student) {
        try {

            if (group.size() >= maxSize) {
                throw new IllegalStateException("Cannot add student: group is full.");
            } else if (student.getAge() >= 60 || student.getAge() <= 16) {
                throw new IllegalStateException("Cannot add student: The student must be over 16 and under 60 years of age.");
            }

            for (Student s : group) {
                if (s.getName().equals(student.getName())) {
                    throw new IllegalArgumentException("Cannot add student: student " + student.getName() + " already exists in the group.");
                }
            }

            group.add(student);
            System.out.println("Student " + student.getName() + " added to the group.");
        } catch (IllegalStateException e) {
            System.err.println(e.getMessage());
        }

    }

    public void removeStudent(Student student) {
        try {
            if (group.size() <= minSize) {
                throw new IllegalStateException("Cannot add student: group is empty.");
            }
            for (Student s : group) {
                if (s.getName().equals(student.getName())) {
                    throw new IllegalArgumentException("Cannot add student: student " + student.getName() + " already exists in the group.");
                }
            }

            group.remove(student);
            System.out.println("Student " + student.getName() + " removed from the group.");
        } catch (IllegalStateException e) {
            System.err.println(e.getMessage());
        }
    }

    public Group() {
        this.maxSize = 15;
        this.minSize = 3;
        this.group = new ArrayList<Student>();
    }

}
