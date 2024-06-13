/* Simulates a physical OR gate.
 *
 * Author: Nathan Tebbs
 */

public class Sim1_OR
{
	public void execute()
	{
		boolean input1 = a.get();
		boolean input2 = b.get();
		out.set(input1 || input2);
	}



	public RussWire a,b;   // inputs
	public RussWire out;   // output

	public Sim1_OR()
	{
		a = new RussWire();
		b = new RussWire();
		out = new RussWire();
	}
}

