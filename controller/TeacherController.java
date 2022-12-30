package controller;

import data.Teacher;
import service.TeacherServiceImpl;

public class TeacherController implements UserController<Teacher, Integer> {

    private final TeacherServiceImpl teacherServiceImpl;

    public TeacherController(TeacherServiceImpl teacherServiceImpl) {
        this.teacherServiceImpl = teacherServiceImpl;
    }

    @Override
    public Teacher read(Teacher entity) {
        return teacherServiceImpl.read(entity);
    }

    @Override
    public Teacher create(Teacher entity) {
        teacherServiceImpl.create(entity);
        teacherServiceImpl.read(entity);
        return entity;
    }

    @Override
    public Teacher save(Teacher entity) {
        return teacherServiceImpl.saveUser(entity);
    }

    @Override
    public Teacher findById(Integer id) {
        return teacherServiceImpl.findUserById(id);
    }

    @Override
    public Teacher findUserByFio(String fio) {
        return teacherServiceImpl.findUserByFio(fio);
    }
}