#include <iostream>
#include "Morse.h"
using namespace std;

int main(void){
	Morse m;
	
	cout<<"�Ʒ��� ���� �ؽ�Ʈ�� �Է��ϼ���. �� ��ȣ�� �ٲߴϴ�."<<endl;
	
	string text, morse;
	
	getline(cin,text);

	m.textToMorse(text, morse);
	cout<<morse;

	cout<<"\n\n�𽺺�ȣ�� �ٽ� ���� �ؽ�Ʈ�� �ٲߴϴ�."<<endl;

	m.buffer(morse, text);
	cout<<text;

	return 0;
}
