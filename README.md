# inktest

## To Build

`mvn clean package`

## To Run

`java -jar test-1.0.jar`

or

`java -jar test-1.0.jar {timestamp}`

where {timestamp} conforms to Java's DateTimeFormatter.ISO_LOCAL_TIME format

## Differences to the provided examples

- The top yellow light is used to indicate an odd or even number of seconds. The specification says that the light should be lit when the number of seconds is even, yet the examples show the light lit when the number of seconds is odd. I have chosen to follow the specification here (The light is lit on an even number of seconds).
- The lowest row of lights is said to be yellow in the specification, and yet is indicated with an `R` in the examples. I have chosen to follow the specification here (the lowest lights are indicated to be lit using a `Y` character).

## Design

### Why I chose the design I did

As far as I saw the problem, there were only two main tasks to think about:
- Storage of the Clock state
- Printing of the Clock State to standard out

This gives us a clean and easy separation of concerns. The BerlinClock object exists only to store the clock state, either through manual light setting by a user, or from a provided LocalTime. The Output class can then produce output based on the state of any BerlinClock object, and the Main class exists only to tie the two together with any provided command-line inputs.

The Output object can easily be extended to various other output formats, eg. using a GUI, without impacting the design of the rest of the system.

### What choices I made during implementation, and why

I felt comfortable hard-coding many values into the BerlinClock object (and elsewhere) due to the nature of the task; the measurement of time has become a global standard - almost everyone recognises 24 hours in a day, 60 minutes to the hour, etc, and so it is unlikely that we will need to adjust these values at all in the future.

I also decided to allow passing in a time to the jar file as a command-line argument, to allow me to manually test the system start-to-finish with any output I chose. Since this is also a nice feature, I have left it in.

### Why I have tested what I have tested

For each class, I have attempted to give a couple of 'standard' examples (the ones used in the problem specification), as well as edge cases, null cases, and any errors that may be thrown.

This will ensure that any new changes made to the project will not accidentally break existing functionality. Ideally, tests would be added for any new functionality added as well.

These tests also almost act as documentation for the system. If another programmer were to wonder about the outputs of a function given certain inputs, hopefully the case would be covered by (or at least could be inferred from) the tests.
