import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/*Заполнить список названиями планет Солнечной системы в произвольном порядке с повторениями.
Вывести название каждой планеты и количество его повторений в списке. */

public class Task3_2 {
    public static void main(String[] args) {
        String [] namePlanet = new String [] {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto"};
        Random rnd = new Random();
        int size = 20;
        ArrayList <String> PlanetArray = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            PlanetArray.add(namePlanet[rnd.nextInt(8)]);
        }
        System.out.println(PlanetArray);

        Set <String> mySet = new HashSet<String>(PlanetArray);
        for (String s: mySet) {
            System.out.println(s + " " + Collections.frequency(PlanetArray, s));
        }
        }

    }