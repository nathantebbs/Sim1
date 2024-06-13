/* Simulates a physical device that performs 2's complement on a 32-bit input.
 *
 * Author: Nathan Tebbs
 */

public class Sim1_2sComplement
{
	public void execute()
	{
		for (int i = 0; i < 32; i++) {
			not[i].in.set(in[i].get());
			not[i].execute();
			negation[i].set(not[i].out.get());
		}


		for (int i = 0; i < 32; i++) {
			add.a[i].set(negation[i].get());
			add.b[i].set(theNumber1[i]);
		}

		add.execute();

		for (int i = 0; i < 32; i++) {
			out[i].set(add.sum[i].get());
		}
	}



	// you shouldn't change these standard variables...
	public RussWire[] in;
	public RussWire[] out;


		public Sim1_ADD add;
	public Sim1_NOT[] not;
	public RussWire[] negation;

	private boolean[] theNumber1 = {true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false};



	public Sim1_2sComplement()
	{
		in = new RussWire[32];
		out = new RussWire[32];
		not = new Sim1_NOT[32];
		negation = new RussWire[32];

		for (int i = 0; i < 32; i++) {
			in[i] = new RussWire();
			out[i] = new RussWire();
			not[i] = new Sim1_NOT();
			negation[i] = new RussWire();
		}

		add = new Sim1_ADD();
	}
}

