package com.mplescano.app.poc.optaplanner.knapsack.simple.solver.score;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;

import com.mplescano.app.poc.optaplanner.knapsack.simple.domain.Item;
import com.mplescano.app.poc.optaplanner.knapsack.simple.domain.KnapsackSolution;

public class KnapsackSolutionUnitTest {

	@Test
	public void test_one() {
		KnapsackSolution unsolvedKnapsackSolution = new KnapsackSolution();
		unsolvedKnapsackSolution.setCapacity(Integer.valueOf(24));
		/*List<Item> itemList = new ArrayList<>();
		itemList.add(new Item(1, 1));
		itemList.add(new Item(2, 1));
		itemList.add(new Item(3, 3));
		itemList.add(new Item(4, 3));
		itemList.add(new Item(5, 6));
		itemList.add(new Item(6, 11));
		itemList.add(new Item(7, 11));
		unsolvedKnapsackSolution.setItemList(itemList);*/

		List<Item> itemList = new ArrayList<>();
		itemList.add(new Item(1, 1, false));
		itemList.add(new Item(2, 1, false));
		itemList.add(new Item(3, 3, false));
		itemList.add(new Item(4, 3, false));
		itemList.add(new Item(5, 6, false));
		itemList.add(new Item(6, 11, false));
		itemList.add(new Item(7, 11, false));
		unsolvedKnapsackSolution.setItemList(itemList);
		SolverFactory<KnapsackSolution> solverFactory = SolverFactory.createFromXmlResource("knapsackSolverConfig.xml");
		Solver<KnapsackSolution> solverCourseSchedule = solverFactory.buildSolver();
		KnapsackSolution solvedKnapsackSolution = solverCourseSchedule.solve(unsolvedKnapsackSolution);
		solvedKnapsackSolution.printSolution();
	}

	@Test
	public void test_two() {
		KnapsackSolution unsolvedKnapsackSolution = new KnapsackSolution();
		unsolvedKnapsackSolution.setCapacity(Integer.valueOf(15));
		unsolvedKnapsackSolution.getItemList().add(new Item(1, 1, false));
		unsolvedKnapsackSolution.getItemList().add(new Item(2, 1, false));
		unsolvedKnapsackSolution.getItemList().add(new Item(3, 3, false));
		unsolvedKnapsackSolution.getItemList().add(new Item(4, 3, false));
		unsolvedKnapsackSolution.getItemList().add(new Item(5, 6, false));
		unsolvedKnapsackSolution.getItemList().add(new Item(6, 11, false));
		unsolvedKnapsackSolution.getItemList().add(new Item(7, 11, false));
		SolverFactory<KnapsackSolution> solverFactory = SolverFactory.createFromXmlResource("knapsackSolverConfig.xml");
		Solver<KnapsackSolution> solverCourseSchedule = solverFactory.buildSolver();
		KnapsackSolution solvedKnapsackSolution = solverCourseSchedule.solve(unsolvedKnapsackSolution);
		solvedKnapsackSolution.printSolution();
	}
}
