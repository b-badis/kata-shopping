# kata-shopping

## Enoncé de l’exercice technique à réaliser :
Tu es un nouveau développeur dans une société de vente de produit en ligne. La société vend trois types de
produits : des téléphones haut de gamme, des téléphones moyens de gamme, et des ordinateurs portables.
Ton Product Manager te demande de développer un programme permettant de calculer le panier d’un
consommateur.
Il existe deux types de clients :
1) Des clients particuliers identifié par un id client, un nom et un prénom
2) Des clients professionnels identifiés par un id client, une raison sociale, un numéro de TVA intracommunautaire
(qui est optionnel), un SIREN, et un chiffre d’affaires annuel

Pour les particuliers, le modèle de téléphone haut de gamme coute 1500 euros, le moyen de gamme coûte 800
euros, et le laptop 1200 euros.
Pour les clients professionnels ayant un chiffre d’affaires supérieur à 10 millions d’euros, le modèle de téléphone
haut de gamme coute 1000 euros, le moyen de gamme coûte 550 euros, et le laptop 900 euros.
Pour les clients professionnels ayant un chiffre d’affaires inférieur à 10 millions d’euros, le modèle de téléphone
haut de gamme coute 1150 euros, le moyen de gamme coûte 600 euros, et le laptop 1000 euros.
Calculer pour un client donné le cout de son panier, sachant que celui-ci pour contenir les 3 produits en plusieurs
exemplaires.

## Technologies utilisées
- **Langage** : Java
- **Build Tool** : Maven
- **Tests** : JUnit 5

## Prérequis
- **Java** : Version 17 ou supérieure.
- **Maven** : Version 3.8 ou supérieure.

## Installation
1. Clonez le dépôt :
   ```bash
    git clone https://github.com/b-badis/shopping-kata.git
   ```
2. Accédez au répertoire du projet :
  ```bash
    cd shopping-kata
  ```
3. Compilez le projet avec Maven :
  ```bash
    mvn clean install
  ```
