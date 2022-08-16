package com.iu.start.di;

import org.springframework.stereotype.Component;

@Component 
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
	
	public Car(Engine engine) {
		this.engine=engine;
	}
	// Engine engine = new Engine();
	// Car car = new Car(engine);
	
	//4.
//	{
//		this.engine = new Engine();
//	}
	
	private Engine engine;

	//5.
	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	// Car car = new Car();
	// Engine engine = new Engine();
	// Car.setEngine(engine);
	
}
