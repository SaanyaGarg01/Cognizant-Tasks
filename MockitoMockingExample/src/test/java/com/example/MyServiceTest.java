package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * Unit test for MyService using Mockito to mock and stub ExternalApi.
 */
public class MyServiceTest {

    @Test
    public void testExternalApi() {
        // 1. Create a mock object for the external API dependency
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // 2. Stub the getData method to return a predefined value
        when(mockApi.getData()).thenReturn("Mock Data");

        // 3. Inject the mock into the service class
        MyService service = new MyService(mockApi);

        // 4. Act
        String result = service.fetchData();

        // 5. Assert
        assertEquals("Mock Data", result);

        // 6. Verify that the mocked method was called exactly once
        verify(mockApi, times(1)).getData();
    }
}
