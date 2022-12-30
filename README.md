# Java OOP

## Семинар 2

**Задача 1.1**

Создать package data. Работу проводить в нем
Создать абстрактный класс User и его наследники Student и Teacher родитель имеет в себе общие данные (фио, год рождения, паспорт (серия и номер)),
а наследники - собственные параметры (номер группы для Student, кафедра для Teacher)

**Задача 1.2**

Создать package util. Работу проводить в нем
Создать классы WriterToTxt и ReaderFromTxt, имеющие статичные методы для записи/чтения в/из txt.файла

**Задача 1.3**

Создать package service. Работу проводить в нем
Создать интерфейс DataService, описывающий реализацию конкретных сервисов по управлению сущностями (create, read).
Создать для сущности Student отдельный Service, реализующий интерфейс DataService.
Create и read операции реализуются путем вызова utils методов

**Задача 2**

Создать package view. Работу проводить в нем.
Создать абстрактный класс или интерфейс UserView, содержащий в себе метод void showTheBest(List <User> userList),
внутри вызывающий абстрактный метод User findTheBest(List <User> userList) и распечатывающий результат.
Создать класс StudentView, унаследованный от UserView, содержащий в себе реализацию findTheBest.

**Задача 3**
  
Создать package controller
Создать класс Controller, содержащий в себе необходимые интерфейсы в виде переменных, а в конструкторе создать объекты конкретных реализаций.
Создать метод createStudent (Student), реализующий логику путем вызова соответствующих методов интерфейсов:
* Создание студента;
* Запись в файл студента;
* Чтение того, что записали;
* Возвращение в методе того, что прочли в файле


## Домашнее задание (семинар 2)
  
1. Создать класс StudentGroup, содержащая в себе поля Teacher и список студентов.
2. Создать класс StudentGroupServiceImpl, в котором реализована логика чтения Студентов и Преподавателя из файла txt
(реализация чтения файла опциональна), создания класса StudentGroup и возвращения его.
3. Создать метод в Controller createGroup(int groupNumber), в который передается номер группы, а возвращается StudentGroup.
4. Все вышеуказанное создать согласно принципам ООП пройдённым на семинаре.


## Семинар 3

**Задача 1**
  
1. Создать класс StudentGroupIterator, заставив его реализовать интерфейс Iterator <Student>.
2. Реализовать его абстрактные метод.
3. Реализовать метод remove()
  
**Задача 2**
  
1. Модифицировать класс StudentGroup, заставив его реализовать интерфейс Iterable<Student>
2. Реализовать метод iterator() возвращающий экземпляр созданного нами итератора
3. Модифицировать класс StudentGroupServiceImpl, добавив в него метод удаления студента по ФИО
4. Модифицировать класс Controller, добавив в него метод удаления студента и вызывать в нем созданный метод из StudentGroupServiceImpl

**Задача 3**
  
1. Модифицировать класс Student, заставив его реализовать интерфейс Comparable
2. Реализовать контракт compareTo () со сравнением по году рождения студента
3. Модифицировать класс StudentGroupServiceImpl, добавив в него метод сортировки списка студентов
4. Модифицировать класс Controller, добавив в него метод сортировки списка студентов и вызывать в нем созданный метод из StudentGroupServiceImpl

**Задача 4**
  
1. Создать класс UserComparator реализующий интерфейс Comparator<User>
2. Реализовать контракт compareTo() со сравнением по ФИО
3. Модифицировать класс StudentGroupServiceImpl, добавив в него метод сортировки списка студентов по ФИО
4. Модифицировать класс Controller, добавив в него метод сортировки списка студентов по ФИО и вызывать в нем созданный метод из StudentGroupServiceImpl


## Семинар 4

**Задача 1**
  
* Создать пекедж repository. Дальнейшие работы ведем в нем
* Реализовать в нем интерфейс Repository<E,I>
* Задать в созданном интерфейсе 2 абстрактных метода:
E save(E entity)
E findById (I id)
* Создать класс GroupRepository, имплементировав его от Repository

**Задача 2**

* Создать класс GroupRepository имплементировав его от Repository<Group, Integer>
* В классе StudentGroupServiceImpl добавить новую переменную Repository<Group, Integer>
* В классе StudentGroupServiceImpl  реализовать методы сохранения группы и поиска её по номеру 

**Задача 3**

* Создать интерфейс UserRepository<E  extends User,I> унаследовав его от Repository<E, I>
* В интерфейс UserRepository<E,I> задать абстрактный метод E findByFio (String fio)
* Создать класc StudentRepository имплементировав интерфейс UserRepository
 
**Задача 4**
  
* Создать класc StudentRepository имплементировав интерфейс UserRepository <Student, Integer>
* В классе StudentService добавить новую переменную StudentRepository 
* В классе StudentService  реализовать методы сохранения студента и его поиска по id и ФИО.

  
## Домашнее задание (семинар 4)
  
1. Реализовать класc TeacherRepository (обобщение на ваше усмотрение)
2. Обобщить интерфейс DataService, чтобы он работал только с наследникам класса User
3. Реализовать методы поиска и сохранения в классе TeacherService
4. Реализовать как можно более обобщенный интерфейс Controller
5. Создать классы StudentController, TeacherController, GroupController с методами сохранения и поиска соответствующих объектов
* Реализовать такой же функционал для класса GroupStream