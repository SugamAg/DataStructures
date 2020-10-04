package calculator;
import java.util.*;
/**
 * @author sugamagarwal
 */
public class DoubleCalc implements Operation<Double>{
    @Override
    public Double add(Double x, Double y) {
        return x + y;
    }

    @Override
    public Double subtract(Double x, Double y) {
        return x - y;
    }

    @Override
    public Double multiplly(Double x, Double y)
    {
        return x * y;
    }


}
