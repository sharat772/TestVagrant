import java.util.*;
//Without Takking user input 
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
    //creating a method to add gas
    public void gas(String gasName) {
        gasLst.add(gasName);
    }
}

public class PlanetaryDataS {
    public static void main(String[] args) {
        List<Planet> pLst = new ArrayList<Planet>();
        //Creating planet Objects and ading Informations
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
        //adding planets to List
        pLst.add(p1);
        pLst.add(p2);
        pLst.add(p3);
        pLst.add(p4);
        pLst.add(p5);
        pLst.add(p6);
        //Creating Main class Object to pass list into the methods
        PlanetaryDataS plantInfo=new PlanetaryDataS();
        //calling Moons count method
        plantInfo.printNumOfMoons(pLst);
        //calling gas find and print method
        plantInfo.printGasName(pLst);
    }

    public void printNumOfMoons(List<Planet> pLst) {
        int cnt = 0;
        //itterating eash planets in for eash loop
        for (Planet p : pLst) {
            if (p.rings == true) {
                cnt += p.moons;
            }
        }
        System.out.println("Number of moons Planets which is having rings = " + cnt);
    }

    public void printGasName(List<Planet> pLst) {
        //creating map to findout appearance of gases
        HashMap<String, Integer> mapOfGas = new HashMap<String, Integer>();
        //Creating a list to store the gases having same count (if 2 or more gases present in same number of planets)
        List<String> maxGasLst=new ArrayList<>();
        //itterating eash planets in for eash loop
        for (Planet p : pLst) {
            //ittraring gasList
            for (int i = 0; i < p.gasLst.size(); i++) {
                //adding gas to the Map with count 
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
