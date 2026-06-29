package com.example;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * Demonstrates interaction verification in Mockito, ensuring
 * that specific methods are invoked on mocked dependencies with precise parameters.
 */
public class InteractionVerificationTest {

    @Test
    public void testExternalApiInteraction() {
        // 1. Create a mock object for the ExternalApi dependency
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // 2. Stub the getDataById method to return specific responses based on argument inputs
        when(mockApi.getDataById(101)).thenReturn("Specific Product Data");
        when(mockApi.getDataById(999)).thenReturn("Not Found Data");

        // 3. Inject the mock into the service
        MyService service = new MyService(mockApi);

        // 4. Act (Call the service method with specific arguments)
        String result = service.fetchDataById(101);

        // 5. Assert that the returned value matches stub specifications
        assertEquals("Specific Product Data", result);

        // 6. Verify that the mocked method was called with the exact argument (101)
        verify(mockApi, times(1)).getDataById(101);

        // 7. Verify that the method was NEVER called with other arguments (like 999)
        verify(mockApi, never()).getDataById(999);
    }
}
