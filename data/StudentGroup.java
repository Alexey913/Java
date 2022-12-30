package data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import data.iterator.StudentGroupIterator;

public class StudentGroup implements Iterable<Student> {

    Teacher teacher;
    List<Student> listOfStudents = new ArrayList<>();
    int groupNumber;

    public StudentGroup(Teacher teacher, List<Student> listOfStudents) {
        this.teacher = teacher;
        this.listOfStudents = listOfStudents;
    }

    public StudentGroup(Teacher teacher, List<Student> listOfStudents, int groupNumber) {
        this.teacher = teacher;
        this.listOfStudents = listOfStudents;
        this.groupNumber = groupNumber;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getListOfStudents() {
        return listOfStudents;
    }

    public void setListOfStudents(List<Student> listOfStudents) {
        this.listOfStudents = listOfStudents;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    @Override
    public Iterator<Student> iterator() {
        return new StudentGroupIterator(this);
    }
}