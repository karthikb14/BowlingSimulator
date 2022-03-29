**Bowling Simulator:**

Main program starts from GamePlay.java

- Run->GamePlay->Main
- Currently main initialises one player.
- Input is taken from console

Tested the below cases:
1. Tested with input 5,3; 10; 9,1; 8,0; 0,6; 3,1; 7,3; 10; 1,0; 10 (0) (1)

Score is calculated as 107

Expected: 
8 + (10 + 9 + 1) + (10 + 8) + 8 + 6 + 4 + (10 + 10) + (10 + 1 + 0) + 1 (10 + 0 + 1) = 107 total score over 10 frames.

   
2. 5,3; 10; 9,1; 8,0; 0,6; 3,1; 7,3; 10; 1,0; 8,1

Score is 105

Expected:
8 + (10 + 9 + 1) + (10 + 8) + 8 + 6 + 4 + (10 + 10) + (10 + 1 + 0) + 1 + 9 

