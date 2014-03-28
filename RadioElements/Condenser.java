package RadioScheme.RadioElements;
import java.math.BigDecimal;

public class Condenser extends RadioElement
{
    private double capacity;
    private double capacityImpedance;
    private double capacityVoltage;

    public Condenser (double capacity )
    {
        this. capacity= capacity;
    }

    public double Impedance(double frequency)  // Емкостное  сопротивление
    {
        capacityImpedance=1/(2*Math.PI *frequency*capacity);
        return capacityImpedance;
    }

    public double getImpedance()
    {
        return capacityImpedance;
    }

    public void Voltage(double voltage ) // напряжение на конденсаторе
    {
        capacityVoltage=voltage*capacityImpedance;
    }

     public void showCharacteristics()  // Емкостное  сопротивление
    {
        System.out.println("\n____Конденсатор___" );
        System.out.println("Емкостное сопротивление =  " +rounding(capacityImpedance) +"  Oм ");
        System.out.println("Напряжение на конденсаторе  =  " + rounding(capacityVoltage) + "  В ");
    }

}
