/*
 * Copyright 2014 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mplescano.app.poc.optaplanner.knapsack.simple.domain;

import java.io.Serializable;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.lookup.PlanningId;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity
public class Item implements Serializable {

	private static final long serialVersionUID = -3689317429583843521L;

	protected int id;

	private int weight;

	private Boolean inside;

	public Item() {
	}

	public Item(int id, int weight) {
		this.id = id;
		this.weight = weight;
	}
	
	public Item(int id, int weight, boolean inside) {
		this.id = id;
		this.weight = weight;
		this.inside = Boolean.valueOf(inside);
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@PlanningVariable(valueRangeProviderRefs = { "insideRange" })
	public Boolean getInside() {
		return inside;
	}

	public void setInside(Boolean inside) {
		this.inside = inside;
	}

	@Override
	public String toString() {
		return getClass().getName().replaceAll(".*\\.", "") + "-" + id + "@" + weight + "-" + inside;
	}

	@PlanningId
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
