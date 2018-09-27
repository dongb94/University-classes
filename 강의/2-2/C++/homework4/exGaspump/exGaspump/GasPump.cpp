#include <iostream>
#include "GasPump.h"
using namespace std;

double GasPump::gasInMainTank = 0;
double GasPump::costPerGallon = 0;

void GasPump::initialize() {
	gasInMainTank = 0;
	gasDispensed = 0;
	charge = 0;
}

void GasPump::reset() {
	gasDispensed = 0;
	charge = 0;
}

void GasPump::displayCostPerGallon() {
	cout << "Gallon�� ��� : "  << costPerGallon << endl;
}

void GasPump::displayGasNCharges() {
	cout << "������ : " << gasDispensed << endl
		<< "�ݾ� : " << charge << endl;
}

void GasPump::dispense() {
	displayGasNCharges();                         // ���� ������ Gas��� ������ ���

	while (gasInMainTank > 0) {                 // Gas Pump�� Gas�� �ִٸ� ������ ����
		char quit = cin.get();                        // ���� �Է��� �޾�
		if (quit == 'q' || quit == 'Q') break;     // ��q���ų� ��Q���̸� ������ ����
												// �׷��� ������ ������ ��� ����
		gasDispensed += 0.1;                      // Gas 0.1 ������ ����
		charge += 0.1 * costPerGallon;         // ������ 0.1 ������ Gas��ŭ ������ ����
		gasInMainTank -= 0.1;                     // ������ Gas��ŭ Gas Pump�� Gas���� ����

		displayGasNCharges();                       // ����� Gas ������� ������ 
	}
}

void GasPump::setPricePerGallon(double newPrice) {
	costPerGallon = newPrice;          // ���ο� Gas ���� (Gallon�� �޷�)�� ����
}

void GasPump::buyFromJobber(double quantityBought) {
	gasInMainTank += quantityBought;   // Gas Pump�� quantityBought��ŭ
}

void GasPump::displayAmountInMainTank() {
	cout << "Gas�� : " << gasInMainTank << endl;
}
