/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatefulEjbClass.java to edit this template
 */
package tracker.ejb;

import jakarta.ejb.Stateful;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
@Stateful
public class TrackerBean implements TrackerBeanLocal {

    private double total = 0;
    private int count = 0;
    private List<Double> values = new ArrayList<>();
    private List<Double> evenValues = new ArrayList<>();
    private List<Double> oddValues = new ArrayList<>();

//    @Override
//    public double add(double value) {
//        total += value;
//        count += 1;
//        return total;
//    }

    @Override
    public double average() {
        return total / count;
    }
    
    @Override
    public double add(double value) {
        total += value;
        count += 1;
        values.add(value);

        // Memisahkan nilai genap dan ganjil
        if (value % 2 == 0) {
            evenValues.add(value);
        } else {
            oddValues.add(value);
        }

        return total;
    }
//    public void addData(Double a) {
//        evenValues.add(a);
//    }
//    
//    public String getData() {
//        return evenValues.toString();
//    }
//    
//    public void addData(Double a) {
//        oddValues.add(a);
//    }
//    
//    public String getData() {
//        return data.toString();
//    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public double getTotal() {
        return total;
    }
    
    public List<Double> getValues(){
        return values;
    }
    
    public List<Double> getEvenValues(){
        return evenValues;
    }
    
    public List<Double> getOddValues(){
        return oddValues;
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
