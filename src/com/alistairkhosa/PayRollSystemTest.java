package com.alistairkhosa;

public class PayRollSystemTest {

    public static void main(String[] args) {
        // create subclass objects
        SalariedEmployee salariedEmployee = new SalariedEmployee("Alistair",
                "Khosa","444-545-222",800.0);
        HourlyEmployee hourlyEmployee = new HourlyEmployee("Karen",
                "Price", "222-111-000", 16.75,40);
        CommissionEmployee commissionEmployee = new CommissionEmployee("John",
                "Smith", "622-111-000", 1000,.06);
        BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Bob",
                "Burke", "888-222-121", 5000,.04, 300);

        System.out.println("Employees processed individually:");
        System.out.printf("%n%s%n%s: $%,.2f%n%n", salariedEmployee, "earned", salariedEmployee.earnings());
        System.out.printf("%n%s%n%s: $%,.2f%n%n", hourlyEmployee, "earned", hourlyEmployee.earnings());
        System.out.printf("%n%s%n%s: $%,.2f%n%n", commissionEmployee, "earned", commissionEmployee.earnings());
        System.out.printf("%n%s%n%s: $%,.2f%n%n", basePlusCommissionEmployee, "earned", basePlusCommissionEmployee.earnings());

        // create four-element Employee array
        Employee[] employees = new Employee[4];

        // initialize array with Employee
        employees[0] = salariedEmployee;
        employees[1] = hourlyEmployee;
        employees[2] = commissionEmployee;
        employees[3] = basePlusCommissionEmployee;

        System.out.println("Employees processed polymorphically:\n");

        for (Employee currentEmp : employees){
            System.out.println("\n" + currentEmp);
            if (currentEmp instanceof BasePlusCommissionEmployee){
                BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee) currentEmp;
                employee.setBaseSalary(1.10 * employee.getBaseSalary());

                System.out.printf("new base salary with 10%% increase: $%,.2f%n", employee.getBaseSalary());
            }
            System.out.printf("earned: $%,.2f%n", currentEmp.earnings());
        }

        for (int i = 0; i < employees.length; i++) {
            System.out.printf("%nEmployee %d is a %s%n", i, employees[i].getClass().getName());
        }

    }
}

