import java.util.List;

// Продумайте структуру класса Кот. Какие поля и методы будут актуальны для приложения, которое является
// а) информационной системой ветеринарной клиники
// б) архивом выставки котов
// в) информационной системой Театра кошек Ю. Д. Куклачёва
// Можно записать в текстовом виде, не обязательно реализовывать в java.

public class Cat {
    String color;
    int age;
    String name;
    List <String> SeekStory;
    long passport;
    Doctor doctor;

    public Cat (String name) {
        this.name = name;
    }

    public void invite () {
        
    }

    
}
