package period1;
import robocode.*;
import java.awt.geom.Point2D;



public class MuthurajaVishal extends Robot
{
	private Enemy target = new Enemy();
	
	public void run() {
		target.reset();
		setAdjustRadarForGunTurn(true);
		setAdjustGunForRobotTurn(true);
		while(true) {
			turnRight(40);
			ahead(70);
			turnRadarRight(360);
			shoot();
		}
	}



	public void onScannedRobot(ScannedRobotEvent e) {
		if (target.getDistance() > e.getDistance() + 50 || target.none() || target.getName().equals(e.getName())) {
			target.update(e, this);
		}
	}

	public void onHitByBullet(HitByBulletEvent e) {
		ahead(60);
	}

	public void onHitWall(HitWallEvent e) {
		turnRight(20);
		back(60);
		turnRight(60);
	}
	
	public void shoot() {
		if (!(target.none())) {
			double pow = Math.min(500/target.getDistance(), 3.0);
			double speed = 20 - pow*3;
			long time = (long)(target.getDistance() / speed);
			
			double x = target.getFutureX(time);
			double y = target.getFutureY(time);
			
			double ang = findAngle(getX(), getY(), x, y);
			turnGunRight(createAngle(ang - getGunHeading()));
			
			fire(pow);
			
		}
	}
	
	public double findAngle(double p1x, double p1y, double p2x, double p2y) {
		double a = p2x - p1x;
		double b = p2y - p1y;
		double c = Point2D.distance(p1x, p1y, p2x, p2y);
		double angle = Math.toDegrees(Math.asin(a/c));
		boolean x = a > 0;
		boolean y = b > 0;
		
		if (x && y) return createAngle(angle);
		else if (!x && y) return createAngle(360 + angle);
		else if (x && !y) return createAngle(180 - angle);
		else return createAngle(180 - angle); 
		
		
	}
	
	public double createAngle(double o) {
		while (o < -180) {
			o +=360;
		}
		while (o > 180) {
			o -=360;
		}
		return o;
	}	
}
