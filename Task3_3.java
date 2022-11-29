import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/*Заполнить список названиями планет Солнечной системы в произвольном порядке с повторениями.
Вывести название каждой планеты и количество его повторений в списке. */ //- это из второй задачи
/*Удалить повторяющиеся элементы */

public class Task3_3 {
    public static void main(String[] args) {
        String [] namePlanet = new String [] {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto"};
        Random rnd = new Random();
        int size = 30;
        ArrayList <String> PlanetArray = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            PlanetArray.add(namePlanet[rnd.nextInt(8)]);
        }
        System.out.println(PlanetArray);

        // Set <String> mySet = new HashSet<String>(PlanetArray); // это из прошлой задачи
        // for (String s: mySet) {
        //     System.out.println(s + " " + Collections.frequency(PlanetArray, s));
        // }
        
        // Метод через удаление повторов
        Collections.sort(PlanetArray);//сортируем массив
        System.out.println(PlanetArray);//вывод отсортированного массива

        for (int j = 0; j < PlanetArray.size()-1; j++) {
            if (PlanetArray.get(j)==PlanetArray.get(j+1)) {
                PlanetArray.remove(PlanetArray.get(j));
                j--;
            }
        }
        System.out.println(PlanetArray);



        /* Метод через Set
        Set <String> newSet = new HashSet<String>(PlanetArray);
        System.out.println(newSet);
        */
    }
}



