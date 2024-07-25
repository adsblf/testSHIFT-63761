package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        boolean paramO = false;
        String oPath = "";
        boolean paramP = false;
        String pPrefix = "";
        boolean paramA = false;
        boolean paramS = false;
        boolean paramF = false;
        ArrayList<String> files = new ArrayList<>();

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-o":
                    if (args[i + 1].startsWith("-") || args[i + 1].endsWith(".txt") || i + 1 > args.length) {
                        System.err.println("Вы не указали путь для результата");
                        System.exit(1);
                    } else {
                        paramO = true;
                        oPath = args[++i];
                    }
                    break;
                case "-p":
                    if (args[i + 1].startsWith("-") || args[i + 1].endsWith(".txt") || i + 1 > args.length) {
                        System.err.println("Вы не указали префикс");
                        System.exit(1);
                    } else {
                        paramP = true;
                        pPrefix = args[++i];
                    }
                    break;
                case "-a":
                    paramA = true;
                    break;
                case "-s":
                    paramS = true;
                    break;
                case "-f":
                    paramF = true;
                    break;
                default:
                    files.add(args[i]);
            }
        }
        if (files.isEmpty()) {
            System.err.println("Вы не указали исходные файлы с данными");
            System.exit(1);
        }

        Main main = new Main();
        main.datasort(paramO, oPath, paramP, pPrefix, paramA, paramS, paramF, files);
    }

    private void datasort(boolean paramO, String oPath, boolean paramP, String pPrefix, boolean paramA, boolean paramS, boolean paramF, ArrayList<String> files) {
        String basePath = paramO ? oPath : System.getProperty("user.dir");
        if (!basePath.endsWith(File.separator)) {
            basePath += File.separator;
        }
        String integerFilePath = basePath + (paramP ? pPrefix : "") + "integers.txt";
        String floatFilePath = basePath + (paramP ? pPrefix : "") + "floats.txt";
        String stringFilePath = basePath + (paramP ? pPrefix : "") + "strings.txt";

        File integerFile = new File(integerFilePath);
        File floatFile = new File(floatFilePath);
        File stringFile = new File(stringFilePath);

        File parentDir = integerFile.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            if (!parentDir.mkdirs()) {
                System.err.println("Не удалось создать директории: " + parentDir.getAbsolutePath());
                return;
            }
        }

        Map<String, Integer> countMap = new HashMap<>();
        Map<String, Double> sumMap = new HashMap<>();
        Map<String, Double> minMap = new HashMap<>();
        Map<String, Double> maxMap = new HashMap<>();
        Map<String, Integer> minLengthMap = new HashMap<>();
        Map<String, Integer> maxLengthMap = new HashMap<>();
        countMap.put("integer", 0);
        countMap.put("float", 0);
        countMap.put("string", 0);

        for (String file : files) {
            File f = new File(file);
            if (!f.exists()) {
                System.err.println("Файл не найден: " + file);
                continue;
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    line = line.trim();
                    if (line.isEmpty()) continue;
                    if (isInteger(line)) {
                        long value = Long.parseLong(line);
                        countMap.put("integer", countMap.get("integer") + 1);
                        updateStats(sumMap, minMap, maxMap, "integer", (double) value);
                    } else if (isFloat(line)) {
                        double value = Double.parseDouble(line);
                        countMap.put("float", countMap.get("float") + 1);
                        updateStats(sumMap, minMap, maxMap, "float", value);
                    } else {
                        countMap.put("string", countMap.get("string") + 1);
                        updateStringStats(minLengthMap, maxLengthMap, "string", line);
                    }
                }
            } catch (IOException e) {
                System.err.println("Ошибка при чтении файла: " + file);
                e.printStackTrace();
            }
        }

        try {
            if (countMap.get("integer") > 0) {
                try (BufferedWriter intWriter = new BufferedWriter(new FileWriter(integerFilePath, paramA))) {
                    for (String file : files) {
                        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                            String line;
                            while ((line = reader.readLine()) != null) {
                                line = line.trim();
                                if (isInteger(line)) {
                                    intWriter.write(line);
                                    intWriter.newLine();
                                }
                            }
                        }
                    }
                }
            }

            if (countMap.get("float") > 0) {
                try (BufferedWriter floatWriter = new BufferedWriter(new FileWriter(floatFilePath, paramA))) {
                    for (String file : files) {
                        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                            String line;
                            while ((line = reader.readLine()) != null) {
                                line = line.trim();
                                if (isFloat(line)) {
                                    floatWriter.write(line);
                                    floatWriter.newLine();
                                }
                            }
                        }
                    }
                }
            }

            if (countMap.get("string") > 0) {
                try (BufferedWriter strWriter = new BufferedWriter(new FileWriter(stringFilePath, paramA))) {
                    for (String file : files) {
                        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                            String line;
                            while ((line = reader.readLine()) != null) {
                                line = line.trim();
                                if (!isInteger(line) && !isFloat(line)) {
                                    strWriter.write(line);
                                    strWriter.newLine();
                                }
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл");
            e.printStackTrace();
        }

        printStatistics(paramS, paramF, countMap, sumMap, minMap, maxMap, minLengthMap, maxLengthMap);
    }

    private boolean isInteger(String s) {
        try {
            Long.parseLong(s);
            return !s.contains(".") && !s.contains("E");
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isFloat(String s) {
        try {
            Double.parseDouble(s);
            return s.contains(".") || s.contains("E");
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void updateStats(Map<String, Double> sumMap, Map<String, Double> minMap, Map<String, Double> maxMap, String key, double value) {
        sumMap.put(key, sumMap.getOrDefault(key, 0.0) + value);
        minMap.put(key, Math.min(minMap.getOrDefault(key, value), value));
        maxMap.put(key, Math.max(maxMap.getOrDefault(key, value), value));
    }

    private void updateStringStats(Map<String, Integer> minLengthMap, Map<String, Integer> maxLengthMap, String key, String value) {
        int length = value.length();
        minLengthMap.put(key, Math.min(minLengthMap.getOrDefault(key, length), length));
        maxLengthMap.put(key, Math.max(maxLengthMap.getOrDefault(key, length), length));
    }

    private void printStatistics(boolean paramS, boolean paramF, Map<String, Integer> countMap, Map<String, Double> sumMap, Map<String, Double> minMap, Map<String, Double> maxMap, Map<String, Integer> minLengthMap, Map<String, Integer> maxLengthMap) {
        if (paramS || paramF) {
            System.out.println("Статистика:");
            if (paramS) {
                System.out.println("Количество целых чисел: " + countMap.get("integer"));
                System.out.println("Количество вещественных чисел: " + countMap.get("float"));
                System.out.println("Количество строк: " + countMap.get("string"));
            }
            if (paramF) {
                if (countMap.get("integer") > 0) {
                    System.out.println("Целые числа - минимальное: " + minMap.get("integer") + ", максимальное: " + maxMap.get("integer") + ", сумма: " + sumMap.get("integer") + ", среднее: " + (sumMap.get("integer") / countMap.get("integer")));
                }
                if (countMap.get("float") > 0) {
                    System.out.println("Вещественные числа - минимальное: " + minMap.get("float") + ", максимальное: " + maxMap.get("float") + ", сумма: " + sumMap.get("float") + ", среднее: " + (sumMap.get("float") / countMap.get("float")));
                }
                if (countMap.get("string") > 0) {
                    System.out.println("Строки - минимальная длина: " + minLengthMap.get("string") + ", максимальная длина: " + maxLengthMap.get("string"));
                }
            }
        }
    }
}
