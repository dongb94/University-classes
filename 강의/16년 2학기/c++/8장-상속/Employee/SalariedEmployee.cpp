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
	setNetPay(salary);  // �� �޿��� netPay�� ����
	cout << "\n------------------------------------------ - \n";
	cout << "Pay to the order of " << getName() << endl;   // �̸� ���
	cout << "The sum of " << getSalary() << " Dollars\n";   // �ֱ� ���
	cout << "Check Stub Not Negotiable\n";
	cout << "Employee Number :" << getSsn() << endl;   // �ֹε�Ϲ�ȣ ���
	cout << "Salaried Employee.Regular Pay : " << getNetPay() << endl; // �� �޿� ���
	cout << "\n------------------------------------------ - \n";
}

double SalariedEmployee::getSalary() const { return salary;  }

void SalariedEmployee::setSalary(double s) { salary = s; }

