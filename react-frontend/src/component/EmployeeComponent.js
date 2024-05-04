import React, { Component } from 'react';
import EmployeeService from '../service/EmployeeService';

class EmployeeComponent extends Component {
    constructor(props) {
        super(props);
        this.state={
            employee :{},
            department:{},
            organization:{}
        }
    }
    
    componentDidMount(){
        EmployeeService.getEmployeeDetails().then((response)=>{
            this.setState({employee : response.data.employeeDto})
            this.setState({department : response.data.departmentDto})
            this.setState({organization : response.data.organizationDto})
            console.log(this.state.employee)
            console.log(this.state.department)
            console.log(this.state.organization)
        })
    }

    render() {
        return (
            <div>
                <div className='card col-md-6 offset-md-3'>
                    <h3 className='text-center card-header'>View Employee Details</h3>
                    <div className='card-body'>
                    <div className='row'>
                        <p><strong>Employee first name </strong>{this.state.employee.firstName}</p>
                    </div>
                    <div className='row'>
                        <p><strong>Employee last Name  </strong>{this.state.employee.lastName}</p>
                    </div>
                    <div className='row'>
                        <p><strong>Employee email </strong>{this.state.employee.email}</p>
                    </div>
                    
                    <h3 className='text-center card-header'>View Department details Details</h3>
                    <div className='row'>
                    <div className='card-body'>
                        <p><strong>department Name </strong>{this.state.department.departmentName}</p>
                    </div>
                    <div className='row'>
                        <p><strong>departmentDescription  </strong>{this.state.department.departmentDescription}</p>
                    </div>
                    <div className='row'>
                        <p><strong>department Code </strong>{this.state.department.departmentCode}</p>
                        </div>
                    </div>
                    <h3 className='text-center card-header'>View Organization details Details</h3>
                    <div className='card-body'>
                        <p><strong>organization Name </strong>{this.state.organization.organizationName}</p>
                    </div>
                    <div className='row'>
                        <p><strong>organization Description  </strong>{this.state.organization.organizationDescription}</p>
                    </div>
                    <div className='row'>
                        <p><strong>organization Code </strong>{this.state.organization.organizationCode}</p>
                        </div>
                    </div>
                    
                </div>
            </div>
          
        );
    }
}

export default EmployeeComponent