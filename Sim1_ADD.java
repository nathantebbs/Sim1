/* Simulates a physical device that performs (signed) addition on
 * a 32-bit input.
 *
 * Author: Nathan Tebbs
 */

public class Sim1_ADD
{
	public void execute()
	{
		boolean carry = false;
		boolean signA = a[31].get();
		boolean signB = b[31].get();
		boolean signSum;

		for (int i = 0; i < 32; i++) {
			boolean num1 = a[i].get();
			boolean num2 = b[i].get();
			if (!num1 && !num2 && !carry) {
				sum[i].set(false);
				carry = false;
			} else if ((num1 && !num2 && !carry) || !num1 && !num2 && carry || (!num1 && num2 && !carry)) {
				sum[i].set(true);
				carry = false;
			} else if ((num1 && !num2 && carry) || (num1 && num2 && !carry || ((!num1 && num2 && carry)))) {
				sum[i].set(false);
				carry = true;
			} else  { // 1 & 1 & 1
				sum[i].set(true);
				carry = true;
			}

		}

		carryOut.set(carry);
		signSum = sum[31].get();
		if ((signA == signB) && (signA != signSum)) {
			overflow.set(true);  // Overflow for same signs with different resulting sign
		} else if ((signA != signB) && (signA == signSum)) {
			overflow.set(true);  // Overflow for different signs with the same resulting sign
		} else {
			overflow.set(false);
		}	
	}
	// inputs
	public RussWire[] a,b;
	// outputs
	public RussWire[] sum;
	public RussWire   carryOut, overflow;
	public Sim1_ADD()
	{
		a   = new RussWire[32];
		b   = new RussWire[32];
		sum = new RussWire[32];
		for (int i=0; i<32; i++)
		{
			a  [i] = new RussWire();
			b  [i] = new RussWire();
			sum[i] = new RussWire();
		}
		carryOut = new RussWire();
		overflow = new RussWire();
	}
}

