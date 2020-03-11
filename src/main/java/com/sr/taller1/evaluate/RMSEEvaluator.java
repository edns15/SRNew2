package com.sr.taller1.evaluate;

import com.sr.taller1.data.DataRecommendationModels;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.recommender.Recommender;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class RMSEEvaluator {

    private Recommender recommender;
    private String testFile;
    double total = 0;
    double count = 0;
    int nan = 0;
    int errors = 0;

    public RMSEEvaluator(Recommender recommender, String testFile){
        this.recommender = recommender;
        this.testFile = testFile;
    }

    public double evaluate() throws IOException {
        total = 0;
        count = 0;
        nan = 0;
        errors = 0;
        File train = DataRecommendationModels.instance().loadFileFromResource(testFile);

        try (Stream<String> stream = Files.lines(Paths.get(train.getAbsolutePath()))) {
            stream.forEach((line) -> {
                String[] rank = line.split(",");
                Long user = Long.parseLong(rank[0]);
                Long item = Long.parseLong(rank[1]);
                Long rating = Long.parseLong(rank[2]);

                try {
                    double estimatedRating = this.recommender.estimatePreference(user,item);
                    if (!Double.isNaN(estimatedRating)) {
                        total += Math.pow(estimatedRating-rating, 2);
                        count++;
                    }
                    else{
                        nan++;
                    }

                } catch (TasteException e) {
                    errors++;
                }
            });
        } catch (IOException e) {
            throw e;
        }
        System.out.println("Errors: "+errors);
        System.out.println("NaN: "+nan);
        System.out.println("Count: "+count);

        return Math.sqrt(total / count);
    }

}
