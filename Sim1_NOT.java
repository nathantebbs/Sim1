/* Simulates a physical NOT gate.
 *
 * Author: Nathan Tebbs 
 */

public class Sim1_NOT
{
	public void execute()
	{
		out.set(!in.get());
	}



	public RussWire in;    // input
	public RussWire out;   // output

	public Sim1_NOT()
	{
		in = new RussWire();
		out = new RussWire();
	}

	public static void main(String[] args) {
		Sim1_NOT p = new Sim1_NOT();
		p.in.set(true);
		System.out.println(p.in.get());
	}
}

