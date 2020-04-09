package fp.tutelab1.exercise;

import java.util.Scanner;

// Topic 1 tutelab exercise written by Caspar
// this code lacks cohesion and encapsulation and is a prime example of how NOT to write code that is readable/reusable/extensible!
// i.e. it is poor quality code ;)
//
// TODO: fix it by extracting methods and choosing appropriate use of local variables and parameters
//       consider the use of static variables as well and use printf where appropriate
//
// Ohm's law V=IR .. https://en.wikipedia.org/wiki/Ohm%27s_law
public class TuteLab01
{
//   static double volts[];
//   static double amps[];
//   static double resistance[];
   static Scanner scanner = new Scanner(System.in);
   static double v;
   static double i;
   static double r;
   static boolean doAgain;
   static double vavg;
   static double vmax;
   static double vmin;
   static double iavg;
   static double imax;
   static double imin;
   static double ravg;
   static double rmax;
   static double rmin;
   
   private static final int NUM_INPUTS = 3;
   // message for intputting information
   
   private static String enterMessage(String kind, String subKind)
   {
	String message = "Enter " + kind +  " in " + subKind + ":";
	return message;
	   
   }   
   // calcs averarge of array of doubles
   private static double calcAverage(double[] myarray) {
	double calcAvg = (myarray[0] + myarray[1] + myarray[2]) / 3;
	 return calcAvg;
   }
   // calcs max for array of doubles
   private static double calcMax(double[] myarray) {
	double calcMax = Math.max(Math.max(myarray[0], myarray[1]), myarray[2]);
	 return calcMax;
   }
   // calcs mins for array of doubles
   private static double calcMin(double[] myarray) {
	double calcMin = Math.min(Math.max(myarray[0], myarray[1]), myarray[2]);
	 return calcMin;
   }
   public static String toString(double avg, double max, double min, String kind) {
	   String message = (kind + "  .. Avg=" + avg + ", Max=" + max + ", Min=" + min);
	return message;
	   
   }

   

   public static void main(String[] args)
   {
	  double volts[] = new double[NUM_INPUTS];
	  double amps[] = new double[NUM_INPUTS];
	  double resistance[] = new double[NUM_INPUTS];

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
               System.out.print(enterMessage("Voltage", "volts"));
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
//               System.out.print("Enter Current (I) in amperes: ");
               System.out.print(enterMessage("Current", "amperes"));
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

      vavg = calcAverage(volts);
      vmax = calcMax(volts);
      vmin = calcMin(volts);
      
      System.out.println(toString(vavg, vmax, vmin, "Volts"));

      iavg = calcAverage(amps);
      imax = calcMax(amps);
      imin = calcMin(amps);

      System.out.println(toString(iavg, imax, imin, "Amperes"));

      ravg = calcAverage(resistance);
      rmax = calcMax(resistance);
      rmin = calcMin(resistance);  

      System.out.println(toString(ravg, rmax, rmin, "resistance"));
   }
}
