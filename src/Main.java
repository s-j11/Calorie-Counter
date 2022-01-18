import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        StepTracker stepTracker = new StepTracker();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();

            int command = scanner.nextInt();

            if (command == 1) {
                System.out.println("Укажите месяц за который хотите ввести пройденные шаги от 1 до 12");
                int month = scanner.nextInt();
                month = month -1;
                if ((month>=0) && (month < 12)) {
                   System.out.println("Укажите день за который хотите ввести шаги от 1 до 30");
                   int day = scanner.nextInt();
                    day = day -1;
                    if ((day >= 0) && (day < 30)){
                        System.out.println("Укажите количество пройденных шагов, значение доложно быть положитеным или равно 0");
                    int steps = scanner.nextInt();
                    if(steps >= 0) {
                        stepTracker.saveStepsInDay(month, day, steps);
                    }else {
                        System.out.println("Количество шагов указано с отрицательным знаком");
                    }
                    }else{
                        System.out.println("Вы указали день вне диапозона от 1 до 30");
                        }
                }else{
                            System.out.println("Вы указали месяц вне диапозона от 1 до 12");
                        }

            } else if (command == 2) {
                System.out.println("Укажите месяц за который хотите ввести пройденные шаги от 1 до 12");
                int month = scanner.nextInt();
                if ((month>=0) && (month < 12)) {
                    stepTracker.allStatistics(month);
                }else {
                    System.out.println("Вы указали месяц вне диапозона от 1 до 12");
                }
            } else if (command == 3) {
                System.out.println("Задайте новую цель");
                int n = scanner.nextInt();
                if(n > 0) {
                    stepTracker.changeTarget(n);

                } else {
                    System.out.println("Цель указана с отрицательным знаком либо равна 0, необходимо задать цель значение которой, больше 0");
                }
            } else if (command == 4) {

                System.out.println("Выход");
                break;
            } else {
                System.out.println("Извините, такой команды нет.");
            }
        }
    }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("4 - Выйти из приложения");


    }
}

