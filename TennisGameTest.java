// JUnit assertion - the default Java assertion library
// https://junit.org/junit5/

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TennisGameTest {

    TennisGame tennisGame;
    
    @BeforeEach
    public void initEach() {
        tennisGame = new TennisGame();
    }
    
    @Test
    public void test_Love_Love_score() {
        String expected = "Love - Love";
    
        String actual = tennisGame.Score();
    
        assertEquals(expected, actual);
    }
    
    @Test
    public void test_30_Love_score() {
        String expected = "15 - Love";
        
        tennisGame.ServerScoresPoint();     // 15 - Love
        String actual = tennisGame.Score();
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void test_Server_Can_Score_Point() {
        int currentPoints = tennisGame.getServerPoints();
        
        tennisGame.ServerScoresPoint();
        int newPoints = tennisGame.getServerPoints();
        
        assertEquals(currentPoints + 1, newPoints);
    }
    
    @Test
    public void test_Receiver_Can_Score_Point() {
        int currentPoints = tennisGame.getReceiverPoints();
        
        tennisGame.ReceiverScoresPoint();
        int newPoints = tennisGame.getReceiverPoints();
        
        assertEquals(currentPoints + 1, newPoints);
    }
    
    @Test
    public void test_Love_15_score() {
        String expected = "Love - 15";
        
        tennisGame.ReceiverScoresPoint();   // Love - 15
        String actual = tennisGame.Score();
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void test_15_15_score() {
        String expected = "15 - 15";
        
        tennisGame.ServerScoresPoint();     // 15 - Love
        tennisGame.ReceiverScoresPoint();   // 15 - 15
        String actual = tennisGame.Score();
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void test_30_15_score() {
        String expected = "30 - 15";
        
        tennisGame.ServerScoresPoint();     // 15 - Love
        tennisGame.ServerScoresPoint();     // 30 - Love
        tennisGame.ReceiverScoresPoint();   // 30 - 15
        String actual = tennisGame.Score();
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void test_15_30_score() {
        String expected = "15 - 30";
        
        tennisGame.ServerScoresPoint();     // 15 - Love
        tennisGame.ReceiverScoresPoint();   // 15 - 15
        tennisGame.ReceiverScoresPoint();   // 15 - 30
        String actual = tennisGame.Score();
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void test_30_30_score() {
        String expected = "30 - 30";
        
        tennisGame.ServerScoresPoint();     // 15 - Love
        tennisGame.ReceiverScoresPoint();   // 15 - 15
        tennisGame.ServerScoresPoint();     // 30 - 15
        tennisGame.ReceiverScoresPoint();   // 30 - 30
        String actual = tennisGame.Score();
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void test_40_30_score() {
        String expected = "40 - 30";
        
        tennisGame.ServerScoresPoint();     // 15 - Love
        tennisGame.ServerScoresPoint();     // 30 - Love
        tennisGame.ServerScoresPoint();     // 40 - Love
        tennisGame.ReceiverScoresPoint();   // 40 - 15
        tennisGame.ReceiverScoresPoint();   // 40 - 30
        String actual = tennisGame.Score();
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void test_30_40_score() {
        String expected = "30 - 40";
        
        tennisGame.ServerScoresPoint();     // 15 - Love
        tennisGame.ServerScoresPoint();     // 30 - Love
        tennisGame.ReceiverScoresPoint();   // 30 - 15
        tennisGame.ReceiverScoresPoint();   // 30 - 30
        tennisGame.ReceiverScoresPoint();   // 30 - 40
        String actual = tennisGame.Score();
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void test_Deuce_score() {
        String expected = "Deuce";
        
        tennisGame.ServerScoresPoint();     // 15 - Love
        tennisGame.ServerScoresPoint();     // 30 - Love
        tennisGame.ServerScoresPoint();     // 40 - Love
        tennisGame.ReceiverScoresPoint();   // 40 - 15
        tennisGame.ReceiverScoresPoint();   // 40 - 30
        tennisGame.ReceiverScoresPoint();   // Deuce
        String actual = tennisGame.Score();
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void test_Game_Server_score() {
        String expected = "Game Server";
        
        tennisGame.ServerScoresPoint();     // 15 - Love
        tennisGame.ServerScoresPoint();     // 30 - Love
        tennisGame.ServerScoresPoint();     // 40 - Love
        tennisGame.ReceiverScoresPoint();   // 40 - 15
        tennisGame.ReceiverScoresPoint();   // 40 - 30
        tennisGame.ServerScoresPoint();     // Game Server
        String actual = tennisGame.Score();
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void test_Game_Receiver_score() {
        String expected = "Game Receiver";
        
        tennisGame.ReceiverScoresPoint();   // Love - 15
        tennisGame.ReceiverScoresPoint();   // Love - 30
        tennisGame.ReceiverScoresPoint();   // Love - 40
        tennisGame.ServerScoresPoint();     // 15 - 40
        tennisGame.ServerScoresPoint();     // 30 - 40
        tennisGame.ReceiverScoresPoint();   // Game Receiver
        String actual = tennisGame.Score();
        
        assertEquals(expected, actual);
    }

    @Test
    public void test_Advantage_Server_score() {
        String expected = "Advantage Server";
        
        tennisGame.ReceiverScoresPoint();   // Love - 15
        tennisGame.ReceiverScoresPoint();   // Love - 30
        tennisGame.ReceiverScoresPoint();   // Love - 40
        tennisGame.ServerScoresPoint();     // 15 - 40
        tennisGame.ServerScoresPoint();     // 30 - 40
        tennisGame.ServerScoresPoint();     // Deuce
        tennisGame.ServerScoresPoint();     // Advantage Server
        String actual = tennisGame.Score();
        
        assertEquals(expected, actual);
    }

    @Test
    public void test_Deuce_after_Advantage_Server_score() {
        String expected = "Deuce";
        
        tennisGame.ReceiverScoresPoint();   // Love - 15
        tennisGame.ReceiverScoresPoint();   // Love - 30
        tennisGame.ReceiverScoresPoint();   // Love - 40
        tennisGame.ServerScoresPoint();     // 15 - 40
        tennisGame.ServerScoresPoint();     // 30 - 40
        tennisGame.ServerScoresPoint();     // Deuce
        tennisGame.ServerScoresPoint();     // Advantage Server
        tennisGame.ReceiverScoresPoint();   // Deuce
        String actual = tennisGame.Score();
        
        assertEquals(expected, actual);
    }

    @Test
    public void test_Advantage_Server_after_two_Deuce_score() {
        String expected = "Advantage Server";
        
        tennisGame.ReceiverScoresPoint();   // Love - 15
        tennisGame.ReceiverScoresPoint();   // Love - 30
        tennisGame.ReceiverScoresPoint();   // Love - 40
        tennisGame.ServerScoresPoint();     // 15 - 40
        tennisGame.ServerScoresPoint();     // 30 - 40
        tennisGame.ServerScoresPoint();     // Deuce
        tennisGame.ServerScoresPoint();     // Advantage Server
        tennisGame.ReceiverScoresPoint();   // Deuce
        tennisGame.ServerScoresPoint();     // Advantage Server
        String actual = tennisGame.Score();
        
        assertEquals(expected, actual);
    }

    @Test
    public void test_Advantage_Receiver_score() {
        String expected = "Advantage Receiver";
        
        tennisGame.ReceiverScoresPoint();   // Love - 15
        tennisGame.ReceiverScoresPoint();   // Love - 30
        tennisGame.ReceiverScoresPoint();   // Love - 40
        tennisGame.ServerScoresPoint();     // 15 - 40
        tennisGame.ServerScoresPoint();     // 30 - 40
        tennisGame.ServerScoresPoint();     // Deuce
        tennisGame.ReceiverScoresPoint();   // Advantage Receiver
        String actual = tennisGame.Score();
        
        assertEquals(expected, actual);
    }

    @Test
    public void test_Deuce_after_Advantage_Receiver_score() {
        String expected = "Deuce";
        
        tennisGame.ReceiverScoresPoint();   // Love - 15
        tennisGame.ReceiverScoresPoint();   // Love - 30
        tennisGame.ReceiverScoresPoint();   // Love - 40
        tennisGame.ServerScoresPoint();     // 15 - 40
        tennisGame.ServerScoresPoint();     // 30 - 40
        tennisGame.ServerScoresPoint();     // Deuce
        tennisGame.ReceiverScoresPoint();   // Advantage Receiver
        tennisGame.ServerScoresPoint();     // Deuce
        String actual = tennisGame.Score();
        
        assertEquals(expected, actual);
    }

    @Test
    public void test_Advantage_Receiver_after_two_Deuce_score() {
        String expected = "Advantage Receiver";
        
        tennisGame.ReceiverScoresPoint();   // Love - 15
        tennisGame.ReceiverScoresPoint();   // Love - 30
        tennisGame.ReceiverScoresPoint();   // Love - 40
        tennisGame.ServerScoresPoint();     // 15 - 40
        tennisGame.ServerScoresPoint();     // 30 - 40
        tennisGame.ServerScoresPoint();     // Deuce
        tennisGame.ReceiverScoresPoint();   // Advantage Receiver
        tennisGame.ServerScoresPoint();     // Deuce
        tennisGame.ReceiverScoresPoint();   // Advantage Receiver
        String actual = tennisGame.Score();
        
        assertEquals(expected, actual);
    }

    @Test
    public void test_Game_Server_after_Advantage_Server_score() {
        String expected = "Game Server";
        
        tennisGame.ReceiverScoresPoint();   // Love - 15
        tennisGame.ReceiverScoresPoint();   // Love - 30
        tennisGame.ReceiverScoresPoint();   // Love - 40
        tennisGame.ServerScoresPoint();     // 15 - 40
        tennisGame.ServerScoresPoint();     // 30 - 40
        tennisGame.ServerScoresPoint();     // Deuce
        tennisGame.ServerScoresPoint();     // Advantage Server
        tennisGame.ServerScoresPoint();     // Game Server
        String actual = tennisGame.Score();
        
        assertEquals(expected, actual);
    }

    @Test
    public void test_Game_Receiver_after_Advantage_Receiver_score() {
        String expected = "Game Receiver";
        
        tennisGame.ReceiverScoresPoint();   // Love - 15
        tennisGame.ReceiverScoresPoint();   // Love - 30
        tennisGame.ReceiverScoresPoint();   // Love - 40
        tennisGame.ServerScoresPoint();     // 15 - 40
        tennisGame.ServerScoresPoint();     // 30 - 40
        tennisGame.ServerScoresPoint();     // Deuce
        tennisGame.ReceiverScoresPoint();   // Advantage Receiver
        tennisGame.ReceiverScoresPoint();   // Game Receiver
        String actual = tennisGame.Score();
        
        assertEquals(expected, actual);
    }
}
