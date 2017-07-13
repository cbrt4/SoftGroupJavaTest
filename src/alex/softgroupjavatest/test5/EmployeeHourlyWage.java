package alex.softgroupjavatest.test5;

public class EmployeeHourlyWage extends Employee {

    private double hourlyWage;

    public EmployeeHourlyWage(int id,
                              String name,
                              String surname,
                              int age,
                              String phoneNumber,
                              String email,
                              double hourlyWage) {
        super(id, name, surname, age, phoneNumber, email);
        this.hourlyWage = hourlyWage;
    }

    public double calculatePayment() {
        return 20.8*8*hourlyWage;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nPayment (hourly): " + calculatePayment();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeHourlyWage)) return false;
        if (!super.equals(o)) return false;

        EmployeeHourlyWage that = (EmployeeHourlyWage) o;

        return Double.compare(that.hourlyWage, hourlyWage) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(hourlyWage);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
