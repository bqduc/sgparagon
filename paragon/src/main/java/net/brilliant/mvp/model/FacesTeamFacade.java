package net.brilliant.mvp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rmpestano on 18/01/17.
 */
public class FacesTeamFacade implements Serializable {

    private String name;

    private List<Stats> stats;

    public FacesTeamFacade() {
        stats = new ArrayList<Stats>();
    }

    public FacesTeamFacade(String name) {
        this.name = name;
        stats = new ArrayList<Stats>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Stats> getStats() {
        return stats;
    }

    public void setStats(List<Stats> stats) {
        this.stats = stats;
    }

    public int getAllWins() {
        int sum = 0;

        for(Stats s : stats) {
            sum += s.getWin();
        }

        return sum;
    }

    public int getAllLosses() {
        int sum = 0;

        for(Stats s : stats) {
            sum += s.getLoss();
        }

        return sum;
    }
}