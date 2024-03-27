# Compte Rendu du TP 1 : Patrons de Conceptions

Noms des étudiants du binôme :

## Exercices 1

    Quel patron de conception reflète ce modèle ? Identifiez le rôle de chaque de ces deux classes dans ce patron.
    
    Réalisez la classe TagAlongBike qui représente un vélo parental traînant un vélo d'enfant (voir image). Le vélo parental est un vélo qui contient dans ses composants un autre vélo simple. Doit-on récrire la méthode getVelocity() ou la méthode getMass() pour la nouvelle classe ?
    

Ici le design pattern utilisé est le **design pattern composite**. 
En effet dans ce cas:
* La classe abstraite **Mobile Object** joue le role de la classe **Composant**
* La classe abstraite **Vehicle** joue le role de la classe **Composite**
* La classe **Wheel** joue le role de la classe **Feuille** 

Pour implémenter **TagAlongWheel**, il suffit de créer une classe qui hérite de **SimpleBike** et qui a un **ChildBike** qui est 
lui même un **SimpleBike**. 
Dans le constructeur on ajoute le **ChildBike** a la liste des des composants ce qui permet d'utiliser la force du design pattern et de ne pas 
réimplémenter **getVelocity()** et **getMass()**


## Exercices 2

## Exercices 3

## Exercices 4

## Exercices 5

## Exercices 6

## Exercices 7

## Exercices 8


