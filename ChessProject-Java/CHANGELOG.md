# Changelog

## Version: 1.0-SNAPSHOT - January 2019

### Changed

- Set language level to 8 from 5 (Used System.lineSeparator - Another option it could be change the method by 
System.getProperty("line.separator") - Reference: 
https://dzone.com/articles/prefer-systemlineseparator-for-writing-system-depe)

- Method names changed to follow naming convention (Camel case starting by lower case in the case of methods)

- Changed value from MAX_BOARD_WIDTH and MAX_BOARD_HEIGHT from 7 to 8. From the point of view of a developer, arrays 
start by 0 (index), so this is the reason why 8 positions are between 0 and 7, but from the high level point of view, in
chess we have a board with dimensions 8x8.

- In the class ChessBoardTest the tests testHas_MaxBoardWidth_of_7 and testHas_MaxBoardHeight_of_7 have been renamed to 
testHas_MaxBoardWidth_of_8 and testHas_MaxBoardHeight_of_8 by the design decision of change these values from 7 to 8. 

- Old test names testHas_MaxBoardWidth_of_7 validates internally the Height instead of Width. Modified to be coherent 
with the name.

- In the file ChessBoardTest is used Assert.assertEquals and assertEquals. Because we can find the method assertEquals 
implemented in the parent class (TestCase) we don't need to use the first option (Assert.assertEquals) and the import
can be removed.

- ChessBoardTest contains an invalid test, the condition should be assertFalse in 
testIsLegalBoardPosition_False_X_equals_11_Y_equals_5 

- Refactoring of testLimits_The_Number_Of_Pawns in ChessBoardTest. It does not affect because both values are the same 
in this case, but it is comparing the Y coordinate with WIDTH instead of HEIGHT. In this case it is required a change as 
well in the 6, if we want to check the limits, we have to put a 7 here.
 
- Using JUnit 4 we don't need to add the key word test in front of the test and we don't need to specify TestCase as the 
parent class. We can use static imports to use the assertion methods.

- Removed in ChessBoardTest from the setUp method the throws Exception. Usually we can throw custom exceptions, but 
there is no point in throw the more general Exception in this case. 

- Replaced in PawnTest the import * by the specific imports that we need.

- Added assertions to check the Color of the Pawn. All the variables should be tested.

- Added in PawnTest a new test to add checking all the values, not only individuals.

- Removed semicolon from enumeration definitions, not needed.

- String format fixed to implement the toString functionality in the Pawn class. Use of String.join to use the lines
separator between the strings to concatenate (String.join requires Java version 8).

- Max height and width by default use the values defined in constants, the constructor in ChessBoard can decide doing 
something different.

- Removed the color from the add method in the ChessBoard class, there is no need. In case we need it, the color is 
included in the piece itself.

- Pawn now it has as a parent class Piece, with all the common functionality and properties for another types of pieces.

- Moving move functionality to the Board (Initially the Board and the Pawn are really coupled, this change want to 
delegate responsibilities.)

- Refactoring in unit tests. All of them have been distributed into the right unit test file.

### Added

- Implemented method isLegalBoardPosition in ChessBoard class.

- New method to make it easier set the coordinates of a piece (setCoordinates).

- Added new method isEmpty in ChessBoard to validate if the position is empty.

- Added in Piece a new attribute to specify the initial position in the board (top or bottom). By default it will be 
considered Black color at the Top and White color at the Bottom, but this can be changed modifying the property.

- Created new Piece class to manage all the shared functionality and properties from pieces.

- Adding functionality to double jump for Pawns if they are in the initial position.

- New Coordinate class to manage xCoordinate and yCoordinate.

- Adding Layout to manage the real situation of the board. The board will have a method to return the instance of the 
layout to have a way to represent/display the position of the pieces. This class has lazy initialisation to load all the
positions.

- New package structure by feature to make it more readable.

- Added interfaces to define the methods and add polymorphism into the code.

- Added abstract class (Piece and Board) to encapsulate the shared functionality and distribute and delegate the code 
between classes.

- Added custom exceptions. 

### Additional comments

- There are different naming conventions for the methods used for testing. I decided to follow with the same as code, 
but it could be something to discuss.

- At the moment, there are a lot of public methods, depending on the case, we should consider if this is the right 
visibility level.

- I upgraded the Java level to 8, but as a design decision, if this is a problem, multiple ways can be found to do the
same functionality.

- I decided to remove the invalid position (-1, -1) for pieces that can't be added into the board, the new way to handle
this is with custom exceptions. 

- Some of the comments could be deprecated, I just decided to leave it in that way to analyse the situations as I found
it.

- It could be interesting for the long term project the integration with Mockito or similar tool in order to do the 
tests.

- As a consideration, Javadoc could be added as well into the code. At the moment I tried to follow the convention about
do code as readable as possible. 


