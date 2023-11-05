import java.util.*;
import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

import java.util.*;
import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;

// Класс, который представляет динамическую коллекцию, которая имеет статическую размерность
public class DynamicCollection extends StringCollection {

    // Поле, которое хранит статическую размерность коллекции
    private int capacity;

    // Конструктор, который инициализирует коллекцию пустым списком и заданной статической размерностью
    public DynamicCollection(int capacity) {
        super();
        this.capacity = capacity;
    }

    // Конструктор, который инициализирует коллекцию по текстовому файлу и заданной статической размерностью
    public DynamicCollection(String fileName, int capacity) throws FileNotFoundException {
        super(fileName);
        this.capacity = capacity;
    }

    // Переопределенный метод, который добавляет строку в конец списка, и если размер списка превышает статическую размерность, удаляет первый элемент
    @Override
    public void add(String s) {
        super.add(s);
        if (size() > capacity) {
            remove(0);
        }
    }

}
