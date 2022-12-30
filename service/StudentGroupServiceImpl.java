
package service;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import data.Student;
import data.StudentGroup;
import data.Teacher;
import data.comparator.UserComparator;
import repository.Repository;
import util.ReaderFromTxt;
import util.WriterToTxt;

public class StudentGroupServiceImpl implements StudentGroupService {

    private final Repository<StudentGroup, Integer> studentGroupRepository;

    public StudentGroupServiceImpl(Repository<StudentGroup, Integer> studentGroupRepository) {
        this.studentGroupRepository = studentGroupRepository;
    }

    @Override
    public StudentGroup read() {
        Teacher teacher = ReaderFromTxt.readTeacher();
        List<Student> listOfStudents = ReaderFromTxt.readStudents();
        StudentGroup studentGroup = new StudentGroup(teacher, listOfStudents);
        return studentGroup;
    }

    public StudentGroup read(int groupNumber) {
        Teacher teacher = ReaderFromTxt.readTeacher();
        List<Student> listOfStudents = ReaderFromTxt.readStudents();
        StudentGroup studentGroup = new StudentGroup(teacher, listOfStudents, groupNumber);
        return studentGroup;
    }

    @Override
    public void create(StudentGroup studentGroup) {
        WriterToTxt.writeStudentGroup(studentGroup);
    }

    @Override
    public void removeStudent(String fio) {
        Iterator<Student> studentGroup = read().iterator();
        while (studentGroup.hasNext()) {
            Student student = studentGroup.next();
            if (fio.equals(student.getFio())) {
                studentGroup.remove();
            }
        }
    }

    @Override
    public void sortByYear(StudentGroup studentGroup) {
        Collections.sort(studentGroup.getListOfStudents());
    }

    @Override
    public void sortByFio(StudentGroup studentGroup) {
        Collections.sort(studentGroup.getListOfStudents(), new UserComparator());
    }

    @Override
    public StudentGroup saveGroup(StudentGroup studentGroup) {
        return studentGroupRepository.save(studentGroup);
    }

    @Override
    public StudentGroup findGroup(Integer groupNumber) {
        return studentGroupRepository.findById(groupNumber);
    }
}