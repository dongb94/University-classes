
#ifndef GASPUMP_H
#define GASPUMP_H

class GasPump {
public:
	void initialize();				// Gas Pump를 초기화
	void reset();                   // 주유를 시작하기 전 주유 양과 금액을 0으로
	static void displayCostPerGallon();    // Gallon당 비용을 출력
	void displayGasNCharges();		// 주유한 Gas양과 금액을 출력
	void dispense();                // Gas를 주유하면서 Gas 양과 금액을 업데이트
private:
	double gasDispensed, charge;	// 주유한 Gas 양, 해당 금액
public:
	static void setPricePerGallon(double newPrice);	// Gallon당 비용을 설정
	static void buyFromJobber(double quantity);		// Gas Pump에 Gas를 채워넣음
	static void displayAmountInMainTank();          // Gas Pump에 담긴 Gas양을 출력
private:
	static double gasInMainTank, costPerGallon;		// Gas Pump에 담긴 Gas양, Gallon당 비용
};

#endif //GASPUMP_H