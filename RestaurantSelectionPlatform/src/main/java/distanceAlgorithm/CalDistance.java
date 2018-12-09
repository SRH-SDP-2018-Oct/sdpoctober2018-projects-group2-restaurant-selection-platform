package distanceAlgorithm;

public class CalDistance {
	public void calculateDistance() {
		CalDistance obj = new CalDistance();
		System.out.println(obj.distance(88.898556, -89.037852, 86.897147, -89.043934) + " Miles\n");
	}

	public double distance(double lat1, double lon1, double lat2, double lon2) {

		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
				+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		return (dist);
	}

	public double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	public double rad2deg(double rad) {
		return (rad * 180.0 / Math.PI);
	}
}
