# Stuctural Design Patterns

### Object: TMPS
### Author: Golis Boris

----

## Theory
Modelele de proiectare sunt soluții tipice la probleme comune în proiectarea software. Fiecare model este ca un plan pe care îl puteți personaliza pentru a rezolva o anumită problemă de design din codul dvs.

Modelele sunt un set de instrumente de soluții la probleme comune în proiectarea software. Ele definesc un limbaj comun care vă ajută echipa să comunice mai eficient.

Modelele de design diferă prin complexitatea lor, nivelul de detaliu și scara de aplicabilitate. În plus, ele pot fi clasificate în funcție de intenția lor și împărțite în trei grupuri

<b>Structural Design Patterns</b>
Modelele de proiectare structurală sunt preocupate de modul în care clasele și obiectele pot fi compuse, pentru a forma structuri mai mari. Modelele de proiectare structurală simplifică structura prin identificarea relațiilor. Aceste modele se concentrează asupra modului în care clasele moștenesc unele de la altele și cum sunt compuse din alte clase.

* <b>Adapter</b>
  Adapter este un model de design structural care permite obiectelor cu interfețe incompatibile să colaboreze.
* <b>Bridge</b>
  Bridge este un model de proiectare structurală care vă permite să împărțiți o clasă mare sau un set de clase strâns legate în două ierarhii separate - abstracție și implementare - care pot fi dezvoltate independent una de cealaltă.
* <b>Decorator</b>
  Decorator este un model de design structural care vă permite să atașați noi comportamente la obiecte prin plasarea acestor obiecte în interiorul obiectelor speciale de ambalare care conțin comportamentele.
* <b>Facade</b>
  Facade este un model de proiectare structurală care oferă o interfață simplificată unei biblioteci, unui cadru sau oricărui alt set complex de clase.
* <b>Flyweight</b>
  Flyweight este un model de design structural care vă permite să încadrați mai multe obiecte în cantitatea disponibilă de RAM, partajând părți comune de stare între mai multe obiecte, în loc să păstrați toate datele în fiecare obiect.
## Objectives:

* Studiați și înțelegeți modelele de proiectare structurală.
* Ca o continuare a lucrărilor anterioare de laborator, gândiți-vă la funcționalitățile pe care sistemul dumneavoastră va trebui să le ofere utilizatorului.
* Implementați câteva funcționalități suplimentare folosind modele de proiectare structurală.


## Implementation description

* Decorator

Aici este foarte simplu. Trebuie în primul rând să facem o interfață cu unele clase. După aceea, faceți niște clase care implementează această interfață.

```
   public class SupportReport implements Report {

    @Override
    public Object[][] getReportData(String reportId) {
        return null;
    }

    @Override
    public String getFirstColumnData() {
        return "Support data";
    }

}
```

Acum trebuie să creăm o altă clasă (abstract). În această clasă trebuie să folosim metoda interfeței private pe care am creat-o mai devreme. Și în metodele acestei clase folosim atributele interfeței.

```
public abstract class ColumDecorator implements Report {
    private Report decoratedReport;

    public ColumDecorator(Report report){
        this.decoratedReport = report;
    }

    public String getFirstColumnData() {
        return decoratedReport.getFirstColumnData();
    }

    @Override
    public Object[][] getReportData(String reportId) {
        return decoratedReport.getReportData(reportId);
    }
}
```

Și pentru simplitate adăugați încă o clasă care extinde clasa abstractă anterioară.
```
public class SupportLinkDecorator extends ColumDecorator{

    public SupportLinkDecorator(Report report) {
        super(report);
    }

    public String getFirstColumnData() {
        return addMoreInfo (super.getFirstColumnData()) ;
    }

    private String addMoreInfo(String data){
        return data  + " - support link - ";
    }
}
```
* Facade

Creați o interfață care va avea de exemplu 2 metode. Acum facem o implementare concretă de clasă a acestei interfețe.


```
public class Iphone implements IMobileShop {
    @Override
    public void getMobileModelNumber() {
        System.out.println("The model is: IPhone 13");
    }

    @Override
    public void getMobilePrice() {
        System.out.println("The price is: 200 USD ");
    }
}

```

Și în funcția principală (ShopKeeper) constructorul declară 2 implementări concrete private a interfeței anterioare. Acum implementați metoda pentru fiecare clasă.
```
public class ShopKeeper {
    private IMobileShop iphone;
    private IMobileShop samsung;

    public ShopKeeper() {
        iphone = new Iphone();
        samsung = new Samsung();
    }

    public void iphonePhoneSale() {
        iphone.getMobileModelNumber();
        iphone.getMobilePrice();
    }

    public void samsungPhoneSale() {
        samsung.getMobileModelNumber();
        samsung.getMobilePrice();
    }
}

```

* Flyweight

Ca de obicei, faceți o interfață cu unele metode. Implementați o clasă concretă a acestei interfețe.

```
public class MediumPen implements Pen {

    final BrushSize brushSize = BrushSize.MEDIUM;
    private String color = null;

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void draw(String content) {
        System.out.println("Drawing MEDIUM content in color : " + color);
    }
}
```

Acum în PenFactory avem un hashmap. Creați o funcție pentru fiecare dimensiune de stilou (medium,thick) Setați culoarea și puneți în hashmap acest obiect.

```
public class PenFactory
{
    private static final HashMap<String, Pen> pensMap = new HashMap<>();
    public static Pen getThickPen(String color) {
        String key = color + "-THICK";
        Pen pen = pensMap.get(key);
        if(pen != null) {
            return pen;
        } else {
            pen = new ThickPen();
            pen.setColor(color);
            pensMap.put(key, pen);
        }
        return pen;
    }
    public static Pen getThinPen(String color) {
        String key = color + "-THIN";
        Pen pen = pensMap.get(key);
        if(pen != null) {
            return pen;
        } else {
            pen = new ThinPen();
            pen.setColor(color);
            pensMap.put(key, pen);
        }
        return pen;
    }

    public static Pen getMediumPen(String color) {
        String key = color + "-MEDIUM";
        Pen pen = pensMap.get(key);

        if(pen != null) {
            return pen;
        } else {
            pen = new MediumPen();
            pen.setColor(color);
            pensMap.put(key, pen);
        }
        return pen;
    }
}

```



* Adapter

Faceți o interfață cu o funcție. Faceți o clasă concretă cu funcție implementată din interfață. De asemenea, am adăugat o metodă suplimentară.

```
public class MediaAdapter implements MediaPlayer {

    public static final String VLC = "vlc";
    public static final String MP_4 = "mp4";

    private AdvancedMediaPlayer advancedMusicPlayer;
    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase(VLC)) {
            advancedMusicPlayer = new VLCMusicPlayer();
        } else if (audioType.equalsIgnoreCase(MP_4)) {
            advancedMusicPlayer = new MP4MusicPlayer();
        }
    }

    @Override
    public void playMusic(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase(VLC)) {
            advancedMusicPlayer.playVlcPlayer(fileName);
        } else if (audioType.equalsIgnoreCase(MP_4)) {
            advancedMusicPlayer.playMp4Player(fileName);
        }
    }
}

```

În clasa principală implementăm acea clasă.
```
public class Main {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.playMusic("mp3", "song1.mp3");
        audioPlayer.playMusic("mp4", "song2.mp4");
        audioPlayer.playMusic("vlc", "song3.vlc");
        audioPlayer.playMusic("xyz", "song4.avi");
    }
}
```


* Bridge

Acum creăm o interfață simplă cu 3 funcții.

```
public interface Device {
    void turnOn();
    void turnOff();
    void setChannel(int number);
}

```

Faceți o clasă care implementează acea interfață. Pentru simplitate, va imprima doar o metodă.

```
public class SonyTV implements Device {
    @Override
    public void turnOn() {
        System.out.println("Sony turn on");
    }

    @Override
    public void turnOff() {
        System.out.println("Sony turn off");
    }

    @Override
    public void setChannel(int number) {
        System.out.println("Channel: " +  number);
    }
}
```

Creați o clasă cu un constructor care preia o clasă a acelei interfețe. Și faceți 2 metode (turnOn și turnOff).

```
public  class RemoteControl {
    protected Device device;

    public RemoteControl(Device device) {
        this.device = device;
    }

    public void turnOn() {
        device.turnOn();
    }

    public void turnOff() {
        device.turnOff();
    }

}
```

## Conclusions
În concluzie, am înțeles cum funcționează modelele de proiectare structurală,
am învățat cum să le implementam, care este diferența dintre ele, când să le folosim si care sunt beneficiile.