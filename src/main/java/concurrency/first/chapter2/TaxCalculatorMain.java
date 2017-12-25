package concurrency.first.chapter2;

public class TaxCalculatorMain {



    public static void main(String[] args) {

        Taxcalaculator taxcalaculator = new Taxcalaculator(10000d, 2000d){
            @Override
            public double calcTax() {
                return this.getSalary()*0.1+this.getBonus()*0.15;
            }
        };

        double tax = taxcalaculator.calcuate();
        System.out.println(tax);

    }
}
