package mountain;

import java.util.LinkedList;
import java.util.List;

import mountain.*;
import fractal.*;

public class Mountain extends Fractal {
	private Point m_p1, m_p2, m_p3;
	private double m_dev;

	private List<Side> m_sides;

	public Mountain(double dev, Point p1, Point p2, Point p3) {
		super();
		m_p1 = p1;
		m_p2 = p2;
		m_p3 = p3;

		m_dev = dev;
		m_sides = new LinkedList<Side>();
	}

	/**
	 * Returns the title.
	 * @return the title
	 */
	public String getTitle() {
		return "Mountain fractal";
	}

	/** Draws the fractal.
	 * @param turtle the turtle graphic object
	 */
	public void draw(TurtleGraphics turtle) {
		fractralLine(turtle, order, m_dev, m_p1, m_p2, m_p3);
	}

	/**
	 * Reursive method: Draws a recursive line of the triangle.
	 */
	private void fractralLine(TurtleGraphics turtle, int order, double dev, Point p1, Point p2, Point p3) {

		if (order == 0) {
			turtle.moveTo(p1.getX(), p1.getY());
			turtle.forwardTo(p2.getX(), p2.getY());
			turtle.forwardTo(p3.getX(), p3.getY());
			turtle.forwardTo(p1.getX(), p1.getY());
		} else {
			Point left = centerPoint(p1, p2, dev);
			Point right = centerPoint(p2, p3, dev);
			Point bot = centerPoint(p3, p1, dev);

			fractralLine(turtle, order - 1, dev / 2, p1, left, bot);
			fractralLine(turtle, order - 1, dev / 2, left, p2, right);
			fractralLine(turtle, order - 1, dev / 2, right, p3, bot);
			fractralLine(turtle, order - 1, dev / 2, bot, left, right);
		}
	}

	/*
	 * Get center point of a line
	 */
	private Point centerPoint(Point p1, Point p2, double dev) {

		for (Side s : m_sides) {
			if(s.matchPoints(p1, p2)){
				Point p = s.getCenter();
				m_sides.remove(s);
				return p;
			}
		}

		Point p = new Point(p1.getX() + (p2.getX() - p1.getX()) / 2 ,
				p1.getY() + (p2.getY() - p1.getY()) / 2 - RandomUtilities.randFunc(dev));
		m_sides.add(new Side(p1, p2, p));
		return p;
	}

}