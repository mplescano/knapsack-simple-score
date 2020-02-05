package com.mplescano.app.poc.optaplanner.knapsack.simple.solver;

import java.io.Serializable;
import java.util.Comparator;

import org.apache.commons.lang3.builder.CompareToBuilder;

import com.mplescano.app.poc.optaplanner.knapsack.simple.domain.Item;

public class ItemDifficultyComparator implements Comparator<Item>, Serializable {

  private static final long serialVersionUID = -2624752404146078785L;

  public int compare(Item a, Item b) {
    return new CompareToBuilder().append(a.getSize(), b.getSize()).append(a.getId(), b.getId()).toComparison();
  }

}
