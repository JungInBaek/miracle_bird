package com.multi.miraclebird.weka;

public class RecommendVO {
	
	private double gender;
	private double age;
	private double areaFirst;
	private double areaSecond;
	private double areaThird;
	private double areaFourth;
	private double incomeFirst;
	private double incomeSecond;
	private double incomeThird;
	private double incomeFourth;
	private double inout;
	
	public double getGender() {
		return gender;
	}

	public void setGender(double gender) {
		this.gender = gender;
	}

	public double getAge() {
		return age;
	}

	public void setAge(double age) {
		this.age = age;
	}

	public double getAreaFirst() {
		return areaFirst;
	}

	public void setAreaFirst(double areaFirst) {
		this.areaFirst = areaFirst;
	}

	public double getAreaSecond() {
		return areaSecond;
	}

	public void setAreaSecond(double areaSecond) {
		this.areaSecond = areaSecond;
	}

	public double getAreaThird() {
		return areaThird;
	}

	public void setAreaThird(double areaThird) {
		this.areaThird = areaThird;
	}

	public double getAreaFourth() {
		return areaFourth;
	}

	public void setAreaFourth(double areaFourth) {
		this.areaFourth = areaFourth;
	}

	public double getIncomeFirst() {
		return incomeFirst;
	}

	public void setIncomeFirst(double incomeFirst) {
		this.incomeFirst = incomeFirst;
	}

	public double getIncomeSecond() {
		return incomeSecond;
	}

	public void setIncomeSecond(double incomeSecond) {
		this.incomeSecond = incomeSecond;
	}

	public double getIncomeThird() {
		return incomeThird;
	}

	public void setIncomeThird(double incomeThird) {
		this.incomeThird = incomeThird;
	}

	public double getInout() {
		return inout;
	}

	public void setInout(double inout) {
		this.inout = inout;
	}

	public double getIncomeFourth() {
		return incomeFourth;
	}

	public void setIncomeFourth(double incomeFourth) {
		this.incomeFourth = incomeFourth;
	}

	@Override
	public String toString() {
		return "RecommendVO [gender=" + gender + ", age=" + age + ", areaFirst=" + areaFirst + ", areaSecond="
				+ areaSecond + ", areaThird=" + areaThird + ", areaFourth=" + areaFourth + ", incomeFirst="
				+ incomeFirst + ", incomeSecond=" + incomeSecond + ", incomeThird=" + incomeThird + ", incomeFourth="
				+ incomeFourth + ", inout=" + inout + "]";
	}

}
