import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nВыберите задание:");
            System.out.println("1. Работа с коробкой (Задание 1.1)");
            System.out.println("2. Работа с хранилищем (Задание 1.2)");
            System.out.println("3. Работа с трехмерной точкой (Задание 2.3)");
            System.out.println("4. Работа с методом apply (Задание 3.1)");
            System.out.println("5. Работа с фильтрами (Задание 3.2)");
            System.out.println("6. Работа сокращение (Задание 3.3)");
            System.out.println("0. Выйти из программы");
            System.out.print("Ваш выбор: ");

            int taskChoice;
            try {
                taskChoice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите корректный номер задания.");
                continue;
            }

            switch (taskChoice) {
                case 1:
                    runBoxTask(scanner);
                    break;
                case 2:
                    runStorageTask(scanner);
                    break;
                case 3:
                    runPointTask(scanner);
                    break;
                case 4:
                    runApplyTask(scanner);
                    break;
                case 5:
                    runFilterTask(scanner);
                    break;
                case 6:
                    runReductionTask(scanner);
                    break;
                case 0:
                    running = false;
                    System.out.println("Выход из программы. До свидания!");
                    break;
                default:
                    System.out.println("Ошибка: выберите корректный номер задания.");
            }
        }

        scanner.close();
    }

    // Задание 1.1: Работа с коробкой
    private static void runBoxTask(Scanner scanner) {
        Box<Integer> intBox = new Box<>();
        boolean taskRunning = true;

        while (taskRunning) {
            System.out.println("\nВыберите действие для коробки:");
            System.out.println("1. Проверить, пуста ли коробка");
            System.out.println("2. Поместить число в коробку");
            System.out.println("3. Извлечь число из коробки");
            System.out.println("4. Показать содержимое коробки");
            System.out.println("0. Вернуться в главное меню");
            System.out.print("Ваш выбор: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите корректный номер действия.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println(intBox.isEmpty() ? "Коробка пуста." : "Коробка не пуста.");
                    break;
                case 2:
                    if (!intBox.isEmpty()) {
                        System.out.println("Коробка уже содержит объект. Извлеките его сначала.");
                    } else {
                        System.out.print("Введите число для помещения в коробку: ");
                        try {
                            int value = Integer.parseInt(scanner.nextLine());
                            intBox.setItem(value);
                            System.out.println("Число успешно помещено в коробку.");
                        } catch (NumberFormatException e) {
                            System.out.println("Ошибка: введите корректное целое число.");
                        } catch (BoxFullException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 3:
                    if (intBox.isEmpty()) {
                        System.out.println("Коробка уже пуста.");
                    } else {
                        System.out.println("Извлечено из коробки: " + intBox.getItem());
                    }
                    break;
                case 4:
                    System.out.println(intBox);
                    break;
                case 0:
                    taskRunning = false;
                    break;
                default:
                    System.out.println("Ошибка: выберите корректный номер действия.");
            }
        }
    }

    // Задание 1.2: Работа с хранилищем
    private static void runStorageTask(Scanner scanner) {
        System.out.println("\nРабота с хранилищем. Выберите тип данных:");
        System.out.println("1. Числа");
        System.out.println("2. Строки");
        System.out.print("Ваш выбор: ");

        int typeChoice;
        try {
            typeChoice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введите корректный номер.");
            return;
        }

        switch (typeChoice) {
            case 1:
                System.out.print("Введите число для хранения (или оставьте пустым для null): ");
                String input = scanner.nextLine();
                Integer number = input.isEmpty() ? null : Integer.parseInt(input);
                Storage<Integer> intStorage = new Storage<>(number);

                // Альтернативные значения
                int alternative;
                if (number == null) {
                    alternative = 0;
                } else if (number == 99) {
                    alternative = -1;
                } else {
                    alternative = 999; 
                }

                System.out.println("Хранилище создано: " + intStorage);
                System.out.println("Извлечённое значение: " + intStorage.getItem(alternative, 99, -1));
                break;

            case 2:
                System.out.print("Введите строку для хранения (или оставьте пустым для null): ");
                String text = scanner.nextLine();
                Storage<String> stringStorage = new Storage<>(text.isEmpty() ? null : text);

                // Альтернативные значения
                String alternativeString;
                if (text.isEmpty()) {
                    alternativeString = "default";
                } else if ("hello".equals(text)) {
                    alternativeString = "hello world";
                } else {
                    alternativeString = "unknown";
                }

                System.out.println("Хранилище создано: " + stringStorage);
                System.out.println("Извлечённое значение: " + stringStorage.getItem(alternativeString, "hello", "hello world"));
                break;

            default:
                System.out.println("Ошибка: выберите корректный тип данных.");
        }
    }
    
    // Задание 2.3: Работа с отчетом
    private static void runPointTask(Scanner scanner) {
        Box<Point3D> pointBox = new Box<>();
        boolean taskRunning = true;

        while (taskRunning) {
            System.out.println("\nВыберите действие для работы с трехмерной точкой:");
            System.out.println("1. Поместить точку в коробку");
            System.out.println("2. Извлечь точку из коробки");
            System.out.println("3. Показать содержимое коробки");
            System.out.println("0. Вернуться в главное меню");
            System.out.print("Ваш выбор: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите корректный номер действия.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Введите координату x: ");
                    double x = scanner.nextDouble();
                    System.out.print("Введите координату y: ");
                    double y = scanner.nextDouble();
                    System.out.print("Введите координату z: ");
                    double z = scanner.nextDouble();
                    scanner.nextLine(); 
                    Point3D point = new Point3D(x, y, z);
                    try {
                        pointBox.setItem(point);  // Обработка исключения BoxFullException
                        System.out.println("Точка успешно помещена в коробку.");
                    } catch (BoxFullException e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                break;

                case 2:
                    if (pointBox.isEmpty()) {
                        System.out.println("Коробка пуста.");
                    } else {
                        System.out.println("Извлечена точка: " + pointBox.getItem());
                    }
                    break;

                case 3:
                    System.out.println(pointBox);
                    break;

                case 0:
                    taskRunning = false;
                    break;

                default:
                    System.out.println("Ошибка: выберите корректный номер действия.");
            }
        }
    }
    
    // Задание 3.1: Работа с apply
    private static void runApplyTask(Scanner scanner) {
    System.out.println("\nВыберите тип данных:");
    System.out.println("1. Список строк для получения длин");
    System.out.println("2. Список чисел для преобразования отрицательных в положительные");
    System.out.println("3. Список массивов для нахождения максимальных элементов");
    System.out.print("Ваш выбор: ");

    int choice;
    try {
        choice = Integer.parseInt(scanner.nextLine());
    } catch (NumberFormatException e) {
        System.out.println("Ошибка: введите корректный номер.");
        return;
    }

    switch (choice) {
        case 1:
            // Ввод списка строк
            System.out.println("Введите строки, разделенные пробелами:");
            String[] stringInput = scanner.nextLine().split(" ");
            List<String> strings = Arrays.asList(stringInput);
            System.out.println("Результат: " + ListTransformer.transformList(strings, str -> str.length()));
            break;
        case 2:
            // Ввод списка чисел
            System.out.println("Введите числа, разделенные пробелами:");
            String[] numberInput = scanner.nextLine().split(" ");
            List<Integer> numbers = new ArrayList<>();
            for (String num : numberInput) {
                numbers.add(Integer.parseInt(num));
            }
            System.out.println("Результат: " + ListTransformer.transformList(numbers, num -> Math.abs(num)));
            break;
        case 3:
            // Ввод списка массивов
            System.out.println("Введите количество массивов:");
            int arrayCount = Integer.parseInt(scanner.nextLine());
            List<int[]> arrays = new ArrayList<>();
            for (int i = 0; i < arrayCount; i++) {
                System.out.println("Введите элементы массива " + (i + 1) + ", разделенные пробелами:");
                String[] arrayElements = scanner.nextLine().split(" ");
                int[] array = new int[arrayElements.length];
                for (int j = 0; j < arrayElements.length; j++) {
                    array[j] = Integer.parseInt(arrayElements[j]);
                }
                arrays.add(array);
            }
            
            // Вывод максимальных значений каждого массива
            System.out.println("Результат: " + ListTransformer.transformList(arrays, arr -> Arrays.stream(arr).max().orElse(Integer.MIN_VALUE)));
            break;

        default:
            System.out.println("Ошибка: выберите корректный номер.");
    }
}

    // Задание 3.2: Работа с фильтрами
    private static void runFilterTask(Scanner scanner) {
        System.out.println("\nВыберите тип фильтрации:");
        System.out.println("1. Фильтрация строк по длине (длина строки > 3)");
        System.out.println("2. Фильтрация чисел по положительности (только положительные числа)");
        System.out.println("3. Фильтрация массивов без положительных чисел");
        System.out.print("Ваш выбор: ");
    
        int filterChoice;
        try {
            filterChoice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введите корректный номер.");
            return;
        }
    
        switch (filterChoice) {
            case 1:
                // Ввод списка строк
                System.out.println("Введите строки, разделенные пробелами:");
                String[] stringInput = scanner.nextLine().split(" ");
                List<String> strings = Arrays.asList(stringInput);
                System.out.println("Результат: " + ListTransformer.filterList(strings, str -> str.length() > 3));
                break;
            case 2:
                // Ввод списка чисел
                System.out.println("Введите числа, разделенные пробелами:");
                String[] numberInput = scanner.nextLine().split(" ");
                List<Integer> numbers = new ArrayList<>();
                for (String num : numberInput) {
                    numbers.add(Integer.parseInt(num));
                }
                System.out.println("Результат: " + ListTransformer.filterList(numbers, num -> num > 0));
                break;
            case 3:
                // Ввод списка массивов
                System.out.println("Введите количество массивов:");
                int arrayCount = Integer.parseInt(scanner.nextLine());
                List<int[]> arrays = new ArrayList<>();
                for (int i = 0; i < arrayCount; i++) {
                    System.out.println("Введите элементы массива " + (i + 1) + ", разделенные пробелами:");
                    String[] arrayElements = scanner.nextLine().split(" ");
                    int[] array = new int[arrayElements.length];
                    for (int j = 0; j < arrayElements.length; j++) {
                        array[j] = Integer.parseInt(arrayElements[j]);
                    }
                    arrays.add(array);
                }
            
                // Фильтрация массивов, в которых нет положительных элементов
                List<int[]> filteredArrays = ListTransformer.filterList(arrays, arr -> Arrays.stream(arr).noneMatch(num -> num > 0));
            
                // Печать отфильтрованных массивов
                System.out.println("Результат: ");
                for (int[] array : filteredArrays) {
                    System.out.println(Arrays.toString(array));
                }
                break;

    
            default:
                System.out.println("Ошибка: выберите корректный номер.");
        }
    }
    
    // Задание 3.3: Работа с сокращением
    private static void runReductionTask(Scanner scanner) {
        System.out.println("\nВыберите тип сокращения:");
        System.out.println("1. Сокращение списка чисел (нахождение суммы)");
        System.out.println("2. Сокращение списка строк (объединение в одну строку)");
        System.out.println("3. Сокращение массива чисел (нахождение общего количества элементов во всех массивах)");
        System.out.print("Ваш выбор: ");
        
        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введите корректный номер.");
            return;
        }
    
        switch (choice) {
            case 1:
                // Ввод списка чисел для нахождения суммы
                System.out.println("Введите числа, разделенные пробелами:");
                String[] numberInput = scanner.nextLine().split(" ");
                List<Integer> numbers = new ArrayList<>();
                for (String num : numberInput) {
                    numbers.add(Integer.parseInt(num));
                }
                int sum = numbers.stream().reduce(0, Integer::sum);
                System.out.println("Результат: Сумма чисел = " + sum);
                break;
    
            case 2:
                // Ввод списка строк для их объединения
                System.out.println("Введите строки, разделенные пробелами:");
                String[] stringInput = scanner.nextLine().split(" ");
                List<String> strings = Arrays.asList(stringInput);
                String concatenated = strings.stream().reduce("", String::concat);
                System.out.println("Результат: Объединенные строки = " + concatenated);
                break;
    
            case 3:
                // Ввод списка массивов для нахождения общего количества элементов
                System.out.println("Введите количество массивов:");
                int arrayCount = Integer.parseInt(scanner.nextLine());
                List<int[]> arrays = new ArrayList<>();
                for (int i = 0; i < arrayCount; i++) {
                    System.out.println("Введите элементы массива " + (i + 1) + ", разделенные пробелами:");
                    String[] arrayElements = scanner.nextLine().split(" ");
                    int[] array = new int[arrayElements.length];
                    for (int j = 0; j < arrayElements.length; j++) {
                        array[j] = Integer.parseInt(arrayElements[j]);
                    }
                    arrays.add(array);
                }
                
                // Нахождение общего количества элементов во всех массивах
                int totalCount = arrays.stream()
                                       .mapToInt(arr -> arr.length)
                                       .sum();
                System.out.println("Результат: Общее количество элементов во всех массивах = " + totalCount);
                break;
    
            default:
                System.out.println("Ошибка: выберите корректный номер.");
        }
    }
}
