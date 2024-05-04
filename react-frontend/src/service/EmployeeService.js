import axois from 'axios'   

const EMPLOYEE_SERVICE_BASE_URL="http://localhost:8484/api/employees";
const EMPLOYEE_Id=2;

class EmployeeService{

    getEmployeeDetails(){
       return axois.get(EMPLOYEE_SERVICE_BASE_URL+"/"+EMPLOYEE_Id);
    }
}
export default new EmployeeService