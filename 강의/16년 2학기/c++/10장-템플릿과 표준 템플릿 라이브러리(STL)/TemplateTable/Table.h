// Table.h
#include <string>
using namespace std;

template <class T>
class Table {
protected:
	T* p; // 문자열 배열
	int sz; // 크기
public:
	Table();
	Table(const Table<T>& tbl);
	Table<T>& operator=(const Table<T>& rhs);
	T& operator[](int index);
	virtual ~Table();
};

template <class T>
Table<T>::Table() {
	sz = 10;
	p = new T[sz];
}

template <class T>
Table<T>::Table(const Table<T>& tbl) {
	sz = tbl.sz;
	p = new T[sz];
	for(int i=0; i<sz; i++) p[i] = tbl.p[i];
}

template <class T>
Table<T>& Table<T>::operator=(const Table<T>& rhs) {
	if(this != &rhs) {
		delete [] p;
		sz = rhs.sz;
		p = new T[sz];
		for(int i=0; i<sz; i++) p[i] = rhs.p[i];
	}
	return *this;
}

template <class T>
T& Table<T>::operator[](int index) {
	return p[index];
}

template <class T>
Table<T>::~Table(){
	delete [] p;
}