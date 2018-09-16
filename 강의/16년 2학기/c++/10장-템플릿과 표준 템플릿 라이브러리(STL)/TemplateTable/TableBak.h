//TableBak.h
#include <string>
using namespace std;
#include "Table.h"

template <class T>
class TableBak : public Table<T> {
	T* pbak;
	int psz;
public:
	TableBak();
	TableBak(const TableBak<T>& tbak);
	TableBak<T>& operator=(const TableBak<T>& rhs);
	void backup();
	void restore();
	virtual ~TableBak();
};

template <class T>
TableBak<T>::TableBak() : Table<T>() {
	psz = 10;
	pbak = new T[psz];
}

template <class T>
TableBak<T>::TableBak(const TableBak<T>& tbak)
	: Table<T>(tbak) { 
	psz = tbak.psz;
	pbak = new T[psz];
	for(int i =0; i<psz;  i++) 
		pbak[i] = tbak.pbak[i];
}

template <class T>
TableBak<T>& TableBak<T>::operator=(const TableBak<T>& rhs){
	Table<T>::operator=(rhs);
	if( this != &rhs ) {
		delete [] pbak;
		psz = rhs.psz;
		pbak = new T[psz];
		for(int i=0; i<psz; i++) pbak[i] = rhs.pbak[i];
	}
	return *this;
}

template <class T>
void TableBak<T>::backup(){
	delete [] pbak;
	psz = sz;
	pbak = new T[psz];
	for(int i=0; i<psz; i++) pbak[i] = p[i];
}

template <class T>
void TableBak<T>::restore(){
	delete [] p;
	sz = psz;
	p = new T[sz];
	for(int i=0; i<sz; i++) p[i] = pbak[i];
}

template <class T>
TableBak<T>::~TableBak(){
	// ºÒÇÊ¿ä: Table::~Table();
	delete [] pbak;
}