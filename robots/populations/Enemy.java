package populations;

import robocode.Robot;
import robocode.ScannedRobotEvent;

public class Enemy {
	double bearing;
	double distance;
	double energy;
	double heading;
	double velocity;
	String name;
	private double x, y;
	public double getBearing(){
		return bearing;
	}
	public double getDistance(){
		return distance;
	}
	public double getEnergy(){
		return energy;
	}
	public double getHeading(){
		return heading;
	}
	public double getVelocity(){
		return velocity;
	}
	public String getName(){
		return name;
	}
	public void update(ScannedRobotEvent bot){
		bearing = bot.getBearing();
		distance = bot.getDistance();
		energy = bot.getEnergy();
		heading = bot.getHeading();
		velocity = bot.getVelocity();
		name = bot.getName();
		double absBearingDeg= (robot.getHeading() + e.getBearing());
		if (absBearingDeg <0) absBearingDeg +=360;
		x = robot.getX() + Math.sin(Math.toRadians(absBearingDeg)) * e.getDistance();
		y = robot.getY() + Math.cos(Math.toRadians(absBearingDeg)) * e.getDistance();

	}
	public void reset(){
		x = 0;
		y = 0;
		bearing = 0.0;
		distance =0.0;
		energy= 0.0;
		heading =0.0;
		velocity = 0.0;
		name = null;
	}

	public double getX(){
		return x;
	}

	public double getY(){
		return y;
	}

	public double getFutureX(long when){
		return x + Math.sin(Math.toRadians(getHeading())) * getVelocity() * when;
	}

	public double getFutureY(long when ){
		return y + Math.cos(Math.toRadians(getHeading())) * getVelocity() * when;
	}

	public Boolean none(){
		if (name == null || name == "")
			return true;
		else
			return false;
	}

	public EnemyBot(){
		reset();
	}

}

