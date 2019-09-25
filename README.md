## Multiplication Table Trainer

### Description
The application allows user to train knowledge of multiplication table

### Version
1.1

### Version Features

1. User Interface - command line
2. Test finishes after 1 min (can be changed) or when all tasks are passed
3. Task is a set of all multiplications of two numbers (no repetitions):
    - Integer from 2 to 9
    - Integer from 2 to complexity (default value is 9, may be chooses by user from 2 to infinity)
4. Result score calculates as `t * c  * 10` 
    - `t` - time factor; takes a negative value if answer is wrong; for correct answer getting bigger if time of answer getting smaller; for wrong answers getting bigger (with a minus sign) if time of answer getting bigger.
    - `c` - complexity factor; getting smaller if chosen complexity is less than 9, and getting if complexity is bigger than 9.


