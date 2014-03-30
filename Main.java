package RadioScheme;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main
{
     public static void main( String args[] )
     {

         RadioScheme scheme=new RadioScheme(4);
         try
         {
             int position=0;
             File file = new File("input.txt");
             Scanner scanner = new Scanner(file);
             while (scanner.hasNext())
             {
               switch((scanner.next()).charAt(0))
                {
                  case 'R' :
                      scheme.setResistance(Double.parseDouble(scanner.next()), position); break;
                  case 'L' :
                     scheme.setInductance(Double.parseDouble(scanner.next()),position) ; break;
                  case 'C' :
                     scheme.setCapacity(Double.parseDouble(scanner.next()), position);  break;
                }
                 position++;
             }
             scanner.close();
         }
          catch (FileNotFoundException e)
        {
            System.out.println("Файл не найден");
            System.exit(0);
        }

         scheme.set(200, 120); // устанавливаем частоту и подаём напряжение
         scheme.Impedance(); // сопротивление на каждом элементе
         scheme.Current(); // вычисляем ток
         scheme.Voltage(); // напряжение на каждом элементе
         scheme.Show();

         System.out.println("\nУгол сдвига фаз = " + scheme.shiftPhases());
         System.out.println("\nСреднее значение тока = " +(int)(scheme.averageCurrent()) + " А ");


     }

}
