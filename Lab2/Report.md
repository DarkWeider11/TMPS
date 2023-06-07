# Creational Design Patterns

### Object: TMPS
### Author: Golis Boris 

----

## Theory
Modelele de proiectare sunt soluții tipice la probleme comune în proiectarea software. Fiecare model este ca un plan pe care îl puteți personaliza pentru a rezolva o anumită problemă de design din codul dvs.

Modelele sunt un set de instrumente de soluții la probleme comune în proiectarea software. Ele definesc un limbaj comun care vă ajută echipa să comunice mai eficient.

Modelele de design diferă prin complexitatea lor, nivelul de detaliu și scara de aplicabilitate. În plus, ele pot fi clasificate în funcție de intenția lor și împărțite în trei grupuri

<b>Modele de design creațional</b>
Aceste modele de design sunt toate despre instanțierea clasei. Acest model poate fi împărțit în continuare în modele de creare a clasei și modele de creație a obiectelor. În timp ce modelele de creare a clasei folosesc moștenirea în mod eficient în procesul de instanțiere, modelele de creare a obiectelor folosesc delegarea în mod eficient pentru a finaliza treaba.

* <b>Abstract Factory</b>
Creează o instanță a mai multor familii de clase

* <b>Builder</b>
Separă construcția obiectului de reprezentarea acestuia
* <b>Factory Method</b>
Creează o instanță a mai multor clase derivate
* <b>Prototype</b>
 O instanță complet inițializată de copiat sau clonat
* <b>Singleton</b>
O clasă din care poate exista doar o singură instanță
## Objectives:

* Înțelegeți ce sunt modelele de design
* Ce tipuri de modele de design există
* Implementați 5 modele de design creațional
* Înțelegeți ce este abstracția


## Implementation description

* Singleton

Aici este foarte simplu. Trebuie să inițializam obiectul cu o valoare, de exemplu. Și după aceea creați o metodă care va verifica dacă instanța obiectului nostru este nulă. Dacă da, creați un nou obiect de acest tip.

```
    private static Singleton instance;
    public String value;

    public Singleton(String value) {
        this.value = value;
    }

    public static Singleton getInstance(String value) {
        if(instance == null) {
            synchronized (Singleton.class) {
                if(instance == null)
                    instance = new Singleton(value);
            }
        }
        return instance;
    }
```

* Factory Method

Am împărțit implementarea mea în 2 foldere. Produsul este despre crearea de obiecte de tip apartament sau vilă. Pentru asta avem o interfață casă în care declarăm o metodă constructHouse. Pentru simplitate, în clasa concreta „Apartment” am implementat acea metodă și pur și simplu am printat în consolă „Building apartment”.

```
public class Apartment implements House {
    @Override
    public void constructHouse() {
        System.out.println("Building apartment");
    }
}

```

În folderul creator, am creat și o interfață BaseHouse care va avea o metodă createHouse.
```
public interface BaseHouseFactory {
    House createHouse(String type);
}
```

Și la finalul creat „HouseFactory” (implementare concretă) care va avea o metodă și, în funcție de parametrul care ia, returnează obiectul respectiv.

```
public class HouseFactory implements BaseHouseFactory {
    @Override
    public House createHouse(String type) {
        House house;

        switch (type) {
            case "villa":
                house = new Villa();
                break;
            case "apartment":
                house = new Apartment();
                break;
            default:
                throw new IllegalArgumentException("No such house available");
        }
        house.constructHouse();
        return house;
    }
}
```

* Abstract Factory

Pentru simplitate, am creat uși și podele ale unei case. Sunt destul de asemănătoare. Mai întâi creează interfața (floor and door). După aceea, fac câteva implementări. În cazul meu, imprim doar ce fel de door sau floor este.

```
public class BlueDoor implements Door {
    @Override
    public void installingDoor() {
        System.out.println("You have installed blue door");
    }
}
```

S-a creat un alt folder „factories” care va avea o interfață HouseFactory și 2 metode au declarat că returnează obiectele Floor și Door. În implementarea concretă, doar returnează obiecte noi de aceste tipuri.

```
public class OneFloorGreen implements HouseFactory {
    @Override
    public Floor buildFloor() {
        return new OneFloor();
    }

    @Override
    public Door installDoor() {
        return new GreenDoor();
    }
}
```


Avem nevoie de încă o clasă pe care o vom inițializa cu obiectul HouseFactory care a fost creat mai devreme. Și în metoda de construire, executați metode pentru floor și door.

```
public class Construction {
    private Floor floor;
    private Door door;

    public Construction(HouseFactory factory) {
        floor = factory.buildFloor();
        door = factory.installDoor();
    }

    public void build() {
        floor.constructFloor();
        door.installingDoor();
    }
}
```

* Builder

Creați un obiect de casă cu parametrii de care aveți nevoie (structure, foundation) de exemplu și inițializați cu setari.

```
public class House {
    private String foundation;
    private String structure;
    private String roof;
    private boolean furnished;
    private boolean painted;

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public void setRoof(String roof) {
        this.roof = roof;
    }

    public void setFurnished(boolean furnished) {
        this.furnished = furnished;
    }

    public void setPainted(boolean painted) {
        this.painted = painted;
    }

    public void setFoundation(String foundation) {
        this.foundation = foundation;
    }

    @Override
    public String toString() {
        return "Foundation - " + foundation + "; Structure - "
                + structure + "; Roof - " + roof + "; Is Furnished? "
                + furnished + "; Is Painted? " + painted;
    }
}
```

Avem nevoie de o interfață care să aibă toate metodele de care vom avea nevoie și un obiect de casă;
```
public interface HouseBuilder {
    void buildFoundation();
    void buildStructure();
    void buildRoof();
    void paintHouse();
    void furnishHouse();

    House getHouse();

}
```

Creați câte clase aveți nevoie din interfața HouseBuilder.

```
public class PrefabricatedHouseBuilder implements HouseBuilder {
    private House house;

    public PrefabricatedHouseBuilder() {
        this.house = new House();
    }

    @Override
    public void buildFoundation() {
        house.setFoundation("Building fundament and other parts of house");
        System.out.println("PrefabricatedHouseBuilder: Structure complete...");
    }

    @Override
    public void buildStructure() {
        house.setStructure("Structural steels and wooden wall panels");
        System.out.println("PrefabricatedHouseBuilder: Structure complete...");
    }

    @Override
    public void buildRoof() {
        house.setRoof("Roofing sheets");
        System.out.println("PrefabricatedHouseBuilder: Roof complete...");
    }

    @Override
    public void paintHouse() {
        this.house.setPainted(true);
        System.out.println("PrefabricatedHouseBuilder: Painting done...");
    }

    @Override
    public void furnishHouse() {
        this.house.setFurnished(true);
        System.out.println("PrefabricatedHouseBuilder: Furnishing complete...");
    }

    @Override
    public House getHouse() {
        System.out.println("PrefabricatedHouseBuilder: Prefabricated house complete...");
        return this.house;
    }
}
```

În clasa Construction vom avea în constructor un obiect concret HouseBuilder. Declarați o metodă care va returna un obiect casă. Înainte de a reveni, rulați metode din acel obiect HouseBuilder.

```
public class Construction {
    private HouseBuilder houseBuilder;

    public Construction(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public House constructHouse() {
        this.houseBuilder.buildFoundation();
        this.houseBuilder.buildRoof();
        this.houseBuilder.buildStructure();
        this.houseBuilder.paintHouse();
        this.houseBuilder.furnishHouse();
        return this.houseBuilder.getHouse();
    }
}
```

* Prototype

Creați o clasă abstractă cu id,type field, and buld method. Creați o clonă a metodei care va analiza clasa părinte și va încerca să cloneze, altfel excepția nu este acceptată.

```
public abstract class Construction implements Cloneable {

    private String id;
    protected String type;

    abstract void build();

    public String getType() {
        return this.type;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object clone() {
        Object clone = null;

        try {
            clone = super.clone();
        }

        catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clone;
    }

}
```

Creați metoda concretă apartment sau house și, pentru simplitate în metoda de construire, imprimați un mesaj pe consolă și setați tipul la „apartment” sau „house” în funcție de clasa creată.

```

public class Apartment extends Construction {
    public Apartment() {
        type = "apartemnt";
    }

    @Override
    public void build() {
        System.out.println("Inside Apartemnt: build() method");
    }
}
```

În clasa principală vom face o hartă hash care va stoca obiectele noastre. Ar trebui să avem o metodă care să ia id-ul unui obiect și să returneze acest obiect. Și o altă metodă prin care ne creăm și ne punem obiectele.

```
public class ConstructionCache {

    private static Map<String, Construction> constructionMap = new HashMap<>();

    public static Construction getConstruction(String constructionId) {
        Construction cachedConstruction = constructionMap.get(constructionId);
        return  cachedConstruction;
    }

    public static void loadCache() {
        Apartment apartment = new Apartment();
        apartment.setId("1");
        constructionMap.put(apartment.getId(), apartment);

        House house = new House();
        house.setId("2");
        constructionMap.put(house.getId(), house);
    }
}
```

## Conclusions
În concluzie, am înțeles cum funcționează modelele de design creațional, am învățat cum să le implementăm, care este diferența dintre ele, când să le folosim și care sunt beneficiile.