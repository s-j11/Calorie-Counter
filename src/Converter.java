public class Converter {
    double distance = 75; // см
    double calorie = 50;  // шагов

    public Converter() {
    }

    double distanceInKm (int allSteps){

        double km = allSteps * distance / 100 / 1000;
        return km;
    }

    double kCalorie(int allSteps) {
        double kC = allSteps*calorie/1000;
        return kC;
    }

}
