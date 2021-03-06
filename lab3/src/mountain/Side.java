package mountain;

public class Side {
	private Point m_p1, m_p2,  m_center;
	
	public Side(Point p1, Point p2, Point center) {
		m_p1 = p1;
		m_p2 = p2;
		m_center = center;
	}
	
	public Point getP1() {
		return m_p1;
	}
	
	public Point getP2(){
		return m_p2;
	}
	public Point getCenter(){ 
		return m_center;
	}
	public boolean matchPoints(Point p1, Point p2) {
		if(p1 == m_p1 && m_p2 == p2 || p1 == m_p2 && p2 == m_p1){
			return true;
		}
		return false;
	}
	

}
