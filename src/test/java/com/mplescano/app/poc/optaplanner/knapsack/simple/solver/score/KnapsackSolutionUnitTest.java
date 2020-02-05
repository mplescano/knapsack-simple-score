package com.mplescano.app.poc.optaplanner.knapsack.simple.solver.score;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;

import com.mplescano.app.poc.optaplanner.knapsack.simple.domain.Item;
import com.mplescano.app.poc.optaplanner.knapsack.simple.domain.PackingSolution;
import com.mplescano.app.poc.optaplanner.knapsack.simple.domain.Bin;

public class KnapsackSolutionUnitTest {

  @Test
  public void test_one() {
    Bin bin = new Bin();
    bin.setId(1001);
    bin.setVolume(Integer.valueOf(24));
    PackingSolution unsolvedKnapsackSolution = new PackingSolution();
    unsolvedKnapsackSolution.setBin(bin);
    fillItems(unsolvedKnapsackSolution);
    SolverFactory<PackingSolution> solverFactory = SolverFactory.createFromXmlResource("knapsackSolverConfig.xml");
    Solver<PackingSolution> solverCourseSchedule = solverFactory.buildSolver();
    PackingSolution solvedKnapsackSolution = solverCourseSchedule.solve(unsolvedKnapsackSolution);
    solvedKnapsackSolution.printSolution();
  }

  @Test
  public void test_two() {
    Bin bin = new Bin();
    bin.setId(1002);
    bin.setVolume(Integer.valueOf(15));
    PackingSolution unsolvedKnapsackSolution = new PackingSolution();
    unsolvedKnapsackSolution.setBin(bin);
    fillItems(unsolvedKnapsackSolution);
    SolverFactory<PackingSolution> solverFactory = SolverFactory.createFromXmlResource("knapsackSolverConfig.xml");
    Solver<PackingSolution> solverCourseSchedule = solverFactory.buildSolver();
    PackingSolution solvedKnapsackSolution = solverCourseSchedule.solve(unsolvedKnapsackSolution);
    solvedKnapsackSolution.printSolution();
  }

  private void fillItems(PackingSolution unsolvedKnapsackSolution) {
    List<Item> itemList = new ArrayList<>();
    itemList.add(new Item(1, 1));
    itemList.add(new Item(2, 1));
    itemList.add(new Item(3, 3));
    itemList.add(new Item(4, 3));
    itemList.add(new Item(5, 6));
    itemList.add(new Item(6, 11));
    itemList.add(new Item(7, 11));
    unsolvedKnapsackSolution.setListItem(itemList);
  }
}
