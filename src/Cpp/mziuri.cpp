// 1. გადმოგვეცემა რაღაც სტრინგი და შევამოწმოთ არის თუ არა პალინდრომი.

// 2. გადმოგეცემა რაღაც რიცხვი, შეამოწმე არის თუ არა მარტივი.

// 3. გადმოგეცემა a-b შუალედი, დაბეჭდე ამ შუალედში ყველა მარტივი რიცხვი

// 4. გადმოგვეცემა ვექტორი, იპოვეთ ყველაზე გრძელი კლებადი მიმდევრობა


// Dato (Skeletona) - 1+,
// Finix - 1+, 2+,
// saba - 1+, 
// dato - 1+
// sopho - 1+, 2+, 3+

#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <vector>

using namespace std;

int main(){

	int n, k;
	vector<int> v(n, 0);
	for (int i=0; i<n; i++){
		cin >> v[i];
	}

	int yvelazeGrdzeli = 0;

	for (int i=0; i<n; i++){
		int axlandeli = 0;
		for (int j=i; j<n - 1; j++){
			if (v[j] < v[j+1]){
				axlandeli++;
			}else{
				if (axlandeli > yvelazeGrdzeli){
					yvelazeGrdzeli = axlandeli;
				}
				break;
			}
		}
	}

}