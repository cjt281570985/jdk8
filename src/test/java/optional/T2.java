package optional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class T2 {


    public static void main(String[] args) {

        Emp emp = new Emp("yzy");
        Emp emp1 = new Emp("cjt");

        List<Emp> emps = Arrays.asList(emp, emp1);

        Company company = new Company();

        //company.setEmps(emps);

        Optional<Company> companyOptional = Optional.ofNullable(company);
        System.out.println(companyOptional.map(com -> com.getEmps()).orElse(new ArrayList<Emp>()));



    }
}
