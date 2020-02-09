package com.mplescano.app.poc.optaplanner.knapsack.simple.domain;

import org.optaplanner.core.api.domain.lookup.PlanningId;

public class Bin {

  private long id;

  private int volume;

  public Bin() {
  }

  public Bin(long id, int volume) {
    this.id = id;
    this.volume = volume;
  }

  public int getVolume() {
    return volume;
  }

  public void setVolume(int capacity) {
    this.volume = capacity;
  }

  @PlanningId
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @Override
  public String toString() {
		return "Bin [id=" + id + ", volume=" + volume + ", toString()=" + super.toString() + "]";
  }
}
