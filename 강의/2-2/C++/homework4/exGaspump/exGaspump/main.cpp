#include "GasPump.h"

int main() {   // GasPump 클래스 테스트 프로그램

	GasPump pump;

	pump.initialize();  // Gas Pump를 초기화
	GasPump::buyFromJobber(25);  // Gas Pump에 25갤론의 Gas를 채워넣음
	GasPump::setPricePerGallon(1.50); // Gas 가격을 갤론당 1.5달러로 지정

	GasPump::displayAmountInMainTank();   // Gas Pump에 담긴 전체 Gas양을 출력
	pump.dispense();  // Gas 주유를 시작

	pump.reset();        // Gas Pump의 주유한 Gas양과 가격을 0으로 초기화
	GasPump::displayAmountInMainTank(); // Gas Pump 남은 전체 Gas양을 출력
	pump.dispense();  // 다음 Gas 주유를 시작
}
