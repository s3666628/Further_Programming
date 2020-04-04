package fp.tutelab1.exercise;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		{

			   public static void main(String[] args)
			   {
			      volts = new double[3];
			      amps = new double[3];
			      resistance = new double[3];

			      scanner = new Scanner(System.in);

			      System.out.println("Enter 3 pairs of V and I");

			      for (int count = 0; count < 3; count++)
			      {
			         doAgain = true;
			         double num = 0;

			         do
			         {
			            try
			            {
			               System.out.print("Enter Voltage (V) in volts: ");
			               // parseDouble() will "throw" an exception if a number is not
			               // entered. Execution then immediately moves to catch block
			               num = Double.parseDouble(scanner.nextLine());
			               doAgain = false;
			            }
			            catch (NumberFormatException nfe)
			            {
			               // we don't really need to do anything here since we will just loop and try again, but could.
			            }
			         }
			         while (doAgain == true);

			         v = num;
			         volts[count] = v;

			         doAgain = true;

			         do
			         {
			            try
			            {
			               System.out.print("Enter Current (I) in amperes: ");
			               // parseDouble() will "throw" an exception if a number is not
			               // entered. Execution then immediately moves to catch block
			               num = Double.parseDouble(scanner.nextLine());
			               doAgain = false;
			            }
			            catch (NumberFormatException nfe)
			            {
			               // we don't really need to do anything here since we will just loop and try again, but could.
			            }
			         }
			         while (doAgain == true);

			         i = num;
			         amps[count] = i;
			         r = v / i;
			         resistance[count] = r;

			         System.out.println("Resistance R is " + r + " ohms\n");
			      }

			      vavg = (volts[0] + volts[1] + volts[2]) / 3;
			      vmax = Math.max(Math.max(volts[0], volts[1]), volts[2]);
			      vmin = Math.min(Math.min(volts[0], volts[1]), volts[2]);

			      System.out.println("V (Volts) .. Avg=" + vavg + ", Max=" + vmax + ", Min=" + vmin);

			      iavg = (amps[0] + amps[1] + amps[2]) / 3;
			      imax = Math.max(Math.max(amps[0], amps[1]), amps[2]);
			      imin = Math.min(Math.min(amps[0], amps[1]), amps[2]);

			      System.out.println("I (Amperes) .. Avg=" + iavg + ", Max=" + imax + ", Min=" + imin);

			      ravg = (resistance[0] + resistance[1] + resistance[2]) / 3;
			      rmax = Math.max(Math.max(resistance[0], resistance[1]), resistance[2]);
			      rmin = Math.min(Math.min(resistance[0], resistance[1]), resistance[2]);

			      System.out.println("R (Ohms) .. Avg=" + ravg + ", Max=" + rmax + ", Min=" + rmin);
			   }
			}

	}

}
