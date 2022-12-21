import java.util.*;

class Planet {
    String pName;
    int moons;
    boolean rings;
    List<String> gasLst = new ArrayList<>();

    Planet(String name, int moons, boolean rings) {
        this.pName = name;
        this.moons = moons;
        this.rings = rings;
    }

    public void gas(String gasName) {
        gasLst.add(gasName);
    }
}

public class PlanetaryData2 {
    public static void main(String[] args) {
        
        List<Planet> pLst = new ArrayList<Planet>();
        Planet p1=new Planet("Mercury", 0, false);
        Planet p2=new Planet("Venus", 0, false);
        p2.gas("CarbonDioxide");
        p2.gas("Nitrogen");
        Planet p3=new Planet("Earth", 1, false);
        p3.gas("Nitrogen");
        p3.gas("Oxygen");
        Planet p4=new Planet("Jupitor", 79, true);
        p4.gas("Hydrogen");
        p4.gas("Helium");
        Planet p5=new Planet("Saturn", 83, true);
        p5.gas("Hydrogen");
        p5.gas("Helium");
        Planet p6=new Planet("Uranus", 27, true);
        p6.gas("Hydrogen");
        p6.gas("Helium");
        p6.gas("Methane");
        pLst.add(p1);
        pLst.add(p2);
        pLst.add(p3);
        pLst.add(p4);
        pLst.add(p5);
        pLst.add(p6);
        PlanetaryData2 plantInfo=new PlanetaryData2();
        plantInfo.printNumOfMoons(pLst);
        plantInfo.printGasName(pLst);
    }

    public void printNumOfMoons(List<Planet> pLst) {
        int cnt = 0;
        for (Planet p : pLst) {
            if (p.rings == true) {
                cnt += p.moons;
            }
        }
        System.out.println("Number of moons Planets which is having rings = " + cnt);
    }

    public void printGasName(List<Planet> pLst) {
        HashMap<String, Integer> mapOfGas = new HashMap<String, Integer>();
        List<String> maxGasLst=new ArrayList<>();
        for (Planet p : pLst) {
            for (int i = 0; i < p.gasLst.size(); i++) {
                mapOfGas.put(p.gasLst.get(i), mapOfGas.getOrDefault(p.gasLst.get(i), 0) + 1);
            }
        }
        int max = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> gasMp : mapOfGas.entrySet()) {
            max = Math.max(max, gasMp.getValue());
        }
        for (Map.Entry<String, Integer> gasMp : mapOfGas.entrySet()) {
            if(gasMp.getValue()==max){
                maxGasLst.add(gasMp.getKey());
            }
        }
        System.out.println("GAS name which is present in most of the planets \n " + maxGasLst);
    }
}

