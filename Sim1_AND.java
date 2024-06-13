/* Simulates a physical AND gate.
 *
 * Author: Nathan Tebbs
 */

public class Sim1_AND
{
	public void execute()
	{
		boolean bit1 = a.get();
		boolean bit2 = b.get();
		boolean result = bit1 && bit2;
		out.set(result);
	}



	public RussWire a,b;   // inputs
	public RussWire out;   // output

	public Sim1_AND()
	{
		a = new RussWire();
		b = new RussWire();
		out = new RussWire();
	}
}

