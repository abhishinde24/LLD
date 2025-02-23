* This is the my second attempt to design chess game with some working basic functionalities. 

# Chess

- Function
    - Board of 8 * 8
    - Diagonally adjacent black and white
    - 2 players having black and white respectively
    - Chess play piece having property as follow
    1. King : can move in any direction
    2. Queen : any number of steps in any direction
    3. Rook : move horizontally and vertically , any number of times
    4. Bishop : move diagonally, any number of steps
    5. knight : L shap move in any direction
    6. pawn :  It can move 1 step forward vertically. If it is its first turn, then it can also choose to make 2 steps in single move.
       Only : knight can jump over other pieces.
  
Listing down things to consider:
- Board
- Player
- Piece : associate position and player

- Game state:
  - if player king is in check position , need to secure king
  - after move if king is in check position, move will be invalid
- combining above two conditions, check after current move player should not be in check condition

Move validations
  - piece can follow specific movement pattern
  - piece can not over a pass same player piece
  - if destination is having opposite player piece it can be killed

- Each piece will move differently
  - we use movement providers for each type of movement, horizontal, vertical, diagonal
  - we also need to track count of movement, as king can only move in 1 block

Implementation details I am thinking of?
- board will be responsible for giving me neighbouring cells. 
- Provider well be responsible for deciding which see we should proceed. 
- We will maintain N which will decide how many moves are possible. 

I made the move provider, but how we multiple checks in single class