// Pair.h
#ifndef PAIR_H
#define PAIR_H

template <class T>
class Pair {
	T first;
	T second;
public:
	Pair();
	Pair(T first, T second);
	T getFirst();
	T getSecond();
	void setFirst(T first);
	void setSecond(T second);
};

template <class T>
Pair<T>::Pair() { }

template <class T>
Pair<T>::Pair(T f, T s) { first = f; second = s;}

template <class T>
T Pair<T>::getFirst() { return first; }

template <class T>
T Pair<T>::getSecond() { return second; }

template <class T>
void Pair<T>::setFirst(T f) { first = f; }

template <class T>
void Pair<T>::setSecond(T s) { second = s ;}




#endif PAIR_H