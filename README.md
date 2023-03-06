# poker

solution for problem as set in :
https://codingdojo.org/kata/PokerHands/


I will try and take a test driven approach to this problem - starting point as set out in UML diagram(s).

These will be ordered in order of implementation.

In terms of approach to the problem-  i'm going to be using the idea of seeing how many suites there are in a hand.

So there will be a method for:
One Suite - hands
	straight flush
	flush

two suite - hands
	pair
	two pair
	
three suite - hands
	full house
	three of a kind
	
four suite - hands
	four of a kind


If the hand type is not set - then we can check for:
Straight - if hand numbers continuous

else hand is
High

each number of suite processing method will set up a "hand result" class - that will store information
about the result of the hand : hand name, 1st & 2nd High values and then the hand stored in descending
order.
