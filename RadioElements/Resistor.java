package RadioScheme.RadioElements;
import java.math.BigDecimal;

public class Resistor extends RadioElement
{
    private double resistance;
    private double resistanceImpedance;
    private double resistanceVoltage;

    public Resistor (double resistance )
    {
        this.resistance= resistance;

    }
    public double Impedance(double substraction)  // Полное сопротивление цепи
    {
        resistanceImpedance=Math.sqrt(substraction*substraction+ resistance*resistance) ;
        return  resistanceImpedance;
    }

    public void Voltage(double voltage )
    {
        resistanceVoltage=voltage*resistance;
    }

    public double getImpedance()
    {
        return  resistanceImpedance;
    }
    public double getResistance()
    {
        return  resistance;
    }

    public void showCharacteristics()
    {
        System.out.println("\n____Резистор___" );
        System.out.println("Полное сопротивление цепи =  " +rounding(resistanceImpedance) + "  Oм ");
        System.out.println("Напряжение на резисторе  =  " +rounding(resistanceVoltage) + "  В ");

    }

}
