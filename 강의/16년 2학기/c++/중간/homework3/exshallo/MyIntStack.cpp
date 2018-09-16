
#include "MyIntStack.h"

MyIntStack::MyIntStack(){
	size=10;
	tos=-1;
	p=new int[size];
}
MyIntStack::MyIntStack(int size){
	MyIntStack::size=size;
	tos=-1;
	p=new int[size];//MyIntStack::size�� �ƴ϶� int size�� ������ �������
}
MyIntStack::MyIntStack(MyIntStack& s){
	size=s.size;
	tos=s.tos;
	p=s.p;
}

MyIntStack::~MyIntStack(){

}

bool MyIntStack::push(int n){
	if(tos<size-1){
		tos++;
		p[tos]=n;
	}else
		return false;
	return true;
}

bool MyIntStack::pop(int &n){
	if(tos>-1){
		n=p[tos];
		tos--;
	}else
		return false;
	return true;
}