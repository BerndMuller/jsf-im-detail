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


Nur einen Integrationstest ausführen:
```
mvn8  -Dit.test=ParameterPassingIT failsafe:integration-test
```

### Prerequisites

Java-EE-8-Application-Server!

Wir haben mit Payara 5 und WildFly 13 getestet. 



## License

See the [LICENSE](LICENSE.txt) file for license rights and limitations (MIT).
