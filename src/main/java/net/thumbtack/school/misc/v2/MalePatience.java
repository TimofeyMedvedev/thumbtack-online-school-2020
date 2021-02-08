package net.thumbtack.school.misc.v2;

import net.thumbtack.school.iface.v2.HasArea;
import net.thumbtack.school.iface.v2.Stretchable;

import java.util.Objects;

public class MalePatience implements HasArea, Stretchable {
    private String nameHusband;
    private int dailyPatience;
    private int totalPatience;
    private final int MAX_DAILY_PATIENCE = 999;
    private final int MAX_TOTAL_PATIENCE = 999_999;

    public MalePatience(String nameHusband, int dailyPatience, int totalPatience) {
        this.nameHusband = nameHusband;
        this.dailyPatience = dailyPatience;
        this.totalPatience = totalPatience;
    }

    public MalePatience(String nameHusband, int totalPatience) {
        this(nameHusband, 0, totalPatience);
    }

    public MalePatience(String nameHusband) {
        this(nameHusband, 0, 0);
    }

    public String getNameHusband() {
        return nameHusband;
    }

    public void setNameHusband(String nameHusband) {
        this.nameHusband = nameHusband;
    }

    public int getDailyPatience() {
        return dailyPatience;
    }

    public int getTotalPatience() {
        return totalPatience;
    }

    @Override
    public double getArea() {
        System.out.printf("Колличество использованного терпения: %d", MAX_DAILY_PATIENCE * totalPatience);
        return MAX_DAILY_PATIENCE * totalPatience;
    }

    @Override
    public void stretch(double xRatio, double yRatio) {
        dailyPatience = (int) (dailyPatience * xRatio);
        totalPatience = (int) (totalPatience * yRatio);
        if(dailyPatience > MAX_DAILY_PATIENCE) {
            System.out.println("Лимит терпения исчерпан на сегодня.");
            dailyPatience = 0;
        }
        if(totalPatience > MAX_TOTAL_PATIENCE) {
            System.out.println("You killed your husband");
        }
    }

    @Override
    public void resize(double ratio) {
        stretch(ratio, ratio);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MalePatience that = (MalePatience) o;
        return dailyPatience == that.dailyPatience &&
                totalPatience == that.totalPatience &&
                nameHusband.equals(that.nameHusband);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameHusband, dailyPatience, totalPatience);
    }
}
