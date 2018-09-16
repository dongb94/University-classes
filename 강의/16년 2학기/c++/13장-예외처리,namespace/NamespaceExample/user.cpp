// user.cpp
#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

namespace {  // 이름없는 네임스페이스
	string username;
	bool isValid() {
		if (username.size() == 8) {
			return
				all_of(username.begin(), username.end(),
						[](char ch) { return ('a'<=ch && ch<='z'
											|| 'A'<=ch && ch<='Z'); });
		}
		else return false;
	}
	// C언어: static bool isValid() { } 
}

namespace Authenticate { // 일반 네임스페이스
	void inputUserName() { 
		do {
			cout << "Enter your user name : ";
			cin >> username;
		} while (!isValid());
	}
	string getUserName() { return username; }
}