package com.mplescano.app.poc.optaplanner.knapsack.simple.solver.score;

import org.optaplanner.core.api.score.buildin.simple.SimpleScore;
import org.optaplanner.core.impl.score.director.easy.EasyScoreCalculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mplescano.app.poc.optaplanner.knapsack.simple.domain.Item;
import com.mplescano.app.poc.optaplanner.knapsack.simple.domain.PackingSolution;

public class KnapsackEasyScoreCalculator implements EasyScoreCalculator<PackingSolution> {

	Logger logger = LoggerFactory.getLogger(KnapsackEasyScoreCalculator.class);
	
	public SimpleScore calculateScore(PackingSolution knapsack) {
		int free = knapsack.getBin().getVolume();
		int hardScore;
		int sumMass = 0;
		for (Item item : knapsack.getListItem()) {
			if (item.getBin() != PackingSolution.NULL_BIN) {
				sumMass += item.getSize();
			}
		}
		hardScore = free - sumMass;
		logger.debug("free:" + free);
		logger.debug("sumMass:" + sumMass);
		logger.debug("hardScore:" + hardScore);
		return SimpleScore.of(hardScore >= 0 ? 0 : hardScore);
	}
}
