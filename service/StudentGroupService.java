package service;

import data.StudentGroup;

public interface StudentGroupService {

    StudentGroup read();

    StudentGroup create(StudentGroup studentGroup);

    void removeStudent(String fio);

    void sortByYear(StudentGroup studentGroup);

    void sortByFio(StudentGroup studentGroup);

    StudentGroup saveGroup(StudentGroup studentGroup);

    StudentGroup findGroup(Integer groupNumber);
}