package com.sr.taller1.recommender.item;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderBuilder;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.UncenteredCosineSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;

public class ItemCosineRecommenderBuilder implements RecommenderBuilder {

    public Recommender buildRecommender(DataModel dataModel) throws TasteException {
        ItemSimilarity similarity = new UncenteredCosineSimilarity(dataModel);
        return new GenericItemBasedRecommender(dataModel, similarity);
    }
}