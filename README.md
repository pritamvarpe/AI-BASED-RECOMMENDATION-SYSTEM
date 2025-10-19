COMPANY: CODTECH IT SOLUTIONS
NAME: Pritam Varpe
INTERN ID: CT04DY2759
DOMAIN: Java Programming
DURATION: 4 WEEKS
MENTOR: NEELA SANTOSH

Description:

For developing the Product Recommendation System using Apache Mahout, I utilized the following tools and technologies:

1] IntelliJ IDEA

Used as the primary Integrated Development Environment (IDE) for writing, testing, and debugging the recommendation system. Its code assistance and project management features made it easier to integrate Mahout libraries, manage Maven dependencies, and execute the recommender efficiently.

2] Java Development Kit (JDK)

Provided the necessary environment to compile and run the Java-based recommendation engine. Core Java libraries were used for file handling, data modeling, and executing the main logic of the recommender system.

3] Apache Mahout

The key library used to implement collaborative filtering algorithms. Mahout’s Taste API was leveraged to build a user-based recommender using Pearson Correlation Similarity and Nearest-Neighbor techniques to generate product recommendations based on user preferences.

4] Maven

Maven was used for dependency management and project configuration. It automatically handled the inclusion of Apache Mahout and SLF4J libraries, making the build process seamless and reproducible.

5] CSV Data File

A custom dataset (sample_ratings.csv) was created to simulate user-item interactions. The recommender system reads this data, computes similarities between users, and suggests top-rated products that a user might like.

6] Git and GitHub

Git was used for version control throughout the project. The source code and documentation were hosted on GitHub to ensure transparency, collaboration, and easy access for review or portfolio presentation.

7] ChatGPT

ChatGPT served as a technical guide throughout development. It provided assistance in structuring the project, writing optimized code, resolving dependency issues, and improving documentation clarity.

# Java + Apache Mahout Recommendation Engine

This project is a minimal Maven-based Java recommendation system using Apache Mahout's Taste API (user-based collaborative filtering). It includes sample data and a main program that builds a recommender and prints top-N recommendations for a sample user.

## What this is
A small example of a recommendation engine in Java using Apache Mahout (Taste). The engine loads sample user-item-rating data from a CSV file, builds a user-based recommender using Pearson similarity and nearest-neighbor neighborhood, and prints recommended items for a given user.

## Files
- pom.xml — Maven project file with dependencies and exec plugin
- src/main/java/com/example/recommender/RecommenderApp.java — main program
- data/sample_ratings.csv — sample CSV (userID,itemID,preference)

## How to run
1. Ensure you have Java 11+ and Maven installed.
2. From project root run:

```bash
mvn compile exec:java -Dexec.mainClass="com.example.recommender.RecommenderApp"
```

You should see top recommended items printed for a sample user (user ID 1).

## Notes and suggestions

- This example uses *Mahout 0.9* which contains the Taste library with a simple API great for demos. Newer Mahout releases shifted focus to distributed algorithms and changed APIs; if you want a modern, actively maintained library consider using lenskit, spark MLlib, or building a simple matrix-factorization model with librec or other Java libraries.

- To test different approaches, try item-based recommender (GenericItemBasedRecommender), or change similarity to UncenteredCosineSimilarity or LogLikelihoodSimilarity.

- For production use with larger datasets, use a database-backed DataModel or stream updates — FileDataModel is only for small datasets and offline demos.

