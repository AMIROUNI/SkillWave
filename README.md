# SkillWave 🌊

> **Plateforme web de gestion de profils pour freelances**

SkillWave est un backend de plateforme web dédiée aux freelances, permettant une gestion complète des profils utilisateurs, des compétences, des portfolios, des avis sur les cours, des projets et des offres. Ce projet est conçu pour remplacer les méthodes de communication traditionnelles comme WhatsApp ou les e-mails par une solution structurée, scalable et facilement intégrable.

---

## 🚀 Fonctionnalités principales

- 🔐 **Authentification** : inscription, connexion sécurisée  
- 👤 **Gestion des utilisateurs** : création, mise à jour, suppression, consultation  
- 💼 **Portfolio** : gestion des projets réalisés avec image, URL, description  
- 📚 **Cours et avis** : publication de cours et feedback des utilisateurs  
- 🛠️ **Compétences et rôles** : classification des utilisateurs (freelance, client, admin)  
- 📦 **GraphQL API** : backend puissant et typé avec Spring Boot + GraphQL  

---

## 🛠️ Stack Technique

| Technologie       | Description                         |
|-------------------|-----------------------------------|
| Java / Spring Boot | Backend REST/GraphQL robuste      |
| GraphQL           | Requêtes typées et efficaces       |
| PostgreSQL        | Base de données relationnelle      |
| Lombok            | Réduction du code boilerplate      |
| JPA / Hibernate   | Mapping objet-relationnel          |

---

## 📁 Structure du projet

```bash
SkillWave/
├── models/            # Entités JPA : User, Review, Project, Bid, etc.
├── graphql/           # Résolveurs GraphQL (Queries & Mutations)
├── services/          # Services métier (CRUD logique)
├── repositories/      # Interfaces JPA
└── SkillWaveApplication.java
⚙️ Installation
Cloner le dépôt

bash
Copier
Modifier
git clone https://github.com/AMIROUNI/SkillWave.git
cd SkillWave
Configurer la base de données dans src/main/resources/application.properties ou application.yml

properties
Copier
Modifier
spring.datasource.url=jdbc:postgresql://localhost:5432/skillwave_db
spring.datasource.username=postgres
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
Lancer le projet

bash
Copier
Modifier
./mvnw spring-boot:run
Ou avec un IDE comme IntelliJ ou VS Code, exécutez SkillWaveApplication.java.

📬 Accès API GraphQL
URL de l’endpoint : http://localhost:8080/graphql

Utilisez Postman, Insomnia ou GraphQL Playground pour tester vos requêtes.

💡 Exemple de requête GraphQL
graphql
Copier
Modifier
query {
  users {
    id
    name
    email
    skills
  }
}
📌 À venir
Intégration d’un frontend Angular ou React

Sécurité avec JWT

Paiements et contrats freelances

Système de messagerie en temps réel

Recherche intelligente par compétences et tags

🤝 Contribution
Les contributions sont les bienvenues !
Veuillez ouvrir une issue ou proposer une pull request.
