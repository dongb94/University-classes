#include <iostream>
#include <string>
using namespace std;

#include "HourlyEmployee.h"
#include "SalariedEmployee.h"
#include "Employee.h"

int main() {
	SalariedEmployee se1, se2("ȫ�浿", "1994", 100);
	HourlyEmployee he1, he2("ȫ���", "1995", 5, 10);

	se1.printCheck();
	se2.printCheck();
	he1.printCheck();
	he2.printCheck();
}