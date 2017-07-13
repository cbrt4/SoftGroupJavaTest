package alex.softgroupjavatest.test5;

public class EmployeeFixedPayment extends Employee {

    private double fixedPayment;

    public EmployeeFixedPayment(int id,
                                String name,
                                String surname,
                                int age,
                                String phoneNumber,
                                String email,
                                double fixedPayment) {
        super(id, name, surname, age, phoneNumber, email);
        this.fixedPayment = fixedPayment;
    }

    public double calculatePayment() {
        return fixedPayment;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nPayment (fixed): " + calculatePayment();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeFixedPayment)) return false;
        if (!super.equals(o)) return false;

        EmployeeFixedPayment that = (EmployeeFixedPayment) o;

        return Double.compare(that.fixedPayment, fixedPayment) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(fixedPayment);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
