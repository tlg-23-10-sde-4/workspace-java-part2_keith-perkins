package com.duckrace;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DuckRacer {
    private int id;
    private String name;
    private Collection<Reward> rewards = new ArrayList<>();

    public DuckRacer(int id, String name) {
        this.id = id;
        setName(name);
    }

    //methods
    public int getWins() {
        return rewards.size();
    }

    public void win(Reward reward) {
        rewards.add(reward);
    }

    // getters and setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // instead of returning reference to collection return read only view
    public Collection<Reward> getRewards() {
        return Collections.unmodifiableCollection(rewards);
    }

    @Override
    public String toString() {
        return "DuckRacer" +
                "id=" + getId() +
                ", name=" + getName() +
                ", wins=" + getWins() +
                ", rewards=" + getRewards();
    }
}