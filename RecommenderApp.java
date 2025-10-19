package com.example.recommender;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;

import java.io.File;
import java.util.List;

public class RecommenderApp {

    public static void main(String[] args) throws Exception {
        File ratingsFile = new File("data/sample_ratings.csv");

        if (!ratingsFile.exists()) {
            System.err.println("Data file not found: " + ratingsFile.getAbsolutePath());
            System.exit(1);
        }

        DataModel model = new FileDataModel(ratingsFile);
        UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
        int neighborhoodSize = 2;
        UserNeighborhood neighborhood = new NearestNUserNeighborhood(neighborhoodSize, similarity, model);
        Recommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);

        long userID = 1L;
        int howMany = 5;

        List<RecommendedItem> recommendations = recommender.recommend(userID, howMany);

        System.out.println("Top " + howMany + " recommendations for user " + userID + ":");
        if (recommendations.isEmpty()) {
            System.out.println("  (no recommendations found)");
        } else {
            for (RecommendedItem ri : recommendations) {
                System.out.printf("  itemID=%d, score=%.4f%n", ri.getItemID(), ri.getValue());
            }
        }
    }
}