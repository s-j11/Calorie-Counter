import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StepTracker {

    int target = 10000;
    Converter converter = new Converter();


    HashMap<Integer, MonthData> monthToDate = new HashMap<Integer, MonthData>();
    public StepTracker() {
        for (int i = 0; i < 12; i++) {
            monthToDate.put(i, new MonthData());
        }
    }


    class MonthData {
        int[] stepsInDay = new int[30];

        public MonthData() {
        }
    }

    MonthData monthDate = new MonthData();


    HashMap<Integer, MonthData> saveStepsInDay (int month, int day, int step) {
        monthDate.stepsInDay[day] = step;
        monthToDate.put(month, monthDate);
    return monthToDate;
    }

      void allStatistics(int m){
        List<String> allStepsInDay = new ArrayList<>();
        int maxSteps = 0;
        int sumSteps = 0;
        int averageSteps = 0;
        double  distanceCovered = 0;
        double burnedСalories = 0;
        monthToDate.get(m);
        int minSeria = 0;
        int maxSeria = 0;


        for (int i = 0; i < monthDate.stepsInDay.length; i++) {

            allStepsInDay.add(i + 1 + " день: " + monthDate.stepsInDay[i]);
            if (maxSteps < monthDate.stepsInDay[i]) {
                maxSteps = monthDate.stepsInDay[i];
            }

            if (monthDate.stepsInDay[i] > target) {
                minSeria++;
            } else {
                if (minSeria > maxSeria) {
                    maxSeria = minSeria;
                }
                minSeria = 0;
            }

        if (minSeria > maxSeria) {
            maxSeria = minSeria;
        }


            sumSteps = sumSteps + monthDate.stepsInDay[i];



            averageSteps = sumSteps / monthDate.stepsInDay.length;
            distanceCovered = converter.distanceInKm(sumSteps);
            burnedСalories = converter.kCalorie(sumSteps);

        }
          System.out.println("Количество пройденных шагов по дням: "+ "\n" + allStepsInDay);
          System.out.println("Общее количество шагов за месяц: " + sumSteps);
          System.out.println("Максимальное количество шагов пройденное в месяце: " + maxSteps);
          System.out.println("Среднее количество шагов: " + averageSteps);
          System.out.println("Пройденная дистанция (в км): " + distanceCovered);
          System.out.println("Количество сожжённых килокалорий: " + burnedСalories);
          System.out.println("Лучшая серия в этом месяце: " + maxSeria);
          System.out.println();

    }

    void changeTarget(int n) {
     target = n;
    }

}
