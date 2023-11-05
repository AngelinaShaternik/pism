
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

        // Создаем переменную для хранения выбранной операции
        int choice;

        // Создаем бесконечный цикл
        while (true) {
            // Считываем выбранную операцию с клавиатуры
            choice = sc.nextInt();

            // В зависимости от выбранной операции выполняем соответствующий блок кода
            switch (choice) {
                case 1: // Добавить строку в коллекцию
                    System.out.print("Введите строку, которую хотите добавить: ");
                    String s = sc.next();
                    dc.add(s);
                    System.out.println("Строка добавлена в коллекцию");
                    break;
                case 2: // Удалить строку из коллекции по индексу
                    System.out.print("Введите индекс строки, которую хотите удалить: ");
                    int index = sc.nextInt();
                    if (index >= 0 && index < dc.size()) {
                        dc.remove(index);
                        System.out.println("Строка удалена из коллекции");
                    } else {
                        System.out.println("Неверный индекс");
                    }
                    break;
                case 3: // Найти индекс строки в коллекции
                    System.out.print("Введите строку, индекс которой хотите найти: ");
                    s = sc.next();
                    index = dc.indexOf(s);
                    if (index != -1) {
                        System.out.println("Индекс строки в коллекции: " + index);
                    } else {
                        System.out.println("Такой строки нет в коллекции");
                    }
                    break;
                case 4: // Найти индексы строк, которые содержат подстроку
                    System.out.print("Введите подстроку, которую хотите найти: ");
                    s = sc.next();
                    List<Integer> indexes = dc.find(s);
                    if (!indexes.isEmpty()) {
                        System.out.println("Индексы строк, которые содержат подстроку: " + indexes);
                    } else {
                        System.out.println("Нет строк, которые содержат подстроку");
                    }
                    break;
                case 5: // Найти строки, которые совпадают с заданной строкой
                    System.out.print("Введите строку, которую хотите найти: ");
                    s = sc.next();
                    List<String> matches = dc.match(s);
                    if (!matches.isEmpty()) {
                        System.out.println("Строки, которые совпадают с заданной строкой: " + matches);
                    } else {
                        System.out.println("Нет строк, которые совпадают с заданной строкой");
                    }
                    break;
                case 6: // Посчитать количество совпадений заданной строки в коллекции
                    System.out.print("Введите строку, количество совпадений которой хотите посчитать: ");
                    s = sc.next();
                    int count = dc.count(s);
                    System.out.println("Количество совпадений заданной строки в коллекции: " + count);
                    break;
                case 7: // Посчитать длины строк в коллекции
                    List<Integer> lengths = dc.lengths();
                    System.out.println("Длины строк в коллекции: " + lengths);
                    break;
                case 8: // Посчитать длины строк в коллекции и отсортировать их
                    List<Integer> sortedLengths = dc.sortedLengths();
                    System.out.println("Отсортированные длины строк в коллекции: " + sortedLengths);
                    break;
                case 9: // Посчитать статистику по символам в строках коллекции
                    Map<Character, Integer> statistics = dc.statistics();
                    System.out.println("Статистика по символам в строках коллекции: " + statistics);
                    break;
                case 10: // Сделать реверс всех строк в коллекции
                    List<String> reversed = dc.reverse();
                    System.out.println("Реверс всех строк в коллекции: " + reversed);
                    break;
                case 11: // Сравнить два элемента коллекции по индексам
                    System.out.print("Введите индекс первого элемента: ");
                    int firstIndex = sc.nextInt();
                    System.out.print("Введите индекс второго элемента: ");
                    int secondIndex = sc.nextInt();
                    if (firstIndex >= 0 && firstIndex < dc.size() && secondIndex >= 0 && secondIndex < dc.size()) {
                        boolean compare = dc.compareInnerObjects(firstIndex, secondIndex);
                        System.out.println("Результат сравнения: " + compare);
                    } else {
                        System.out.println("Неверные индексы");
                    }
                    break;
                case 12: // Сохранить коллекцию в xml-файл
                    System.out.print("Введите имя файла, в который хотите сохранить коллекцию: ");
                    s = sc.next();
                    dc.saveToXml(s);
                    System.out.println("Коллекция сохранена в файл");
                    break;
                case 13: // Вывести коллекцию на экран
                    dc.print();
                    break;
                case 14: // Выход
                    System.out.println("Спасибо за использование моей программы. До свидания!");
                    sc.close();
                    return;
                default: // Неверный выбор
                    System.out.println("Неверный выбор. Пожалуйста, выберите операцию от 1 до 14");
                    break;
            }
        }
    }
}
