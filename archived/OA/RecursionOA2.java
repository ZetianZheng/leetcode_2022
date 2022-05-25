import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RecursionOA2 {
    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
        public Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }

        public int getId() {
            return this.id;
        }
    }

    Map<Integer, Employee> employeeMap;
    int getImportance(List<Employee> employees, int id) {
        employeeMap = employees.stream().collect(Collectors.toMap(Employee::getId, employee -> employee));
        return getImportanceHelper(id);
    }

    public int getImportanceHelper(int id) {
        Employee currEmp = employeeMap.get(id);
        // base case:
        int currImp = currEmp.importance;
        if (currEmp.subordinates.isEmpty()) {
            return currImp;
        }

        for (int subId : currEmp.subordinates) {
            currImp += getImportanceHelper(subId);
        }

        return currImp;
    }

    public static void main(String[] args) {

    }

}
