
#include <iostream>
#include <string>
using namespace std;

#include "HourlyEmployee.h"

HourlyEmployee::HourlyEmployee()
	: Employee(), wageRate(0), hours(0)
{ /* nothing */
}

HourlyEmployee::HourlyEmployee(string theName, string theNumber,
	double theWageRate, double theHours)
	: Employee(theName, theNumber), wageRate(theWageRate), hours(theHours)
{ /* nothing */
}

/* Refer to Display 14.5 for setRate(), getRate(), setHours(), getHours() */

void HourlyEmployee::printCheck() {
	setNetPay(hours * wageRate);
	cout << "\n------------------------------------------ - \n";
	cout << "Pay to the order of " << getName() << endl;
	cout << "Check Stub Not Negotiable\n";
	cout << "Employee Number : " << getSsn() << endl;
	cout << "Hourly Employee. \nHours worked : " << hours
		<< "Rate : ¡± << wageRate << ¡°Pay : " << getNetPay() << endl;
	cout << "\n------------------------------------------ - \n";
}
