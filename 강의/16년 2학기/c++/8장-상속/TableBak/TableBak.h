//TableBak.h
#include <string>
using namespace std;
#include "Table.h"

class TableBak : public Table {
	string* pbak;
	int psz;
public:
	TableBak();
	TableBak(const TableBak& tbak);
	TableBak& operator=(const TableBak& rhs);
	void backup();
	void restore();
	~TableBak();
};