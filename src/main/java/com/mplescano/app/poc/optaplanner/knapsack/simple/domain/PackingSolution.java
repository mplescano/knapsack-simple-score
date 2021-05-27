package com.mplescano.app.poc.optaplanner.knapsack.simple.domain;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.ProblemFactProperty;
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

  public final static Bin NULL_BIN = new Bin(Integer.MAX_VALUE, Integer.MAX_VALUE);

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
    return Arrays.asList(bin, NULL_BIN);
  }

  @PlanningEntityCollectionProperty
  public List<Item> getListItem() {
    return listItem;
  }

  public void setListItem(List<Item> itemList) {
    this.listItem = itemList;
  }

  @Override
  public String toString() {
	return new ToStringBuilder(this).append("bin", this.bin).append("listItem", this.listItem).build();
  }

  public void setBin(Bin bin) {
    this.bin = bin;
  }
}
