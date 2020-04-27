
Your task is to write a “TennisGame” class containing the logic which outputs the correct score as a string for display on the scoreboard. When a player scores a point, it triggers a method to be called on your class letting you know who scored the point. Later, you will get a call “score()” from the scoreboard asking what it should display. This method should return a string with the current score.

Summary of tennis scoring:

1. A game is won by the first player to have won at least four points in total and at least two points more than the opponent.
   
2. The running score of each game is described in a manner peculiar to tennis: scores from zero to three points are described as "Love", "15", "30", and "40" respectively.
   
3. If at least three points have been scored by each player, and the scores are equal, the score is "Deuce".
   
4. If at least three points have been scored by each side and a player has one more point than his opponent, the score of the game is "Advantage" for the player in the lead.

[source http://en.wikipedia.org/wiki/Tennis#Scoring]
