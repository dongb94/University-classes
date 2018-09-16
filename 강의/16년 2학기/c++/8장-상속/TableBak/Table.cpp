// Table.cpp
#include <string>
using namespace std;

#include "Table.h"

Table::Table() {
	sz = 10;
	p = new string[sz];
}

Table::Table(const Table& tbl) {
	sz = tbl.sz;
	p = new string[sz];
	for(int i=0; i<sz; i++) p[i] = tbl.p[i];
}

Table& Table::operator=(const Table& rhs) {
	if(this != &rhs) {
		delete [] p;
		sz = rhs.sz;
		p = new string[sz];
		for(int i=0; i<sz; i++) p[i] = rhs.p[i];
	}
	return *this;
}

string& Table::operator[](int index) {
	return p[index];
}

Table::~Table(){
	delete [] p;
}