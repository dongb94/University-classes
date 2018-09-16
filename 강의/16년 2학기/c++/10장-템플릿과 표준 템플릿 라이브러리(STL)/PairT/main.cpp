//10장 템플릿 예제
#include <iostream>
#include <string>
using namespace std;

#include "Pair.h"

int main() {
	Pair<int> p(123, 456);
	Pair<string> q("hello", "world");

	p.setFirst(789);
	cout << p.getFirst() + p.getSecond() << endl;

	q.setSecond(" world");
	cout << q.getFirst() + q.getSecond() << endl;

}