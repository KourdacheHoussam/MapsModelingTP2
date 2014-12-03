*************************
** Objetifs *************
*************************
- Générer le code d’un méta-modèle donnée.
- Charger et manipuler des modèles (fichier xmi) en Java/EMF
	

Pour generer le code du meta-modele maps, suivez les etapes suivantes :


— Creer un nouveau EMF Empty project nommée maps.
— Copier le fichier maps.ecore dans le dossier model du projet maps.
— Creer un fichier maps.genmodel.
— Menu contextuel sur maps.ecore , New , Other,
— EMF Generator Model , Nommer puis Next , Choisir Ecore Model puis Next,
— Appuyer sur Load (pas d’erreurs) puis Next , Finish.
— Ouvrir le fichier cree et menu contextuel sur la racine  Generate Model Code.
— Regarder le dossier src du projet, 3 nouveaux packages ont ete crees. Ils contiennent des
classes pour instancier le meta-modele et manipuler ses modeles conformes.

*********************************
**** Charger une instance *******
*********************************

— Créer un nouveau package java dans le dossier src et le nommer test.
— Copier le fichier test.java dans le package src/test.
— Copier l’instance map.xmi dans le dossier model.
— Exécuter le programme test.java pour voir ce qu’il fait.


*****************
*** Effectué ****
*****************

Utiliser la methode charger Modele contenue dans test.java pour ecrire les methodes suivantes :

— Recuperer et afficher les noms de toutes les rues (Street) d’une map donnee.
— Recuperer toutes les rues pietonnes (Pedetrian) dont la longueur depasse 1000m.
— Pour un nom de boulevard donne (Boulevard), trouver tous les noms des routes adjacentes.
— Pour un nom de place (Square) donne, trouver tous les noms des routes la bordant.

Astuce Générer le ECore Diagram du méta-modèele pour mieux voir les classes et références.
- Pour Générer le diagram UML depuis le maps.ecore: 
	clique droit sur maps.ecore > initialize ecore diagram
	


