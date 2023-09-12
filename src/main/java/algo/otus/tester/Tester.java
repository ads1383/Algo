package algo.otus.tester;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tester {

    private final String path;

    public Tester(String path) {
        this.path = path;
    }

    public boolean testDoubleOutAndDoubleLongIn(BiFunction<Double, Long, Double> function) {
        try (Stream<Path> filePathStream = Files.walk(Paths.get(path))) {
            return !filePathStream
                    .filter(Files::isRegularFile)
                    .collect(Collectors.groupingBy(p -> p.toString().split("\\.")[1]))
                    .entrySet()
                    .stream()
                    .map(entry -> {
                        List<Path> list = entry.getValue();
                        String key = entry.getKey();
                        List<String> stringList = list.stream().filter(p -> p.toString().endsWith("in")).map(this::readStringArray).findFirst().get();
                        Double firstValue = Double.valueOf(stringList.get(0).trim());
                        Long secondValue = Long.valueOf(stringList.get(1).trim());
                        Double out = list.stream().filter(p -> p.toString().endsWith("out")).map(this::readDoubleValue).findFirst().get();
                        long timeMillis = System.currentTimeMillis();
                        Double result = function.apply(firstValue, secondValue);
                        long resultTime = System.currentTimeMillis() - timeMillis;
                        DecimalFormat df = new DecimalFormat("#.00000000000");
                        String resultString = df.format(result);
                        String outString = df.format(out);
                        if (outString.equals(resultString)) {
                            System.out.println("Проверка теста № " + key + " прошла успешно! | Затраченное время: " + resultTime + " ms");
                            return true;
                        }
                        System.out.println("Тест № " + key + " не прошел проверку!!! Результат: " + resultString + " != " + outString);
                        return false;
                    }).collect(Collectors.toSet()).contains(Boolean.FALSE);
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода. Завершение работы тестов...");
        }
        return false;
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
                        long timeMillis = System.currentTimeMillis();
                        Long result = function.apply(in);
                        long resultTime = System.currentTimeMillis() - timeMillis;
                        if (out.equals(result)) {
                            System.out.println("Проверка теста № " + key + " прошла успешно! | Затраченное время: " + resultTime + " ms");
                            return true;
                        }
                        System.out.println("Тест № " + key + " не прошел проверку!!! Результат: " + result + " != " + out + " | ");
                        return false;
                    }).collect(Collectors.toSet()).contains(Boolean.FALSE);
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода. Завершение работы тестов...");
        }
        return false;
    }

    public boolean testIntegerInOut(Function<Integer, Integer> function) {
        try (Stream<Path> filePathStream = Files.walk(Paths.get(path))) {
            return !filePathStream
                    .filter(Files::isRegularFile)
                    .collect(Collectors.groupingBy(p -> p.toString().split("\\.")[1]))
                    .entrySet()
                    .stream()
                    .map(entry -> {
                        List<Path> list = entry.getValue();
                        String key = entry.getKey();
                        Integer in = list.stream().filter(p -> p.toString().endsWith("in")).map(this::readIntegerValue).findFirst().get();
                        Integer out = list.stream().filter(p -> p.toString().endsWith("out")).map(this::readIntegerValue).findFirst().get();
                        long timeMillis = System.currentTimeMillis();
                        Integer result = function.apply(in);
                        long resultTime = System.currentTimeMillis() - timeMillis;
                        if (out.equals(result)) {
                            System.out.println("Проверка теста № " + key + " прошла успешно! | Затраченное время: " + resultTime + " ms");
                            return true;
                        }
                        System.out.println("Тест № " + key + " не прошел проверку!!! Результат: " + result + " != " + out + " | ");
                        return false;
                    }).collect(Collectors.toSet()).contains(Boolean.FALSE);
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода. Завершение работы тестов...");
        }
        return false;
    }

    public boolean testDoubleOutLongIn(Function<Long, Double> function) {
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
                        Double out = list.stream().filter(p -> p.toString().endsWith("out")).map(this::readDoubleValue).findFirst().get();
                        long timeMillis = System.currentTimeMillis();
                        Double result = function.apply(in);
                        long resultTime = System.currentTimeMillis() - timeMillis;
                        DecimalFormat df = new DecimalFormat("#.00000000000");
                        String resultString = df.format(result);
                        String outString = df.format(out);
                        if (outString.equals(resultString)) {
                            System.out.println("Проверка теста № " + key + " прошла успешно! | Затраченное время: " + resultTime + " ms");
                            return true;
                        }
                        System.out.println("Тест № " + key + " не прошел проверку!!! Результат: " + resultString + " != " + outString);
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

    private Integer readIntegerValue(Path path) {
        try {
            String value = Files.readAllLines(path).get(0).trim();
            return Integer.valueOf(value);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка ввода/вывода. Невозможно прочитать значение");
        }
    }

    private String readStringValue(Path path) {
        try {
            return Files.readAllLines(path).get(0).trim();
        } catch (IOException e) {
            throw new RuntimeException("Ошибка ввода/вывода. Невозможно прочитать значение");
        }
    }

    private Double readDoubleValue(Path path) {
        try {
            String value = Files.readAllLines(path).get(0).trim();
            return Double.valueOf(value);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка ввода/вывода. Невозможно прочитать значение");
        }
    }

    private List<String> readStringArray(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка ввода/вывода. Невозможно прочитать значение");
        }
    }
}
