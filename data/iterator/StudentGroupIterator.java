package data.iterator;

import java.util.Iterator;
import java.util.List;

import data.Student;
import data.StudentGroup;

public class StudentGroupIterator implements Iterator<Student> {

    private StudentGroup studentGroup;
    private List<Student> students;
    private int cursor;

    public StudentGroupIterator(StudentGroup studentGroup) {
        this.studentGroup = studentGroup;
        this.students = studentGroup.getListOfStudents();
    }

    @Override
    public boolean hasNext() {
        return cursor < students.size();
    }

    @Override
    public Student next() {
        return students.get(cursor++);
    }

    @Override
    public void remove() {
        this.students.remove(cursor);
    }
}