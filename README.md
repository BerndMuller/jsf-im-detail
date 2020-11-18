# JavaServer Faces im Detail

Code-Beispiele zum Kapitel 2 des Buches 
*JavaServer Faces - Ein Arbeitsbuch für die Praxis*, 3. Auflage (noch nicht erschienen)

Siehe auch <https://www.jsfpraxis.de>.

Achtung: * ich arbeite noch dran, die Beispiele sind alles andere als vollständig *

## Getting Started
```
mvn clean package
```
Dann deployen Sie wie gewohnt auf Ihrem Java-EE-8-Application-Server

### WildFly bootable JAR

Mit dem WildFly-Maven-JAR-Plugin können JARs erzeugt werden, die sowohl die benötigten Module
des Application-Servers als auch die Anwendung enthält. Dies ist nicht in einem Profil des
Standard-POMs, sondern in einem eigenen POM definiert. Zuächst packetieren, dann mit
Java ausführen:

```
mvn clean package -f pom-bootable.xml
java -jar target/jsf-im-detail-bootable.jar
```

Die Anwendung wird als ROOT.war deployt ist also unter ``http://localhost:8080/`` ohne Anwendungsname
verfügbar.

Das Maven-Plugin kann auch hollow JARS erzeugen. Dazu einfach den Kommentar um das ``<hollow-jar>`` Tag
entfernen. Aufruf nach dem Bauen :

```
java -jar target/jsf-im-detail-bootable.jar --deployment=target/jsf-im-detail.war
```

Dabei wird mit Anwendungsname deployt, also ``http://localhost:8080/jsf-im-detail`` aufrufen.


### Prerequisites

Java-EE-8-Application-Server!

Wir haben mit WildFly 21 unter Java 15 getestet. 



## License

See the [LICENSE](LICENSE.txt) file for license rights and limitations (MIT).
