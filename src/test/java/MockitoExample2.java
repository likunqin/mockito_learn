import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * 捕获参数来进一步断言
 * 较复杂的参数匹配器会降低代码的可读性，有些地方使用参数捕获器更加合适。
 */
public class MockitoExample2 {
    private PersonDao personDao;
    private PersonService personService;

    @Before
    public void setUp() {
        personDao = mock(PersonDao.class);
        personService = new PersonService(personDao);
    }

    @Test
    public void capturing_args() {
        ArgumentCaptor<Person> argument = ArgumentCaptor.forClass(Person.class);
        personService.update(1, "jack");
        verify(personDao).update(argument.capture());
        assertEquals(1, argument.getValue().getId());
        assertEquals("jack", argument.getValue().getName());
    }
}