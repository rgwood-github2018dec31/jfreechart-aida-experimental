package hep.aida.jfree.test;

import hep.aida.IHistogram1D;
import hep.aida.IPlotterStyle;
import hep.aida.jfree.plot.style.DefaultHistogram1DStyle;
import hep.aida.jfree.test.AbstractPlotTest;

import java.util.Random;

/**
 * @author Jeremy McCormick <jeremym@slac.stanford.edu>
 */
public class Histogram1DTest extends AbstractPlotTest {

    protected void plot() {

        // Create a simple histogram.
        IHistogram1D h1d = histogramFactory.createHistogram1D("h1d", 11, 0., 11.0);
        Random rand = new Random();
        for (int i = 0; i < 1000; i++) {
            int value = rand.nextInt(10);
            if (value % 2 == 0 || value == 3)
                h1d.fill(value);
        }

        h1d.annotation().addItem("xAxisLabel", h1d.title() + " X");
        h1d.annotation().addItem("yAxisLabel", h1d.title() + " Y");
        
        IPlotterStyle pstyle = new DefaultHistogram1DStyle();
        
        plotter.createRegions(1, 2, 0);
        
        plotter.region(0).plot(h1d, pstyle);
        
        pstyle.dataBoxStyle().backgroundStyle().setColor("gray");
        plotter.region(1).plot(h1d, pstyle);
    }
}

/*

old style stuff....

// data fill color
// pstyle.dataStyle().fillStyle().setColor("white");
pstyle.dataStyle().fillStyle().setVisible(false);

pstyle.dataStyle().outlineStyle().setVisible(true);
pstyle.dataStyle().outlineStyle().setColor("blue");
// pstyle.dataStyle().outlineStyle().setVisible(false);

pstyle.dataStyle().lineStyle().setVisible(false);

// title style
ITextStyle titleStyle = pstyle.titleStyle().textStyle();
titleStyle.setBold(true);
// titleStyle.setItalic(true);
titleStyle.setFontSize(30.);
titleStyle.setFont("Arial");
titleStyle.setColor("black");

// axis style
List<IAxisStyle> axes = new ArrayList<IAxisStyle>();
axes.add(pstyle.xAxisStyle());
axes.add(pstyle.yAxisStyle());
for (IAxisStyle axisStyle : axes) {
    axisStyle.labelStyle().setBold(true);
    // axisStyle.labelStyle().setItalic(true);
    axisStyle.labelStyle().setFont("Helvetica");
    axisStyle.labelStyle().setFontSize(15);
    axisStyle.labelStyle().setColor("black");
    axisStyle.lineStyle().setColor("black");
    axisStyle.lineStyle().setThickness(2);
    axisStyle.tickLabelStyle().setColor("black");
    axisStyle.tickLabelStyle().setFont("Helvetica");
    axisStyle.tickLabelStyle().setBold(true);
    axisStyle.tickLabelStyle().setFontSize(10);
}

// background color
pstyle.regionBoxStyle().backgroundStyle().setColor("white");

pstyle.gridStyle().setVisible(true);
*/