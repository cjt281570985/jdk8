package concurrency.first.chapter2;

public class TaxCalculatorMain2 {



    public static void main(String[] args) {

        //使用策略模式
        Taxcalaculator taxcalaculator = new Taxcalaculator(10000d, 2000d);
        SimpleCaclulatorStrategy simpleCaclulatorStrategy = new SimpleCaclulatorStrategy();
        taxcalaculator.setCalculatorStrategy(simpleCaclulatorStrategy);
        taxcalaculator.setCalculatorStrategy((s,b)->{return s*0.1+b*0.3;});

        double tax = taxcalaculator.calcuate2();
        System.out.println(tax);

    }
}
