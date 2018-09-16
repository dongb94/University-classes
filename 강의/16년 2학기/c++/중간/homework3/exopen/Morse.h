
#include <string>
using namespace std;

#ifndef MORSE_H
#define MORSE_H

class Morse{
 	string alphabet[26];
	string digit[10];
	string slash, question, comma, period, plus, equal;
public:
	Morse();
	void textToMorse(string text, string& morse);
	void buffer(string morse, string& text);//morse ��ȣ�� ��������� �о���δ�
	void morseToText(string buffer, string& text);//buffer�� �о���� 1������ morse��ȣ�� ���ڷ� ��ȯ

};

#endif //MORSE_H