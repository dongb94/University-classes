#include <iostream>
#include <string>
using namespace std;

#include "TableBak.h"

int main() {
	TableBak<string> tb1;
	TableBak<int> tb2;

	tb1[0] = "hello";
	tb1[1] = "world";
	tb1[2] = "!!!";

	tb1.backup();

	tb1[0] = "Chonnam";
	tb1[1] = "National";
	tb1[2] = "University";

	tb1.restore();

	tb2[0] = 123;
	tb2[1] = 456;
	tb2[2] = 789;

	tb2.backup();

	tb2[0] = 987;
	tb2[1] = 654;
	tb2[2] = 321;

	tb2.restore();



	return 0;
}