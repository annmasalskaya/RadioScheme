package RadioScheme;
import RadioScheme.RadioElements.*;

import java.math.BigDecimal;

public class RadioScheme
{
    private RadioElement[] radioElements;
    private  double frequency;
    private double voltage;
    InductanceCoil inductanceCoil;
    Condenser condenser;
    Resistor resistor;
    public RadioScheme()
    {
        radioElements= new RadioElement[3];
    }
    public void set( double resistance, double inductance, double capacity,  double frequency, double voltage)
    {
       this.frequency=frequency;
       this.voltage=voltage;
       condenser=new Condenser (capacity);
       resistor=new Resistor( resistance);
       inductanceCoil=new InductanceCoil(inductance);
       radioElements[0]=resistor;
       radioElements[1]=condenser;
       radioElements[2]=inductanceCoil;

    }
    public double averageVoltage()
    {
      return 2/Math.PI*voltage*1.41; // Iср=2/pi*Im, где Im- амплитудное значение
    }

    public void Impedance()
    {
        inductanceCoil.Impedance(frequency);
        condenser.Impedance(frequency);
        double substraction=inductanceCoil.getImpedance()-condenser.getImpedance();
        resistor.Impedance(substraction);

    }

    public void Voltage()
    {
       for(int i=0; i<3; i++)
       {
           radioElements[i].Voltage(voltage/(resistor.getImpedance()));
       }
    }
    public void Show()
    {
        for(int i=0; i<3; i++)
        {
            radioElements[i].showCharacteristics();
        }
    }
    public double shiftPhases() // угол сдвига фаз
    {
        return (int)Math.toDegrees(Math.atan((inductanceCoil.getImpedance()-condenser.getImpedance())/resistor.getResistance()));

    }
}
