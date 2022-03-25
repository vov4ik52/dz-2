public class Main {
    <dependency>
<groupId>org.junit.jupiter</groupId>
<artifactId>junit-jupiter-engine</artifactId>
<version>5.6.2</version>
<scope>test</scope>
</dependency>
}
<build>
<plugins>
<plugin>
<artifactId>maven-surefire-plugin</artifactId>
<version>3.0.0-M5</version>
</plugin>
<plugin>
<artifactId>maven-failsafe-plugin</artifactId>
<version>2.12</version>
</plugin>
<plugin>
<artifactId>maven-surefire-report-plugin</artifactId>
<version>3.0.0-M5</version>
</plugin>
<plugin>
<groupId>org.apache.maven.plugins</groupId>
<artifactId>maven-site-plugin</artifactId>
<version>3.7.1</version>
</plugin>
<plugin>
<groupId>org.apache.maven.plugins</groupId>
<artifactId>maven-project-info-reports-plugin</artifactId>
<version>3.0.0</version>
</plugin>
</plugins>
</build>
@Test
public void rigorousTest(){
Assertions.assertTrue(true)
}
@DisplayName("Слово является палиндромом")
@ParameterizedTest
@ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba" })
public void isPalindromeTest(String word){
Assertions.assertTrue(functions.isPalindrome(word));
}
@ParameterizedTest
@CsvSource({ "foo, 1", "bar, 2", "'baz, qux', 3" })
// или даже так: @CsvFileSource(resources = "/two-column.csv")
void testWithCsvSource(String first, int second) {
assertNotNull(first);
assertNotEquals(0, second);
}
@ParameterizedTest
@EnumSource(value = TimeUnit.class, names = { "DAYS", "HOURS" })
void testWithEnumSourceInclude(TimeUnit timeUnit) {
assertTrue(EnumSet.of(TimeUnit.DAYS, TimeUnit.HOURS).contains(timeUnit));
}
@ParameterizedTest
@ArgumentsSource(MyArgumentsProvider.class)
void testWithArgumentsSource(String argument) {
assertNotNull(argument);
}
static class MyArgumentsProvider implements ArgumentsProvider {
@Override
public Stream<? extends Arguments> provideArguments(ExtensionContext
context) {
return Stream.of("foo", "bar").map(Arguments::of);
}
}
public class BoxTests {
Box box;
@Test
void canBeInitializedTest() {
box = new Box();
}
@Nested
@DisplayName("when new")
class WhenNew {
@BeforeEach
void createNewBox() {
box = new Box();
}
@Test
@DisplayName("is empty")
void isEmptyTest() {
assertThat(box.isEmpty());
}
}
}@Test
void lambdaExpressions() {
assertTrue(Stream.of(1, 2, 3)
.stream()
.mapToInt(i -> i)
@Test
void groupAssertions() {
int[]numbers = {0, 1, 2, 3, 4};
assertAll("numbers",
() -> assertEquals(numbers[0], 1),
() -> assertEquals(numbers[3], 3),
() -> assertEquals(numbers[4], 1)
);
}@Test
void trueAssumption() {
assumeTrue(5 > 1);
assertEquals(5 + 2, 7);
}
@Test
void falseAssumption() {
assumeFalse(5 < 1);
assertEquals(5 + 2, 7);
}
@Test
void assumptionThat() {
String someString = "Just a string";
assumingThat(
someString.equals("Just a string"),
() -> assertEquals(2 + 2, 4)
);
}@Test
void shouldThrowException() {
Throwable exception = assertThrows(UnsupportedOperationException.class, ()
-> {
throw new UnsupportedOperationException("Not supported");
});
assertEquals(exception.getMessage(), "Not supported");
}