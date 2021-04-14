* File: pqueue-vector.cpp
 *
 * Implementation file for the VectorPriorityQueue
 * class.
 */
 
#include "pqueue-vector.h"
#include "error.h"

VectorPriorityQueue::VectorPriorityQueue() {
}

VectorPriorityQueue::~VectorPriorityQueue() {
}

int VectorPriorityQueue::size() {

	return words.size();

}

bool VectorPriorityQueue::isEmpty() {
	
	return words.size() == 0;

}

void VectorPriorityQueue::enqueue(string value) {
	
	words.push_back(value);

}

string VectorPriorityQueue::peek() {
	
	if (words.size() == 0) error("We ain't got words here pal");

	string first = words[0];
	for (int i=0; i<words.size(); i++)
	{
		if (words[i] < first) first = words[i];
	}
	
	return first;
}

string VectorPriorityQueue::dequeueMin() {
	
	if (words.size() == 0) error("We ain't got words here pal");

	string first = words[0];
	int index = 0;
	for (int i=0; i<words.size(); i++)
	{
		if (words[i] < first){ first = words[i]; index = i; }
	}
	words.erase(words.begin() + index);

	return first;
}