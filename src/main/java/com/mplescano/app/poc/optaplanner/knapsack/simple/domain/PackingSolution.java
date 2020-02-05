package com.mplescano.app.poc.optaplanner.knapsack.simple.domain;

import java.util.Arrays;
import java.util.List;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.drools.ProblemFactProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.simple.SimpleScore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@PlanningSolution
public class PackingSolution {

  Logger logger = LoggerFactory.getLogger(PackingSolution.class);

  private SimpleScore score;

  private List<Item> listItem;

  private Bin bin;

  @PlanningScore
  public SimpleScore getScore() {
    return score;
  }

  public void setScore(SimpleScore score) {
    this.score = score;
  }

  @ProblemFactProperty
  public Bin getBin() {
    return bin;
  }

  @ValueRangeProvider(id = "binReference")
  public List<Bin> getListBin() {
    return Arrays.asList(bin);
  }

  @PlanningEntityCollectionProperty
  public List<Item> getListItem() {
    return listItem;
  }

  public void setListItem(List<Item> itemList) {
    this.listItem = itemList;
  }

  public void printSolution() {
    listItem.stream().map(c -> c).forEach(k -> logger.info(k.toString()));
  }

  public void setBin(Bin bin) {
    this.bin = bin;
  }
}
