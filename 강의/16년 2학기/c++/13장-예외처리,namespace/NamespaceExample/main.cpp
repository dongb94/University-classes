#include <iostream>
#include <string>
using namespace std;

#include "user.h"
#include "password.h"
using namespace Authenticate;

int main() {
	inputUserName();
	inputPassword();
	cout << getUserName() << ", " << getPassword();
	return 0;
}