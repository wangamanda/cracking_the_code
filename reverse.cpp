//implement a function void reverse(char* str) in
//C or C++ which reverses a null-terminated string

#include <iostream>

using namespace std;


void reverse(char* str)
{
	char* cur = str;
	int n = 0;
	while(*cur)
	{
		cur = cur++;
		n ++ ;
	}

	for (int i = 0 ; i < (n-1)/2 ; i ++ )
	{
		char tmp = str[i];
		str[i] = str[n-1-i];
		str[n-1-i] = tmp;
	}
}

int main(){
	char str[][10] = {{'a','b','c','d','e','f','g'},{'a','c','t'}};
	for (int i = 0 ; i < 2 ; i ++ ){
		cout << str[i] << endl;
		reverse(str[i]);
		cout << str[i] << endl;
	}
	return 0;
}
