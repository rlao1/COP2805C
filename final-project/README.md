## Final Project (Word Searcher) – COP 2805
#### Background:
An old concept in computer science is to have a more powerful computer perform computations at the 
request of a slower computer. This is more popular in modern times with web services which use XML or 
JSON as the communication protocol. We are going to mimic this by creating a service that searches 
through a large amount of text for occurrences of a word or phrase, though it won’t be a true web 
service since the XML/JSON message formatting is not required and our server will not be connected to 
the internet.
#### Objective:
We are going to build an example server/client where the client sends a request to the server and 
receives a response. The server will represent a word searcher functionality where it loads in a large text 
file and searches for occurrences of a word or phrase within the array of strings. It responds with a list of 
integers which represent each line number that the word/phrase appeared in. 
You will construct two applications: a client and a server. The client will contain a GUI where a user can
type in a word or phrase and press a button to connect to the server. The client will display the list of 
results into a JList on the GUI. The server will accept connections and process the word search, 
responding with a list of integers for the client to then process.

Further info in instructions.pdf
