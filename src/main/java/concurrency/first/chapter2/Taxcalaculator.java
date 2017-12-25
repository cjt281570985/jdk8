package concurrency.first.chapter2;

public class Taxcalaculator {

    private final double salary;

    private final double bonus;

    private CalculatorStrategy calculatorStrategy;

    public void setCalculatorStrategy(CalculatorStrategy calculatorStrategy) {
        this.calculatorStrategy = calculatorStrategy;
    }

    public Taxcalaculator(double salary, double bonus) {
        this.salary = salary;
        this.bonus = bonus;
    }

    public double calcTax() {

        return 0.0d;
    }
    public double calcuate2() {

        return calculatorStrategy.calcuate(salary, bonus);
    }

    public double calcuate() {
        return this.calcTax();
    }

    public double getSalary() {
        return salary;
    }

    public double getBonus() {
        return bonus;
    }
}
