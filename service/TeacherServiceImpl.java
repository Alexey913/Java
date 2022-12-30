package service;

import data.Teacher;
import repository.TeacherRepository;
import util.ReaderFromTxt;
import util.WriterToTxt;

public class TeacherServiceImpl implements DataService<Teacher> {

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public void create(Teacher entity) {
        WriterToTxt.write(entity);
    }

    @Override
    public Teacher read(Teacher entity) {
        ReaderFromTxt.read(entity);
        return entity;
    }

    @Override
    public Teacher saveUser(Teacher entity) {
        return teacherRepository.save(entity);
    }

    @Override
    public Teacher findUserById(int id) {
        return teacherRepository.findById(id);
    }

    @Override
    public Teacher findUserByFio(String fio) {
        return teacherRepository.findByFio(fio);
    }
}