// Table.h
#ifndef TABLE_H
#define TABLE_H

#include <string>
using namespace std;

class Table {
protected:
	string* p; // 문자열 배열
	int sz; // 크기
public:
	Table();
	Table(const Table& tbl);
	Table& operator=(const Table& rhs);
	string& operator[](int index);
	~Table();
};

#endif