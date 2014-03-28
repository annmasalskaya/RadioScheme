package RadioScheme;


public class Main
{
     public static void main( String args[] )
     {
         RadioScheme scheme=new RadioScheme();
         scheme.set(4,0.00637,0.000159,200,120);

         scheme.Impedance();
         scheme.Voltage();
         scheme.Show();
         System.out.println("\nУгол сдвига фаз = " + scheme.shiftPhases());
         System.out.println("\nСреднее значение тока = " +(int)(scheme.averageVoltage()) + " А ");

     }

}
