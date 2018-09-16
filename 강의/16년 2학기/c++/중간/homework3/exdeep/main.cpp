#include <iostream>
using namespace std;
#include "MyIntStack.h"

void stackCopy(MyIntStack a){
	int n;
	MyIntStack c(a);
	c.pop(n);
	cout<<"스텍 c에서 팝한 값 "<< n <<endl;
	c.push(40);
	c.push(50);
}

int main() {
	MyIntStack a(5);
	a.push(10);
	a.push(20);

	MyIntStack b=a;
	b.push(30);


	int n;
	a.pop(n);
	cout<<"스택 a에서 팝한 값 "<< n << endl;
	b.pop(n);
	cout<<"스택 b에서 팝한 값 "<< n << endl;
	
	stackCopy(a);

	a.pop(n);
	cout<<"스택 a에서 팝한 값 "<< n << endl;
	b.pop(n);
	cout<<"스택 b에서 팝한 값 "<< n << endl;
}

