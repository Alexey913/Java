/*
Даны 2 строки, написать метод, который вернет true,
если эти строки являются изоморфными и false, если нет.
Строки изоморфны, если одну букву в первом слове можно заменить на некоторую букву во втором слове,
при этом повторяющиеся буквы одного слова меняются на одну и ту же букву с сохранением порядка следования.
(Например, add - egg изоморфны)
буква может не меняться, а остаться такой же. (Например, note - code)
Пример 1:
Input: s = "foo", t = "bar"
Output: false
Пример 2:
Input: s = "paper", t = "title"
Output: true
*/

import java.util.*;;
public class Task5_2 {
    public static void main(String[] args) {
        System.out.println(isomorph("paper", "title"));
    }
    public static boolean isomorph(String s1, String s2) {
        if (s1.length()!=s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        Map <Character, Character> keyValue = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char a = s1.charAt(i);
            char b = s2.charAt(i);
            if (keyValue.containsKey(a) == true && keyValue.get(a) != b) 
                return false;
            else 
                keyValue.put(a, b);
        }
        return true;
    }
}
