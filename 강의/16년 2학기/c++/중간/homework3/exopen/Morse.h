
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
	void buffer(string morse, string& text);//morse 신호를 공백단위로 읽어들인다
	void morseToText(string buffer, string& text);//buffer가 읽어들인 1글자의 morse부호를 문자로 변환

};

#endif //MORSE_H