package builderDp;
interface HousePlan 
{ 
    public void setBasement(String basement); 

    public void setRoof(String roof); 
  
    public void setInterior(String interior); 
} 
  
class House implements HousePlan 
{ 
  
    private String basement; 
    private String roof; 
    private String interior; 
  
    public void setBasement(String basement)  
    { 
        this.basement = basement; 
        System.out.println("setting up the basement: "+ basement);
    } 
  
  
    public void setRoof(String roof)  
    { 
        this.roof = roof; 
        System.out.println("finishing up the roof: "+roof);
    } 
  
    public void setInterior(String interior)  
    { 
        this.interior = interior; 
        System.out.println("working on interiors: "+interior);
    } 
  
} 
  
  
interface HouseBuilder 
{ 
  
    public void buildBasement();
  
    public void bulidRoof(); 
  
    public void buildInterior(); 
  
    public House getHouse(); 
} 
  
class IglooHouseBuilder implements HouseBuilder 
{ 
    private House house; 
  
    public IglooHouseBuilder()  
    { 
        this.house = new House(); 
    } 
  
    public void buildBasement()  
    { 
        house.setBasement("Ice bars"); 
    } 
  
    public void buildInterior()  
    { 
        house.setInterior("carved sheets of ice"); 
    } 
  
    public void bulidRoof()  
    { 
        house.setRoof("dome of ice"); 
    } 
  
    public House getHouse()  
    { 
        return this.house; 
    } 
} 
  
class TipiHouseBuilder implements HouseBuilder 
{ 
    private House house; 
  
    public TipiHouseBuilder()  
    { 
        this.house = new House(); 
    } 
  
    public void buildBasement()  
    { 
        house.setBasement("wood basement"); 
    } 
  
    public void buildInterior()  
    { 
        house.setInterior("teek wood"); 
    } 
  
    public void bulidRoof()  
    { 
        house.setRoof("special teek wood for cool roof"); 
    } 
  
    public House getHouse()  
    { 
        return this.house; 
    } 
  
} 
  
class CivilEngineer  
{ 
  
    private HouseBuilder houseBuilder; 
  
    public CivilEngineer(HouseBuilder houseBuilder) 
    { 
        this.houseBuilder = houseBuilder; 
    } 
  
    public House getHouse() 
    { 
        return this.houseBuilder.getHouse(); 
    } 
  
    public void constructHouse() 
    { 
        this.houseBuilder.buildBasement();  
        this.houseBuilder.bulidRoof(); 
        this.houseBuilder.buildInterior(); 
    } 
} 
  
public class Builder 
{ 
    public static void main(String[] args) 
    { 
    	System.out.println("getting a request for igloo house... working on it");
        HouseBuilder iglooBuilder = new IglooHouseBuilder(); 
        CivilEngineer engineer = new CivilEngineer(iglooBuilder); 
  
        engineer.constructHouse(); 
  System.out.println("IGLOO house is ready now\n\n");
  System.out.println("getting a request for wood house... working on it");
  HouseBuilder woodBuilder = new TipiHouseBuilder(); 
  CivilEngineer engineer2 = new CivilEngineer(woodBuilder); 

  engineer2.constructHouse(); 
System.out.println("tipi house is ready now");
    } 
} 