package hep.aida.jfree.function;

import hep.aida.IFunction;

import org.jfree.data.function.Function2D;


/**
 * @author Jeremy McCormick <jeremym@slac.stanford.edu>
 */
public class Function2DAdapter implements Function2D {

    IFunction function;
    
    public Function2DAdapter(IFunction function) {
        this.function = function;
    }
        
    public double getValue(double x) {
        return function.value(new double[] {x});
    }    
}
