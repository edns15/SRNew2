package com.sr.taller1.recommender.user;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.TanimotoCoefficientSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class UserJaccardRecommenderBuilder implements RecommenderBuilder {

    private int n = 20;
    private double minSimilarity = 0.02;

    public UserJaccardRecommenderBuilder(int n, double minSimilarity){
        this.n = n;
        this.minSimilarity = minSimilarity;
    }

    public UserJaccardRecommenderBuilder(){}

    public Recommender buildRecommender(DataModel dataModel) throws TasteException {
        UserSimilarity similarity = new TanimotoCoefficientSimilarity(dataModel);
        UserNeighborhood neighborhood = new NearestNUserNeighborhood(n,minSimilarity, similarity, dataModel);
        return new GenericUserBasedRecommender(dataModel, neighborhood, similarity);
    }
}

