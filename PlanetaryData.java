import java.util.*;
class Planet{
    String pName;
    int moons;
    boolean rings;
    List<String> gas=new ArrayList<>();
    Planet(String name,int moons,boolean rings){
        this.pName=name;
        this.moons=moons;
        this.rings=rings;
    }
    public void gas(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of gases");
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.println("Enter Gas Name");
            gas.add(sc.next());
        }
    }
}
public class PlanetaryData {
    static List<Planet> pLst=new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter 1 to finish addding Planets\nEnter 0 to add Planet");
        int ch=sc.nextInt();
        do{
            System.out.println("Enter planet Name");
            String name=sc.next();
            System.out.println("Enter the number of moons");
            int moons=sc.nextInt();
            System.out.println("Enter True or False for Rings");
            boolean rings=sc.nextBoolean();
            Planet p=new Planet(name, moons, rings);
            p.gas();
            pLst.add(p);
            System.out.println("Enter 1 to finish addding Planets\nEnter 0 to add Planet");
            ch=sc.nextInt();
        }while(ch != 1);
        printNumOfMoons();
        printGasName();
    }
    public static void printNumOfMoons(){
        int cnt=0;
        for(Planet p: pLst){
            if(p.rings==true){
                cnt += p.moons;
            }
        }
        System.out.println("Number of moons Planets which is having rings = "+cnt);
    }

    public static void printGasName(){
        HashMap<String,Integer> mapOfGas=new HashMap<String,Integer>();
        for(Planet p:pLst){
            for(int i=0;i<p.gas.size();i++){
                mapOfGas.put(p.gas.get(i),mapOfGas.getOrDefault(p.gas.get(i), 0)+1);
            }
        }
        int max=Integer.MIN_VALUE;
        String gasName="";
        for(Map.Entry<String, Integer> gasMp: mapOfGas.entrySet()){
            max=Math.max(max,gasMp.getValue());
            if(max==gasMp.getValue()){
                gasName=gasMp.getKey();
            }
        }
        System.out.println("GAS name which is present in most of the planets = "+gasName);
    }
}
