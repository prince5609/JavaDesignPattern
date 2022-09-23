package org.example.FactoryPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

abstract class Plan {
    protected double rate;
    abstract void getRate();

    public void calculateBill(int units){
        System.out.println((rate * units) + 250);
    }
}

class DomesticPlan extends Plan{
    @Override
    public void getRate(){
        rate = 3.50;
    }
}

class CommercialPlan extends  Plan{
    @Override
    public void getRate() {
        rate = 7.5;
    }
}

class InstitutionalPlan extends Plan{
    @Override
    public void getRate() {
        rate = 10.5;
    }
}

class GetPlanFactory{
    public Plan getPlan(String planType) {
        if (planType == null) {
            return null;
        }
        if (planType.equalsIgnoreCase("DomesticPlan")) {
            return new DomesticPlan();
        } else if (planType.equalsIgnoreCase("CommercialPlan")) {
            return new CommercialPlan();
        } else if (planType.equalsIgnoreCase("InstitutionalPlan")) {
            return new InstitutionalPlan();
        }
        return null;
    }
}

class GenerateBill{
    public static void main(String [] args)throws IOException{
        GetPlanFactory planFactory = new GetPlanFactory();
        System.out.println("Enter The Name Of Your Plan: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String planName = br.readLine();

        System.out.println("Enter The No Of Units You Have Consumes:");
        int units = Integer.parseInt(br.readLine());

        Plan p = planFactory.getPlan(planName);

        System.out.println("Bill Amount For " + planName + " of " + units + " units is ");
        p.getRate();
        p.calculateBill(units);
    }
}

