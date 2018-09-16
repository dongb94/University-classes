//명령어 입력 예제

#include <iostream>
#include <string>
#include <sstream> // istringstream, ostringstream
#include <algorithm>
using namespace std;

int main() {
	string cmdLine;

	getline(cin, cmdLine); // 한 라인 입력

	istringstream iss(cmdLine);
	string cmd;
	iss >> cmd;
	if (cmd == "insert") {
		string snd;
		iss >> snd; // "N" 또는 "front" 또는 "back"
		if (snd == "front") {
			int N;
			iss >> N;
			// insert front N;
		} else if (snd == "back") {
			int N;
			iss >> N;
			// insert back N;
		} else if (all_of(snd.begin(), snd.end(),
			[](char ch) { return '0'<=ch && ch<='9'; })) {
				// insert N ...
				if (iss.eof()) {
					// insert N 명령어!!! /// snd ==> "N"
					istringstream j(snd);
					int N;
					j >> N; 
				} else {
					string thd; 
					iss >> thd;
					if (thd == "after") {
						int M;
						iss >> M;
						// insert N after M 명령어
					} else if (thd == "before") {
						int M;
						iss >> M;
						// insert N before M 명령어
					} else {
						// insert N 명령어 에러
					}
				}
		} else {
			// insert 명령어 에러!!
		}

	} else if (cmd == "delete") {
		string snd;
		iss >> snd; // "N" 또는 "all"
		if (snd == "all") {
			int N;
			iss >> N;
			// delete all N 명령어
		} else if (all_of(snd.begin(), snd.end(), 
					[](char ch) {
						return '0' <= ch && ch <= '9'; } )
			) {

		} else {
			// delete 명령어 에러!!!
		}

	} else if (cmd == "head") {
		// list의 첫번째 원소를 가져와서 출력
	} else if (cmd == "tail") {
		// list의 첫번째 원소를 제외하고 나머지를 출력
	} else if (cmd == "nth") {
		int N;
		iss >> N;
		// list의 0,1,2,..., N-1 첨자의 원소를 출력
	} else if (cmd == "quit") {
		// 프로그램 종료 return 0;
	} else {
		// Unknown command error!!
	}



	return 0;
}