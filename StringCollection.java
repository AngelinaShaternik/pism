import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

// Класс, который представляет коллекцию строк и реализует различные методы
public class StringCollection {

    // Поле, которое хранит список строк
    private ArrayList<String> list;

    // Конструктор, который инициализирует список пустым
    public StringCollection() {
        list = new ArrayList<String>();
    }

    // Конструктор, который инициализирует список по текстовому файлу
    public StringCollection(String fileName) throws FileNotFoundException {
        list = new ArrayList<String>();
        Scanner sc = new Scanner(new File(fileName));
        while (sc.hasNextLine()) {
            list.add(sc.nextLine());
        }
        sc.close();
    }

    // Метод, который добавляет строку в конец списка
    public void add(String s) {
        list.add(s);
    }

    // Метод, который удаляет строку из списка по индексу
    public void remove(int index) {
        list.remove(index);
    }

    // Метод, который возвращает размер списка
    public int size() {
        return list.size();
    }

    // Метод, который возвращает строку из списка по индексу
    public String get(int index) {
        return list.get(index);
    }

    // Метод, который возвращает индекс строки в списке или -1, если такой строки нет
    public int indexOf(String s) {
        return list.indexOf(s);
    }

    // Метод, который возвращает список индексов строк, которые содержат заданную подстроку
    public List<Integer> find(String sub) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains(sub)) {
                result.add(i);
            }
        }
        return result;
    }

    // Метод, который возвращает список строк, которые совпадают с заданной строкой
    public List<String> match(String s) {
        List<String> result = new ArrayList<String>();
        for (String str : list) {
            if (str.equals(s)) {
                result.add(str);
            }
        }
        return result;
    }

    // Метод, который возвращает количество совпадений заданной строки в списке
    public int count(String s) {
        int result = 0;
        for (String str : list) {
            if (str.equals(s)) {
                result++;
            }
        }
        return result;
    }

    // Метод, который возвращает список длин строк в списке
    public List<Integer> lengths() {
        List<Integer> result = new ArrayList<Integer>();
        for (String str : list) {
            result.add(str.length());
        }
        return result;
    }

    // Метод, который возвращает отсортированный список длин строк в списке
    public List<Integer> sortedLengths() {
        List<Integer> result = lengths();
        Collections.sort(result);
        return result;
    }

    // Метод, который возвращает карту, которая сопоставляет каждый символ с его частотой в строках списка
    public Map<Character, Integer> statistics() {
        Map<Character, Integer> result = new HashMap<Character, Integer>();
        for (String str : list) {
            for (char c : str.toCharArray()) {
                result.put(c, result.getOrDefault(c, 0) + 1);
            }
        }
        return result;
    }

    // Метод, который возвращает список строк, в которых порядок символов обратный
    public List<String> reverse() {
        List<String> result = new ArrayList<String>();
        for (String str : list) {
            result.add(new StringBuilder(str).reverse().toString());
        }
        return result;
    }

    // Метод, который сравнивает два элемента списка по индексам и возвращает true, если они равны, и false, если нет
    public boolean compareInnerObjects(int firstIndex, int secondIndex) {
        return list.get(firstIndex).equals(list.get(secondIndex));
    }

    // Метод, который сохраняет список строк в xml-файл
    public void saveToXml(String fileName) throws ParserConfigurationException, TransformerException, TransformerException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.newDocument();
        Element root = doc.createElement("StringCollection");
        doc.appendChild(root);
        for (String str : list) {
            Element element = doc.createElement("String");
            element.appendChild(doc.createTextNode(str));
            root.appendChild(element);
        }
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        t.transform(new DOMSource(doc), new StreamResult(new File(fileName)));
    }

    // Метод, который выводит содержимое списка на экран
    public void print() {
        System.out.println(list);
    }

}
