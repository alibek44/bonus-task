Bonus Task: Edge Removal from an MST

Description

This project implements a solution to the problem of removing an edge from a Minimum Spanning Tree (MST) while maintaining the properties of the MST. The program builds an MST from a given graph using Prim’s algorithm, removes an edge, finds the components of the graph after removal, and finally finds and adds a replacement edge to reconnect the components.

Features
	•	Build a Minimum Spanning Tree (MST) from a given graph.
	•	Display the MST edges before and after removing an edge.
	•	Remove one edge from the MST.
	•	Show the resulting components after the removal.
	•	Find a replacement edge to reconnect the components and display the new MST.

Technologies Used
	•	Java (JDK 8 or higher)
	•	Maven (for dependency management and build)

⸻

Setup Instructions

Clone the Repository

To get started, clone this repository to your local machine:

git clone https://github.com/alibek44/bonus-task.git
cd bonus-task

Build the Project with Maven

This project uses Maven for dependency management and building the project. To build the project, run the following command:
mvn clean install

How It Works
	1.	Build the MST: The program uses Prim’s algorithm to generate the Minimum Spanning Tree (MST) from a given graph.
	2.	Edge Removal: The program removes an edge from the MST and identifies the resulting components.
	3.	Reconnect the Graph: A replacement edge is found to reconnect the components and the updated MST is displayed.
