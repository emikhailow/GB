package GB5_HomeWork;

public class GB5_HomeWork {

    public static void main(String[] args) {

        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312311", 45000, 30);
        employees[1] = new Employee("Petr Petrov", "Developer", "ppetrov@mailbox.com", "892312312", 120000, 29);
        employees[2] = new Employee("Sidor Sidorov", "Driver", "ssidorov@mailbox.com", "892312313", 25000, 45);
        employees[3] = new Employee("Fedor Fedorov", "Maintenance", "ffedorov@mailbox.com", "892312314", 25000, 54);
        employees[4] = new Employee("Dmitrii Dmitriev", "CEO", "ddmitriev@mailbox.com", "892312315", 100000, 49);

        for(Employee employee : employees){

            if(Employee.isOlderThan(employee,40)){
                System.out.println(employee.toString());
            }

        }

    }


}
