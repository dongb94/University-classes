#include <iostream>
#include <string>
using namespace std;

#include "SalariedEmployee.h"

SalariedEmployee::SalariedEmployee() : Employee()
{ /* nothing */ }

SalariedEmployee::SalariedEmployee(string theName, string theNumber,
	double theWeeklyPay)
	: Employee(theName, theNumber), salary(theWeeklyPay)
{ /* nothing */ }

/* Refer to Display 14.6 for getSalary() and setSalary() */

void SalariedEmployee::printCheck()
{
	setNetPay(salary);  // 총 급여를 netPay에 저장
	cout << "\n------------------------------------------ - \n";
	cout << "Pay to the order of " << getName() << endl;   // 이름 출력
	cout << "The sum of " << getSalary() << " Dollars\n";   // 주급 출력
	cout << "Check Stub Not Negotiable\n";
	cout << "Employee Number :" << getSsn() << endl;   // 주민등록번호 출력
	cout << "Salaried Employee.Regular Pay : " << getNetPay() << endl; // 총 급여 출력
	cout << "\n------------------------------------------ - \n";
}

double SalariedEmployee::getSalary() const { return salary;  }

void SalariedEmployee::setSalary(double s) { salary = s; }

