package RadioScheme.RadioElements;

import java.math.BigDecimal;

public abstract class RadioElement
{
    public abstract double Impedance(double value); // расчёт сопротивления на всех участках цепи
    public abstract void Voltage(double value); // расчёт напряжения на всех участках цепи
    public abstract void showCharacteristics(); // вывод показаний на всех участках цепи
    public abstract double getImpedance();
    public abstract String name();

    public double rounding(double value)  // округляем  до сотых
    {
        BigDecimal x = new BigDecimal(value);
        x = x.setScale(2, BigDecimal.ROUND_HALF_UP);
        return x.doubleValue();

    }
}
