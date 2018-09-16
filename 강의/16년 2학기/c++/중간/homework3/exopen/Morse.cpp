#include "Morse.h"

Morse::Morse(){
	string a[26]={".- ","-... ","-.-. ","-.. ",". ","..-. ","--. ",".... ",".. ",".--- ","-.- ",".-.. ","-- ","-. ","--- ",".--. ","--.- ",".-. ","... ","- ","..- ","...- ",".-- ","-..- ","-.-- ", "--.. "};
	for(int i=0; i<26; i++)
		alphabet[i]=a[i];
	string d[10]={"----- ",".---- ","..--- ","...-- ","....- ","..... ","-.... ","--... ","---.. ","----. "};
	for(int i=0; i<10; i++)
		digit[i]=d[i];
	slash="-..-. ";
	question="..--.. ";
	comma="--..-- ";
	period=".-.-.- ";
	plus=".-.-. ";
	equal="-...- ";
}

void Morse::textToMorse(string text, string& morse){
	char c;
	morse="";
	for(int i=0; i<text.length(); i++){
		c=text[i];
		c=toupper(c);
		if((int)c>=65&&(int)c<91)
			morse+=alphabet[c-65];
		else if((int)c>=48&&(int)c<58)
			morse+=digit[c-48];
		else{
			switch(c){
			case '/':
				morse+=slash;
				break;
			case '?':
				morse+=question;
				break;
			case '.':
				morse+=comma;
				break;
			case ',':
				morse+=period;
				break;
			case '+':
				morse+=plus;
				break;
			case '=':
				morse+=equal;
				break;
			case ' ':
				morse+="  ";
				break;
			}
		}
	}
	return;
}

void Morse::buffer(string morse, string& text){
	char c='0';//임의의 문자로 초기화
	string buffer="";
	text="";
	for(int i=0; i<morse.length(); i++){
		c=morse[i];
		if(c!=' '){
			buffer+=c;
		}else if(morse[i-1]!=' '){
			buffer+=" ";
			morseToText(buffer,text);
			buffer="";
		}
		else{//연속으로 공백이 2개 나온경우 띄어쓰기로 간주하고 i를 1증가시켜 다음 공백을 넘긴다.
			text+=" ";
			i++;
		}
	}
	return;
}

void Morse::morseToText(string buffer, string& text){
	for(int i=0; i<26; i++)
		if(buffer==alphabet[i])
			text+=(char)(i+65);
	for(int i=0; i<10; i++)
		if(buffer==digit[i])
			text+=(char)(i+48);
	if(buffer==slash)
		text+="/";
	if(buffer==question)
		text+="?";
	if(buffer==comma)
		text+=".";
	if(buffer==period)
		text+=",";
	if(buffer==plus)
		text+="+";
	if(buffer==equal)
		text+="=";
	return;
}
