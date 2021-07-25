import java.io.*;
import java.util.*;

public class Reader {
    public static void main(String[] args) {
        try {
            reader();
        } catch (IOException e) {
            System.out.println("Неверный путь до файла");
        }
    }

    // считывает файл
    public static void reader() throws IOException {
        List<String> lines = new ArrayList<>();
        System.out.println("Введите путь до файла:");


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String filePath = bf.readLine();

        File file = new File(filePath);

        FileReader fr = new FileReader(file);

        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();


        while (line != null) {
            String[] lineArr = line.split("[^a-zA-Z]+");
            lines.addAll(Arrays.asList(lineArr));
            line = reader.readLine();
        }

        lines.sort(String::compareToIgnoreCase);
        System.out.println("Слова в алфавитном порядке:");
        System.out.println(lines);


        Map<String, Integer> mapWord = new HashMap<>();

        for (String word : lines) {
            Integer count = mapWord.get(word);
            if (count == null) {
                count = 0;
            }
            mapWord.put(word, count + 1);

        }
        System.out.println("Повторяемость слов:");
        System.out.println(mapWord);

        int maxValue = (Collections.max(mapWord.values()));

        System.out.println("Слово встречающиеся максимальное число раз:");

        for (Map.Entry<String, Integer> entry : mapWord.entrySet()) {
            if (entry.getValue() == maxValue) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
        }

    }
}

