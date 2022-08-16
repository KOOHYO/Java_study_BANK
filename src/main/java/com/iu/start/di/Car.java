package com.iu.start.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class Car {

	//Car는 Engine이 없으면 X
	//Car는 Engine에 의존적이다
	
	
	
	// 1. private Engine engine = new Engine();
	// 2. Car car = new Car();
	//	  Car.engine = new Engine();
	
	// 3.
//	public Car() {
//		this.engine = new Engine();
//	}
	
	private Engine engine;
	private Wheel leftWheel;
	private Wheel rightWheel;
	
	//객체 생성했을때 주입해주세요
	public Car(LeftWheel leWheel, RightWheel rWheel) {
		this.leftWheel = leftWheel;
		this.rightWheel = rightWheel;
	}
	// Engine engine = new Engine();
	// Car car = new Car(engine);
	
	//4.
//	{
//		this.engine = new Engine();
//	}

	//5.
	public Engine getEngine() {
		return engine;
	}
	
	public void setEngine(Engine engine) {
		this.engine=engine;
	}
	// Car car = new Car();
	// Engine engine = new Engine();
	// Car.setEngine(engine);
	
}
