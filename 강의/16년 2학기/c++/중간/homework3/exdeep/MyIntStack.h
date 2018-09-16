#ifndef MYINTSTACK_H
#define MYINTSTACK_H

class MyIntStack{
	int *p;
	int size;
	int tos;
public:
	MyIntStack();
	MyIntStack(int size);
	MyIntStack(MyIntStack& s);
	~MyIntStack();
	bool push(int n);
	
	bool pop(int &n);

};
#endif //MYINTSTACK_H