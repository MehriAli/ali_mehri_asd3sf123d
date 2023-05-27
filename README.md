## Base de données
Dans ce projet, j'ai utilisé MySQL comme base de données.

## Démarrer l'application
Pour lancer l'application, vous devez démarrer une instance MySQL et modifier les informations d'identification de votre base de données dans le fichier `application.properties`. L'application sera disponible sur le port 8000.

## Remarques
L'application comprend deux classes de configuration :

### Main Config
- Permet d'initialiser la base de données avec quelques données pour faciliter les tests.
- Ajoute un utilisateur administrateur pour obtenir le token JWT permettant d'accéder aux endpoints.
- Remplit les tables Student, Teacher et Class.

### Security Config
- Met en place Spring Security et les configurations nécessaires.

## Après avoir lancé l'application
- Le schéma de la base de données sera créé automatiquement grâce à la configuration `?createDatabaseIfNotExist=true`.
- Les tables seront automatiquement remplies.

## Tester l'API student list
Pour tester l'API des étudiants avec les filtres et la pagination, vous devez d'abord récupérer le token. Voici comment procéder :
1. Effectuez une requête GET simple à l'adresse suivante : `http://localhost:8000/api/login`.
2. Récupérez le token retourné.
3. Utilisez Postman pour tester l'API student en spécifiant le token dans la section "Authorization" en sélectionnant "Bearer Token" et en entrant le token récupéré.
4. Voici un exemple de requête : `http://localhost:8000/api/student/list?className=course one&page=0&size=10&teacherFullName=Alex Black`.
5. Vous pouvez modifier les paramètres selon vos besoins.

# Tests unitaires
L'application comprend une classe `StudentControllerTest` qui contient un test unitaire pour l'API studentList.
