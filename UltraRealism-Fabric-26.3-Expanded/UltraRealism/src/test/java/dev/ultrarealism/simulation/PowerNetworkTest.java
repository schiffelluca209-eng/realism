package dev.ultrarealism.simulation;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PowerNetworkTest {
    @Test void higherPriorityConsumersReceivePowerFirst() {
        var result = PowerNetwork.allocate(5, List.of(
            new PowerNetwork.Consumer("mill", 4, 1),
            new PowerNetwork.Consumer("lights", 3, 10)
        ));
        var lights = result.stream().filter(a -> a.id().equals("lights")).findFirst().orElseThrow();
        var mill = result.stream().filter(a -> a.id().equals("mill")).findFirst().orElseThrow();
        assertEquals(3, lights.suppliedPower());
        assertEquals(2, mill.suppliedPower());
    }
}
