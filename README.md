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

