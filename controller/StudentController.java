package controller;

import data.Student;
import service.StudentServiceImpl;

public class StudentController implements UserController<Student, Integer> {

    private final StudentServiceImpl studentServiceImpl;

    public StudentController(StudentServiceImpl studentServiceImpl) {
        this.studentServiceImpl = studentServiceImpl;
    }

    @Override
    public Student read(Student entity) {
        return studentServiceImpl.read(entity);
    }

    @Override
    public Student create(Student entity) {
        studentServiceImpl.create(entity);
        studentServiceImpl.read(entity);
        return entity;
    }

    @Override
    public Student save(Student entity) {
        return studentServiceImpl.saveUser(entity);
    }

    @Override
    public Student findById(Integer id) {
        return studentServiceImpl.findUserById(id);
    }

    @Override
    public Student findUserByFio(String fio) {
        return studentServiceImpl.findUserByFio(fio);
    }
}