package RadioScheme;
import RadioScheme.RadioElements.*;


public class RadioScheme
{
    private RadioElement[] radioElements;
    private  double frequency;
    private double voltage;
    private int size;
    public RadioScheme(int n)
    {
        size=n;
        radioElements= new RadioElement[size];
    }
    public void set(double frequency, double voltage)
    {
       this.frequency=frequency;
       this.voltage=voltage;

    }
    public void setResistance(double resistance,int position)
    {
        radioElements[position]=new Resistor(resistance);

    }

    public void setInductance(double inductance,int position)
    {
        radioElements[position]=new InductanceCoil(inductance);
    }
    public void setCapacity(double capacity,int position)
    {
        radioElements[position]=new Condenser(capacity);
    }
    ////////////////////////////////////////

     public double averageCurrent()
    {
       return 2/Math.PI*Current()*1.41; // Iср=2/pi*Im, где Im- амплитудное значение
    }
    public double fullResistance() // полное сопротивление
    {
       return Math.sqrt(Math.pow( commonResistance(), 2) + Math.pow( commonInducedImpedance()-commonCondencerImpedance(), 2));
    }

    public void Impedance()
    {
       for(int i=0; i<size; i++)
        {
           if(radioElements[i].name()!="R")
            radioElements[i].Impedance(frequency);
        }
    }

   public double Current()  // ток в в цепи
    {
       return voltage/ fullResistance();
    }
    public double commonResistance()
    {
        double commonResistance=0.0;
        for(int i=0; i<size; i++)
        {
            if(radioElements[i].name()=="R")
                commonResistance= commonResistance+radioElements[i].getImpedance();
        }

       return commonResistance;
    }
    public double commonInducedImpedance()
{
    double commonInducedImpedance=0.0;
    for(int i=0; i<size; i++)
    {
        if(radioElements[i].name()=="L")
            commonInducedImpedance=commonInducedImpedance+radioElements[i].getImpedance();
    }
    return commonInducedImpedance;
}
    public double commonCondencerImpedance()
    {
        double commonCondencerImpedance=0.0;
        for(int i=0; i<size; i++)
        {
            if(radioElements[i].name()=="C")
                commonCondencerImpedance=commonCondencerImpedance+1/radioElements[i].getImpedance();
        }
        return 1/commonCondencerImpedance;
    }
    public void Voltage()
    {
        double current=Current();
        for(int i=0; i<size; i++)
          radioElements[i].Voltage(current);
    }
    public void Show()
    {
          for(int i=0; i<size; i++)
          {
              System.out.print("\nЭлемент № :" + (i + 1));
              radioElements[i].showCharacteristics();
          }

    }
    public double shiftPhases() // угол сдвига фаз
    {
        return (int)Math.toDegrees(Math.atan((commonInducedImpedance()-commonCondencerImpedance())/commonResistance()));
    }
}
