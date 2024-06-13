/* Implementation of a 32-bit adder in C.
 *
 * Author: Nathan Tebbs
 */


#include "sim1.h"



void execute_add(Sim1Data *obj)
{
	int currentA = 0;
	int currentB = 0;
	int carry = 0;
	obj->sum = 0;
	int b = obj->b; 

	if (obj->isSubtraction) {
		b = ~b;
		int carry = 1;
		for (int i = 0; i < 32; i++) {
			int bit = (b >> i) & 0x1;
			b = (b & ~(1 << i)) | ((bit ^ carry) << i);
			carry &= bit;
		}
	}

	for (int i = 0; i < 32; i++) {
		currentA = (obj->a >> i) & 0x1;
		currentB = (b >> i) & 0x1;
		int sumBit = currentA ^ currentB ^ carry;
		carry = (currentA & currentB) | (carry & (currentA ^ currentB));


		if (sumBit & 0x1) {
			obj->sum |= (1 << i);
		} else {
			obj->sum &= ~(1 << i);
		}
	}


	obj->aNonNeg = !(obj->a & (1 << 31));
	obj->bNonNeg = !(obj->b & (1 << 31));
	obj->sumNonNeg = !(obj->sum & (1 << 31));
	obj->carryOut = carry;
	obj->overflow = ((obj->a ^ obj->sum) & (b ^ obj->sum) & (1 << 31)) != 0;

}

