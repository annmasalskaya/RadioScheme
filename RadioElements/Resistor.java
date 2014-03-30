package RadioScheme.RadioElements;


public class Resistor extends RadioElement
{
    private double resistance;
    //private double resistanceImpedance;
    private double resistanceVoltage;

    public Resistor (double resistance ) // сопротивление на резисторе
    {
        this.resistance= resistance;

    }
    public double Impedance(double value) // сопротивление на резисторе
    {
      return  resistance;
    }

    public void Voltage(double current)
    {
        resistanceVoltage=current*resistance;
    }

    public double getImpedance()
    {
        return  resistance;
    }
    public void showCharacteristics()
{
    System.out.println("\n____Резистор___" );
    System.out.println("Cопротивление на резисторе =  " +rounding(resistance) + "  Oм ");
    System.out.println("Напряжение на резисторе  =  " +rounding(resistanceVoltage) + "  В ");

}
    public String name()
    {
        return "R";
    }

}
