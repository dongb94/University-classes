// 12�� ���� ����� ��� ����

#include <iostream>
#include <fstream>  // ifstream, ofstream
#include <string> // getline
using namespace std;

int main() {
	ifstream fi;
	
	int ncount;

	// 1. ��ü �ܾ� ��
	fi.open("wordlist.txt");

	ncount = 0;
	while (fi.eof() != true) {
		string line;
		getline(fi, line); // ���� �б�
		ncount ++;
	}

	fi.close();

	// 2. ������ �ܾ ����
	fi.open("wordlist.txt");

	int nword = rand() % ncount;
	int i=0;
	string word;
	while (fi.eof() != true && i < ncount) {
		getline(fi, word);
	}

	fi.close();

	// 3. ��� ���� ����
	string inputChars; // ����ڰ� Guess�� ���ڵ�

	// 3.1 Ʋ�� Ƚ���� 5ȸ ���� �� ���� �ݺ�
	//    3.1.1 word�� ǥ�� 
	//         3.1.1.1 inputChars�� ���� ���ڴ� '_', 
	//                 inputChars�� �ִ� ���ڴ� �״�� ǥ��
	//    3.1.2 ���� ch�� �Է� �ޱ�
	//         3.1.1.1 inputChars�� ch�� �߰�
	//         3.1.1.2 ch�� word�� ���ԵǾ� ���� ������ Ʋ�� Ƚ�� +1

	return 0;
}