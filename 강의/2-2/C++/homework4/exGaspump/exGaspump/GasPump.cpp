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
	cout << "Gallon당 비용 : "  << costPerGallon << endl;
}

void GasPump::displayGasNCharges() {
	cout << "주유량 : " << gasDispensed << endl
		<< "금액 : " << charge << endl;
}

void GasPump::dispense() {
	displayGasNCharges();                         // 현재 주유된 Gas양과 가격을 출력

	while (gasInMainTank > 0) {                 // Gas Pump에 Gas가 있다면 주유를 진행
		char quit = cin.get();                        // 문자 입력을 받아
		if (quit == 'q' || quit == 'Q') break;     // ‘q’거나 ‘Q’이면 주유를 중지
												// 그렇지 않으면 주유를 계속 진행
		gasDispensed += 0.1;                      // Gas 0.1 갤런을 주유
		charge += 0.1 * costPerGallon;         // 주유한 0.1 갤런의 Gas만큼 가격을 증가
		gasInMainTank -= 0.1;                     // 주유한 Gas만큼 Gas Pump의 Gas양을 감소

		displayGasNCharges();                       // 변경된 Gas 주유양과 가격을 
	}
}

void GasPump::setPricePerGallon(double newPrice) {
	costPerGallon = newPrice;          // 새로운 Gas 가격 (Gallon당 달러)로 설정
}

void GasPump::buyFromJobber(double quantityBought) {
	gasInMainTank += quantityBought;   // Gas Pump에 quantityBought만큼
}

void GasPump::displayAmountInMainTank() {
	cout << "Gas량 : " << gasInMainTank << endl;
}
