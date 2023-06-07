# Stuctural Design Patterns

### Object: TMPS
### Author: Golis Boris

----

## Theory
Modelele de proiectare sunt soluții tipice la probleme comune în proiectarea software. Fiecare model este ca un plan pe care îl puteți personaliza pentru a rezolva o anumită problemă de design din codul dvs.

Modelele sunt un set de instrumente de soluții la probleme comune în proiectarea software. Ele definesc un limbaj comun care vă ajută echipa să comunice mai eficient.

Modelele de design diferă prin complexitatea lor, nivelul de detaliu și scara de aplicabilitate. În plus, ele pot fi clasificate în funcție de intenția lor și împărțite în trei grupuri

<b>Behavioral Design Patterns</b>
 Modelele de design comportamental se ocupă de interacțiunea obiectelor într-o aplicație software orientată pe obiecte. Acest articol discută diferite modele de design comportamental care ajută obiectele să coopereze și să interacționeze între ele. Behavioral Design Patterns oferă un set de linii directoare formulate de pionierii software care identifică modele comune de comunicare între obiecte și oferă o modalitate de a rezolva problemele frecvente legate de interacțiunea obiectelor în proiectarea software.

* <b>Visitor</b>
 Încapsulează un algoritm în interiorul unei clase
* <b>Iterator</b>
 Accesați secvențial elementele unei colecții
* <b>Memento</b>
 Capturați și restabiliți starea internă a unui obiect
* <b>Observer</b>
  O modalitate de a notifica modificarea unui număr de clase
* <b>Template</b>
  Amânați pașii exacti ai unui algoritm la o subclasă
## Objectives:

* Prin extinderea proiectului, implementați cel puțin 1 model de design comportamental în proiectul dvs.
*  Păstrați fișierele grupate în funcție de responsabilitățile lor
* Documentați-vă munca într-un fișier separat de reducere, conform cerințelor prezentate mai jos


## Implementation description

* Iterator

Interfața „Iterator” are 3 metode -current, next, hasNext.

```
public interface Iterator {
    boolean hasNext();
    String current();
    void next();
}
```
În clasa „BrowseHistory” am creat un fel de istoric și, la fel ca stocarea în memorie, vom folosi lista de matrice pentru a le stoca. Implementați 2 metode de bază pop și push.

```
public class BrowseHistory {
    private List<String> urls = new ArrayList<>();

    public void push(String url) {
        urls.add(url);
    }

    public String pop() {
        var lastIndex = urls.size() - 1;
        var lastUrl = urls.get(lastIndex);

        urls.remove(lastUrl);
        return lastUrl;
    }
```

O altă clasă „ListIterator” care implementează „Iterator” și implementează aceste metode.
```
public class ListIterator implements Iterator {
        private BrowseHistory history;
        private int index;

        public ListIterator(BrowseHistory history) {
            this.history = history;
        }

        @Override
        public boolean hasNext() {
            return (index < history.urls.size());
        }

        @Override
        public String current() {
            return history.urls.get(index);
        }

        @Override
        public void next() {
            index++;
        }
    }
```
* Memento

Clasa „EditorState” are un constructor care ia un string și un getter.
```
public class EditorState {
    private final String content;

    public EditorState(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

}
```
Clasa „Editor” avem o funcție care creează un nou „EditorState”. Funcția de restaurare returnează starea anterioară. De asemenea, faceți un getter și setter.

```
public class Editor {
    private String content;

    public EditorState createState() {
        return new EditorState(content);
    }

    public void restore(EditorState state) {
        content = state.getContent();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
```

* Observer

În interfața „Observer” adăugați 1 metodă.

```
public interface Observer {
    void update(int value);
}
```

„SpreadSheet” și „Chart” implementează metoda interfeței „Observer”.
```
public class SpreadSheet implements Observer {
    @Override
    public void update(int value) {
        System.out.println("Spreadsheet got notified." + value);
    }
}
```
Clasa „Subject” are o listă cu observatori. În această clasă au metode de adăugare și eliminare. Și pentru a notifica observatorii, le traversează și le actualizează pe fiecare.
```
public class Subject {
    public List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(int value) {
        for (var observer: observers)
            observer.update(value);

    }
```
„DataSource” extinde „Subject” și setValue setează valoarea pentru toți observatorii și notifică.
```
public class DataSource extends Subject {

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        notifyObservers(value);
    }
}
```

* Template

„AuditTrail” are 1 metodă cu metoda de înregistrare.

```
public class AuditTrail {
    public void record() {
        System.out.println("Audit");
    }
}
```

Clasa abstractă „Task” are obiect „AuditTrail”. În metoda executați înregistrarea din auditTrail.
```
public abstract class Task {
    private AuditTrail auditTrail;

    public Task() {
        this.auditTrail = new AuditTrail();
    }

    public Task(AuditTrail auditTrail) {
        this.auditTrail = auditTrail;
    }

    public void execute() {
        auditTrail.record();

        doExecute();
    }
```

„TransferMoneyTask” extinde această clasă abstractă. Implementați „doExecute”.
```
public class TransferMoneyTask extends Task {
    @Override
    protected void doExecute() {
        System.out.println("Transfer Money");
    }
}
```

* Visitor

Interfață de operare cu 2 metode de aplicare. (una pentru direcția, alta pentru ancora)

```
public interface Operation {
    void apply(HeadingNode heading);
    void apply(AnchorNode anchor);
}
```
In headingNode execute method.
```
public class HeadingNode implements HtmlNode {
    @Override
    public void execute(Operation operation) {
        operation.apply(this);
    }
}
```

HighlightOperation implementează Operation cu acele 2 metode.

```
public class HighlightOperation implements Operation {
    @Override
    public void apply(HeadingNode heading) {
        System.out.println("Highlight-heading");
    }

    @Override
    public void apply(AnchorNode anchor) {
        System.out.println("Highlight-ancor");
    }
}
```

## Conclusions
În concluzie, am înțeles cum funcționează modelele de design comportamental, am învățat cum să le implementăm, care este diferența dintre ele, când să le folosim și care sunt beneficiile.