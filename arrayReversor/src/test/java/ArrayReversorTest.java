import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.IArrayFlattenerService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.CoreMatchers.is;
//import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ArrayReversorTest {
    private IArrayFlattenerService arrayFlattenerService = mock(IArrayFlattenerService.class);
    private ArrayReversor arrayReversor;

//    public ArrayReversorTest(IArrayFlattenerService arrayFlattenerService){
//        this.arrayReversor = new ArrayReversor();
//    }

    @BeforeEach
    void setUp() {
        this.arrayReversor = new ArrayReversor(arrayFlattenerService);
    }

    @AfterEach
    void tearDown() {
        this.arrayReversor = null;
    }

    @Test
    void reverseArray() {
        List<List<Integer>> test = Arrays.asList(new ArrayList<>(Arrays.asList(1, 24, 4)),
                new ArrayList<>(Arrays.asList(4, 1, 6)),
                new ArrayList<>(Arrays.asList(43, 1, 6, 2, 1)));
        List<Integer> expected = Arrays.asList(1, 2, 6, 1, 43, 6, 1, 4, 4, 24, 1);

//        assertEquals(expected,arr);
        when(arrayFlattenerService.flattenArray(test)).thenReturn(Arrays.asList(1, 24, 4, 4, 1, 6, 43, 1, 6, 2, 1));
        List<Integer> arr = arrayReversor.reverseArray(test);
        assertThat(arr, is(expected));
//        assertEquals(expected,arr);
        verify(arrayFlattenerService).flattenArray(test);

    }
}