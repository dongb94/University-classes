#ifndef SALARIEDEMPLOYEE_H
#define SALARIEDEMPLOYEE_H

#include <string>
using namespace std;

#include "Employee.h"

class SalariedEmployee : public Employee {
public:
	SalariedEmployee();
	SalariedEmployee(string theName, string theSsn,
		double theWeeklySalary);
	double getSalary() const;
	void setSalary(double newSalary);
	void printCheck();

private:
	double salary;

};

#endif SALARIEDEMPLOYEE_H
