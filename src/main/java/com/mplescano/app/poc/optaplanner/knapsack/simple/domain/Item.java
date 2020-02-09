package com.mplescano.app.poc.optaplanner.knapsack.simple.domain;

import java.io.Serializable;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.lookup.PlanningId;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

import com.mplescano.app.poc.optaplanner.knapsack.simple.solver.ItemDifficultyComparator;

@PlanningEntity(difficultyComparatorClass = ItemDifficultyComparator.class)
public class Item implements Serializable {

  private static final long serialVersionUID = -3689317429583843521L;

  private long id;

  private int size;

  private Bin bin;

  public Item() {
  }

  public Item(int id, int size) {
    this.id = id;
    this.size = size;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  @PlanningVariable(valueRangeProviderRefs = "binReference")
  public Bin getBin() {
    return bin;
  }

  public void setBin(Bin inside) {
    this.bin = inside;
  }


  @PlanningId
  public long getId() {
    return id;
  }

  @Override
  public String toString() {
		return "Item [id=" + id + ", size=" + size + ", bin=" + bin + ", toString()=" + super.toString() + "]";
  }

  public void setId(long id) {
    this.id = id;
  }
}
