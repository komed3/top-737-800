# Boeing 737-800 take off speed calculator

Calculate take off performance (v1, vr and v2) for Boeing 737-800:

- __v1__: maximum speed up to which a start abort may be initiated
- __vr__: speed when pilot lifts nose of aircraft to take off
- __v2__: minimum speed to climb safely even with engine failure

__Do not use for real life flight! Valid for flight simulation use only!__

![Screenshot of the calculator](https://github.com/komed3/tos-737-800/blob/main/resources/screenshot01.png?raw=true)

## Required arguments

- temperature (°C)
- pressure (inHg)
- elevation (ft)
- available runway (ft)
- weight (kg)
- Flaps position [1, 5, 15]
- Wet runway?

## Compile Java file

Download and install __jdk__ and run the following command: ``javac top.java``

After that you can execute the program with: ``java top``

## Data source

![take off speeds](https://github.com/komed3/tos-737-800/blob/main/resources/perf_takeoff.gif?raw=true)

URL: [b737.org.uk](http://www.b737.org.uk/pilotnotes.htm)
