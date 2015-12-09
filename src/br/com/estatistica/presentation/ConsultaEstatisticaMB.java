package br.com.estatistica.presentation;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import br.com.estatistica.business.IManterResultadoService;
import br.com.estatistica.common.entity.Resultado;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;

@ManagedBean(eager = true)
@RequestScoped
public class ConsultaEstatisticaMB {
	
	private BarChartModel barModel;
	private HorizontalBarChartModel horizontalBarModel;
	
	private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
 
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Boys");
        boys.set("2004", 120);
        boys.set("2005", 100);
        boys.set("2006", 44);
        boys.set("2007", 150);
        boys.set("2008", 25);
 
        //ChartSeries girls = new ChartSeries();
        //girls.setLabel("Girls");
        //girls.set("2004", 52);
        //girls.set("2005", 60);
        //girls.set("2006", 110);
        //girls.set("2007", 135);
        //girls.set("2008", 120);
 
        model.addSeries(boys);
        //model.addSeries(girls);
         
        return model;
    }
     
    private void createBarModels() {
        createBarModel();
    }
     
    private void createBarModel() {
        barModel = initBarModel();
         
        barModel.setTitle("Bar Chart");
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Gender");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Births");
        yAxis.setMin(0);
        yAxis.setMax(200);
    }
     
	
	
	public BarChartModel getBarModel() {
		createBarModels();
		return barModel;
    }
}