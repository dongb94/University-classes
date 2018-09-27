#include "GasPump.h"

int main() {   // GasPump Ŭ���� �׽�Ʈ ���α׷�

	GasPump pump;

	pump.initialize();  // Gas Pump�� �ʱ�ȭ
	GasPump::buyFromJobber(25);  // Gas Pump�� 25������ Gas�� ä������
	GasPump::setPricePerGallon(1.50); // Gas ������ ���д� 1.5�޷��� ����

	GasPump::displayAmountInMainTank();   // Gas Pump�� ��� ��ü Gas���� ���
	pump.dispense();  // Gas ������ ����

	pump.reset();        // Gas Pump�� ������ Gas��� ������ 0���� �ʱ�ȭ
	GasPump::displayAmountInMainTank(); // Gas Pump ���� ��ü Gas���� ���
	pump.dispense();  // ���� Gas ������ ����
}
