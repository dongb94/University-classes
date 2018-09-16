//13장 예외처리
class Account {
	double balance;
public:
	Account() {
		balance = 0;
	}
	Account(double initialDeposit) {
		balance = initialDeposit;
	}
	double getBalance() {
		return balance;
	}
	double deposit(double amount) {
		if(amount > 0) balance += amount;
		else return -1;  // 에러 코드
		return balance;
	}
	double withdraw(double amount) {
		if (amount > balance || amount < 0)
			return -1; // 에러 코드
		else
			balance -= amount;
		return balance;
	}
};