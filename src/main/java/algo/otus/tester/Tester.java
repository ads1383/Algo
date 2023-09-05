package algo.otus.tester;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tester {

    private final String path;

    public Tester(String path) {
        this.path = path;
    }

    public boolean testLongInOut(Function<Long, Long> function) {
        try (Stream<Path> filePathStream = Files.walk(Paths.get(path))) {
            return !filePathStream
                    .filter(Files::isRegularFile)
                    .collect(Collectors.groupingBy(p -> p.toString().split("\\.")[1]))
                    .entrySet()
                    .stream()
                    .map(entry -> {
                        List<Path> list = entry.getValue();
                        String key = entry.getKey();
                        Long in = list.stream().filter(p -> p.toString().endsWith("in")).map(this::readLongValue).findFirst().get();
                        Long out = list.stream().filter(p -> p.toString().endsWith("out")).map(this::readLongValue).findFirst().get();
                        Long result = function.apply(in);
                        if (out.equals(result)) {
                            System.out.println("Проверка теста № " + key + " прошла успешно!");
                            return true;
                        }
                        System.out.println("Тест № " + key + " не прошел проверку!!! Результат: " + result + " != " + out);
                        return false;
                    }).collect(Collectors.toSet()).contains(Boolean.FALSE);
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода. Завершение работы тестов...");
        }
        return false;
    }

    private Long readLongValue(Path path) {
        try {
            String value = Files.readAllLines(path).get(0).trim();
            return Long.valueOf(value);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка ввода/вывода. Невозможно прочитать значение");
        }
    }
}
