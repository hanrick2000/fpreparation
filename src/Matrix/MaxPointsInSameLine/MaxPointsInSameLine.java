/*
 * Question: Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * 
 * Question and Answer Source: http://www.fgdsb.com/2015/01/03/max-points-on-a-line/ 
 */

package Matrix.MaxPointsInSameLine;

public class MaxPointsInSameLine {

}
public static int gcd(int a, int b) {
    return a!=0 ? gcd(b % a, a) : b;
}
public static int maxPoints(vector<Point> &points) {
    int ret = 0;
    for(int i = 0; i < points.size(); ++i) {
        map<pair<int,int>, int> record;
        int same_pt = 1, max_val = 0;
        
        for(int j = i + 1; j < points.size(); ++j) {
            int x = points[i].x - points[j].x;
            int y = points[i].y - points[j].y;
            auto g = gcd(x,y);
            if(!g) { 
                same_pt++;
                continue;
            }
            max_val = max(max_val, ++record[make_pair(x/g, y/g)]);
        }
        ret = max(ret, max_val + same_pt);
    }
    return ret;
}
