package com.customerportal.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class Fitness {

	@Entity
	@Table(name="fitness_tracker")
	public class fitness {

		
		  public fitness(String food_name, int calories, String schedule, String day, int exercise) {		  
		  this.food_name = food_name;
		  this.calories = calories; 
		  this.schedule = schedule; 
		  this.day = day; 
		  this.exercise = exercise; }
		  
		  public fitness() { }
		 
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
		private int id;	
		
		@Column(name="food_name")
		private String food_name;
		
		@Column(name="calories")
		private int calories;
		
		@Column(name="schedule")
		private String schedule;
		
		@Column(name="day")
		private String day;
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getFood_name() {
			return food_name;
		}

		public void setFood_name(String food_name) {
			this.food_name = food_name;
		}

		public int getCalories() {
			return calories;
		}

		public void setCalories(int calories) {
			this.calories = calories;
		}

		public String getSchedule() {
			return schedule;
		}

		public void setSchedule(String schedule) {
			this.schedule = schedule;
		}

		public String getDay() {
			return day;
		}

		public void setDay(String day) {
			this.day = day;
		}

		public int getExercise() {
			return exercise;
		}

		public void setExercise(int exercise) {
			this.exercise = exercise;
		}


		@Column(name="exercise")
		private int exercise;	  
		 
	}
}
