package RadioScheme.RadioElements;
import java.math.BigDecimal;

public class InductanceCoil extends RadioElement
{
    private double inductance;
    private double inducedImpedance;
    private double inducedVoltage;

    public InductanceCoil (double inductance )
    {
       this.inductance=inductance;
    }

    public double Impedance(double frequency) // Индуктивное сопротивление
    {
         inducedImpedance=2*Math.PI *frequency*inductance;
         return inducedImpedance;
    }

    public double getImpedance()
    {
       return inducedImpedance;
    }

    public void Voltage(double voltage ) // напряжение на катушке индуктивности
    {
        inducedVoltage=voltage*inducedImpedance;
    }

    public void showCharacteristics()
    {
        System.out.println("\n____Катушка индуктивности___" );
        System.out.println("Индуктивное сопротивление =  " + rounding(inducedImpedance) + "  Oм ");
        System.out.println("Напряжение на катушке индуктивности =  " + rounding(inducedVoltage) + "  В ");
     }



}
