//��ɾ� �Է� ����

#include <iostream>
#include <string>
#include <sstream> // istringstream, ostringstream
#include <algorithm>
using namespace std;

int main() {
	string cmdLine;

	getline(cin, cmdLine); // �� ���� �Է�

	istringstream iss(cmdLine);
	string cmd;
	iss >> cmd;
	if (cmd == "insert") {
		string snd;
		iss >> snd; // "N" �Ǵ� "front" �Ǵ� "back"
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
					// insert N ��ɾ�!!! /// snd ==> "N"
					istringstream j(snd);
					int N;
					j >> N; 
				} else {
					string thd; 
					iss >> thd;
					if (thd == "after") {
						int M;
						iss >> M;
						// insert N after M ��ɾ�
					} else if (thd == "before") {
						int M;
						iss >> M;
						// insert N before M ��ɾ�
					} else {
						// insert N ��ɾ� ����
					}
				}
		} else {
			// insert ��ɾ� ����!!
		}

	} else if (cmd == "delete") {
		string snd;
		iss >> snd; // "N" �Ǵ� "all"
		if (snd == "all") {
			int N;
			iss >> N;
			// delete all N ��ɾ�
		} else if (all_of(snd.begin(), snd.end(), 
					[](char ch) {
						return '0' <= ch && ch <= '9'; } )
			) {

		} else {
			// delete ��ɾ� ����!!!
		}

	} else if (cmd == "head") {
		// list�� ù��° ���Ҹ� �����ͼ� ���
	} else if (cmd == "tail") {
		// list�� ù��° ���Ҹ� �����ϰ� �������� ���
	} else if (cmd == "nth") {
		int N;
		iss >> N;
		// list�� 0,1,2,..., N-1 ÷���� ���Ҹ� ���
	} else if (cmd == "quit") {
		// ���α׷� ���� return 0;
	} else {
		// Unknown command error!!
	}



	return 0;
}