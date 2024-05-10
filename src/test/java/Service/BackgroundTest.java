package Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.ActionEvent;

import static org.junit.jupiter.api.Assertions.*;

class BackgroundTest {
    private Background background;

    @BeforeEach
    void setUp() {
        background = new Background();
        background.calculator();
    }

    @Test
    void testCalculatorSetup() {
        assertNotNull(background);
        assertNotNull(background.textField);
    }

    @Test
    void testActionPerformedClear() {
        ActionEvent event = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "CLR");
        background.actionPerformed(event);
        assertEquals("", background.textField.getText());
    }

    @Test
    void testActionPerformedEqualValid() {
        background.textField.setText("2+3");

        ActionEvent event = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "=");
        background.actionPerformed(event);
        assertEquals("5.0", background.textField.getText());
    }

}