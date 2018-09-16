// TableBak.cpp
#include <string>
using namespace std;

#include "Table.h"
#include "TableBak.h"

TableBak::TableBak() : Table() {
	psz = 10;
	pbak = new string[psz];
}
TableBak::TableBak(const TableBak& tbak) : Table(tbak) { 
	psz = tbak.psz;
	pbak = new string[psz];
	for(int i =0; i<psz;  i++) pbak[i] = tbak.pbak[i];
}

TableBak& TableBak::operator=(const TableBak& rhs){
	Table::operator=(rhs);
	if( this != &rhs ) {
		delete [] pbak;
		psz = rhs.psz;
		pbak = new string[psz];
		for(int i=0; i<psz; i++) pbak[i] = rhs.pbak[i];
	}
	return *this;
}

void TableBak::backup(){
	delete [] pbak;
	psz = sz;
	pbak = new string[psz];
	for(int i=0; i<psz; i++) pbak[i] = p[i];
}
void TableBak::restore(){
	delete [] p;
	sz = psz;
	p = new string[sz];
	for(int i=0; i<sz; i++) p[i] = pbak[i];
}

TableBak::~TableBak(){
	// ºÒÇÊ¿ä: Table::~Table();
	delete [] pbak;
}