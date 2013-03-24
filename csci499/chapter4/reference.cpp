#include <iostream>

void refParamFunction(int & x) {
	x = 10;
}

int main() {
	int number = 5;
	
	std::cout << "Before Function: " << number << std::endl;	

	refParamFunction(number);

	std::cout << "After Function: " << number << std::endl;

	return 0;

}
