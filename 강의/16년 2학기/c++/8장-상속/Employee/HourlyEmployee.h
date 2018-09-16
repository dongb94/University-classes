#ifndef HOURLYEMPLOYEE_H
#define HOURLYEMPLOYEE_H

#include "Employee.h"

class HourlyEmployee : public Employee {
public:
	HourlyEmployee();
	HourlyEmployee(string theName, string theSsn,
		double theWageRate, double theHours);
	void setRate(double newWageRate);
	double getRate() const;
	void setHours(double hoursWorked);
	double getHours() const;
	void printCheck();

private:
	double wageRate;
	double hours;
};


#endif
