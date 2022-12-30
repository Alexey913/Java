package controller;

import data.StudentGroup;
import service.StudentGroupServiceImpl;

public class GroupController implements Controller<StudentGroup, Integer> {

    private final StudentGroupServiceImpl studentGroupServiceImpl;

    public GroupController(StudentGroupServiceImpl studentGroupServiceImpl) {
        this.studentGroupServiceImpl = studentGroupServiceImpl;
    }

    @Override
    public StudentGroup create(StudentGroup entity) {
        return studentGroupServiceImpl.create(entity);
    }

    @Override
    public StudentGroup save(StudentGroup entity) {
        return studentGroupServiceImpl.saveGroup(entity);
    }

    @Override
    public StudentGroup findById(Integer id) {
        return studentGroupServiceImpl.findGroup(id);
    }

    public void removeStudent(String fio) {
        this.studentGroupServiceImpl.removeStudent(fio);
        ;
    }

    public void sortByYear(StudentGroup studentGroup) {
        this.studentGroupServiceImpl.sortByYear(studentGroup);
    }

    public void sortByFio(StudentGroup studentGroup) {
        this.studentGroupServiceImpl.sortByFio(studentGroup);
    }
}