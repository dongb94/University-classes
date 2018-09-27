
#ifndef GASPUMP_H
#define GASPUMP_H

class GasPump {
public:
	void initialize();				// Gas Pump�� �ʱ�ȭ
	void reset();                   // ������ �����ϱ� �� ���� ��� �ݾ��� 0����
	static void displayCostPerGallon();    // Gallon�� ����� ���
	void displayGasNCharges();		// ������ Gas��� �ݾ��� ���
	void dispense();                // Gas�� �����ϸ鼭 Gas ��� �ݾ��� ������Ʈ
private:
	double gasDispensed, charge;	// ������ Gas ��, �ش� �ݾ�
public:
	static void setPricePerGallon(double newPrice);	// Gallon�� ����� ����
	static void buyFromJobber(double quantity);		// Gas Pump�� Gas�� ä������
	static void displayAmountInMainTank();          // Gas Pump�� ��� Gas���� ���
private:
	static double gasInMainTank, costPerGallon;		// Gas Pump�� ��� Gas��, Gallon�� ���
};

#endif //GASPUMP_H