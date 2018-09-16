// 12장 파일 입출력 행맨 예제

#include <iostream>
#include <fstream>  // ifstream, ofstream
#include <string> // getline
using namespace std;

int main() {
	ifstream fi;
	
	int ncount;

	// 1. 전체 단어 수
	fi.open("wordlist.txt");

	ncount = 0;
	while (fi.eof() != true) {
		string line;
		getline(fi, line); // 한줄 읽기
		ncount ++;
	}

	fi.close();

	// 2. 무작위 단어를 선택
	fi.open("wordlist.txt");

	int nword = rand() % ncount;
	int i=0;
	string word;
	while (fi.eof() != true && i < ncount) {
		getline(fi, word);
	}

	fi.close();

	// 3. 행맨 게임 진행
	string inputChars; // 사용자가 Guess한 문자들

	// 3.1 틀린 횟수가 5회 이하 인 동안 반복
	//    3.1.1 word를 표시 
	//         3.1.1.1 inputChars에 없는 문자는 '_', 
	//                 inputChars에 있는 문자는 그대로 표시
	//    3.1.2 문자 ch를 입력 받기
	//         3.1.1.1 inputChars에 ch를 추가
	//         3.1.1.2 ch가 word에 포함되어 있지 않으면 틀린 횟수 +1

	return 0;
}