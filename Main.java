
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// Класс, который содержит точку входа в программу
public class Main {

    // Метод, который запускает программу
    public static void main(String[] args) throws Exception {
        // Создаем объект динамической коллекции с заданной статической размерностью
        DynamicCollection dc = new DynamicCollection(5);

        // Создаем объект сканера для ввода с клавиатуры
        Scanner sc = new Scanner(System.in);

        // Выводим меню с доступными операциями
        System.out.println("Выберите операцию:");
        System.out.println("1. Добавить строку в коллекцию");
        System.out.println("2. Удалить строку из коллекции по индексу");
        System.out.println("3. Найти индекс строки в коллекции");
        System.out.println("4. Найти индексы строк, которые содержат подстроку");
        System.out.println("5. Найти строки, которые совпадают с заданной строкой");
        System.out.println("6. Посчитать количество совпадений заданной строки в коллекции");
        System.out.println("7. Посчитать длины строк в коллекции");
        System.out.println("8. Посчитать длины строк в коллекции и отсортировать их");
        System.out.println("9. Посчитать статистику по символам в строках коллекции");
        System.out.println("10. Сделать реверс всех строк в коллекции");
        System.out.println("11. Сравнить два элемента коллекции по индексам");
        System.out.println("12. Сохранить коллекцию в xml-файл");
        System.out.println("13. Вывести коллекцию на экран");
        System.out.println("14. Выход");


    }}
