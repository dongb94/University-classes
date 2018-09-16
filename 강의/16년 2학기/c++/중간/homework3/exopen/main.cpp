#include <iostream>
#include "Morse.h"
using namespace std;

int main(void){
	Morse m;
	
	cout<<"아래에 영문 텍스트를 입력하세요. 모스 부호로 바꿉니다."<<endl;
	
	string text, morse;
	
	getline(cin,text);

	m.textToMorse(text, morse);
	cout<<morse;

	cout<<"\n\n모스부호를 다시 영문 텍스트로 바꿉니다."<<endl;

	m.buffer(morse, text);
	cout<<text;

	return 0;
}
