/*
 * Question: Find the center of graph (vertex, that is connected with every other vertex,
 *  but edges are directed to the center of graph).
 * 
 * Question Source: http://www.glassdoor.com/Interview/Find-the-center-of-graph-vertex-that-is-connected-with-every-other-vertex-but-edges-are-directed-to-the-center-of-graph-QTN_235640.htm
 * http://www.woolor.com/InterviewMitra/99/find-the-center-of-graph
 * 
 * Explanation:
 * The center (or Jordan center) of a graph is the set of all vertices of minimum eccentricity,
 *  that is, the set of all vertices A where the greatest distance d(A,B) to other vertices B is minimal. 
 *  Equivalently, it is the set of vertices with eccentricity equal to the graph's radius. 
 *  Thus vertices in the center (central points) minimize the maximal distance from other points in the graph.

Finding the center of a graph is useful in facility location problems where the goal is to minimize the
 worst-case distance to the facility. For example, placing a hospital at a central point reduces the longest
  distance the ambulance has to travel.

The concept of the center of a graph is related to the closeness centrality measure in social network analysis,
 which is the reciprocal of the mean of the distances d(A,B).
 * 
 */

package Graph.CenterOfGraph;

public class CenterOfGraph {

}
