#ifndef PQueue_Vector_Included
#define PQueue_Vector_Included

#include <string>
#include <vector>
using namespace std;
 
class VectorPriorityQueue {
public:

	/* Constructs a new, empty priority queue backed by a vector. */
	VectorPriorityQueue();
	
	/* Cleans up all memory allocated by this priority queue. */
	~VectorPriorityQueue();

	/* Returns the number of elements in the priority queue. */
	int size();
	
	/* Returns whether or not the priority queue is empty. */
	bool isEmpty();
	
	/* Enqueues a new string into the priority queue. */
	void enqueue(string value);
	
	/* Returns, but do
	*/
	string peek();
	
	/* Returns and removes the lexicographically first string in the
	 * priority queue.
	 */
	string dequeueMin();

private:
	
	vector <string> words;

};

#endif