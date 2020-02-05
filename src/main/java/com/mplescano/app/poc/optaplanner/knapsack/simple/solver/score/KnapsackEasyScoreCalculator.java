package com.mplescano.app.poc.optaplanner.knapsack.simple.solver.score;

import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.impl.score.director.easy.EasyScoreCalculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mplescano.app.poc.optaplanner.knapsack.simple.domain.Item;
import com.mplescano.app.poc.optaplanner.knapsack.simple.domain.KnapsackSolution;

public class KnapsackEasyScoreCalculator implements EasyScoreCalculator<KnapsackSolution> {

	Logger logger = LoggerFactory.getLogger(KnapsackEasyScoreCalculator.class);
	
	public HardSoftScore calculateScore(KnapsackSolution knapsack) {
		int free = knapsack.getCapacity();
		int hardScore;
		int sumMass = 0;
		for (Item item : knapsack.getItemList()) {
			if (item.getInside() != null && item.getInside().booleanValue()) {
				sumMass += item.getWeight();
			}
		}
		hardScore = free - sumMass;
		logger.debug("hardScore:" + hardScore);
		return HardSoftScore.of(hardScore >= 0 ? 0 : hardScore, hardScore);
	}
}
