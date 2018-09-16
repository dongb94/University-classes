// Table.h
#ifndef TABLE_H
#define TABLE_H

#include <string>
using namespace std;

class Table {
protected:
	string* p; // ���ڿ� �迭
	int sz; // ũ��
public:
	Table();
	Table(const Table& tbl);
	Table& operator=(const Table& rhs);
	string& operator[](int index);
	~Table();
};

#endif