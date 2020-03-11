package com.sr.taller1.evaluate.item;

import com.sr.taller1.data.DataRecommendationModels;
import com.sr.taller1.evaluate.RMSEEvaluator;
import com.sr.taller1.recommender.user.UserPearsonRecommenderBuilder;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.eval.RecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.eval.RMSRecommenderEvaluator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ItemPearsonMain {

    public static void main(String[] args) throws IOException, TasteException {

        ItemPearsonMain pearson = new ItemPearsonMain();
        pearson.recommendAndEvaluate();
    }

    private void recommendAndEvaluate() throws IOException, TasteException {


        System.out.println("Item Pearson");

        for(int i = 1; i <= 3; i++)
        {
            UserPearsonRecommenderBuilder recommenderBuilder = new UserPearsonRecommenderBuilder();

            File data = DataRecommendationModels.instance().loadFileFromResource("test-train"+i+"/train_track.csv");
            DataModel dm = new FileDataModel(data);

            Recommender recommender = recommenderBuilder.buildRecommender(dm);

            RMSEEvaluator evaluator = new RMSEEvaluator(recommender, "test-train"+i+"/test_track.csv");
            double result = evaluator.evaluate();
            System.out.println(result);
        }
    }
}
