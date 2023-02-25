import java.util.Scanner;

public class DepositCalculator {

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double income = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);

        return round(income, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        double income = amount + amount * yearRate * depositPeriod;

        return round(income, 2);
    }

    double round(double valueOfAmount, int roundingAccuracy) {
        double scale= Math.pow(10, roundingAccuracy);

        return Math.round(valueOfAmount * scale) / scale;
    }

    void runApplication() {
        int period;
        int typeOfDeposit;
        double income = 0;

        Scanner input = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = input.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = input.nextInt( );
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        typeOfDeposit = input.nextInt();
        if (typeOfDeposit == 1) {
            income = calculateSimplePercent(amount, 0.06, period);
        } else if (typeOfDeposit == 2) {
            income = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + income);
    }

    public static void main(String[] args) {
        new DepositCalculator().runApplication();
    }
}
