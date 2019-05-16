package com.factory_methos_partter;

import com.factory.CarFactory;

public interface Car {
	public void run();
}

class JiLiFactory extends CarFactory {

	public Car createCar() {

		return new JiLi();
	}

}
 class AoDiFactory extends CarFactory {

	public Car createCar() {
	
		return new AoDi();
	}
}
 class Client {

	public static void main(String[] args) {
		Car aodi = new AoDiFactory().createCar();
		Car jili = new JiLiFactory().createCar();
		aodi.run();
		jili.run();
	}

}