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

    Quel patron de conception utilise la méthode getVelocity() pour parcourir les composants d'un véhicule ? Quel avantage apporte ce patron ?
    
    Modifier la structure de donnée utilisée pour stocker les composants d'un véhicule de Set à List. Doit-on modifier la réalisation de la méthode getVelocity() ?

La méthode **getVelocity()** utilise le patron de conception **Itérateur** pour parcourir les composants d'un véhicule. L'itérateur est utilisé ici pour parcourir chaque objet **MobileObject** contenu dans la collection components sans exposer les détails de la structure sous-jacente de cette collection. 
Cela permet à la classe Vehicle de séparer la manière dont ses composants sont stockés de la logique utilisée pour calculer la vitesse du véhicule basée sur les vitesses et les masses de ses composants.

### Avantage du Patron de Conception Itérateur
L'avantage principal de l'utilisation du patron de conception Itérateur, comme démontré dans getVelocity(), est qu'il fournit une manière d'accéder aux éléments d'une collection de manière séquentielle sans avoir besoin de connaître sa structure interne. Cela permet de :

* **Découpler les structures de données de l'algorithme** : Le code qui utilise l'itérateur pour parcourir les éléments peut rester constant même si la structure de données sous-jacente change (par exemple, passer d'un HashSet à un ArrayList).
* **Simplifier le code** : En encapsulant la logique de parcours, le code client reste plus simple et plus propre.
* **Standardiser l'accès** : Peu importe la structure de données spécifique utilisée (liste, ensemble, tableau, etc.), l'utilisation d'un itérateur offre une interface standard pour parcourir ses éléments.

En modifiant la structure de données pour stocker les composants de notre véhicule de **Set** à **List**, nous n'avons pas besoin de changer l'implémentation de notre méthode **getVelocity()**.
L'utilisation d'un **Iterator*, compatible avec toutes les structures de données standard en Java qui implémentent l'interface Iterable, assure que l'itération sur les éléments reste la même. 
Ce changement vers une List n'affecte donc pas la fonctionnalité de **getVelocity()**, car l'accès séquentiel aux éléments via l'itérateur ne dépend pas du type spécifique de collection utilisé. 
Cependant, en optant pour une List, nous acceptons la possibilité d'ajouter des doublons, ce qui pourrait influencer les calculs de la vitesse et de la masse si des instances identiques de **MobileObject** sont ajoutées plusieurs fois.

## Exercices 3
    
    Utilisez le patron de conception de création singleton pour assurer qu'il n'y a qu'une seule instance de la classe Clock dans l'application. Les deux roues doivent donc utiliser cette même instance et les vitesses doivent être homogènes.
    
    Expliquez, en quelques lignes, les étapes de la réalisation de ce patron dans le code.
    
    Attention, seulement une seule instance doit être instantiable de la classe Clock.


Pour régler ce problème de synchronisation, on utilise le design pattern Singleton que l'on peut mettre en place en suivant ces étapes : 

- **Déclarer un constructeur privé** qui permet d'empêcher l'instanciation directe de la classe.

- **Créer une méthode statique pour obtenir l'instance unique** : Dans notre cas on la nommme `getInstance()`. Elle retourne l'instance unique de la classe et la crée si elle n'a pas encore été instanciée.

- **Utiliser l'instance unique** : On remplace le constructeur de `Clock`utilisé dans la classe `Wheel` par la méthode statique `getInstance()`. Cela garantit l'utilisation de la même instance unique de la classe dans toute l'application.




## Exercices 4

    Les classes Bike et Wheel, appartiennent-elles au même paquetage[^3] ? Quel type de dépendance y a-t-il entre les deux classes ? Cette dépendance adhère-t-elle aux bonnes pratiques de conception ?
    
    Quelle fonctionnalité de la classe Bike utilise la classe Wheel ? Y a-t-il déjà une abstraction de la classe Bike qui isole cette fonctionnalité ? Dans quel paquetage se trouve cette abstraction ?
    
    Proposez, et réalisez, une solution pour casser la dépendance cyclique entre les classes Bike et Wheel.

1. Les classes Bike et Wheel appartiennent-elles au même paquetage?
Non, elles n'appartiennent pas au même paquetage. **Bike** est dans `fr.polytech.sim.cycling` et **Wheel** est dans `fr.polytech.sim.transport`.

2. Quel type de dépendance y a-t-il entre les deux classes?
Il existe une dépendance mutuelle entre les paquetages `transport` et `cycling` : le paquetage `cycling` dépend du paquetage `transport` à travers l'héritage de la classe **Vehicle** dans **Bike**, tandis que `transport` (par exemple, la classe **Wheel**) dépend de la classe **Bike** dans `cycling` pour obtenir des fonctionnalités spécifiques, telles que la propulsion. 
Cela crée une dépendance cyclique au niveau des paquetages.

3. Cette dépendance adhère-t-elle aux bonnes pratiques de conception?
Les dépendances cycliques entre paquetages sont généralement considérées comme une mauvaise pratique en conception logicielle car elles rendent le code plus difficile à comprendre, à maintenir et à tester. 
Elles peuvent également compliquer la compilation et le déploiement des modules. Idéalement, la structure de dépendance devrait être acyclique.

4. Quelle fonctionnalité de la classe Bike utilise la classe Wheel?
La classe **Wheel** utilise la fonctionnalité *getPush()* de la classe **Bike** pour calculer la vélocité.

5. Y a-t-il déjà une abstraction de la classe Bike qui isole cette fonctionnalité?
Oui, l'abstraction existe sous forme de la classe **Vehicle**, qui est étendue par **Bike**. La classe **Vehicle** définit l'interface `getPush()` que **Bike** implémente.

6. Dans quel paquetage se trouve cette abstraction?
L'abstraction **Vehicle** est située dans le paquetage `fr.polytech.sim.transport`.

Pour casser la dépendance cyclique entre les paquetages, nous allons faire dépendre **Wheel** de l'abstraction déja existante **Vehicle**

## Exercices 5

## Exercices 6

## Exercices 7

Facade

## Exercices 8


